package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
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

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {

        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        ResultData resultData = null;
        System.out.println("-----支付微服务远程调用，按照id查询订单支付流水信息");
        try{
            System.out.println("调用开始："+ DateUtil.now());
            resultData = payFeignApi.getPayInfo(id);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("--调用结束："+DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }


    @GetMapping("/feign/pay/mylb")
    public String mylb(){
        return payFeignApi.mylb();
    }

}
