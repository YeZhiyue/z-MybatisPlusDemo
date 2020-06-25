package com.example.demo;

import com.example.demo.proj.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class LockApplicationTests {

    private final String TAG = "LOCK";

    @Autowired
    private UserMapper userMapper;

    // 乐观锁的测试，单线程
    @Test
    void testOptimisticLocker() {
        // 查询用户信息
        User user = userMapper.selectById(5l);
//        log.info(TAG,user);
        System.out.println(user);
        user.setName("New Billie");
        // 进行更新
        userMapper.updateById(user);
        // ==>  Preparing: UPDATE user SET name=?, age=?, email=?, create_time=?, update_time=?, version=? WHERE id=? AND version=?
    }

    // 乐观锁会出现的问题，多线程操作时可能会导致失败
    @Test
    void testOptimisticLockerMore() {
        // 查询用户信息
        User user = userMapper.selectById(5l);
        System.out.println(user);
        user.setName("New Billie01");

        // 插队的线程
        User user02 = userMapper.selectById(5l);
        System.out.println(user);
        user02.setName("New Billie02");
        userMapper.updateById(user02);
        
        // 进行更新
        userMapper.updateById(user);

        // 结果是 New Billie02 ，因为这个更新成功了，但是下面这个 New Billie01 的更新版本号对比失败，于是只执行了一次更新
    }
}
