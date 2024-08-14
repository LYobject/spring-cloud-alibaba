package com.li.mapper;


import com.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName PaymentDao
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/7 9:52
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
