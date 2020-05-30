package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Role)实体类
 *
 * @author shf
 * @since 2020-05-15 10:52:01
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 151863894734447444L;
    
    private Integer id;
    private String roleName;
    private List<Permission> permissions;


}