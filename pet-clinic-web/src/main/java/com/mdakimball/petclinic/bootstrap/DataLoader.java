package com.mdakimball.petclinic.bootstrap;

import com.mdakimball.petclinic.model.Owner;
import com.mdakimball.petclinic.model.Vet;
import com.mdakimball.petclinic.services.OwnerService;
import com.mdakimball.petclinic.services.VetService;
import com.mdakimball.petclinic.services.map.OwnerServiceMap;
import com.mdakimball.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Vince");
        owner1.setLastName("Reynolds");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Alice");
        owner2.setLastName("Adair");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Camille");
        vet1.setLastName("Belden");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Nick");
        vet2.setLastName("Campbell");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
