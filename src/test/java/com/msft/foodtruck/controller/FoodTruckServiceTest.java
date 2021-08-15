package com.msft.foodtruck.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msft.foodtruck.model.FoodTruck;
import com.msft.foodtruck.service.FoodTruckService;

@SpringBootTest(classes = FoodTruckService.class)
public class FoodTruckServiceTest {

	@Autowired
	FoodTruckService foodTruckService;

	@Test
	public void saveFoodTruckWhichDoesNotExist_ShouldSaveSuccess() {
		FoodTruck foodTruck = new FoodTruck(100, "15");
		foodTruckService.save(foodTruck);
		assertNotNull(foodTruckService.getFoodTruckById(100));
	}
	@Test
	public void saveFoodTruckWhichAlreadyExists_ShouldReturnNull() {
		FoodTruck foodTruck = new FoodTruck(1514021, "15");
		assertNull(foodTruckService.save(foodTruck));
	}
	@Test
	public void getFoodTruckByIdIfExsits_ShouldReturnNotNull() {
		assertNotNull(foodTruckService.getFoodTruckById(1514021));
	}

	@Test
	public void getFoodTruckByIdIfDoesnNotExsit_ShouldReturnNull() {
		assertNull(foodTruckService.getFoodTruckById(111000));
	}

	@Test
	public void getFoodTruckByBlockIfExsits_ShouldReturnNotNull() {
		assertNotNull(foodTruckService.getFoodTruckByBlock("3507"));
	}

	@Test
	public void getFoodTruckByBlockIfDoesNotExsit_ShouldReturnNull() {
		assertNull(foodTruckService.getFoodTruckByBlock("xyz"));
	}
}
