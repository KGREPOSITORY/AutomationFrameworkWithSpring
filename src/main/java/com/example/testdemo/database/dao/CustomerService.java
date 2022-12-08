package com.example.testdemo.database.dao;

import com.example.testdemo.database.perository.CustomerRepository;
import com.example.testdemo.database.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

}
