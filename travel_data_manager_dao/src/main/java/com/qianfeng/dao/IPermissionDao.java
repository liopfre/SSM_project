package com.qianfeng.dao;

import com.qianfeng.domain.Permissions;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/9 14:04
 * 描述：TODO
 */
@Repository
public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permissions> findByRoleId(String id);

    @Select("select * from permission")
    List<Permissions> findAll();

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void addPermission(Permissions permissions);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    List<Permissions> findPermissionsByRoleId(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{id})")
    void addRoleToPermission(@Param(value = "roleId") String roleId,@Param(value = "id") String id);
}
