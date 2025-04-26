package com.inn.kafkatask.consumerspringboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.inn.kafkatask.consumerspringboot.dao.OrderRepository;
import com.inn.kafkatask.consumerspringboot.entity.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consume(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        OrderTable order = mapper.readValue(message, OrderTable.class);
        orderRepository.save(order);
        //System.out.println("Saved order: " + order.getCustomerName());
        System.out.println("Received order: " + order);
        System.out.println("Customer Name: " + order.getCustomerName());
    }
}
