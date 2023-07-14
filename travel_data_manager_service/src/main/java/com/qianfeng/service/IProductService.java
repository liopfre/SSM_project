package com.qianfeng.service;

import com.qianfeng.domain.Product;

import java.util.List;

/**
 * @Title: IProductService
 * @Author laowang
 * @Package com.qianfeng.service
 * @Date 2023/5/29 16:26
 * @description: 产品的业务层接口
 */
public interface IProductService {

    List<Product> findAll(Integer page,Integer pageSize);

    void deleteProduct(String[] ids);

    void addProduct(Product product);

    void deleteById(String id);

    Product findById(String id);

    void updateProduct(Product product);
}
