package com.example.palmetto.service.update;


import com.example.palmetto.entity.Order;
import com.example.palmetto.entity.Status;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

    @Override
    public Order updateOrderStatus(Order order, Status status) {
        System.out.println(order + " status changed to " + status.name());
        order.setStatus(status);
        return order;
    }
}