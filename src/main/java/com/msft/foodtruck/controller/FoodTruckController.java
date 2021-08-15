package com.msft.foodtruck.controller;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.msft.foodtruck.model.FoodTruck;
import com.msft.foodtruck.service.FoodTruckServiceAPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller for the rest service which contains GET locationId, GET block
 * and POST endpoints.
 * 
 * @author bajsamar
 *
 */
@Slf4j
@RestController
@RequestMapping("foodtrucks")
@Validated
public class FoodTruckController {
	@Autowired
	FoodTruckServiceAPI foodTruckService;

	@GetMapping("{locationid}")
	public FoodTruck getFoodTruckByLocationId(@PathVariable @Min(1) int locationid) {
		log.info("Get request recieved for locationId {}", locationid);
		FoodTruck foodTruck = foodTruckService.getFoodTruckById(locationid);
		if (foodTruck != null) {
			log.info("Get request processed successfully for locationid {}", locationid);
			return foodTruck;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"FoodTruck with location Id:" + locationid + " Not Found");
	}

	@GetMapping
	public Set<FoodTruck> getFoodTruckByBlock(@RequestParam(value = "block") @Size(max = 10) String block) {
		log.info("Get request recieved for block {}", block);
		Set<FoodTruck> foodTrucks = foodTruckService.getFoodTruckByBlock(block);
		if (foodTrucks != null && foodTrucks.size() > 0) {
			log.info("Get request processed successfully for block {}", block);
			return foodTrucks;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"FoodTrucks at the block number:" + block + " Not Found");

	}

	/**
	 * Post method for creating new food trucks
	 * 
	 * @param newFoodTruck
	 * @return
	 * @throws ServerException
	 */
	@PostMapping
	public ResponseEntity<FoodTruck> create(@Valid @RequestBody FoodTruck newFoodTruck) throws ServerException {
		log.info("Post request recieved for locationId {}", newFoodTruck.getLocationid());
		FoodTruck foodTruck = foodTruckService.save(newFoodTruck);
		if (foodTruck == null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"Food truck with id " + newFoodTruck.getLocationid() + " already exists");
		} else {
			log.info("Post request processed successfully for locationId {}", newFoodTruck.getLocationid());
			return new ResponseEntity<>(foodTruck, HttpStatus.CREATED);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			log.error("fieldName {}", fieldName);
			String errorMessage = error.getDefaultMessage();
			log.error("errorMessage {}", errorMessage);
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}