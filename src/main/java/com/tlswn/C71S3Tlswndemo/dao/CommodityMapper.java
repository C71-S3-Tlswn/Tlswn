package com.tlswn.C71S3Tlswndemo.dao;

import com.tlswn.C71S3Tlswndemo.bean.Commodity;
import com.tlswn.C71S3Tlswndemo.bean.CommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityMapper {
    long countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);
    List<Commodity> selectBythree(CommodityExample example);
    
    List<Commodity> selectBySix(CommodityExample example);

    Commodity selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}