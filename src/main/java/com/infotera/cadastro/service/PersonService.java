package com.infotera.cadastro.service;

import com.infotera.cadastro.model.Person;
import com.infotera.cadastro.model.dtos.PersonDto;
import com.infotera.cadastro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;
    public Person createPerson(PersonDto dto) {
        Person newPerson = new Person(dto);
        return repository.save(newPerson);
    }

    public List<Person> getAllPerson() {
        Sort sort = Sort.by("name").ascending();
        return repository.findAll(sort);
    }

    public Optional<Person> getUserById(Integer id){
        return repository.findById(id);
    }

    public void updatePerson(Integer id, PersonDto dto) {
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
