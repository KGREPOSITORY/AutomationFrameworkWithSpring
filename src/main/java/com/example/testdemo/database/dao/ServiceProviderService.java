package com.example.testdemo.database.dao;


import com.example.testdemo.database.entities.ServiceProvider;
import com.example.testdemo.database.perository.ServiceProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService extends AbstractService<ServiceProvider, ServiceProviderRepository> {

    public ServiceProviderService(ServiceProviderRepository repository) {
        super(repository);
    }

}
