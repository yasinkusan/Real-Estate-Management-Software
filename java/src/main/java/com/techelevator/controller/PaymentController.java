package com.techelevator.controller;

import com.techelevator.dao.PaymentDAO;
import com.techelevator.model.Payment;
import com.techelevator.model.PropertyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentDAO paymentDAO;
//
//    @RequestMapping(path= "/payments/{propertyId}", method= RequestMethod.GET)
//    public List<Payment> getPaymentByPropertyId(@RequestParam int propertyId) {
//        return paymentDAO.getPaymentByPropertyId(propertyId);
//    };

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path= "/payments", method = RequestMethod.POST)
    public void makePayment(@RequestBody Payment payment) {
        paymentDAO.makePayment(payment);
    };

    @RequestMapping(path= "/payments", method= RequestMethod.GET)
    public List<Payment> getPaymentByUserId() {
        return paymentDAO.getPaymentByUserId();
    }

    @RequestMapping(path = "/payments/{userId}", method = RequestMethod.GET)
    public List<Payment> retrievePaymentsByOwnerId(@PathVariable int userId) {
        return paymentDAO.retrievePaymentsByOwnerId(userId);
    };
}
