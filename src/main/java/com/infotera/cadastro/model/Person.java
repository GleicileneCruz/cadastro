package com.infotera.cadastro.model;

import com.infotera.cadastro.model.dtos.PersonDto;

import javax.persistence.*;
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String email;
    private String telephone;

    public Person() {
    }

    public Person(PersonDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.telephone = dto.getTelephone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
