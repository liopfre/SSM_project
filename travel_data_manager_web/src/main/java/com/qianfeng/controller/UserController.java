package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;
import com.qianfeng.service.IRoleService;
import com.qianfeng.service.IUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/8 17:32
 * 描述：TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService iUserService;

    @Resource
    IRoleService iRoleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(required = true,name = "page",defaultValue = "1")Integer page,@RequestParam(required = true,value = "pageSize",defaultValue = "5")Integer pageSize){
       List<UserInfo> users= iUserService.findAll(page,pageSize);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(users);
        List<UserInfo> list = pageInfo.getList();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-list");
        mav.addObject(pageInfo);
        return mav;
    }

    @RequestMapping("/save")
    public String addUser(UserInfo userInfo){
        iUserService.addUser(userInfo);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        UserInfo userInfo= iUserService.findUserById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-show");
        mav.addObject("user",userInfo);
        return mav;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        UserInfo user = iUserService.findUserById(id);
        List<Role> roles=iRoleService.findUserByIdAndAllRole(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user-role-add");
        mav.addObject("user",user);
        mav.addObject("roleList",roles);
        return mav;

    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String [] ids,String userId){
        iUserService.addRoleToUser(ids,userId);
        return "redirect:/user/findAll";
    }


}
