package com.infotera.cadastro.controllers;

import com.infotera.cadastro.models.Document;
import com.infotera.cadastro.models.dtos.DocumentDto;
import com.infotera.cadastro.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService service;

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody @Valid DocumentDto dto){
        Document newDocument = service.createDocument(dto);
        return new ResponseEntity<>(newDocument, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocument(){
        return new ResponseEntity<>(service.getAllDocument(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Document>> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDocument(@PathVariable ("id") Integer id,
                                             @RequestBody DocumentDto dto){
        service.updateDocument(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
