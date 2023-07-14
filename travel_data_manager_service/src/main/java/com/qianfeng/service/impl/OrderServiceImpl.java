package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IOrderDao;
import com.qianfeng.domain.Orders;
import com.qianfeng.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 20:50
 * 描述：TODO
 */
@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements IOrderService {
    @Resource
    IOrderDao iOrderDao;

    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Orders> orders=iOrderDao.findAll();
        return orders;
    }

    @Override
    public Orders findById(String id) {
        Orders orders=iOrderDao.findById(id);
        return orders;
    }

    @Override
    public void delete(String[] id) {
        for (String s : id) {
            iOrderDao.delete(s);
        }

    }
}
