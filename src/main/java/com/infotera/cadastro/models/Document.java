package com.infotera.cadastro.models;

import com.infotera.cadastro.models.dtos.DocumentDto;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String documentNumber;

    private String documentType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Document(){
    }

    public Document(DocumentDto dto) {
        this.documentNumber = dto.getDocumentNumber();
        this.documentType = dto.getDocumentType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
