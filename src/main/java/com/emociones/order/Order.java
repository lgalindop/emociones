package com.emociones.order;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderID;
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;
    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "number_of_adults_in_quote", nullable = false)
    private int numberOfAdultsInQuote;
    @Column(name = "number_of_minors_in_quote")
    private int numberOfMinorsInQuote;
    @Column(name = "minor_one_age")
    private int minorOneAge;
    @Column(name = "minor_two_age")
    private int minorTwoAge;
    @Column(name = "minor_three_age")
    private int minorThreeAge;
    @Column(name = "number_of_days")
    private int numberOfDays;
    @Column(name = "number_of_nights")
    private int numberOfNights;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "hotel_price")
    private BigDecimal hotelPrice;
    @Column(name = "hotel_type")
    private String hotelType;
    @Column(name = "transport_type")
    private String transportType;
    @Column(name = "transport_carrier")
    private String transportCarrier;
    @Column(name = "transport_price")
    private BigDecimal transportPrice;
    @Column(name = "transport_checkin_date")
    private LocalDate transportCheckInDate;
    @Column(name = "transport_checkout_date")
    private LocalDate transportCheckOutDate;
    @Column(name = "shuttle_service_name")
    private String shuttleServiceName;
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(LocalDate checkInDate, LocalDate checkOutDate, String customerPhone, int numberOfAdultsInQuote, OrderStatus orderStatus) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerPhone = customerPhone;
        this.numberOfAdultsInQuote = numberOfAdultsInQuote;
        this.orderStatus = orderStatus;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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

    public BigDecimal getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(BigDecimal hotelPrice) {
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

    public BigDecimal getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(BigDecimal transportPrice) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return numberOfAdultsInQuote == order.numberOfAdultsInQuote && numberOfMinorsInQuote == order.numberOfMinorsInQuote && minorOneAge == order.minorOneAge && minorTwoAge == order.minorTwoAge && minorThreeAge == order.minorThreeAge && numberOfDays == order.numberOfDays && numberOfNights == order.numberOfNights && orderID.equals(order.orderID) && checkInDate.equals(order.checkInDate) && checkOutDate.equals(order.checkOutDate) && customerPhone.equals(order.customerPhone) && Objects.equals(hotelName, order.hotelName) && Objects.equals(hotelPrice, order.hotelPrice) && Objects.equals(hotelType, order.hotelType) && Objects.equals(transportType, order.transportType) && Objects.equals(transportCarrier, order.transportCarrier) && Objects.equals(transportPrice, order.transportPrice) && Objects.equals(transportCheckInDate, order.transportCheckInDate) && Objects.equals(transportCheckOutDate, order.transportCheckOutDate) && Objects.equals(shuttleServiceName, order.shuttleServiceName) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, checkInDate, checkOutDate, customerPhone, numberOfAdultsInQuote, numberOfMinorsInQuote, minorOneAge, minorTwoAge, minorThreeAge, numberOfDays, numberOfNights, hotelName, hotelPrice, hotelType, transportType, transportCarrier, transportPrice, transportCheckInDate, transportCheckOutDate, shuttleServiceName, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", customerPhone='" + customerPhone + '\'' +
                ", numberOfAdultsInQuote=" + numberOfAdultsInQuote +
                ", numberOfMinorsInQuote=" + numberOfMinorsInQuote +
                ", minorOneAge=" + minorOneAge +
                ", minorTwoAge=" + minorTwoAge +
                ", minorThreeAge=" + minorThreeAge +
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
                ", orderStatus=" + orderStatus +
                '}';
    }
}
