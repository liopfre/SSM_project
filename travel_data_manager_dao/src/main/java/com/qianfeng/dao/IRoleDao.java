package com.qianfeng.dao;

import com.qianfeng.domain.Role;
import com.qianfeng.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 3:29
 * 描述：TODO
 */
@Repository
public interface IRoleDao {

    @Results(id = "baseResult",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many = @Many(fetchType = FetchType.LAZY,select = "com.qianfeng.dao.IPermissionDao.findByRoleId"))
    })
    @Select("select * from role where id in(select roleId from users_role where userId=#{id})")
    List<Role> findByUserId(String id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    void addRole(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(String id);

    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void updateRole(Role role);

    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findUserByIdAndAllRole(String id);
}
