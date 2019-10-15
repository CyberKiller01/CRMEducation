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
    private void initDB(){
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
                        .acquired(new ArrayList<String>(Arrays.asList("Uber")))
                        .hiring(new ArrayList<String>(Arrays.asList("Java Developers")))
                        .sale(new ArrayList<String>(Arrays.asList("Yandex.Eda")))
                        .build())
                .actions(new ArrayList<String>(Arrays.asList("Software","Delivering")))
                .nameOfProduct(new ArrayList<String>(Arrays.asList("Yandex.Eda","Yandex.Taxi","Yandex.Cloud")))
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
                        .acquired(new ArrayList<String>(Collections.singletonList("Uber")))
                        .hiring(new ArrayList<String>(Collections.singletonList("Java Developers")))
                        .sale(new ArrayList<String>(Collections.singletonList("Yandex.Eda")))
                        .build())
                .actions(new ArrayList<String>(Arrays.asList("Software","Delivering")))
                .nameOfProduct(new ArrayList<String>(Arrays.asList("Yandex.Eda","Yandex.Taxi","Yandex.Cloud")))
                .build());


        organisationRepo.saveAll(organisations);
    }

    public void addNewOrganisation(Organisation organisation){
        organisationRepo.save(organisation);
    }

    public Optional<Organisation> getOne(String name){
        return organisationRepo.findById(name);
    }

    public List<Organisation> getAllOrganisation(){
        return organisationRepo.findAll();
    }
}
