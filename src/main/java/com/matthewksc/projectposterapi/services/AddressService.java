package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.Address;
import com.matthewksc.projectposterapi.repositories.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Iterable<Address> findAll() {
        return addressRepo.findAll();
    }

    public Optional<Address> findById(Long id) {
        return addressRepo.findById(id);
    }

    public Iterable<Address> saveAll(Iterable<Address> addresses) {
        return addressRepo.saveAll(addresses);
    }

    public Address save(Address address) {
        return addressRepo.save(address);
    }

    public void deleteById(Long id) {
        addressRepo.deleteById(id);
    }
}
