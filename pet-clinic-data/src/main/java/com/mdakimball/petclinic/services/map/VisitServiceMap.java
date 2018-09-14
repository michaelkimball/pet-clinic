package com.mdakimball.petclinic.services.map;

import com.mdakimball.petclinic.model.Visit;
import com.mdakimball.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        Objects.requireNonNull(object.getPet());
        Objects.requireNonNull(object.getPet().getOwner());
        Objects.requireNonNull(object.getPet().getId());
        Objects.requireNonNull(object.getPet().getOwner().getId());

        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

}
