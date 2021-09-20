package com.boot.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingkey}")
    private String routingkey;
    String kafkaTopic = "java_in_use_topic";

    public void send(Object item) {
        amqpTemplate.convertAndSend(exchange, routingkey, item);
        System.out.println("Send msg = " + item);

    }
}