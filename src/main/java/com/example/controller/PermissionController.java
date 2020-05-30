package com.example.controller;

import com.example.constant.enums.ResultCode;
import com.example.entity.Permission;
import com.example.service.PermissionService;
import com.example.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Permission)表控制层
 *
 * @author makejava
 * @since 2020-05-13 10:51:21
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(Integer id) {
        return this.permissionService.queryById(id);
    }

    @GetMapping("/findAll/{page}/{size}")
    public List<Permission> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        return permissionService.queryAllByLimit((page - 1) * size, size);

    }
    @PostMapping("/addPermission")
    public ResultVO<Permission> addPermission(@RequestBody Permission permission){
        Permission permissionRes = permissionService.insert(permission);
        return new ResultVO<>(ResultCode.SAVE,permissionRes);
    }
    @PutMapping("/updatePermission")
    public ResultVO<Permission> updatePermission( @RequestBody Permission permission){
        Permission permissionRes = permissionService.update(permission);
        return new ResultVO<>(ResultCode.UPDATE,permissionRes);
    }
    @DeleteMapping("/deletePermission/{id}")
    public ResultVO<Boolean> deletePermission(@PathVariable("id") int id){
        boolean delete = permissionService.deleteById(id);
        return new ResultVO<>(ResultCode.DELETE,delete);
    }

}