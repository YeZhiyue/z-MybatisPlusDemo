package com.example.demo;

import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class InsertTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        int result = userMapper.insert(new User(null, "ZhangSan", 25, "739153436@qq.com"));
        System.out.println(result);
        userMapper.selectList(null).forEach(System.out::println);
    }
}
