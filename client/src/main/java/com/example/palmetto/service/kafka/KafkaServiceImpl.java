package com.example.palmetto.service.kafka;

import com.example.palmetto.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<Long, Order> kafkaTemplate;

    @Override
    public void sendOrderToKafkaTopic(String topicName, Order order) {

        ListenableFuture<SendResult<Long, Order>> orderFuture
                = kafkaTemplate.send(topicName, order.getId(), order);

        orderFuture.addCallback(
                c -> {
                    System.out.println("Send " + order + " to " + topicName);
                },
                c -> {
                    System.out.println("Problem while sending " + order + " to " + topicName);
                }
        );
    }

}