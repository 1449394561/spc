package com.example.spc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spc.entity.Menu;
import com.example.spc.entity.Validation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ValidationMapper extends BaseMapper<Validation> {
}
