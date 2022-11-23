package com.example.spc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@TableName("wcha")
@Data
public class Wcha {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String password;

    private byte[] picture;
}
