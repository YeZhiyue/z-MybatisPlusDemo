package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class WrapperTests {

    @Autowired
    private UserMapper userMapper;

    // 通过id进行删除
    @Test
    // SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 AND name IS NOT NULL AND email IS NOT NULL AND age >= 12
    void wrapper01Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                // 大于
                .ge("age", 12);

        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
        // SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 AND age BETWEEN 10 AND 30
    void wrapper02Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .between("age", 10, 30);

        userMapper.selectList(wrapper).forEach(System.out::println);

        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
        // SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 AND name = 'Tom'
    void wrapper03Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .eq("name", "Tom");

        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
        // SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 AND name NOT LIKE '%ac%' AND email LIKE 't%'
    void wrapper04Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name", "ac")
                .likeRight("email", "t");

        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
        //SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 AND id IN (select id from user where id<3)
    void wrapper05Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .inSql("id","select id from user where id<4");

        userMapper.selectObjs(wrapper).forEach(System.out::println);
    }

    @Test
       //SELECT id,name,age,email,create_time,update_time,version,deleted FROM user WHERE deleted=0 ORDER BY id DESC
    void wrapper06Test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                // 升序
                //.orderByAsc("id")
                // 降序
                .orderByDesc("id");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
}
