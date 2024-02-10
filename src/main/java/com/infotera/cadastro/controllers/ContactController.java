package com.infotera.cadastro.controllers;

import com.infotera.cadastro.models.Contact;
import com.infotera.cadastro.models.dtos.ContactDto;
import com.infotera.cadastro.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService service;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody @Valid ContactDto dto){
        Contact newContact = service.createContact(dto);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateContact(@PathVariable ("id") Integer id,
                                             @RequestBody ContactDto dto){
        service.updateContact(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
