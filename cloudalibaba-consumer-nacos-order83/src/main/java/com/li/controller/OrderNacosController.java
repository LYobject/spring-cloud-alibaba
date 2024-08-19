package com.li.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderNacosController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/15 14:12
 * @Version 1.0
 */
@RestController
public class OrderNacosController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${service-url}")
    String serviceUrl;


    @RequestMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serviceUrl+"/payment/nacos/"+id,String.class);
    }
}
