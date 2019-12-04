package com.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//@Configuration // indicate that it is a Spring configuration class
//@EnableWebSocketMessageBroker // enable WebSocket message handling, backed by a message broker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    /**
//     * 就是配置 the message broker
//     * @param config
//     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//
//        config.enableSimpleBroker("/topic");
//        //指定客户端请求，服务端的请求前缀
//        config.setApplicationDestinationPrefixes("/app");
//
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/gs-guide-websocket").withSockJS();
//    }
//}
