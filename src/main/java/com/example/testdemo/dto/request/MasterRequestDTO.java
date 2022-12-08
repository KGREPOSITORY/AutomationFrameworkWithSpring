package com.example.testdemo.dto.request;

import com.example.testdemo.database.entities.Service;
import com.example.testdemo.dto.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class MasterRequestDTO extends AbstractDTO {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("services")
    @JsonIgnore
    private List<Service> services;

    public MasterRequestDTO(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public MasterRequestDTO(String firstName, String lastName, String phoneNumber, List<Service> services) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.services = services;
    }
}
