package com.example.courier.service.kafka;


import com.example.courier.entityy.Order;
import com.example.courier.entityy.Status;
import com.example.courier.service.update.UpdateOrderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CourierKafkaListener {

    @Autowired
    private CourierKafkaService courierKafkaService;

    @Autowired
    private UpdateOrderService updateOrderService;


    @KafkaListener(topics = "notificationTopic", groupId = "courierGroup")
    public void notificationListener(ConsumerRecord<Long, Order> record) {
        Order order = record.value();
        if (order.getStatus() == Status.ORDER_IS_READY) {
            System.out.println(order + " received by courier");

            Order updatedToDeliveringStatusOrder = updateOrderService.updateOrderStatus(order, Status.DELIVERING);
            courierKafkaService.sendOrderToKafkaTopic("notificationTopic", updatedToDeliveringStatusOrder);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Order updatedToDeliveredStatusOrder = updateOrderService.updateOrderStatus(order, Status.DELIVERED);
            courierKafkaService.sendOrderToKafkaTopic("notificationTopic", updatedToDeliveredStatusOrder);
        }

    }
}
