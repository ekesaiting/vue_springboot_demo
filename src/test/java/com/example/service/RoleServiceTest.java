package com.example.service;

import com.example.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author shf
 * @Date 2020/5/16 13:10
 */
@SpringBootTest
class RoleServiceTest {

    @Autowired
    private RoleService roleService;
    @Test
    void deleteByIdTest() {
        boolean b = roleService.deleteById(3);
        System.out.println(b);
    }
   @Test
    public void queryAllTest() {
       List<Role> roles = roleService.queryAllByLimit(0, 2);
       for (Role role : roles) {
           System.out.println(role);
       }
   }
}