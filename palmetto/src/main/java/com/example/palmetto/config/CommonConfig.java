package com.example.palmetto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class CommonConfig {

//    @Bean
//    public JsonDeserializer<Order> jsonDeserializer (ObjectMapper objectMapper){
//      JsonDeserializer<Order> jsonDeserializer =  new JsonDeserializer<>(Order.class, objectMapper);
//      jsonDeserializer.addTrustedPackages("*");
//        return jsonDeserializer;
//    }
}