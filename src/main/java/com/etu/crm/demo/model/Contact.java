package com.etu.crm.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "contact")
public class Contact {

    @Id
    private Long contact_id;

    @Column(name = "country")
    private String country;
    @Column(name ="city")
    private String city;
    @Column(name = "location")
    private String location;
    @Column(name = "telephone")
    private String telephone;

    @OneToOne(optional = false, mappedBy = "contact")
    private Organisation organisation;
}
