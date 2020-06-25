package com.example.demo;

import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SelectTests {

    @Autowired
    private UserMapper userMapper;

    // 查询所有
    @Test
    void selectListTest() {
        List<User> users = userMapper.selectList(null);
        System.out.println("查询所有的用户信息");
        users.forEach(System.out::println);
    }

    // 批量查询
    @Test
    void selectBatchIdsTest() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    // 条件查询
    @Test
    void selectByMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        // 通过字段里面多条件进行查询
        map.put("id", 1l);
        map.put("name", "Jone");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

}
