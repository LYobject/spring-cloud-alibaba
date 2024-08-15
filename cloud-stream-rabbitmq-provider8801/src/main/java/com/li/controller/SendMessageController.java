package com.li.controller;

import com.li.provider.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/15 8:05
 * @Version 1.0
 */
@RestController
public class SendMessageController {
    @Autowired
    IMessageProvider iMessageProvider;


    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }


}
