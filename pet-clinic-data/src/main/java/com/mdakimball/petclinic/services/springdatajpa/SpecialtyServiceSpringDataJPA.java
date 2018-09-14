package com.mdakimball.petclinic.services.springdatajpa;

import com.mdakimball.petclinic.model.Specialty;
import com.mdakimball.petclinic.repositories.SpecialtyRepository;
import com.mdakimball.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class SpecialtyServiceSpringDataJPA implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceSpringDataJPA(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return new HashSet<>((Collection<Specialty>) specialtyRepository.findAll());
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
