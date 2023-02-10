package com.emociones.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue int employeeID;

    private String firstName;
    private String lastName;
    private String employeePhone;
    private String employeeEmailAddress;
}
