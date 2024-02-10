package com.infotera.cadastro.models.dtos;

import javax.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank
    private String address;

    private String number;

    private String city;

    private String state;

    private String country;

    public AddressDto(){
    }

    public AddressDto(String address, String number, String city, String state, String country) {
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
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
