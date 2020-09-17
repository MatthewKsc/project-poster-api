package com.matthewksc.projectposterapi.repositories;

import com.matthewksc.projectposterapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
