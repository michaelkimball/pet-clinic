package com.mdakimball.petclinic.services;

import com.mdakimball.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
