package com.example.palmetto.service.kafka;

import com.example.palmetto.entity.Order;
import com.example.palmetto.service.db.OrderDbService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClientKafkaListener {

    @Autowired
    private OrderDbService orderDbService;

    @KafkaListener(topics = "notificationTopic", groupId = "clientGroup")
    public void orderListener(ConsumerRecord<Long, Order> record) {
        System.out.println(record.value() + " check if status updated on client");

        orderDbService.updateOrder(record.value());
    }



}