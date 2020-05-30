package com.example.controller;

import com.example.constant.enums.ResultCode;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.vo.ResultVO;
import com.example.vo.RoleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 * (User)表控制层
 *
 * @author shf
 * @since 2020-05-15 08:34:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }
    @PostMapping("/addUser")
    public ResultVO<User> addUser(@Valid @RequestBody User user){
        User userRes = userService.insert(user);
        return new ResultVO<>(ResultCode.SAVE,userRes);
    }
    @GetMapping("/findAll/{page}/{size}")
    public List<User> findAll(@PathVariable("page") int page,@PathVariable("size") int size){
        List<User> users = userService.queryAllByLimit(size*(page-1), size);
        return users;
    }
    @PutMapping("/updateUser")
    public ResultVO<User> updateUser(@Valid @RequestBody User user){
        User userRes = userService.update(user);
        return new ResultVO<>(ResultCode.UPDATE,userRes);
    }
   @DeleteMapping("/deleteUser/{id}")
    public ResultVO<Boolean> deleteUser(@PathVariable("id") int id){
       boolean delete = userService.deleteById(id);
       return new ResultVO<>(ResultCode.DELETE,delete);
   }
   @PutMapping("/addRole")
   public ResultVO<User> addRole(@RequestBody(required = false) RoleVO roleVO){
       User userRes = userService.addRoleById(roleVO.getUserId(),roleVO.getRoleId());
       return new ResultVO<>(ResultCode.UPDATE,userRes);
   }
    @PostMapping("/deleteRole")
    public ResultVO<User> deleteRole(@RequestBody RoleVO roleVO){
        User userRes = userService.deleteRoleById(roleVO.getUserId(),roleVO.getRoleId());
        return new ResultVO<>(ResultCode.UPDATE,userRes);
    }
}