package com.etu.crm.demo.mapper;

import com.etu.crm.demo.dto.OrgFormDTO;
import com.etu.crm.demo.model.Contact;
import com.etu.crm.demo.model.OperationInformation;
import com.etu.crm.demo.model.Organisation;

public class OrganisationMapper {

    public static OrgFormDTO organisationToDTO(Organisation org) {
        return OrgFormDTO
                .builder()
                .name(org.getName())
                .actions(org.getActions())
                .nameOfProduct(org.getNameOfProduct())
                .contact_id(org.getContact().getContact_id())
                .country(org.getContact().getCountry())
                .city(org.getContact().getCity())
                .location(org.getContact().getLocation())
                .telephone(org.getContact().getTelephone())
                .op_id(org.getOperationInformation().getOp_id())
                .acquired(org.getOperationInformation().getAcquired())
                .sale(org.getOperationInformation().getSale())
                .hiring(org.getOperationInformation().getHiring())
                .build();

    }

    public static Organisation DTOtoOrganisation(OrgFormDTO org){
        return Organisation
                .builder()
                .name(org.getName())
                .actions(org.getActions())
                .nameOfProduct(org.getNameOfProduct())
                .contact(Contact
                        .builder()
                        .contact_id(org.getContact_id())
                        .country(org.getCountry())
                        .city(org.getCity())
                        .location(org.getLocation())
                        .telephone(org.getTelephone())
                        .build())
                .operationInformation(OperationInformation
                        .builder()
                        .op_id(org.getOp_id())
                        .sale(org.getSale())
                        .hiring(org.getHiring())
                        .acquired(org.getAcquired())
                        .build())
                .build();
    }
}
