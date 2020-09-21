package com.matthewksc.projectposterapi.services;

import com.matthewksc.projectposterapi.entity.Address;
import com.matthewksc.projectposterapi.repositories.AddressRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    AddressRepo addressRepo;

    @InjectMocks
    AddressService addressService;

    @Test
    void findById(){
        List<Address> address = initData();

        given(addressRepo.findById(1L)).willReturn(Optional.of(address.get(0)));
        given(addressRepo.findById(3L)).willReturn(Optional.of(address.get(1)));

        Address result = addressService.findById(1L);
        Address result2 = addressService.findById(3L);

        assertAll(
                ()-> assertEquals(address.get(0), result),
                ()-> assertEquals(address.get(1), result2),
                ()-> assertNotEquals(address.get(0), result2),
                ()-> assertNotEquals(address.get(1), result),
                ()-> assertThrows(RuntimeException.class , ()->addressService.findById(2L))
        );
    }

    @Test
    void saveAll(){
        List<Address> addresses = initData();
        given(addressRepo.saveAll(addresses)).willReturn(addresses);

        List<Address> result = (List<Address>) addressService.saveAll(addresses);
        List<Address> fake = new ArrayList<>();

        assertAll(
                ()-> assertEquals(addresses.size(), result.size()),
                ()-> assertEquals(addresses.get(0), result.get(0)),
                ()-> assertEquals(addresses.get(1), result.get(1)),
                ()-> assertSame(addresses, result),
                ()-> assertNotSame(fake, result),
                ()-> verify(addressRepo, times(1)).saveAll(addresses)
        );

    }

    @Test
    void save(){
        Address address = new Address();
        given(addressRepo.save(address)).willReturn(address);

        Address result = addressService.save(Optional.of(address));
        Address fake = new Address();

        assertAll(
                ()-> assertEquals(address, result),
                ()-> assertNotEquals(fake, result),
                ()-> verify(addressRepo, times(1)).save(address),
                ()-> assertThrows(RuntimeException.class, ()-> addressService.save(null))
        );
    }

    @Test
    void deleteById(){
        Address address = new Address();

        given(addressRepo.findById(1L)).willReturn(Optional.of(address));
        addressService.deleteById(1L);

        assertAll(
                ()->verify(addressRepo, times(1)).deleteById(1L),
                ()->verify(addressRepo, times(0)).deleteById(2L),
                ()->assertThrows(RuntimeException.class, ()-> addressService.deleteById(3L))
        );
    }

    public List<Address> initData(){
        return Arrays.asList(
                new Address(),
                new Address());
    }

}
