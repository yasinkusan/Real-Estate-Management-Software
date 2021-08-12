package com.techelevator.dao;

import com.techelevator.model.Payment;
import com.techelevator.model.PropertyApplication;

import java.util.List;

public interface PaymentDAO {
    void makePayment(Payment payment);
    List<Payment> getPaymentByUserId();
    List<Payment> retrievePaymentsByOwnerId(int ownerId);

}
