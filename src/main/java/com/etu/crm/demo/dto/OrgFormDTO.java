package com.etu.crm.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgFormDTO {

    private String name;
    private List<String> actions;
    private List<String> nameOfProduct;


    private Long contact_id;
    private String country;
    private String city;
    private String location;
    private String telephone;

    private Long op_id;
    private List<String> acquired;
    private List<String> sale;
    private List<String> hiring;
}
