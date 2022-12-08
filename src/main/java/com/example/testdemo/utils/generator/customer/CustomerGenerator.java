package com.example.testdemo.utils.generator.customer;

import com.example.testdemo.database.entities.Customer;
import com.example.testdemo.utils.FakerUtil;
import com.example.testdemo.utils.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerGenerator implements Generator<Customer> {

    @Autowired
    FakerUtil fakerUtil;

    @Override
    public Customer generateValidData() {
        return new Customer(fakerUtil.getValidName(),
                fakerUtil.getValidLastName(),
                fakerUtil.getValidNumber());
    }

    @Override
    public Customer generateInvalidDta() {
        return null;
    }
}
