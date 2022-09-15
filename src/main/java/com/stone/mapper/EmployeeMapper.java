package com.stone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stone.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
