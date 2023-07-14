package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.IUserDao;
import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;
import com.qianfeng.service.IUserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * 作者：YoriStar
 * 时间：2023/7/8 16:47
 * 描述：TODO
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user;
        if (userInfo==null){
            user=null;
        }else {
            user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() == 1, true, true, true,getGrantedAuthority(userInfo.getRoles()));
        }
        return user;
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public List<UserInfo> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<UserInfo> usersInfos=userDao.findAll();
        return usersInfos;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        String uuid = UUID.randomUUID().toString();
        String password = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(password);
        userInfo.setId(uuid);

        userDao.addUser(userInfo);
    }

    @Override
    public UserInfo findUserById(String id) {
       UserInfo userInfo= userDao.findUserById(id);
       return userInfo;
    }

    @Override
    public void addRoleToUser(String[] ids,String userId) {
        for (String id : ids) {
            userDao.addRoleToUser(id,userId);
        }
    }
}
