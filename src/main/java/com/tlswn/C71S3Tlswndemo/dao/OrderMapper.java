package com.tlswn.C71S3Tlswndemo.dao;

import com.tlswn.C71S3Tlswndemo.bean.Order;
import com.tlswn.C71S3Tlswndemo.bean.OrderExample;
import com.tlswn.C71S3Tlswndemo.vo.NearWeekVo;
import com.tlswn.C71S3Tlswndemo.vo.StatisticsVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer oid);
    
    @Select("select a.ordertimes,ifnull(b.count,0) as count,ifnull(b.price,0) as price  from "
    		+ "(SELECT curdate() as ordertimes union all "
    		+ "SELECT date_sub(curdate(), interval 1 day) as ordertimes "
    		+ "union all SELECT date_sub(curdate(), interval 2 day) as ordertimes "
    		+ "union all SELECT date_sub(curdate(), interval 3 day) as ordertimes "
    		+ "union all SELECT date_sub(curdate(), interval 4 day) as ordertimes "
    		+ "union all SELECT date_sub(curdate(), interval 5 day) as ordertimes "
    		+ "union all SELECT date_sub(curdate(), interval 6 day) as ordertimes "
    		+ ") a left join (select  DATE_FORMAT(ordertime,'%Y-%m-%d') "
    		+ " ordertime, sum(temp3) count ,sum(oprice) price from orders  where	"
    		+ "status=1 group by DATE_FORMAT(ordertime,'%Y-%m-%d') ) b on a.ordertimes = b.ordertime ")
    List<NearWeekVo> selectStatistics();
   

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}