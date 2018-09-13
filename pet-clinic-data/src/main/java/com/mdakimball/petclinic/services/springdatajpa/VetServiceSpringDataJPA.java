package com.mdakimball.petclinic.services.springdatajpa;

import com.mdakimball.petclinic.model.Vet;
import com.mdakimball.petclinic.repositories.VetRepository;
import com.mdakimball.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class VetServiceSpringDataJPA implements VetService {

    private final VetRepository vetRepository;

    public VetServiceSpringDataJPA(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        return new HashSet<>((Collection<Vet>) vetRepository.findAll());
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}