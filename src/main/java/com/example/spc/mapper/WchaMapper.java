package com.example.spc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spc.entity.Wcha;
import org.apache.ibatis.annotations.Mapper;




@Mapper
public interface WchaMapper extends BaseMapper<Wcha> {

    String getpassword(String name);
}
