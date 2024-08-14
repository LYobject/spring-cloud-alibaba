package com.li.service;



import com.pojo.Payment;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/7 10:04
 * @Version 1.0
 */

public interface PaymentService {
   int create(Payment payment);
   Payment getPaymentById(Long id);
}
