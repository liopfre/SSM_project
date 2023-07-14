package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.Orders;
import com.qianfeng.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 20:45
 * 描述：TODO
 */
@RequestMapping("/orders")
@Controller
public class OrderController {

    @Resource
    IOrderService iOrderService;

    /**
     * 查询所有订单
     * @param page
     * @param pageSize
     * @return
     */

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "3")Integer pageSize){
        List<Orders> orders=iOrderService.findAll(page,pageSize);
        PageInfo<Orders> pageInfo=new PageInfo<>(orders);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("orders-list");
        mav.addObject("pageInfo",pageInfo);
        return mav;
    }

    /**
     * 根据id查找订单信息并返回详情页面
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Orders orders = iOrderService.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("orders-show");
        mav.addObject("orders",orders);
        return mav;
    }

    @RequestMapping("deleteOrder")
    public String deleteOrder(String[] ids){
        iOrderService.delete(ids);
        return "redirect:/orders/findAll";
    }

}
