package com.etu.crm.demo.repository;

import com.etu.crm.demo.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation,String> {
}
