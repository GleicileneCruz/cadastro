package com.infotera.cadastro.controllers;

import com.infotera.cadastro.models.Address;
import com.infotera.cadastro.models.dtos.AddressDto;
import com.infotera.cadastro.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody @Valid AddressDto dto){
        Address newAddress = service.createAddress(dto);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> getAddressById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getAddressById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable ("id") Integer id,
                                             @RequestBody AddressDto dto){
        service.updateAddress(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
