package com.guier.mall.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


// @EnableEurekaClient
// @EnableDiscoveryClient
// @SpringBootApplication
// @EnableFeignClients(basePackages = "com.guier.*")
// @EnableJpaRepositories(basePackages = {"com.guier.*"})
// @EntityScan(basePackages = {"com.guier.*"})
// @EnableAsync
@ComponentScan(basePackages = { "com.guier.*" })
// @EnableScheduling

@SpringBootApplication
@MapperScan(basePackages = {"com.guier.mall.goods.dao"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }
}
