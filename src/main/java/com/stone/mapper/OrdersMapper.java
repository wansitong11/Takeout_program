package com.stone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stone.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
