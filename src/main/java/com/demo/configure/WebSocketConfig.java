package com.demo.configure;

import com.demo.interceptor.IpHandShakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
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

        // 开启线程
        ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
        te.setPoolSize(1);
        te.setThreadNamePrefix("wss-heartbeat-thread-");
        te.initialize();


        //指定客户端请求，服务端的请求前缀
        // 将“app”前缀绑定到MessageMapping注解指定的方发上。如"app/hello"被指定用greeting()方法来处理.
        config.setApplicationDestinationPrefixes("/app");

        // 启用SimpleBroker，使得订阅到此“topic”前缀的客户端可以收到greeting消息
        config.enableSimpleBroker("/topic/greetings")
                // 设置心跳信息
                .setHeartbeatValue(new long[]{2000, 2000}).setTaskScheduler(te);
    }

    /**
     * 用来注册EndPoint, "/gs-guide-websocket"即为客户端尝试建立连接的地址
     * 说白了，给前端一个用来建立websocket连接的地址
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        int i=1;
        System.err.println("第"+i+"执行");
        registry.addEndpoint("/gs-guide-websocket")
                .addInterceptors(new IpHandShakeInterceptor())
                .setAllowedOrigins("*") // 开启跨域
                .withSockJS();
        i++;
    }
}
