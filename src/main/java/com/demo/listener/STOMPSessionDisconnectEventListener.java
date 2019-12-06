package com.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class STOMPSessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        System.err.println("这是断开连接监听器打印的结果-------------");
        System.err.println(event.getSessionId());
        System.err.println(event.getCloseStatus());
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        System.err.println("命令：" + sha.getCommand());
        System.err.println("确认包" + sha.getAck());
        System.err.println("Host" + sha.getHost());
        System.err.println("sessionID" + sha.getSessionId());
        System.err.println("sessionAttr" + sha.getSessionAttributes());
        System.err.println("这是断开连接监听器打印结果结束-------------");
    }
}
