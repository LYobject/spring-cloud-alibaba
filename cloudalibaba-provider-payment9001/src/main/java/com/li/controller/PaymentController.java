package com.li.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/15 13:55
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    String port;


    @RequestMapping("payment/nacos/{id}")
    public String getPayment(@PathVariable Integer id){
        return "nacos registry, serverPort: " + port + "\t id" + id;
    }
}
