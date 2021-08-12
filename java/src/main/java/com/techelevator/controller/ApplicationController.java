package com.techelevator.controller;

import com.techelevator.dao.ApplicationDAO;
import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ApplicationController {
    @Autowired
    private ApplicationDAO applicationDAO;

    @RequestMapping(path = "/applications", method = RequestMethod.GET)
    public List<PropertyApplication> retrieveApplications() {
        return applicationDAO.retrieveApplications();
    };

    @RequestMapping(path = "/applications/{userId}", method = RequestMethod.GET)
    public List<PropertyApplication> retrieveApplicationsByOwnerId(@PathVariable int userId) {
        return applicationDAO.retrieveApplicationsByOwnerId(userId);
    };

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/applications", method = RequestMethod.POST)
    public void addApplication(@RequestBody PropertyApplication application) {
        applicationDAO.addApplication(application);
    }
    @RequestMapping(path = "/changeApplicationStatus/{applicationId}", method = RequestMethod.PUT)
    public void changeApplicationStatus(@RequestBody PropertyApplication application, @PathVariable int applicationId) {
        applicationDAO.updateApplicationStatus(applicationId,application);
    }
}
