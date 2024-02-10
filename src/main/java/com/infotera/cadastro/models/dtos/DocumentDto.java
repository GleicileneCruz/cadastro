package com.infotera.cadastro.models.dtos;

import javax.validation.constraints.NotBlank;

public class DocumentDto {

    @NotBlank
    private String documentNumber;

    private String documentType;

    public  DocumentDto(){
    }

    public DocumentDto(String documentNumber, String documentType){
        this.documentNumber = documentNumber;
        this.documentType = documentType;
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
