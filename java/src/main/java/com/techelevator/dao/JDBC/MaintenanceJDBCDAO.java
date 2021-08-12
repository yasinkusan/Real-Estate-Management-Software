package com.techelevator.dao.JDBC;

import com.techelevator.dao.MaintenanceDAO;
import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class MaintenanceJDBCDAO implements MaintenanceDAO {
    private JdbcTemplate jdbcTemplate;

    public MaintenanceJDBCDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void requestMaintenance(Maintenance maintenance) {

        String applicationsSQL = "SELECT * from applications where applications.user_id=?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(applicationsSQL, maintenance.getUserId());

        List<PropertyApplication> applicationList = new ArrayList<PropertyApplication>();

        while (results.next()) {
            PropertyApplication application = new PropertyApplication();
            application.setPropertyId(results.getInt("property_id"));
            applicationList.add(application);
        }


        String maintenanceSQL = "INSERT INTO maintenance(first_name, last_name, email, phone," +
                " property_id, status,user_id, issue,request_date) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";

        jdbcTemplate.update(maintenanceSQL,
                maintenance.getFirstName(),
                maintenance.getLastName(),
                maintenance.getEmail(),
                maintenance.getPhone(),
                applicationList.get(0).getPropertyId(),
                maintenance.getStatus(),
                maintenance.getUserId(),
                maintenance.getIssue(),
                maintenance.getDate()
        );
    }
    public  List<Maintenance>  retrieveMaintenanceRequestsByOwnerId(int ownerId) {
        List<Maintenance> maintenanceList = new ArrayList<Maintenance>();

        String sql = "SELECT maintenance.*, address.*\n" +
                "                FROM maintenance \n" +
                "                JOIN property ON property.property_id = maintenance.property_id \n" +
                "                JOIN address ON property.address_id = address.address_id \n" +
                "      \n" +
                "                WHERE maintenance.status = 'requested' and property.owner_id= ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,ownerId);
        while (results.next()) {
            Maintenance maintenance = mapRowToMaintenance(results);
            maintenanceList.add(maintenance);
        }
        return maintenanceList;
    }

    @Override
    public  List<Maintenance>  retrieveMaintenanceRequests() {
        List<Maintenance> maintenanceList = new ArrayList<Maintenance>();

        String sql = "SELECT maintenance.*, address.*\n" +
                "                FROM maintenance \n" +
                "                JOIN property ON property.property_id = maintenance.property_id \n" +
                "                JOIN address ON property.address_id = address.address_id \n" +
                "      \n" +
                "                WHERE maintenance.status = 'requested';";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Maintenance maintenance = mapRowToMaintenance(results);
            maintenanceList.add(maintenance);
        }
        return maintenanceList;
    }
    @Override
    public void updateMaintenanceStatus(int maintenanceId,Maintenance maintenance) {
        String maintenanceSQL ="UPDATE maintenance SET status = 'Done' WHERE maintenance_id = ?;\n";
        jdbcTemplate.update(maintenanceSQL,maintenanceId);
    }
    private Maintenance mapRowToMaintenance(SqlRowSet results) {
        Maintenance maintenance = new Maintenance();
        maintenance.setUserId(results.getInt("user_id"));
        maintenance.setMaintenanceId(results.getInt("maintenance_id"));
        maintenance.setFirstName(results.getString("first_name"));
        maintenance.setLastName(results.getString("last_name"));
        maintenance.setEmail(results.getString("email"));

        Address address = new Address();
        address.setAddressLine(results.getString("address_line"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZipCode(results.getInt("zip"));

        maintenance.setAddress(address);

        maintenance.setIssue(results.getString("issue"));
        maintenance.setDate(results.getDate("request_date"));
        maintenance.setStatus(results.getString("status"));

        return maintenance;
    }

}
