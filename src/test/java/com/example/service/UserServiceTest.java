package com.example.service;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author shf
 * @Date 2020/5/16 10:38
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void queryById() {
        User user = userService.queryById(1);
        System.out.println(user);
    }
    @Test
    void queryAllTest() {
        List<User> users = userService.queryAllByLimit(0, 6);
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println(users.size());
    }

    @Test
    void deleteByIdTest() {
        boolean b = userService.deleteById(9);
        System.out.println(b);
    }
}