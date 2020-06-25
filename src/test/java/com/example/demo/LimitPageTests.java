package com.example.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LimitPageTests {

    @Autowired
    private UserMapper userMapper;

    // 分页查询，但是效率不会太高，因为查询出来的信息比较多
    @Test
    void selectPageTest() {
        // 当前页和页面的大小
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        // 分页的循环遍历
        page.getRecords().forEach(System.out::println);

        // 下面可以直接获取其中的一些属性
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
        System.out.println(page.getCurrent());
        System.out.println(page.setDesc("id"));
    }
}
