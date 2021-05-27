package com.example.courier.service.update;


import com.example.courier.entityy.Order;
import com.example.courier.entityy.Status;
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