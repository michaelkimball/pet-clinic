package com.mdakimball.petclinic.repositories;

import com.mdakimball.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
