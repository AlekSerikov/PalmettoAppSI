package com.example.palmetto.controller;

import com.example.palmetto.entity.Order;
import com.example.palmetto.service.db.OrderDbService;
import com.example.palmetto.service.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class OrderController {

    @Autowired
    private OrderDbService orderDbService;

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order) {
        Order orderFromDb = orderDbService.addOrder(order);
        kafkaService.sendOrderToKafkaTopic("orderTopic", orderFromDb);
        return orderFromDb;
    }

    @GetMapping("/order/{id}")
    public Order getOrderStatus(@PathVariable long id){

        System.out.println(id);
        return orderDbService.getOrderById(id);
    }

}