package com.other.security.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="address")
public class Address extends Audit {
    @Column(name="address_id")
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long addressId;

    @NotBlank @Column(name="house_no")
    private String houseNo;

    @NotBlank @Column(name="street")
    private String street;

    @NotBlank @Column(name="state")
    private String state;

    @NotBlank @Column(name="city")
    private String city;

    @NotBlank @Column(name="postcode")
    private String postcode;

    @Column(name="landmark")
    private String landmark;

    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Employee.class)
    @JoinColumn(name="employee_id")
    private Employee employee;

}
