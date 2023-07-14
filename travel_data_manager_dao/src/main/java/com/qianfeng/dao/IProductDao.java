package com.qianfeng.dao;

import com.qianfeng.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 作者：YoriStar
 * 时间：2023/7/7 11:37
 * 描述：TODO
 */
@Repository
public interface IProductDao {

    @Select("select * from product")
    List<Product> findAll();

    @Delete("delete from product where id=#{id}")
    void deleteProduct(String  id);

    @Insert("insert into product value(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);


    @Select("select * from product where id=#{id}")
    Product findProductById(String id);

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},DepartureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void updateProduct(Product product);
}
