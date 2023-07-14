package com.qianfeng.dao;

import com.qianfeng.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/10 21:33
 * 描述：TODO
 */
@Repository
public interface ISysLogDao {
    @Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void addSysLog(SysLog sysLog);


    @Select("select * from syslog")
    List<SysLog> findAll();

}
