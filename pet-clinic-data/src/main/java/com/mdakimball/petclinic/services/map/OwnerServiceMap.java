package com.mdakimball.petclinic.services.map;

import com.mdakimball.petclinic.model.Owner;
import com.mdakimball.petclinic.services.OwnerService;
import com.mdakimball.petclinic.services.PetService;
import com.mdakimball.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null) {
            object.getPets().forEach(pet -> {
                if(pet.getPetType() != null){
                    if(pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else
                    throw new RuntimeException("Pet Type is required");
                if(pet.getId() == null)
                    pet.setId(petService.save(pet).getId());
            });
            object = super.save(object);
        }
        return object;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
