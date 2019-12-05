package com.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // 标识这是一个Springboot的配置类
@EnableWebSocketMessageBroker // 使用此注解来标识 能使用WebSocket的broker，即使用broker来处理消息
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 就是配置 broker（消息代理）
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //指定客户端请求，服务端的请求前缀
        // 将“app”前缀绑定到MessageMapping注解指定的方发上。如"app/hello"被指定用greeting()方法来处理.
        config.setApplicationDestinationPrefixes("/app");

        // 启用SimpleBroker，使得订阅到此“topic”前缀的客户端可以收到greeting消息
        config.enableSimpleBroker("/topic/greetings");
    }

    /**
     * 用来注册EndPoint, "/gs-guide-websocket"即为客户端尝试建立连接的地址
     * 说白了，给前端一个用来建立websocket连接的地址
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket")
                .setAllowedOrigins("*") // 开启跨域
                .withSockJS();
    }
}
