package com.example.palmetto.service.kafka;


import com.example.palmetto.entity.Order;

public interface KafkaService {

    void sendOrderToKafkaTopic(String topic, Order order);

}