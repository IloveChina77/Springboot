package com.demo.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class IpHandShakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                           WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        System.err.println("进入IP获取拦截器~~~~~~~~~~~");
//        System.err.println(request.getPrincipal());
        System.err.println(request.getRemoteAddress());
        System.err.println(request.getLocalAddress());
//        attributes.put("userPrincipal", request.getPrincipal());
        attributes.put("RemoteAddress", request.getRemoteAddress());
        attributes.put("LocalAddress", request.getLocalAddress());

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
