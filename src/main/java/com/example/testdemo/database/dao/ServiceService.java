package com.example.testdemo.database.dao;


import com.example.testdemo.database.entities.Service;
import com.example.testdemo.database.perository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService extends AbstractService<Service, ServiceRepository> {

    public ServiceService(ServiceRepository repository) {
        super(repository);
    }
}
