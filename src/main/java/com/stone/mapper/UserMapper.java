package com.stone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stone.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
