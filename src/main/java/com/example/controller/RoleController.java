package com.example.controller;

import com.example.constant.enums.ResultCode;
import com.example.entity.Role;
import com.example.service.RoleService;
import com.example.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author shf
 * @since 2020-05-15 10:52:01
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }
    @GetMapping("/findAll/{page}/{size}")
    public List<Role> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        List<Role> roles = roleService.queryAllByLimit((page - 1) * size, size);
        return roles;
    }

    @PostMapping("/addRole")
    public ResultVO<Role> addRole(@RequestBody Role role){
        Role roleRes = roleService.insert(role);
        return new ResultVO<>(ResultCode.SAVE,roleRes);
    }
    @PutMapping("/updateRole")
    public ResultVO<Role> updateRole( @RequestBody Role role){
       Role roleRes = roleService.update(role);
        return new ResultVO<>(ResultCode.UPDATE,roleRes);
    }
    @DeleteMapping("/deleteRole/{id}")
    public ResultVO<Boolean> deleteRole(@PathVariable("id") int id){
        boolean delete = roleService.deleteById(id);
        return new ResultVO<>(ResultCode.DELETE,delete);
    }

}