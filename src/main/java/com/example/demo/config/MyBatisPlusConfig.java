package com.example.demo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 这里设置这个类为配置类
@MapperScan("com.example.demo.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    // TODO 2020/6/24 配置类
    // 乐观锁组件，乐观锁拦截类
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    // 分页查询插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 这里我们简单的使用的话就只需要简单的配置下面这一句话，如果有需求添加注释中的配置
        return new PaginationInterceptor();
        //PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        //paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        //return paginationInterceptor;
    }

    // 配置逻辑删除
    // 3.1.1 之后不需要这个配置
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    // 配置性能测试
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启，否则会导致性能比较低
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 设置sql执行的最大时间，如果超时那么就执行失败
        performanceInterceptor.setMaxTime(100);
        // sql是否进行格式化
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
