package com.matthewksc.projectposterapi.backend.services;

import com.matthewksc.projectposterapi.backend.entity.Address;
import com.matthewksc.projectposterapi.backend.exceptions.Address.NotFoundAddressException;
import com.matthewksc.projectposterapi.backend.repositories.AddressRepo;
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
                .orElseThrow(()-> new NotFoundAddressException(id));
    }

    public Iterable<Address> saveAll(Iterable<Address> addresses) {
        return addressRepo.saveAll(addresses);
    }

    public Address save(Optional<Address> address) {
        if (address.isPresent()){
            return addressRepo.save(address.get());
        }else{
            throw new NotFoundAddressException();
        }
    }

    public void deleteById(Long id) {
        if (addressRepo.findById(id).isPresent()){
            addressRepo.deleteById(id);
        }else{
            throw new NotFoundAddressException(id);
        }
    }

}
