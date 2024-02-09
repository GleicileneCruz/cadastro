package com.infotera.cadastro.model.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PersonDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String telephone;

    public PersonDto(){
    }
    public PersonDto(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
