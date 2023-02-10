package com.emociones.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {

    private @Id @GeneratedValue int employeeID;

    private String firstName;
    private String lastName;
    private String employeePhone;
    private String employeeEmailAddress;

    Employee() {};
    public Employee(int employeeId, String firstName, String lastName, String employeePhone, String employeeEmailAddress) {
        this.employeeID = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeePhone = employeePhone;
        this.employeeEmailAddress = employeeEmailAddress;
    }
}
