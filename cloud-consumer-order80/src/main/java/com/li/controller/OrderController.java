package com.li.controller;

import com.pojo.CommonResult;
import com.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/7 13:50
 * @Version 1.0
 */
@RestController
public class OrderController {

    // private static final String requestUrl = "http://localhost:8001";
     private static final String requestUrl = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult createOrder(Payment payment){
        return restTemplate.postForObject(requestUrl+"/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(requestUrl+"/payment/get/"+id, CommonResult.class);
    }
}
