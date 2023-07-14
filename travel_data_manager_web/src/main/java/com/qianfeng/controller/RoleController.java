package com.qianfeng.controller;

import com.github.pagehelper.PageInfo;
import com.qianfeng.domain.Permissions;
import com.qianfeng.domain.Role;
import com.qianfeng.service.IPermissionService;
import com.qianfeng.service.IRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 15:56
 * 描述：TODO
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    IRoleService iRoleService;

    @Resource
    IPermissionService iPermissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(required = true,name = "page",defaultValue = "1")Integer page,@RequestParam(name = "pageSize",defaultValue = "3")Integer pageSize){
        List<Role> roles=iRoleService.findAll(page,pageSize);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role-list");
        mav.addObject("pageInfo",pageInfo);
        return mav;
    }

    @RequestMapping("/save")
    public String addRole(Role role){
        iRoleService.addRole(role);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Role role=iRoleService.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role-update");
        mav.addObject("role",role);
        return mav;
    }

    @RequestMapping("/update")
    @PreAuthorize("authentication.principal.username=='vuebaby'")
    public String updateRole(Role role){
        iRoleService.update(role);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/findPermissionsByRoleId")
    public ModelAndView findPermissionsByRoleId(String id){
        List<Permissions> permissions=iPermissionService.findPermissionsByRoleId(id);
        Role role = iRoleService.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role-permission-add");
        mav.addObject("permissionList",permissions);
        mav.addObject("role",role);
        return mav;
    }

    @RequestMapping("/addRoleToPermission")
    public String addRoleToPermission(String roleId,String[] ids){
        iPermissionService.addRoleToPermission(roleId,ids);
        return "redirect:/role/findAll";
    }

}
