package com.emociones.order;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long partyID;
    @Column(name = "owner_first_name")
    private String ownerFirstname;
    @Column(name = "owner_last_name")
    private String ownerLastName;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "member_first_name", nullable = false)
    private String memberFirstName;
    @Column(name = "member_last_name", nullable = false)
    private String memberLastName;
    @Column(name = "member_age", nullable = false)
    private int memberAge;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Party() {
    }

    public Party(String memberFirstName, String memberLastName) {
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
    }

    public Party(String ownerFirstname, String ownerLastName, String customerPhone, String memberFirstName, String memberLastName, int memberAge) {
        this.ownerFirstname = ownerFirstname;
        this.ownerLastName = ownerLastName;
        this.customerPhone = customerPhone;
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberAge = memberAge;
    }

    public String getPartyMemberName() {
        return this.memberFirstName + " " + this.memberLastName;
    }

    public void setPartyMemberName(String name) {
        String[] parts = name.split(" ");
        this.memberFirstName = parts[0];
        this.memberLastName = parts[1];
    }

    public Long getPartyID() {
        return partyID;
    }

    public void setPartyID(Long partyID) {
        this.partyID = partyID;
    }

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Party party)) return false;
        return memberAge == party.memberAge && partyID.equals(party.partyID) && Objects.equals(ownerFirstname, party.ownerFirstname) && Objects.equals(ownerLastName, party.ownerLastName) && Objects.equals(customerPhone, party.customerPhone) && memberFirstName.equals(party.memberFirstName) && memberLastName.equals(party.memberLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partyID, ownerFirstname, ownerLastName, customerPhone, memberFirstName, memberLastName, memberAge);
    }
}