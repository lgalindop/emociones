package com.emociones.order;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerID) {
        super("Could not find customer " + customerID);
    }
}