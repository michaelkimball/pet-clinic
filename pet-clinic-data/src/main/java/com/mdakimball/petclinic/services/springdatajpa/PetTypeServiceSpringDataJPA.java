package com.mdakimball.petclinic.services.springdatajpa;

import com.mdakimball.petclinic.model.PetType;
import com.mdakimball.petclinic.repositories.PetTypeRepository;
import com.mdakimball.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class PetTypeServiceSpringDataJPA implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceSpringDataJPA(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return new HashSet<>((Collection<PetType>) petTypeRepository.findAll());
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
