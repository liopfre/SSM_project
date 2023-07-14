package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IProductDao;
import com.qianfeng.domain.Product;
import com.qianfeng.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 11:36
 * 描述：TODO
 */
@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements IProductService {
    @Resource
    IProductDao iProductDao;

    @Override
    public List<Product> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Product> productList = iProductDao.findAll();
        return productList;
    }

    @Override
    public void deleteProduct(String[] ids) {
        for (String id : ids) {
            iProductDao.deleteProduct(id);
        }
    }

    @Override
    public void addProduct(Product product) {
        String uuid = UUID.randomUUID().toString();
        product.setId(uuid);
        iProductDao.addProduct(product);
    }

    @Override
    public void deleteById(String id) {
        iProductDao.deleteProduct(id);
    }

    @Override
    public Product findById(String id) {
        Product product=iProductDao.findProductById(id);
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        iProductDao.updateProduct(product);
    }

}
