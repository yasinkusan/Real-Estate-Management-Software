package com.techelevator.dao.JDBC;

import com.techelevator.Application;
import com.techelevator.dao.ApplicationDAO;
import com.techelevator.model.PropertyApplication;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationJDBCDAO implements ApplicationDAO {
    private JdbcTemplate jdbcTemplate;

    public ApplicationJDBCDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void addApplication(PropertyApplication application) {

        String applicationSQL = "INSERT INTO applications(first_name, last_name, email, phone, property_id,income, status, user_id, application_date) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?,?,?)";

        jdbcTemplate.update(applicationSQL,
                application.getFirstName(),
                application.getLastName(),
                application.getEmail(),
                application.getPhone(),
                application.getPropertyId(),
                application.getIncome(),
                application.getStatus(),
                application.getUserId(),
                application.getApplicationDate()
        );
    }

    @Override

    public List<PropertyApplication> retrieveApplications() {
        List<PropertyApplication> applicationList = new ArrayList<>();

        String sql = "SELECT applications.* FROM applications";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            PropertyApplication application = mapRowToApplication(results);
            applicationList.add(application);
        }
        return applicationList;
    };

    public List<PropertyApplication> retrieveApplicationsByOwnerId(int ownerId) {
        List<PropertyApplication> applicationList = new ArrayList<>();

        String sql = "SELECT applications.* FROM applications JOIN property ON property.property_id=applications.property_id WHERE property.owner_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);

        while (results.next()) {
            PropertyApplication application = mapRowToApplication(results);
            applicationList.add(application);
        }
        return applicationList;
    }

    @Override
    public void updateApplicationStatus(int applicationId,PropertyApplication application) {
        String applicationSQL ="UPDATE applications SET status = ? WHERE application_id = ?;\n";
        jdbcTemplate.update(applicationSQL,application.getStatus(),applicationId);
    }

    ;


    private PropertyApplication mapRowToApplication(SqlRowSet results) {
        PropertyApplication application = new PropertyApplication();

        application.setApplicationId(results.getInt("application_id"));
        application.setFirstName(results.getString("first_name"));
        application.setLastName(results.getString("last_name"));
        application.setPhone(results.getString("phone"));
        application.setEmail(results.getString("email"));
        application.setPropertyId(results.getInt("property_id"));
        application.setIncome(results.getString("income"));
        application.setStatus(results.getString("status"));
        application.setUserId(results.getInt("user_id"));
        application.setApplicationDate(results.getDate("application_date"));

        return application;
    }
}
