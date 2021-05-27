package com.example.palmetto.service.db;

import com.example.palmetto.entity.Order;

public interface OrderDbService {

    Order addOrder(Order order);

    Order getOrderById(long id);

    Order updateOrder(Order order);
}