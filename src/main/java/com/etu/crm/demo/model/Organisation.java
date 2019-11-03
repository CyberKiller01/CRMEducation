package com.etu.crm.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "organisation")
public class Organisation {

    @Id
    @Column(name = "name")
    private String name;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ElementCollection
    @CollectionTable(name = "actions", joinColumns = @JoinColumn(name = "name"))
    @Column(name = "actions")
    private List<String> actions;

    @ElementCollection
    @CollectionTable(name = "name_of_product", joinColumns = @JoinColumn(name = "name"))
    @Column(name = "name_of_product")
    private List<String> nameOfProduct;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "op_id")
    private OperationInformation operationInformation;
}
