package com.li.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/13 10:52
 * @Version 1.0
 */
@Component //必须加 //必须加 //必须加
public class PaymentFallbackService implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall  paymentInfo_OK----- °(°ˊДˋ°) °";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall  paymentInfo_TimeOut----- °(°ˊДˋ°) °";
    }
}
