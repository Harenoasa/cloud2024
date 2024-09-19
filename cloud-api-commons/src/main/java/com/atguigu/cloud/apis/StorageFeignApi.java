package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:StorageFeignApi
 * Package:com.atguigu.cloud.apis
 * Description:
 *
 * @Author Harenoasa
 * @Create 2024/9/19 18:36
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {

    @PostMapping(value = "/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);

}
