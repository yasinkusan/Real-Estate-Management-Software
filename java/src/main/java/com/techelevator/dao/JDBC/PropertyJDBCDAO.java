package com.techelevator.dao.JDBC;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Address;
import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyJDBCDAO implements PropertyDAO {
    private JdbcTemplate jdbcTemplate;

    public PropertyJDBCDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Property> retrievePropertiesForRent() {
        List<Property> propertyList = new ArrayList<Property>();

        String sql = "SELECT property.*, address.* " +
                "FROM property " +
                "JOIN address ON property.address_id = address.address_id " +
                "WHERE property.is_available = true";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Property property = mapRowToProperty(results);
            propertyList.add(property);
        }
        return propertyList;
    }

    @Override
    public List<Property> retrievePropertiesByOwnerId(int ownerId) {
        List<Property> propertyList = new ArrayList<Property>();

        String sql = "SELECT property.*, address.* " +
                "FROM property " +
                "JOIN address ON property.address_id = address.address_id " +
                "WHERE property.is_available = true AND property.owner_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);

        while (results.next()) {
            Property property = mapRowToProperty(results);
            propertyList.add(property);
        }
        return propertyList;
    }

    @Override
    public void addProperty(Property property) {
        int nextAddressId = getNextAddressId();

        String addressSQL = "INSERT INTO address(address_id, address_line, city, state, zip) " +
                "VALUES(?, ?, ?, ?, ?)";

        jdbcTemplate.update(addressSQL,
                nextAddressId,
                property.getAddress().getAddressLine(),
                property.getAddress().getCity(),
                property.getAddress().getState(),
                property.getAddress().getZipCode()
        );

        String propertySQL = "INSERT INTO property (image_name, address_id, number_of_bathrooms, number_of_bedrooms, price, " +
                "short_description,property_type,pets,washer,dryer,dishwasher,owner_id, square_ft) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(propertySQL,
                property.getImageName(),
                nextAddressId,
                property.getNumberOfBathrooms(),
                property.getNumberOfBedrooms(),
                property.getRentAmount(),
                property.getDescription(),
                property.getPropertyType(),
                property.isPet(),
                property.isWasher(),
                property.isDryer(),
                property.isDishwasher(),
                property.getOwnerId(),
                property.getSize()
        );
    }

    @Override
    public List<Property> retrievePropertiesByUserId(int userId) {
        List<Property> propertyList = new ArrayList<Property>();

        String sql = "SELECT DISTINCT property.*, address.* FROM property\n" +
                "JOIN address ON property.address_id = address.address_id "+
                "JOIN applications on property.property_id=applications.property_id\n" +
                "Where applications.user_id=? and applications.status='approved'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Property property = mapRowToProperty(results);
            propertyList.add(property);
        }
        return propertyList;
    }

    @Override
    public void deleteByPropertyId(int propertyId) {
        String deleteSQL="DELETE FROM property WHERE property_id = ?;";
        jdbcTemplate.update(deleteSQL, propertyId);
    }

    private Property mapRowToProperty(SqlRowSet results) {
        Property property = new Property();

        property.setNumberOfBathrooms(results.getDouble("number_of_bathrooms"));
        property.setPropertyId(results.getInt("property_id"));
        property.setImageName(results.getString("image_name"));
        property.setRentAmount(results.getBigDecimal("price"));
        property.setNumberOfBedrooms(results.getDouble("number_of_bedrooms"));
        property.setDescription(results.getString("short_description"));
        property.setPropertyType(results.getString("property_type"));
        property.setDishwasher(results.getBoolean("dishwasher"));
        property.setPet(results.getBoolean("pets"));
        property.setDryer(results.getBoolean("dryer"));
        property.setWasher(results.getBoolean("washer"));
        property.setSize(results.getInt("square_ft"));

        Address address = new Address();
        address.setAddressLine(results.getString("address_line"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZipCode(results.getInt("zip"));

        property.setAddress(address);

        property.setOwnerId(results.getInt("owner_id"));

        return property;
    }

    private int getNextAddressId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('address_address_id_seq')");
        if(nextIdResult.next()) {
            return nextIdResult.getInt(1);
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new address");
        }
    }
}
