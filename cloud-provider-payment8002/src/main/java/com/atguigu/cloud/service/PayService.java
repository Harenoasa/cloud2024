package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName:PayService
 * Package:com.atguigu.cloud.service
 * Description:
 *
 * @Author Harenoasa
 * @Create 2024/8/22 19:54
 * @Version 1.0
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
