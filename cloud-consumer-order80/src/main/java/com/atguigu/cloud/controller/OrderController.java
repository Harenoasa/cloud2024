package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName:OrderController
 * Package:com.atguigu.cloud.controller
 * Description:
 *
 * @Author Harenoasa
 * @Create 2024/8/23 16:27
 * @Version 1.0
 */
@RestController
public class OrderController {
//    public static final String PaymentSrv_URL = "http://localhost:8081";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,
                ResultData.class, id);
    }
    @DeleteMapping("/consumer/pay/del/{id}")
    public ResultData delPay(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/del/"+id,ResultData.class,id);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
