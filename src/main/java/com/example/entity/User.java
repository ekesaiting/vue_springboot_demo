package com.example.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author shf
 * @since 2020-05-15 08:34:24
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -31629683610940941L;
    
    private Integer id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 2,max = 15,message = "用户名必须是2~15个字符")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;
    private List<Role> roles;

}