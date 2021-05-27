package com.example.courier.service.update;


import com.example.courier.entityy.Order;
import com.example.courier.entityy.Status;

public interface UpdateOrderService {

    Order updateOrderStatus(Order order, Status status);

}