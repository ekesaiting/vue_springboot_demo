package com.example.service.impl;

import com.example.dao.RoleDao;
import com.example.entity.User;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author shf
 * @since 2020-05-15 08:34:24
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        userDao.deleteUserRole(id);
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    @Transactional
    public User addRoleById(int userId,int[] roleIds) {
        for (int roleId : roleIds) {
            userDao.addRoleById(userId,roleId);
        }
        return this.queryById(userId);
    }

    @Override
    @Transactional
    public User deleteRoleById(int userId, int[] roleIds) {
        for (int roleId : roleIds) {
            userDao.deleteRoleById(userId,roleId);
        }
        return this.queryById(userId);
    }
}