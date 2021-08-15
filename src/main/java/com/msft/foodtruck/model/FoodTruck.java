package com.msft.foodtruck.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * FoodTruck POJO class representing the FoodTruck which is marshalled/unmarshalled by Jackson serializer.
 * @author bajsamar
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class FoodTruck {
	@Min(1) // Location id cannot be less than 1
	@Max(1000000000) // Location id cannot be more than 1000000000
	private int locationid;
	private String applicant;
	private String facilityType;
	private String cnn;
	private String jocationDescription;
	private String address;
	private String blocklot;
	private String block;
	private String lot;
	private String permit;
	private String status;
	private String foodItems;
	private String x;
	private String y;
	private double latitude;
	private double longitude;
	private String schedule;
	private String dayshours;
	private String nOISent;
	private String approved;
	private String received;
	private String priorPermit;
	private String expirationDate;
	private String location;
	private String firePreventionDistricts;
	private String policeDistricts;
	private String supervisorDistricts;
	private String zipCodes;
	private String neighborhoodsOld;

	public FoodTruck() {
	}

	public FoodTruck(int locationId, String block) {
		this.locationid = locationId;
		this.block = block;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public String getCnn() {
		return cnn;
	}

	public void setCnn(String cnn) {
		this.cnn = cnn;
	}

	public String getJocationDescription() {
		return jocationDescription;
	}

	public void setJocationDescription(String jocationDescription) {
		this.jocationDescription = jocationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlocklot() {
		return blocklot;
	}

	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDayshours() {
		return dayshours;
	}

	public void setDayshours(String dayshours) {
		this.dayshours = dayshours;
	}

	public String getnOISent() {
		return nOISent;
	}

	public void setnOISent(String nOISent) {
		this.nOISent = nOISent;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getPriorPermit() {
		return priorPermit;
	}

	public void setPriorPermit(String priorPermit) {
		this.priorPermit = priorPermit;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFirePreventionDistricts() {
		return firePreventionDistricts;
	}

	public void setFirePreventionDistricts(String firePreventionDistricts) {
		this.firePreventionDistricts = firePreventionDistricts;
	}

	public String getPoliceDistricts() {
		return policeDistricts;
	}

	public void setPoliceDistricts(String policeDistricts) {
		this.policeDistricts = policeDistricts;
	}

	public String getSupervisorDistricts() {
		return supervisorDistricts;
	}

	public void setSupervisorDistricts(String supervisorDistricts) {
		this.supervisorDistricts = supervisorDistricts;
	}

	public String getZipCodes() {
		return zipCodes;
	}

	public void setZipCodes(String zipCodes) {
		this.zipCodes = zipCodes;
	}

	public String getNeighborhoodsOld() {
		return neighborhoodsOld;
	}

	public void setNeighborhoodsOld(String neighborhoodsOld) {
		this.neighborhoodsOld = neighborhoodsOld;
	}

}
