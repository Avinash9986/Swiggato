package com.example.swiggato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SwiggatoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SwiggatoApplication.class, args);

//		List<Integer> l = List.of(1,2,3,4,5,6) ;
//
//		List<Integer> newList = l.stream().map(x->x+10).collect(Collectors.toList());
//		for (int i = 0 ; i < newList.size() ; i++){
//			System.out.println(newList.get(i));
		}
	}


