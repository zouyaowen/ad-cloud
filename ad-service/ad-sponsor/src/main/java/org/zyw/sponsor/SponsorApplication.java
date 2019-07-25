package org.zyw.sponsor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zouyaowen
 * @Description: SpringBootApplication标明是一个微服务,
 * EnableFeignClients可以调用其他的微服务，此处只是为了dashboard调用
 * EnableEurekaClient标明是微服务客户端
 * EnableCircuitBreaker断路器，实现监控
 * @Date: 1:25 2019/7/25
 * @Modifyed by:
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class SponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class, args);
    }
}
