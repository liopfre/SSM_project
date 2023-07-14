package com.qianfeng.dao;

import com.qianfeng.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 21:24
 * 描述：TODO
 */
@Repository
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findByMemberId(String id);
}
