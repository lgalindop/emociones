package com.emociones.order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long employeeID) {
        super("Could not find employee " + employeeID);
    }
}