package com.example.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DeleteTests {

    @Autowired
    private UserMapper userMapper;

    // 通过id进行删除
    @Test
    void deleteByIdTest() {
        int result = userMapper.deleteById(6l);
        System.out.println(result);

        userMapper.selectList(null).
                forEach(System.out::println);
    }

    // 多条件删除
    @Test
    void deleteByMapTest() {
        // 当前页和页面的大小
        HashMap<String, Object> map = new HashMap<>();
        // 多条件删除
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);

        userMapper.selectList(null).
                forEach(System.out::println);
    }

    // 多条件逻辑删除（删除操作变为更新操作，变为了更新标志位的操作）
    // ==>  Preparing: UPDATE user SET deleted=1 WHERE id=? AND deleted=0
    // 逻辑删除需要额外的配置
    @Test
    void deleteTest() {
        int result = userMapper.deleteById(2l);
        System.out.println(result);

        userMapper.selectList(null).
                forEach(System.out::println);
    }

}
