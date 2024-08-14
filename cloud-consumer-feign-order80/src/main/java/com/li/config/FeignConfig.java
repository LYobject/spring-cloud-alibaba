package com.li.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Description TODO
 * @Author LiYe
 * @Date 2024/8/13 8:19
 * @Version 1.0
 */
@Configuration
public class FeignConfig {


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
