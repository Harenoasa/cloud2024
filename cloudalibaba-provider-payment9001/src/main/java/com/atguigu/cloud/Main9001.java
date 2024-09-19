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
 * @Create 2024/9/15 9:20
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001 {
   public static void main(String[] args) {
         SpringApplication.run(Main9001.class, args);
      }
}