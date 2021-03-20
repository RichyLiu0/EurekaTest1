package com.rui.srvprovider;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello/{userName}")
    public  String hello(@PathVariable(value = "userName") String userName)
    {
        return  port+":hello," +userName;
    }
}
