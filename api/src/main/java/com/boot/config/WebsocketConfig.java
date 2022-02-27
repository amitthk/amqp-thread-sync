package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Value("${spring.rabbitmq.host}")
    String rmqHost;

    @Value("${spring.rabbitmq.port}")
    Integer rmqPort;

    @Value("${spring.rabbitmq.username}")
    String rmqUser;

    @Value("${spring.rabbitmq.password}")
    String rmqPassw;


    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/websocket-chat")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/topic/").setRelayHost(rmqHost).setRelayPort(rmqPort).setClientLogin(rmqUser)
                .setClientPasscode(rmqPassw);
        registry.setApplicationDestinationPrefixes("/app");
    }
}