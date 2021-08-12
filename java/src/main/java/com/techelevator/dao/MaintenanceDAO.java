package com.techelevator.dao;

import com.techelevator.model.Maintenance;

import java.util.List;

public interface MaintenanceDAO {
    void requestMaintenance(Maintenance maintenance);
    List<Maintenance> retrieveMaintenanceRequests();
    List<Maintenance>  retrieveMaintenanceRequestsByOwnerId(int ownerId);
    void updateMaintenanceStatus(int maintenanceId,Maintenance maintenance);
}
