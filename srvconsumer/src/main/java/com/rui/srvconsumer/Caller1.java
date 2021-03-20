package com.rui.srvconsumer;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class Caller1 {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate();
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello()
    {
        RestTemplate template=getRestTemplate();
        String retVal=template.getForEntity("http://SrvProvider/hello/Eureka",String.class).getBody();
        return  "我是消费者," +retVal;
    }

}



