package com.example.demo;

import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void updateTest() {
        User liSi = new User(6l, "LiSi", 25, "739153436@qq.com");
        int result = userMapper.updateById(liSi);
        System.out.println(result);
        userMapper.selectList(null).forEach(System.out::println);
    }
}
