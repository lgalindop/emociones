package com.emociones.order;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long employeeID) {
        super("Could not find employee " + employeeID);
    }
}