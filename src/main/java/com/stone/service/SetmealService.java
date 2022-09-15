package com.stone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stone.dto.SetmealDto;
import com.stone.entity.Setmeal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
    public void removeWithDish(List<Long> ids);
}
