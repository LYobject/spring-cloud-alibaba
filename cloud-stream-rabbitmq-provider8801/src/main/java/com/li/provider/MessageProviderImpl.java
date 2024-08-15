package com.li.provider;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/14 16:41
 * @Version 1.0
 */
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider{

    @Resource
    MessageChannel output;

    @Override
    public String send() {
        String serial  = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build()); // 创建并发送消息
        System.out.println("***serial: " + serial);
        return serial;
    }
}
