package com.infotera.cadastro.controller;

import com.infotera.cadastro.model.Person;
import com.infotera.cadastro.model.dtos.PersonDto;
import com.infotera.cadastro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDto dto){
        Person newPerson = service.createPerson(dto);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return new ResponseEntity<>(service.getAllPerson(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable ("id") Integer id,
                                             @RequestBody PersonDto dto){
        service.updatePerson(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
