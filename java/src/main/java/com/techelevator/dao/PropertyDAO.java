package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDAO {
    List<Property> retrievePropertiesForRent();
    List<Property> retrievePropertiesByOwnerId(int userId);
    void addProperty(Property property);
    List<Property> retrievePropertiesByUserId(int userId);
    void deleteByPropertyId(int propertyId);
}
