package com.matthewksc.projectposterapi.backend.repositories;

import com.matthewksc.projectposterapi.backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
