package com.example.testdemo.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceID")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterID")
    private Master master;

    @Column(name = "time")
    private Date time;

    public Order() {
    }

    public Order(Date time) {
        this.time = time;
    }
}
