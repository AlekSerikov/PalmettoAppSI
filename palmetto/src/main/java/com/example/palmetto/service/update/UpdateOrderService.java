package com.example.palmetto.service.update;


import com.example.palmetto.entity.Order;
import com.example.palmetto.entity.Status;

public interface UpdateOrderService {

    Order updateOrderStatus(Order order, Status status);

}