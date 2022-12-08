package com.example.testdemo.database.perository;

import com.example.testdemo.database.entities.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CommonRepository<Customer>{

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
