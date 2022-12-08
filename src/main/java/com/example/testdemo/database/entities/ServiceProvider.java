package com.example.testdemo.database.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "service_providers")
public class ServiceProvider extends AbstractEntity{

    @Column(name = "serviceID")
    @NotNull
    private int serviceID;
    @Column(name = "masterID")
    @NotNull
    private long masterID;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceID",
            nullable = false,
            insertable = false,
            updatable = false)
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterID",
            nullable = false,
            insertable = false,
            updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Master master;


    public ServiceProvider(int serviceID, long masterID) {
        this.serviceID = serviceID;
        this.masterID = masterID;
    }

    public ServiceProvider() {
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "serviceID=" + serviceID +
                ", masterID=" + masterID +
                '}';
    }
}