package com.mdakimball.petclinic.repositories;

import com.mdakimball.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
