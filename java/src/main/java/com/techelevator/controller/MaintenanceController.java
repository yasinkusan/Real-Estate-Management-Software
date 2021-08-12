package com.techelevator.controller;

import com.techelevator.dao.MaintenanceDAO;
import com.techelevator.model.Maintenance;
import com.techelevator.model.Property;
import com.techelevator.model.PropertyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MaintenanceController {

    @Autowired
    private MaintenanceDAO maintenanceDAO;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/maintenances", method = RequestMethod.POST)
    public void addMaintenance(@RequestBody Maintenance maintenance) {
        maintenanceDAO.requestMaintenance(maintenance);
    }

    @RequestMapping(path = "/maintenances", method = RequestMethod.GET)
    public List<Maintenance> getMaintenances() {
        return maintenanceDAO.retrieveMaintenanceRequests();
    }
    @RequestMapping(path = "/maintenances/{userId}", method = RequestMethod.GET)
    public List<Maintenance> getMaintenances(@PathVariable int userId) {
        return maintenanceDAO.retrieveMaintenanceRequestsByOwnerId(userId);
    }

    @RequestMapping(path = "/maintenances/{maintenanceId}", method = RequestMethod.PUT)
    public void changeMaintenanceStatus(@RequestBody Maintenance maintenance, @PathVariable int maintenanceId) {
        maintenanceDAO.updateMaintenanceStatus(maintenanceId,maintenance);
    }

}

