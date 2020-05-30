package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2020-05-13 10:51:21
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -58093485933221250L;
    
    private Integer id;
    
    private String permissionName;

}