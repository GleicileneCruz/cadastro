package com.infotera.cadastro.services;

import com.infotera.cadastro.models.Contact;
import com.infotera.cadastro.models.dtos.ContactDto;
import com.infotera.cadastro.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;
    public Contact createContact(ContactDto dto) {
        Contact newContact = new Contact(dto);
        return repository.save(newContact);
    }

    public List<Contact> getAll() {
        Sort sort = Sort.by("name").ascending();
        return repository.findAll(sort);
    }

    public Optional<Contact> getUserById(Integer id){
        return repository.findById(id);
    }

    public void updateContact(Integer id, ContactDto dto) {
        var userExists = repository.findById(id);
        if(userExists.isPresent()){
            var user = userExists.get();
            if(dto.getName() != null){
                user.setName(dto.getName());
            }
            if(dto.getEmail() != null){
                user.setEmail(dto.getEmail());
            }
            if(dto.getTelephone() != null){
                user.setTelephone(dto.getTelephone());
            }
            repository.save(user);
        }
    }

    public void deleteById(Integer id) {
        var userExists = repository.existsById(id);
        if(userExists){
            repository.deleteById(id);
        }
    }
}
