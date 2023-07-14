package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.Permissions;
import com.qianfeng.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 18:23
 * 描述：TODO
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    IPermissionService iPermissionService;

    @RequestMapping("/findAll")
    public ModelAndView permission(@RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam(name = "pageSize",defaultValue = "3")Integer pageSize){
        List<Permissions> permissions=iPermissionService.findAll(page,pageSize);
        PageInfo<Permissions> pageInfo = new PageInfo<>(permissions);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("permission-list");
        mav.addObject("pagInfo",pageInfo);
        return mav;
    }

    @RequestMapping("/save")
    public String save(Permissions permissions){
        iPermissionService.addPermission(permissions);
        return "redirect:/permission/findAll";
    }
}
