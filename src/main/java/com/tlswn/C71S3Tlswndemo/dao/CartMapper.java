package com.tlswn.C71S3Tlswndemo.dao;

import com.tlswn.C71S3Tlswndemo.bean.Cart;
import com.tlswn.C71S3Tlswndemo.bean.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer ccid);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer ccid);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExampleNum(@Param("record") Integer count,@Param("example") CartExample example);
    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}