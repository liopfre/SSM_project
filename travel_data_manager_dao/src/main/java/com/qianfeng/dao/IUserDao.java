package com.qianfeng.dao;

import com.qianfeng.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/8 16:48
 * 描述：TODO
 */
@Repository
public interface IUserDao {

    @Insert("insert into users_role(roleId,userId) values(#{RoleId},#{userId})")
    void addRoleToUser(@Param(value = "RoleId") String RoleId, @Param("userId") String userId);


    @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);

    @Results(id = "baseResult",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "STATUS",property = "status")
    })
    @Select("select * from users where STATUS=1")
    List<UserInfo> findAll();

    @Select("select * from users where username=#{username}")
    @ResultMap( value= "baseResult2")
    UserInfo findByUsername(String username);

    @Results(id = "baseResult2",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "PASSWORD",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "STATUS",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(fetchType = FetchType.LAZY,select = "com.qianfeng.dao.IRoleDao.findByUserId"))
    })
    @Select("select * from users where id=#{id}")
    UserInfo findUserById(String id);
}
