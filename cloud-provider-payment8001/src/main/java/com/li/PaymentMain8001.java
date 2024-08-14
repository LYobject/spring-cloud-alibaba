package com.li;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//为什么我没添加这个注解，也能使用服务发现功能
public class PaymentMain8001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PaymentMain8001.class, args);
        // for (String beanDefinitionName : context.getBeanDefinitionNames()) {
        //     System.out.println(beanDefinitionName);
        // }


    }
}
