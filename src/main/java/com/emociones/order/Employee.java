package com.emociones.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    private @Id @GeneratedValue Long employeeID;

    private String firstName;
    private String lastName;
    private String employeePhone;
    private String employeeEmailAddress;


    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }


    public Employee(String firstName, String lastName, String employeePhone, String employeeEmailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeePhone = employeePhone;
        this.employeeEmailAddress = employeeEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeID.equals(employee.employeeID) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && employeePhone.equals(employee.employeePhone) && Objects.equals(employeeEmailAddress, employee.employeeEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName, employeePhone, employeeEmailAddress);
    }
}