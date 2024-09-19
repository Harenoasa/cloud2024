package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:PayController
 * Package:com.atguigu.cloud.controller
 * Description:
 *
 * @Author Harenoasa
 * @Create 2024/8/22 20:23
 * @Version 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deleteBody(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.update(pay);

        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照id查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        if(id.equals(-4))throw new RuntimeException("传入id不能为负数");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询所有流水" ,description = "查询所有id的所有流水")
    public ResultData<List<Pay>>getAll(){
        return ResultData.success(payService.getAll());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo){
        return "atguiguInfo:"+atguiguInfo+"\t"+"port:"+port;
    }

    @GetMapping(value = "/pay/error")
    public ResultData<Integer> getPayError()
    {
        try{


            Integer i = Integer.valueOf(200);
            int age = 10/0;
        }catch(Exception e){
            e.printStackTrace();
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return null;
    }


//    public static void main(String[] args) {
//        System.out.println(Integer.valueOf(169) == 169);//true
//        System.out.println(Integer.valueOf(169) == Integer.valueOf(169));//false
//        System.out.println(Integer.valueOf(16) == Integer.valueOf(16));//true
//    }

}
