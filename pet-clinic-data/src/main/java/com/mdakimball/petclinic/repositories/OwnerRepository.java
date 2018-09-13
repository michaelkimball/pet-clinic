package com.mdakimball.petclinic.repositories;

import com.mdakimball.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
