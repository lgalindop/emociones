package com.emociones.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.util.Currency;

@Data
@Entity
@Table(name = "customer_order")
public class Order {
    private @Id @GeneratedValue String orderID;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfAdultsInQuote;
    private int numberOfMinorsInQuote;
    private int minorOneAge;
    private int minorTwoAge;
    private int minorThreeAge;
    private String customerPhone;
    private int numberOfDays;
    private int numberOfNights;
    private String hotelName;
    private Currency hotelPrice;
    private String hotelType;
    private String transportType;
    private String transportCarrier;
    private Currency transportPrice;
    private Date transportCheckInDate;
    private Date transportCheckOutDate;
    private String shuttleServiceName;
    private String orderStatus;
}
