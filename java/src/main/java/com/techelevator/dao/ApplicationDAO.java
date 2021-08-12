package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.model.Maintenance;
import com.techelevator.model.PropertyApplication;

import java.util.List;

public interface ApplicationDAO {
    void addApplication(PropertyApplication application);
    List<PropertyApplication> retrieveApplications();
    List<PropertyApplication> retrieveApplicationsByOwnerId(int ownerId);
    void updateApplicationStatus(int applicationId,PropertyApplication application);
}
