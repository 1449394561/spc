package com.example.spc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("menu")
@Data
public class Menu {
    @TableId(type = IdType.AUTO)
    private Integer mid;

    private String redirect;
    private String name;
    private String path;
    private String component1;
    private String childrenpath;
    private String childrenname;
    private String childrencomponent;



}
