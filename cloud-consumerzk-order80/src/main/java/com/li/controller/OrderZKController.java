package com.li.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderZKController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/9 10:05
 * @Version 1.0
 */
@RestController
public class OrderZKController {

    private static final String INVOKE_URL ="http://cloud-provider-payment";

    @Autowired
     private RestTemplate  restTemplate;


    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        System.out.println("消费者调用支付服务(zookeeper)--->result:" + result);
        return result;
    }

}
