package com.mdakimball.petclinic.services.springdatajpa;

import com.mdakimball.petclinic.model.Pet;
import com.mdakimball.petclinic.repositories.PetRepository;
import com.mdakimball.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetServiceSpringDataJPA implements PetService {

    private final PetRepository petRepository;

    public PetServiceSpringDataJPA(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return new HashSet<>((Collection<Pet>) petRepository.findAll());
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
