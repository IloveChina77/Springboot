package com.demo;

import com.demo.listener.STOMPConnectEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRun {
    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(ApplicationRun.class);
//        springApplication.addListeners(new STOMPConnectEventListener());
//        springApplication.run(args);
        SpringApplication.run(ApplicationRun.class, args);

    }
}
