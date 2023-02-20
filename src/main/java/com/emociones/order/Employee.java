package com.emociones.order;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(name = "employee_phone", columnNames = {"employee_phone"}))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeID;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_first_name")
    private String secondFirstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    @Column(name = "employee_phone", nullable = false)
    private String employeePhone;
    @Column(name = "employee_email_address")
    private String employeeEmailAddress;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String secondFirstName, String secondLastName, String employeePhone, String employeeEmailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondFirstName = secondFirstName;
        this.secondLastName = secondLastName;
        this.employeePhone = employeePhone;
        this.employeeEmailAddress = employeeEmailAddress;
    }

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

    public String getSecondFirstName() {
        return secondFirstName;
    }

    public void setSecondFirstName(String secondFirstName) {
        this.secondFirstName = secondFirstName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeID.equals(employee.employeeID) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && Objects.equals(secondFirstName, employee.secondFirstName) && Objects.equals(secondLastName, employee.secondLastName) && Objects.equals(employeePhone, employee.employeePhone) && Objects.equals(employeeEmailAddress, employee.employeeEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName, secondFirstName, secondLastName, employeePhone, employeeEmailAddress);
    }
}