package com.example.spc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spc.entity.Cc;
import com.example.spc.entity.Wcha;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface WchaMapper extends BaseMapper<Wcha> {

    String getpassword(String name);

    public String cc(String name);

    public void wupdate(Wcha wcha);

    public List<Wcha> selectOrdersList(Wcha wcha);
}
