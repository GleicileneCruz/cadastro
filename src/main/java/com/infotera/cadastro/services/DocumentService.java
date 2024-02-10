package com.infotera.cadastro.services;

import com.infotera.cadastro.models.Document;
import com.infotera.cadastro.models.dtos.DocumentDto;
import com.infotera.cadastro.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository repository;
    public Document createDocument(DocumentDto dto) {
        Document newDocument = new Document(dto);
        return repository.save(newDocument);
    }

    public List<Document> getAllDocument() {
        Sort sort = Sort.by("documentType").ascending();
        return repository.findAll(sort);
    }

    public Optional<Document> getUserById(Integer id){
       return repository.findById(id);
    }

    public void updateDocument(Integer id, DocumentDto dto) {
        var userExists = repository.findById(id);
        if(userExists.isPresent()){
            var user = userExists.get();
            if(dto.getDocumentNumber() != null){
                user.setDocumentNumber(dto.getDocumentNumber());
            }
            if(dto.getDocumentType()!= null){
                user.setDocumentType(dto.getDocumentType());
            }
            repository.save(user);
        }
    }

    public void deleteById(Integer id) {
        var userExists = repository.existsById(id);
        if (userExists) {
            repository.deleteById(id);
        }
    }
}
