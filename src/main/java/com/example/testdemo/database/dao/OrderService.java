package com.example.testdemo.database.dao;

import com.example.testdemo.database.entities.Order;
import com.example.testdemo.database.perository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order, OrderRepository>{

    public OrderService(OrderRepository repository) {
        super(repository);
    }
}
