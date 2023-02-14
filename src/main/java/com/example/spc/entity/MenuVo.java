package com.example.spc.entity;

import lombok.Data;

import java.util.List;

@Data
public class MenuVo {
    private String path;
    private String name;
    private String redirect;
    private String component1;
    private List children1;
}
