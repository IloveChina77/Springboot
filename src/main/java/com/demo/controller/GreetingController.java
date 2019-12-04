package com.demo.controller;

import com.demo.pojo.Greeting;
import com.demo.pojo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
//
//@Controller
//public class GreetingController {
//
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting Greeting(HelloMessage message) throws Exception {
//        System.err.println("收到：" + message.toString() + "消息");
//        //Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello," + HtmlUtils.htmlEscape(message.getName() + "!"));
//    }
//
//
//}
