package com.example.spc.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.util.Date;

@Data
public class Validation {
    private Integer id;
    private String email;
    private String code;
    private Integer type;
    private DateTime time;
}
