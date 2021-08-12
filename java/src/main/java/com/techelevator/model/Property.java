package com.techelevator.model;

import java.math.BigDecimal;

public class Property {
    private int propertyId;
    private String imageName;
    private Address address;
    private double numberOfBedrooms;
    private double numberOfBathrooms;
    private BigDecimal rentAmount;
    private String description;
    private String propertyType;
    private boolean pet;
    private boolean washer;
    private boolean dryer;
    private boolean dishwasher;
    private int ownerId;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(double numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public double getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(double numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    public boolean isWasher() {
        return washer;
    }

    public void setWasher(boolean washer) {
        this.washer = washer;
    }

    public boolean isDryer() {
        return dryer;
    }

    public void setDryer(boolean dryer) {
        this.dryer = dryer;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
