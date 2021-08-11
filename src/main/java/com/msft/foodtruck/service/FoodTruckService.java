package com.msft.foodtruck.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.msft.foodtruck.model.FoodTruck;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class that loads and stores the foodtruck data in memory in two data
 * structures.
 * 
 * @author bajsamar
 *
 */
@Slf4j
@Service
public class FoodTruckService implements FoodTruckServiceAPI {
	// ConcurrentHash map allows concurrent access to the map. Part of the map
	// called Segment (internal data structure) is only getting locked while adding
	// or updating the map
	private final Map<Integer, FoodTruck> foodTruckMap = new ConcurrentHashMap<>();
	private final Map<String, Set<FoodTruck>> blockFoodTruckMap = new ConcurrentHashMap<>();
	@Value("${foodtruck.filepath}")
	private String foodtruckFilePath;

	public FoodTruck save(FoodTruck foodTruck) {
		if (getFoodTruckById(foodTruck.getLocationid()) != null) {
			log.info("Food Truck with location already exists locationId: " + foodTruck.getLocationid());
			return null;
		}
		updateTables(foodTruck);
		log.info("Food Truck locationId: " + foodTruck.getLocationid() + " saved successfully.");
		return foodTruck;
	}

	public FoodTruck getFoodTruckById(int locationid) {
		FoodTruck foodTruck = foodTruckMap.get(locationid);
		if (foodTruck == null) {
			log.info("Food truck not found locationId: " + foodTruckMap.get(locationid));
		}
		return foodTruck;
	}

	public Set<FoodTruck> getFoodTruckByBlock(String block) {
		Set<FoodTruck> foodTrucks = blockFoodTruckMap.get(block);
		if (foodTrucks == null || foodTrucks.size() < 1) {
			log.info("Food truck not founds for block: " + block);
		}
		return foodTrucks;
	}

	@PostConstruct
	public void parseFileLoadFoodTruckInADT() {
		log.info("Loading food truck csv data ...");
		// Get the CSVReader instance with try with resources so autoclose happens, no
		// need of explicit close

		try (CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(foodtruckFilePath).getInputStream()))) {
			String[] nextLine;
			// Move the reader once so that the header lines are ignored
			reader.readNext();
			// Read one line at a time
			while ((nextLine = reader.readNext()) != null) {
				FoodTruck foodTruck = createFoodTruckPojo(nextLine);
				updateTables(foodTruck);
			}
			log.info("Successfully loaded the CSV fine in the memory with " + foodTruckMap.size() + " records");
		} catch (IOException | CsvValidationException e) {
			log.error(e.getMessage());
			throw new RuntimeException("ApplicationStartException: Problem loading foodtruck data.", e);
		}

	}

	private void updateTables(FoodTruck foodTruck) {
		foodTruckMap.put(foodTruck.getLocationid(), foodTruck);
		if (blockFoodTruckMap.containsKey(foodTruck.getBlock())) {
			blockFoodTruckMap.get(foodTruck.getBlock()).add(foodTruck);
			log.debug("Found existing foodTrucks on the block, updating the block with foodTruck "
					+ foodTruck.getLocationid());
		} else {
			Set<FoodTruck> foodTruckSet = new HashSet<>();
			foodTruckSet.add(foodTruck);
			blockFoodTruckMap.put(foodTruck.getBlock(), foodTruckSet);
			log.debug(
					"No Food truck found on the block, updating the block with foodTruck " + foodTruck.getLocationid());

		}
	}

	private FoodTruck createFoodTruckPojo(String[] nextLine) {
		FoodTruck foodTruck = new FoodTruck();
		if (nextLine != null) {
			for (int i = 0; i < nextLine.length; i++) {
				foodTruck.setLocationid(Integer.valueOf(nextLine[0]));
				foodTruck.setApplicant(nextLine[1]);
				foodTruck.setFacilityType(nextLine[2]);
				foodTruck.setAddress(nextLine[5]);
				foodTruck.setBlock(nextLine[7]);
				foodTruck.setStatus(nextLine[10]);
				foodTruck.setFoodItems(nextLine[11]);
				foodTruck.setLatitude(Double.valueOf(nextLine[14]));
				foodTruck.setLongitude(Double.valueOf(nextLine[15]));
			}
		}
		log.debug("Created new foodTruck with locationID:" + foodTruck.getLocationid());
		return foodTruck;
	}
}