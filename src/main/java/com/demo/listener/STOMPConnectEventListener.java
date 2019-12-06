package com.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Component
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        System.err.println(sha.getHost());
        System.err.println(sha.getCommand());
        if(sha.getCommand() != null && sha.getCommand() == StompCommand.CONNECT ) {
            //判断客户端的连接状态
            System.err.println("用户上线");
        }
    }
}