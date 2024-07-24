package com.sachin.ex.demoproj.client;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.cloud.openfeign.FeignClient(value = "jplaceholder", url = "http://localhost:8080")
public interface FeignClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String getGreetings();
}
