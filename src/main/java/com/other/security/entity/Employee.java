package com.other.security.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="employee")
public class Employee extends Audit {

    @Column(name="employee_id")
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @NotBlank @Column(name="email")
    private String email;

    @NotBlank @Column(name="phone")
    private String phone;

    @Column(name = "age")
    private Integer age;

    @Column(name="salary")
    private Double salary;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Set<Address> address;
}
