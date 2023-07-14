package com.qianfeng.dao;

import com.qianfeng.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 21:28
 * 描述：TODO
 */
@Repository
public interface ITravellerDao {


    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findTravellerByOrderId(String orderId);
}
