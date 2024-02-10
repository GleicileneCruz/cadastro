package com.infotera.cadastro.services;

import com.infotera.cadastro.models.Address;
import com.infotera.cadastro.models.dtos.AddressDto;
import com.infotera.cadastro.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;
    public Address createAddress(AddressDto dto) {
        Address newAddress = new Address(dto);
        return repository.save(newAddress);
    }

    public List<Address> getAll() {
        Sort sort = Sort.by("address").ascending();
        return repository.findAll(sort);
    }

    public Optional<Address> getAddressById(Integer id){
        return repository.findById(id);
    }

    public void updateAddress(Integer id, AddressDto dto) {
        var addressExists = repository.findById(id);
        if(addressExists.isPresent()){
            var user = addressExists.get();
            if(dto.getAddress() != null){
                user.setAddress(dto.getAddress());
            }
            if(dto.getNumber() != null){
                user.setNumber(dto.getNumber());
            }
            if(dto.getCity() != null){
                user.setCity(dto.getCity());
            }
            if(dto.getState() != null){
                user.setState(dto.getState());
            }
            if(dto.getCountry() != null){
                user.setCountry(dto.getCountry());
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
