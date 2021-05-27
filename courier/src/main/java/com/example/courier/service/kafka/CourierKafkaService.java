package com.example.courier.service.kafka;


import com.example.courier.entityy.Order;

public interface CourierKafkaService {

    void sendOrderToKafkaTopic(String topic, Order order);
}
