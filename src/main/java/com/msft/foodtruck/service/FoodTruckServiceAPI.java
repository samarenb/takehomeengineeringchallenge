package com.msft.foodtruck.service;

import java.util.Set;

import com.msft.foodtruck.model.FoodTruck;

/**
 * 
 * @author bajsamar
 *
 */
public interface FoodTruckServiceAPI {
	public FoodTruck save(FoodTruck foodTruck);

	public FoodTruck getFoodTruckById(int locationid);

	public Set<FoodTruck> getFoodTruckByBlock(String block);
}
