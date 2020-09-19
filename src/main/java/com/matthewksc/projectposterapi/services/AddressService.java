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

    public Address findById(Long id) {
        return addressRepo
                .findById(id)
                .orElseThrow(()-> new RuntimeException("No such Address with id: " +id));
    }

    public Iterable<Address> saveAll(Iterable<Address> addresses) {
        return addressRepo.saveAll(addresses);
    }

    public Address save(Optional<Address> address) {
        if (address.isPresent()){
            return addressRepo.save(address.get());
        }else{
            throw new RuntimeException("No object of address is presented");
        }
    }

    public void deleteById(Long id) {
        addressRepo.findById(id)
                .ifPresent(address -> addressRepo.delete(address));
    }

}
