package com.etu.crm.demo.service;

import com.etu.crm.demo.model.Contact;
import com.etu.crm.demo.model.OperationInformation;
import com.etu.crm.demo.model.Organisation;
import com.etu.crm.demo.repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class OrganisationService {

    private final OrganisationRepo organisationRepo;

    @Autowired
    public OrganisationService(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }

    @PostConstruct
    private void initDB() {
        List<Organisation> organisations = new ArrayList<>();
        organisations.add(Organisation.builder()
                .name("Yandex")
                .contact(Contact.builder()
                        .city("Москва")
                        .country("Russia")
                        .location("Nevskiy street ")
                        .telephone("+79631111111")
                        .build())
                .operationInformation(OperationInformation.builder()
                        .acquired(Collections.singletonList("Uber"))
                        .hiring(Collections.singletonList("Java Developers"))
                        .sale(Collections.singletonList("Yandex.Eda"))
                        .build())
                .actions(Arrays.asList("Software", "Delivering"))
                .nameOfProduct(Arrays.asList("Yandex.Eda", "Yandex.Taxi", "Yandex.Cloud"))
                .build());

        organisations.add(Organisation.builder()
                .name("Google")
                .contact(Contact.builder()
                        .city("Москва")
                        .country("Russia")
                        .location("Liteiniy street ")
                        .telephone("+79631111111")
                        .build())
                .operationInformation(OperationInformation.builder()
                        .acquired(Collections.singletonList("Uber"))
                        .hiring(Collections.singletonList("Java Developers"))
                        .sale(Collections.singletonList("Yandex.Eda"))
                        .build())
                .actions(Arrays.asList("Software", "Delivering"))
                .nameOfProduct(Arrays.asList("Yandex.Eda", "Yandex.Taxi", "Yandex.Cloud"))
                .build());


        organisationRepo.saveAll(organisations);
    }

    public void addNewOrganisation(Organisation organisation) {
        organisationRepo.save(organisation);
    }

    public Optional<Organisation> getOne(String name) {
        return organisationRepo.findById(name);
    }

    public List<Organisation> getAllOrganisation() {
        return organisationRepo.findAll();
    }
}
