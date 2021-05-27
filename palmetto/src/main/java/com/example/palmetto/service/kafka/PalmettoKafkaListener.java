package com.example.palmetto.service.kafka;


import com.example.palmetto.entity.Order;
import com.example.palmetto.entity.Status;
import com.example.palmetto.service.update.UpdateOrderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PalmettoKafkaListener {

    @Autowired
    private UpdateOrderService updateOrderService;

    @Autowired
    private  KafkaService kafkaService;

    @KafkaListener(topics = "orderTopic", groupId = "palmettoGroup")
    public void orderListener(ConsumerRecord<Long, Order> record) {
        System.out.println("listener1");
        processOrder(record);
    }

    @KafkaListener(topics = "orderTopic", groupId = "palmettoGroup")
    public void orderListener1(ConsumerRecord<Long, Order> record) {
        System.out.println("listener2");
        processOrder(record);
    }

    @KafkaListener(topics = "orderTopic", groupId = "palmettoGroup")
    public void orderListener2(ConsumerRecord<Long, Order> record) {
        System.out.println("listener3");
        processOrder(record);
    }

    private void processOrder(ConsumerRecord<Long, Order> record){
        System.out.println(record.value() + " received in palmetto pizzeria");
        Order updatedOrder = updateOrderService.updateOrderStatus(record.value(), Status.COOKING);
        kafkaService.sendOrderToKafkaTopic("notificationTopic", updatedOrder);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order readyOrder = updateOrderService.updateOrderStatus(record.value(), Status.ORDER_IS_READY);
        kafkaService.sendOrderToKafkaTopic("notificationTopic", readyOrder);
    }



}