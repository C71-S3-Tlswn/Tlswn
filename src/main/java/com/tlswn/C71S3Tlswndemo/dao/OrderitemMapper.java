package com.tlswn.C71S3Tlswndemo.dao;

import com.tlswn.C71S3Tlswndemo.bean.Orderitem;
import com.tlswn.C71S3Tlswndemo.bean.OrderitemExample;
import com.tlswn.C71S3Tlswndemo.vo.StatisticsVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderitemMapper {
    long countByExample(OrderitemExample example);

    int deleteByExample(OrderitemExample example);

    int deleteByPrimaryKey(Integer otid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    List<Orderitem> selectByExample(OrderitemExample example);
    
    @Select("select distinct ifnull(sum(o.count),0) count,o.price,c.cid,t.vid,v.vname from "
    		+ "orderitem o,commodity c,variety v, type t where o.cid =c.cid"
    		+ " and v.vid=t.vid and c.tid=t.tid GROUP BY t.vid")
    List<StatisticsVo> selectStatistics();

    Orderitem selectByPrimaryKey(Integer otid);

    int updateByExampleSelective(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByExample(@Param("record") Orderitem record, @Param("example") OrderitemExample example);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
}