package com.atguigu.cloud.exception;

/**
 * ClassName:GlobalExceptionHandler
 * Package:com.atguigu.cloud.exception
 * Description:
 *
 * @Author Harenoasa
 * @Create 2024/8/23 14:14
 * @Version 1.0
 */

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exceoption(Exception e) {
        System.out.println("####come in GlobalExceptionHandle");
        log.error("全局异常信息：{}",e.getMessage(),e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }



}
