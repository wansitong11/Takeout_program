package com.stone.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stone.entity.DishFlavor;
import com.stone.mapper.DishFlavorMapper;
import com.stone.service.DishFlavorService;
import com.stone.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
