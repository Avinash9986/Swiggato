package com.example.swiggato.service;

import com.example.swiggato.dto.request.FoodRequest;
import com.example.swiggato.dto.response.CartStatusResponse;
import com.example.swiggato.dto.response.FoodResponse;
import com.example.swiggato.exception.CustomerNotFoundException;
import com.example.swiggato.exception.MenuItemNotFoundException;
import com.example.swiggato.model.Cart;
import com.example.swiggato.model.Customer;
import com.example.swiggato.model.FoodItem;
import com.example.swiggato.model.MenuItem;
import com.example.swiggato.repository.CartRepository;
import com.example.swiggato.repository.CustomerRepository;
import com.example.swiggato.repository.FoodRepsitory;
import com.example.swiggato.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CustomerRepository customerRepository ;

    @Autowired
    MenuRepository menuRepository ;

    @Autowired
    FoodRepsitory foodrepsitory ;

    @Autowired
    CartRepository cartRepository ;
    public CartStatusResponse addFoodItemToCart(FoodRequest foodRequest) {

        Customer customer = customerRepository.findByMobileNo(foodRequest.getCustomerMobile()) ;
        if (customer == null){
            throw new CustomerNotFoundException("cusotmer not found") ;
        }
        Optional<MenuItem> menuItemOptional= menuRepository.findById(foodRequest.getMenuItemId()) ;
        if (menuItemOptional.isEmpty()){
            throw new MenuItemNotFoundException("Menu item doestnot exist") ;
        }
        MenuItem menuItem = menuItemOptional.get() ;
        if (!menuItem.getRestraunt().isOpened() || !menuItem.isAvailable()){
            throw new MenuItemNotFoundException("Given Item is out of stock") ;
        }
        FoodItem foodItem = FoodItem.builder()
                .menuItem(menuItem)
                .cart(customer.getCart())
                .requiredQuantity(foodRequest.getRequiredQuantity())
                .totalCost(foodRequest.getRequiredQuantity()*menuItem.getPrice())
                .build();

        Cart cart = customer.getCart() ;

        FoodItem savedFoodItem = foodrepsitory.save(foodItem) ;

        double cartotal = 0 ;
        for (FoodItem food : cart.getFoodItems()){
            cartotal += food.getRequiredQuantity() * food.getMenuItem().getPrice() ;
        }

        cart.getFoodItems().add(savedFoodItem) ;
        cart.setCartotal(cartotal);
        menuItem.getFoodItems().add(foodItem) ;

        Cart savedCart = cartRepository.save(cart) ;
        MenuItem savedMenuItem = menuRepository.save(menuItem) ;

        List<FoodResponse> foodResponseList = new ArrayList<>() ;
        for (FoodItem foodItem1 : cart.getFoodItems()){
            FoodResponse foodResponse  =  FoodResponse.builder()
                    .dishName(foodItem1.getMenuItem().getDishName())
                    .price(foodItem1.getMenuItem().getPrice())
                    .category(foodItem1.getMenuItem().getFoodCategory())
                    .veg(foodItem1.getMenuItem().isVeg())
                    .quantityAdded(foodItem1.getRequiredQuantity())
                    .build() ;

            cartotal+= foodItem1.getRequiredQuantity() * foodItem1.getMenuItem().getPrice() ;
            foodResponseList.add(foodResponse) ;
        }
        return  CartStatusResponse.builder()
                .cutomerName(savedCart.getCustomer().getName())
                .customeraddress(savedCart.getCustomer().getAddress())
                .foodList(foodResponseList)
                .restarauntName(savedMenuItem.getRestraunt().getName())
                .cartTotal(cartotal)
                .build();
    }
}
