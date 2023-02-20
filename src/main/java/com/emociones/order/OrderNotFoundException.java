package com.emociones.order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderID) {
        super("Could not find order " + orderID);
    }
}