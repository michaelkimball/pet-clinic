package com.mdakimball.petclinic.bootstrap;

import com.mdakimball.petclinic.model.Owner;
import com.mdakimball.petclinic.model.Pet;
import com.mdakimball.petclinic.model.PetType;
import com.mdakimball.petclinic.model.Vet;
import com.mdakimball.petclinic.services.OwnerService;
import com.mdakimball.petclinic.services.PetTypeService;
import com.mdakimball.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        cat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Vince");
        owner1.setLastName("Reynolds");
        owner1.setAddress("Melbrook Suite #1");
        owner1.setCity("Lander");
        owner1.setTelephone("14445556666");
        Pet vinceDog = new Pet();
        vinceDog.setName("Globe");
        vinceDog.setPetType(dog);
        vinceDog.setOwner(owner1);
        vinceDog.setBirthDate(LocalDate.now());
        owner1.getPets().add(vinceDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alice");
        owner2.setLastName("Adair");
        owner2.setAddress("Melbrook Suite #5");
        owner2.setCity("Lander");
        owner2.setTelephone("15556667777");
        Pet aliceCat = new Pet();
        aliceCat.setName("Shelby");
        aliceCat.setPetType(cat);
        aliceCat.setOwner(owner2);
        aliceCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(aliceCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Camille");
        vet1.setLastName("Belden");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nick");
        vet2.setLastName("Campbell");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
