package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:${NAME}
 * Package:com.atguigu.cloud
 * Description:$description
 *
 * @Author Harenoasa
 * @Create 2024/9/15 12:13
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Main83 {
    public static void main(String[] args) {
          SpringApplication.run(Main83.class, args);
       }
}