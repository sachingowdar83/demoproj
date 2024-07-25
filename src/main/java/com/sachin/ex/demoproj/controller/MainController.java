package com.sachin.ex.demoproj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sachin.ex.demoproj.client.FeignClient;
import com.sachin.ex.demoproj.entities.UserEntity;
import com.sachin.ex.demoproj.kafka.SendMessage;
import com.sachin.ex.demoproj.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableFeignClients
@Slf4j
public class MainController {

    @Autowired
    AccountService accountService;
    @Autowired
    FeignClient client;

    @Autowired
    SendMessage message;

    @GetMapping("/account/{accno}")
    @Cacheable("cacheme")
    public ResponseEntity<String> validateAccNumber(@PathVariable Integer accno ){
        log.info("CACHE Hit");
        if(accountService.validateAcc(accno)){
            return ResponseEntity.ok("Valid");
        }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/addUser")
    public ResponseEntity<UserEntity> addUser(){
        return  ResponseEntity.ok(accountService.addUser());
    }

    @GetMapping("/greet")
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public ResponseEntity<String> greet(){
        return  ResponseEntity.ok(client.getGreetings());
    }

    @GetMapping("/testKafka")
    public String  testkafka(){
        message.sendMessage("my-topic", "Hello! Sachin");
        return "SENT!";
    }
    private String defaultGreeting() {
        return "Hello User!";
    }
}
