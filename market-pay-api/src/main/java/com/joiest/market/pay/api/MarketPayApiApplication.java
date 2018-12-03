package com.joiest.market.pay.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 支付系统主启动类
 * @author zhouchaowei 
 */
@SpringBootApplication
public class MarketPayApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketPayApiApplication.class, args);
    }
}
