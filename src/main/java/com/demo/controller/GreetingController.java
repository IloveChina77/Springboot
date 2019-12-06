package com.demo.controller;

import com.demo.pojo.Greeting;
import com.demo.pojo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

@Controller // 使用controller注解来标志这是一个控制器
public class GreetingController {

    @MessageMapping("/hello") //使用MessageMapping注解来标识所有发送到“/hello”这个destination的消息，都会被路由到这个方法进行处理.
    // 用来返回结果给指定地址的用户
    @SendTo("/topic/greetings")//使用SendTo注解来标识这个方法返回的结果，都会被发送到它指定的destination，“/topic/greetings”.
    public Greeting greeting(HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        System.err.println( "Controller 层打印" + message);
        //传入的参数HelloMessage为客户端发送过来的消息，是自动绑定的。
        //Thread.sleep(1000); // simulated delay
        Map<String, Object> attrs = headerAccessor.getSessionAttributes();
        System.err.println("Controller层打印" + attrs.get("RemoteAddress"));

        return new Greeting("用户："+attrs.get("RemoteAddress") + "发送了：" + "Hello," + HtmlUtils.htmlEscape(message.getBody() + "!"));
    }




}
