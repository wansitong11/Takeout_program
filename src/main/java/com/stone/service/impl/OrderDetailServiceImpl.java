package com.stone.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stone.entity.OrderDetail;
import com.stone.mapper.OrderDetailMapper;
import com.stone.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
        implements OrderDetailService {
}
