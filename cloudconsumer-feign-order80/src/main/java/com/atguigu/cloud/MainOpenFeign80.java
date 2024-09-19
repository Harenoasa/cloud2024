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
 * @Create 2024/8/28 17:08
 * @Version 1.0
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MainOpenFeign80 {
    public static void main(String[] args) {
          SpringApplication.run(MainOpenFeign80.class, args);
       }
}