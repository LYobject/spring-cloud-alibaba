package com.li.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/13 8:42
 * @Version 1.0
 */
@Service
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id+"\t" + "O(∩_∩)O";
    }

    // @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
    //         @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    @HystrixCommand
   public String paymentInfo_TimeOut(Integer id){
        int age =10/0;
        int second =5;
       try {
           TimeUnit.SECONDS.sleep(second);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费3秒";
   }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) throws InterruptedException {
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t" + "\t当前线程池名字" + Thread.currentThread().getName();
    }


    public String payment_Global_FallbackMethod() {
        return "Global  对方的系统繁忙或者已经宕机，请十秒后在尝试！,o(╥﹏╥)o";
    }

    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期(时间范围)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
