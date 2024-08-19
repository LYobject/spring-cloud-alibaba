package com.li.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/15 14:54
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {
    
    @Value("${config.name}")
    String name;


    @RequestMapping("/config/info")
    public String getConfigInfo(){
        return name;
    }
}
