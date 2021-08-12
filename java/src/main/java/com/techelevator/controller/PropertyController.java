package com.techelevator.controller;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
public class PropertyController {
    @Autowired
    private PropertyDAO propertyDAO;

    @RequestMapping(path = "/properties", method = RequestMethod.GET)
    public List<Property> getProperties() {
        return propertyDAO.retrievePropertiesForRent();
    }

    @RequestMapping(path = "/properties/{userId}", method = RequestMethod.GET)
    public List<Property> getPropertiesByOwnerId(@PathVariable int userId) {
        return propertyDAO.retrievePropertiesByOwnerId(userId);
    }
    @RequestMapping(path = "/userProperties/{userId}", method = RequestMethod.GET)
    public List<Property> getPropertiesByUserId(@PathVariable int userId) {
        return propertyDAO.retrievePropertiesByUserId(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/properties", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        propertyDAO.addProperty(property);
    }

    @RequestMapping(path = "/properties/{propertyId}", method = RequestMethod.DELETE)
    public void deleteAProperty(@PathVariable int propertyId){
        propertyDAO.deleteByPropertyId(propertyId);
    }

}
