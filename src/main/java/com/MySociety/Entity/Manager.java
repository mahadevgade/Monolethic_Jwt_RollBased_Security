package com.MySociety.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "First Name")
    private String firstname;

    @Column(name = "Last Name")
    private String lastName;

    @Column(name = "Mobile No.")
    private long mobileNo;

    @Column(name = "Email Id")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "City Name")
    private String city;
}
