package com.techelevator.dao.JDBC;

import com.techelevator.dao.PaymentDAO;
import com.techelevator.model.Address;
import com.techelevator.model.Payment;
import com.techelevator.model.PropertyApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentJDBCDAO implements PaymentDAO {
    private JdbcTemplate jdbcTemplate;

    public PaymentJDBCDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void makePayment(Payment payment) {

        String sql = "INSERT INTO payments ( property_id, user_id, payment_date, payment_amount) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                payment.getPropertyId(),
                payment.getUserId(),
                payment.getDate(),
                payment.getAmount());
    }


    @Override
    public List<Payment> getPaymentByUserId() {
        List<Payment> paymentList = new ArrayList<>();

        String sql = "SELECT payments.*,applications.first_name,applications.last_name, address.*, payments.user_id,payments.property_id, payments.payment_amount\n" +
                "                           FROM payments\n" +
                "                                JOIN applications ON payments.user_id = applications.user_id\n" +
                "                                JOIN property on property.property_id = payments.property_id\n" +
                "                                JOIN address on address.address_id = property.address_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Payment payment = mapRowToPayment(results);
            paymentList.add(payment);
        }
        return paymentList;

    }

    @Override
    public List<Payment> retrievePaymentsByOwnerId(int ownerId) {
        List<Payment> paymentList = new ArrayList<>();

        String sql = "SELECT users.username , payment_date, payment_amount FROM payments JOIN users on users.user_id = payments.user_id\n" +
                "JOIN property ON property.property_id=payments.property_id WHERE owner_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);

        while (results.next()) {
            Payment payment = new Payment();
            payment.setFirstName(results.getString("username"));
            payment.setDate(results.getDate("payment_date"));
            payment.setAmount(results.getBigDecimal("payment_amount"));

            paymentList.add(payment);
        }
        return paymentList;
    }

    private Payment mapRowToPayment(SqlRowSet results) {
        Payment payment = new Payment();

        payment.setPaymentId(results.getInt("payment_id"));
        payment.setPropertyId(results.getInt("property_id"));
        payment.setUserId((results.getInt("user_id")));
        payment.setDate(results.getDate("payment_date"));
        payment.setAmount(results.getBigDecimal("payment_amount"));
        payment.setFirstName(results.getString("first_name"));
        payment.setLastName(results.getString("last_name"));

        Address address = new Address();
        address.setAddressLine(results.getString("address_line"));
        address.setCity(results.getString("city"));
        address.setState(results.getString("state"));
        address.setZipCode(results.getInt("zip"));

        payment.setAddress(address);

        return payment;
    }
}
