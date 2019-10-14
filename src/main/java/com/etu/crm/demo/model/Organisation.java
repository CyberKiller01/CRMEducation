package com.etu.crm.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "organisation")
public class Organisation {

    @Id
    String name;
    Contact contact;
    List<String> actions;
    List<String> nameOfProduct;
    OperationInformation operationInformation;
}
