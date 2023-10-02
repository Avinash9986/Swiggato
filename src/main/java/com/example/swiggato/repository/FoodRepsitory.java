package com.example.swiggato.repository;

import com.example.swiggato.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepsitory extends JpaRepository<FoodItem,Integer> {
}
