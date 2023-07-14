package com.qianfeng.service;

import com.qianfeng.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/8 16:41
 * 描述：TODO
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer pageSize);

    void addUser(UserInfo userInfo);

    UserInfo findUserById(String id);

    void addRoleToUser(String[] ids,String userId);
}
