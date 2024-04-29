package com.MySociety.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String firstname;
     private String lastname;
     private long mobno;
     private String email;
     private  String address;
     private String city;
     @OneToOne(cascade = CascadeType.ALL)
     private Flat flat;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getFirstname() {
          return firstname;
     }

     public void setFirstname(String firstname) {
          this.firstname = firstname;
     }

     public String getLastname() {
          return lastname;
     }

     public void setLastname(String lastname) {
          this.lastname = lastname;
     }

     public long getMobno() {
          return mobno;
     }

     public void setMobno(long mobno) {
          this.mobno = mobno;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public String getCity() {
          return city;
     }

     public void setCity(String city) {
          this.city = city;
     }

     public Flat getFlat() {
          return flat;
     }

     public void setFlat(Flat flat) {
          this.flat = flat;
     }
}
