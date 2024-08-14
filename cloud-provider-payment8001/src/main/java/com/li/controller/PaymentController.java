package com.li.controller;

import com.li.service.PaymentService;
import com.pojo.CommonResult;
import com.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/7 10:33
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    DiscoveryClient discoveryClient;


    /**
     * @Author: 李烨
     * @Description:
     * @DateTime:
     * @Params:
     * @Return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        //获取所注册eureka里面的所有服务名称
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
        }
        //获取某个具体服务名称下的服务信息
        for (ServiceInstance instance : discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")) {
            System.out.println(instance.getServiceId() + "\t" +instance.getHost()+"\t"+ instance.getPort() +"\t" + instance.getUri());
        }
        return this.discoveryClient;

    }

    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功,返回结果" + result + "\t 服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + "\t 服务端口：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

    /**
     * @Author: 李烨
     * @Description: 编写一个方式让程序睡三秒
     * @DateTime:  
     * @Params: 
     * @Return 
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        System.out.println("*****paymentFeignTimeOut from port: " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort;
    }


}
