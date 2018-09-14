package com.mdakimball.petclinic.services.springdatajpa;

import com.mdakimball.petclinic.model.Visit;
import com.mdakimball.petclinic.repositories.VisitRepository;
import com.mdakimball.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitServiceSpringDataJPA implements VisitService {
    
    private final VisitRepository visitRepository;

    public VisitServiceSpringDataJPA(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        return new HashSet<>((Collection<Visit>) visitRepository.findAll());
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
