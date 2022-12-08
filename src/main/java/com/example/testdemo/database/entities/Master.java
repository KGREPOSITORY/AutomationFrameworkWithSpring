package com.example.testdemo.database.entities;

import com.example.testdemo.dto.request.MasterRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "masters")
public class Master extends AbstractEntity{

    @Column(name = "firstName")
    @NotNull
    private String firstName;
    @Column(name = "lastName")
    @NotNull
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @ManyToMany(mappedBy = "masters",
            fetch = FetchType.EAGER)
    private List<Service> services;
    @OneToMany(mappedBy = "master",
            fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<ServiceProvider> serviceProviders;

    public Master() {
    }

    public Master(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public MasterRequestDTO toRequestDto(){
        return MasterRequestDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .build();
    }

    @Override
    public String toString() {
        return "Master{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", services=" + services +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return Objects.equals(firstName, master.firstName) && Objects.equals(lastName, master.lastName) && Objects.equals(phoneNumber, master.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }
}