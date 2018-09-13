package com.mdakimball.petclinic.repositories;

import com.mdakimball.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
