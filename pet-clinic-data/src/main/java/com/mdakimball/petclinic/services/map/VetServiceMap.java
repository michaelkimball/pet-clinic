package com.mdakimball.petclinic.services.map;

import com.mdakimball.petclinic.model.Vet;
import com.mdakimball.petclinic.services.SpecialtyService;
import com.mdakimball.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null) {
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null)
                    specialty.setId(specialtyService.save(specialty).getId());
            });
            object = super.save(object);
        }
        return object;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
