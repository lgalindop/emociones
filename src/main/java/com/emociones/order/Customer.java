package com.emociones.order;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer"/*, uniqueConstraints = @UniqueConstraint(name = "customer_phone", columnNames = {"customer_phone"})*/)
public class Customer {
    @Column(name = "customer_id", unique = true, nullable = false, insertable = false, updatable = false, columnDefinition = "SERIAL")
    private Long customerID;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_first_name")
    private String secondFirstName;
    @Column(name = "third_first_name")
    private String thirdFirstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    @Id
    @Column(name = "customer_phone", length = 13, nullable = false, unique = true)
    private String customerPhone;
    @Column(name = "customer_phone_country_code")
    private String customerPhoneCountryCode;
    @Column(name = "customer_secondary_phone")
    private String customerSecondaryPhone;
    @Column(name = "customer_secondary_phone_country_code")
    private String customerSecondaryPhoneCountryCode;
    @Column(name = "street")
    private String street;
    @Column(name = "address_number")
    private String addressNumber;
    @Column(name = "address_number_interior")
    private String addressNumberInterior;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Column(name = "personal_id")
    private String personalID;
    @Column(name = "personal_id_code")
    private String personalIDCode;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String customerPhone, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerPhone = customerPhone;
        this.emailAddress = emailAddress;
    }

    public Customer(String firstName, String secondFirstName, String thirdFirstName, String lastName, String secondLastName, String customerPhone, String customerPhoneCountryCode, String customerSecondaryPhone, String customerSecondaryPhoneCountryCode, String street, String addressNumber, String addressNumberInterior, String city, String zipCode, String emailAddress, String personalID, String personalIDCode) {
        this.firstName = firstName;
        this.secondFirstName = secondFirstName;
        this.thirdFirstName = thirdFirstName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.customerPhone = customerPhone;
        this.customerPhoneCountryCode = customerPhoneCountryCode;
        this.customerSecondaryPhone = customerSecondaryPhone;
        this.customerSecondaryPhoneCountryCode = customerSecondaryPhoneCountryCode;
        this.street = street;
        this.addressNumber = addressNumber;
        this.addressNumberInterior = addressNumberInterior;
        this.city = city;
        this.zipCode = zipCode;
        this.emailAddress = emailAddress;
        this.personalID = personalID;
        this.personalIDCode = personalIDCode;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondFirstName() {
        return secondFirstName;
    }

    public void setSecondFirstName(String secondFirstName) {
        this.secondFirstName = secondFirstName;
    }

    public String getThirdFirstName() {
        return thirdFirstName;
    }

    public void setThirdFirstName(String thirdFirstName) {
        this.thirdFirstName = thirdFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhoneCountryCode() {
        return customerPhoneCountryCode;
    }

    public void setCustomerPhoneCountryCode(String customerPhoneCountryCode) {
        this.customerPhoneCountryCode = customerPhoneCountryCode;
    }

    public String getCustomerSecondaryPhone() {
        return customerSecondaryPhone;
    }

    public void setCustomerSecondaryPhone(String customerSecondaryPhone) {
        this.customerSecondaryPhone = customerSecondaryPhone;
    }

    public String getCustomerSecondaryPhoneCountryCode() {
        return customerSecondaryPhoneCountryCode;
    }

    public void setCustomerSecondaryPhoneCountryCode(String customerSecondaryPhoneCountryCode) {
        this.customerSecondaryPhoneCountryCode = customerSecondaryPhoneCountryCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressNumberInterior() {
        return addressNumberInterior;
    }

    public void setAddressNumberInterior(String addressNumberInterior) {
        this.addressNumberInterior = addressNumberInterior;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPersonalIDCode() {
        return personalIDCode;
    }

    public void setPersonalIDCode(String personalIDCode) {
        this.personalIDCode = personalIDCode;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return customerID.equals(customer.customerID) && firstName.equals(customer.firstName) && Objects.equals(secondFirstName, customer.secondFirstName) && Objects.equals(thirdFirstName, customer.thirdFirstName) && lastName.equals(customer.lastName) && Objects.equals(secondLastName, customer.secondLastName) && Objects.equals(customerPhone, customer.customerPhone) && Objects.equals(customerPhoneCountryCode, customer.customerPhoneCountryCode) && Objects.equals(customerSecondaryPhone, customer.customerSecondaryPhone) && Objects.equals(customerSecondaryPhoneCountryCode, customer.customerSecondaryPhoneCountryCode) && Objects.equals(street, customer.street) && Objects.equals(addressNumber, customer.addressNumber) && Objects.equals(addressNumberInterior, customer.addressNumberInterior) && Objects.equals(city, customer.city) && Objects.equals(zipCode, customer.zipCode) && emailAddress.equals(customer.emailAddress) && Objects.equals(personalID, customer.personalID) && Objects.equals(personalIDCode, customer.personalIDCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, secondFirstName, thirdFirstName, lastName, secondLastName, customerPhone, customerPhoneCountryCode, customerSecondaryPhone, customerSecondaryPhoneCountryCode, street, addressNumber, addressNumberInterior, city, zipCode, emailAddress, personalID, personalIDCode);
    }
}