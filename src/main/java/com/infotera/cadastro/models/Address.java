package com.infotera.cadastro.models;

import com.infotera.cadastro.models.dtos.AddressDto;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private String number;

    private String city;

    private String state;

    private String country;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(){
    }

    public Address(AddressDto dto) {
        this.address = dto.getAddress();
        this.number = dto.getNumber();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.country = dto.getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
