package com.stone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stone.entity.OrderDetail;
import com.stone.entity.Orders;

import java.util.List;

public interface OrdersService extends IService<Orders> {

    public void submit(Orders orders);

    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}
