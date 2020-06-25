package com.example.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

// 日志
@Slf4j
// 需要加入到我们的IOC容器当中
@Component
public  class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入的时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName("createTime", new Date(),metaObject);
    }

    // 更新的时候的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
