package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.Product;
import com.qianfeng.service.IProductService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 11:33
 * 描述：TODO
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    IProductService iProductService;

    /**
     * 查询所有产品信息并使用分页插件分页
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",name = "page") Integer page,@RequestParam(required = true,defaultValue = "5",name = "pageSize") Integer pageSize){
        List<Product> allProduct = iProductService.findAll(page,pageSize);
        PageInfo <Product> pageInfo=new PageInfo<>(allProduct);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-list");
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteProduct")
    @RolesAllowed("ADMIN")
    public String deleteProduct(String [] ids){
        iProductService.deleteProduct(ids);
        return "redirect:/product/findAll";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteById(String id){
        iProductService.deleteById(id);
        return "redirect:/product/findAll";
    }
    /**
     * 添加产品
     * @param product
     * @return
     */
    @RequestMapping("/addProduct")
    @Secured("ROLE_ADMIN")
    public String addProduct(Product product){
        iProductService.addProduct(product);
        return "redirect:/product/findAll";
    }

    /**
     * 根据id查询,并重定向到前端的产品修改界面
     * @param productId
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String productId){
        Product product=iProductService.findById(productId);
        ModelAndView mav=new ModelAndView();
        mav.addObject("product",product);
        mav.setViewName("product-update");
        return mav;
    }

    @RequestMapping("/update")
    public String update(Product product){
        iProductService.updateProduct(product);
        return "redirect:/product/findAll";
    }
}
