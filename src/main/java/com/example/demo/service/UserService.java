package com.example.demo.service;

import com.example.demo.proj.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.proj.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YeZhiyue
 * @since 2020-06-25
 */
public interface UserService extends IService<User> {


    List<User> getAllUser();

    List<User> selectUser(UserInfo userInfo);

    int deleteUser(UserInfo userInfo);

    int insertUser(User user);

    List<User> selectByPage(int currentPage);
}
