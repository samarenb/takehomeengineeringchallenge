package com.msft.foodtruck.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.msft.foodtruck.model.FoodTruck;
import com.msft.foodtruck.service.FoodTruckService;

@WebMvcTest(FoodTruckController.class)
public class FoodTruckControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private FoodTruckService foodTruckService;

	@Test
	public void whenGetRequestToFoodTrucksAndFoodTruckExists_thenCorrectResponse() throws Exception {
		when(foodTruckService.getFoodTruckById(any(Integer.class))).thenReturn(new FoodTruck());
		mockMvc.perform(MockMvcRequestBuilders.get("/foodtrucks/900").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void whenGetRequestToFoodTrucksAndFoodTruckDoesNotExist_thenCorrectResponse() throws Exception {
		when(foodTruckService.getFoodTruckById(any(Integer.class))).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/foodtrucks/900").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void whenGetRequestToFoodTrucksByBlockAndFoodTruckExists_thenCorrectResponse() throws Exception {
		Set<FoodTruck> set = new HashSet<FoodTruck>();
		FoodTruck truck = new FoodTruck();
		truck.setLocationid(9484);
		truck.setBlock("315");
		set.add(truck);
		when(foodTruckService.getFoodTruckByBlock(any(String.class))).thenReturn(set);
		mockMvc.perform(MockMvcRequestBuilders.get("/foodtrucks?block=315").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void whenGetRequestToFoodTrucksByBlockAndFoodTruckDoesNotExist_thenCorrectResponse() throws Exception {
		when(foodTruckService.getFoodTruckByBlock(any(String.class))).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/foodtrucks?block=315").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void whenPostRequestToFoodTrucksAndValidFoodTruck_thenCorrectResponse() throws Exception {
		when(foodTruckService.save(any(FoodTruck.class))).thenReturn(new FoodTruck());
		String foodTruck = "{\"locationid\": \"900\", \"block\" : \"239\"}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/foodtrucks").content(foodTruck).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void whenPostRequestToFoodTrucksAndDuplicateFoodTruck_thenCorrectResponse() throws Exception {
		when(foodTruckService.save(any(FoodTruck.class))).thenReturn(null);
		String foodTruck = "{\"locationid\": \"500\", \"block\" : \"300\"}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/foodtrucks").content(foodTruck).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isConflict());
	}

	@Test
	public void whenPostRequestToFoodTrucksAndInValidFoodTruck_thenCorrectResponse() throws Exception {
		String foodTruck = "{\"locationid\": \"-2\", \"block\" : \"239\"}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/foodtrucks").content(foodTruck).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.locationid", Is.is("must be greater than or equal to 1")))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}
}
