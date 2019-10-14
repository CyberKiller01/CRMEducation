package com.etu.crm.demo.service;

import com.etu.crm.demo.model.Organisation;
import com.etu.crm.demo.repository.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationService {

    private final OrganisationRepo organisationRepo;

    @Autowired
    public OrganisationService(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }

    public void addNewOrganisation(Organisation organisation){
        organisationRepo.save(organisation);
    }
}
