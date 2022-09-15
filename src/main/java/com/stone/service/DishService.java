package com.stone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stone.dto.DishDto;
import com.stone.entity.Dish;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据
    public void saveWithFlavor(DishDto dishDto);
}
