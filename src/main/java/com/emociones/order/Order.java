package com.emociones.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
public class Order {
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfAdultsInQuote() {
        return numberOfAdultsInQuote;
    }

    public void setNumberOfAdultsInQuote(int numberOfAdultsInQuote) {
        this.numberOfAdultsInQuote = numberOfAdultsInQuote;
    }

    public int getNumberOfMinorsInQuote() {
        return numberOfMinorsInQuote;
    }

    public void setNumberOfMinorsInQuote(int numberOfMinorsInQuote) {
        this.numberOfMinorsInQuote = numberOfMinorsInQuote;
    }

    public int getMinorOneAge() {
        return minorOneAge;
    }

    public void setMinorOneAge(int minorOneAge) {
        this.minorOneAge = minorOneAge;
    }

    public int getMinorTwoAge() {
        return minorTwoAge;
    }

    public void setMinorTwoAge(int minorTwoAge) {
        this.minorTwoAge = minorTwoAge;
    }

    public int getMinorThreeAge() {
        return minorThreeAge;
    }

    public void setMinorThreeAge(int minorThreeAge) {
        this.minorThreeAge = minorThreeAge;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Currency getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(Currency hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportCarrier() {
        return transportCarrier;
    }

    public void setTransportCarrier(String transportCarrier) {
        this.transportCarrier = transportCarrier;
    }

    public Currency getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(Currency transportPrice) {
        this.transportPrice = transportPrice;
    }

    public LocalDate getTransportCheckInDate() {
        return transportCheckInDate;
    }

    public void setTransportCheckInDate(LocalDate transportCheckInDate) {
        this.transportCheckInDate = transportCheckInDate;
    }

    public LocalDate getTransportCheckOutDate() {
        return transportCheckOutDate;
    }

    public void setTransportCheckOutDate(LocalDate transportCheckOutDate) {
        this.transportCheckOutDate = transportCheckOutDate;
    }

    public String getShuttleServiceName() {
        return shuttleServiceName;
    }

    public void setShuttleServiceName(String shuttleServiceName) {
        this.shuttleServiceName = shuttleServiceName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY", Locale.ENGLISH);
    LocalDate LuisBirthDayDate = LocalDate.parse("15/12/1984", formatter);
    private @Id @GeneratedValue String orderID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
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
    private LocalDate transportCheckInDate;
    private LocalDate transportCheckOutDate;
    private String shuttleServiceName;
    private OrderStatus orderStatus;

    public Order(LocalDate checkInDate, LocalDate checkOutDate, int numberOfAdultsInQuote, int numberOfMinorsInQuote, int minorOneAge, int minorTwoAge, int minorThreeAge, String customerPhone, int numberOfDays, int numberOfNights, String hotelName, Currency hotelPrice, String hotelType, String transportType, String transportCarrier, Currency transportPrice, LocalDate transportCheckInDate, LocalDate transportCheckOutDate, String shuttleServiceName, OrderStatus orderStatus) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfAdultsInQuote = numberOfAdultsInQuote;
        this.numberOfMinorsInQuote = numberOfMinorsInQuote;
        this.minorOneAge = minorOneAge;
        this.minorTwoAge = minorTwoAge;
        this.minorThreeAge = minorThreeAge;
        this.customerPhone = customerPhone;
        this.numberOfDays = numberOfDays;
        this.numberOfNights = numberOfNights;
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.hotelType = hotelType;
        this.transportType = transportType;
        this.transportCarrier = transportCarrier;
        this.transportPrice = transportPrice;
        this.transportCheckInDate = transportCheckInDate;
        this.transportCheckOutDate = transportCheckOutDate;
        this.shuttleServiceName = shuttleServiceName;
        this.orderStatus = orderStatus;
    }

    public Order(LocalDate checkInDate, LocalDate checkOutDate, int numberOfAdultsInQuote, String customerPhone, OrderStatus orderStatus) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfAdultsInQuote = numberOfAdultsInQuote;
        this.customerPhone = customerPhone;
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return numberOfAdultsInQuote == order.numberOfAdultsInQuote && numberOfMinorsInQuote == order.numberOfMinorsInQuote && minorOneAge == order.minorOneAge && minorTwoAge == order.minorTwoAge && minorThreeAge == order.minorThreeAge && numberOfDays == order.numberOfDays && numberOfNights == order.numberOfNights && orderID.equals(order.orderID) && checkInDate.equals(order.checkInDate) && checkOutDate.equals(order.checkOutDate) && customerPhone.equals(order.customerPhone) && Objects.equals(hotelName, order.hotelName) && Objects.equals(hotelPrice, order.hotelPrice) && Objects.equals(hotelType, order.hotelType) && Objects.equals(transportType, order.transportType) && Objects.equals(transportCarrier, order.transportCarrier) && Objects.equals(transportPrice, order.transportPrice) && Objects.equals(transportCheckInDate, order.transportCheckInDate) && Objects.equals(transportCheckOutDate, order.transportCheckOutDate) && Objects.equals(shuttleServiceName, order.shuttleServiceName) && orderStatus.equals(order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, checkInDate, checkOutDate, numberOfAdultsInQuote, numberOfMinorsInQuote, minorOneAge, minorTwoAge, minorThreeAge, customerPhone, numberOfDays, numberOfNights, hotelName, hotelPrice, hotelType, transportType, transportCarrier, transportPrice, transportCheckInDate, transportCheckOutDate, shuttleServiceName, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfAdultsInQuote=" + numberOfAdultsInQuote +
                ", numberOfMinorsInQuote=" + numberOfMinorsInQuote +
                ", minorOneAge=" + minorOneAge +
                ", minorTwoAge=" + minorTwoAge +
                ", minorThreeAge=" + minorThreeAge +
                ", customerPhone='" + customerPhone + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", numberOfNights=" + numberOfNights +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPrice=" + hotelPrice +
                ", hotelType='" + hotelType + '\'' +
                ", transportType='" + transportType + '\'' +
                ", transportCarrier='" + transportCarrier + '\'' +
                ", transportPrice=" + transportPrice +
                ", transportCheckInDate=" + transportCheckInDate +
                ", transportCheckOutDate=" + transportCheckOutDate +
                ", shuttleServiceName='" + shuttleServiceName + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
