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
@Table(name = "operation_information")
public class OperationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long op_id;

    @ElementCollection
    @CollectionTable(name="acquired", joinColumns=@JoinColumn(name="op_id"))
    @Column(name="acquired")
    private List<String> acquired;

    @ElementCollection
    @CollectionTable(name="sale", joinColumns=@JoinColumn(name="op_id"))
    @Column(name="sale")
    private List<String> sale;

    @ElementCollection
    @CollectionTable(name="hiring", joinColumns=@JoinColumn(name="op_id"))
    @Column(name="hiring")
    private List<String> hiring;

    @OneToOne(optional = false, mappedBy = "operationInformation")
    private Organisation organisation;
}
