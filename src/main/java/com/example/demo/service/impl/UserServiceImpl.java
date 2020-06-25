package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.proj.UserInfo;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YeZhiyue
 * @since 2020-06-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }


    @Override
    public List<User> selectUser(UserInfo userInfo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                // >=
                .ge("id", userInfo.getIdGe())
                // <=
                .le("id",userInfo.getIdLe())
                .like("name",userInfo.getName())
                .ge("age",userInfo.getAgeGe())
                .le("age",userInfo.getAgeLe())
                .like("email",userInfo.getEmail());

        return userMapper.selectList(wrapper);
    }

    @Override
    public int deleteUser(UserInfo userInfo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                // >=
                .ge("id", userInfo.getIdGe())
                // <=
                .le("id",userInfo.getIdLe())
                .like("name",userInfo.getName())
                .ge("age",userInfo.getAgeGe())
                .le("age",userInfo.getAgeLe())
                .like("email",userInfo.getEmail());

        return userMapper.delete(wrapper);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> selectByPage(int currentPage) {
        // 当前页和页面的大小
        int current = (currentPage - 1) * 5;
        Page<User> page = new Page<>(current, 5);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        // 分页的循环遍历
        page.getRecords().forEach(System.out::println);

        System.out.println(page.getTotal());
        System.out.println(page.getSize());
        return page.getRecords();
    }
}
