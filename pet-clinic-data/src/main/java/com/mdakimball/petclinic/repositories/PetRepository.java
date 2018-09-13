package com.mdakimball.petclinic.repositories;

import com.mdakimball.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
