package com.example.palmetto.service.db;

import com.example.palmetto.entity.Order;
import com.example.palmetto.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDbServiceImpl implements OrderDbService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order addOrder(Order order) {
        Order orderFromDb = repository.save(order);
        System.out.println("Add " + order + " to DB");
        return orderFromDb;
    }

    @Override
    public Order getOrderById(long id) {
        return repository.getOrderById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderFromDb = repository.save(order);
        System.out.println("Updated " + order + " status in DB");
        return orderFromDb;
    }
}