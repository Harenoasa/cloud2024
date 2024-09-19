package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:${NAME}
 * Package:com.atguigu.cloud
 * Description:$description
 *
 * @Author Harenoasa
 * @Create 2024/8/23 15:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main80 {
    public static void main(String[] args) {
          SpringApplication.run(Main80.class, args);
       }

}