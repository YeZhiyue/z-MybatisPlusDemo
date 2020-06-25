package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class MyGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 配置你整体的包属性(service\controller\mapper)
         */
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前项目根目录的获取
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("YeZhiyue");
        // 设置是否打开资源管理器中的目录
        gc.setOpen(false);
        // 配置是否覆盖原文件
        gc.setFileOverride(false);
        // 各层文件名称方式，例如： %sAction 生成 UserAction
        gc.setServiceName("%sService");
       // id的自增策略
        gc.setIdType(IdType.ID_WORKER);
        // 配置日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 用于前后端分离,实体属性 Swagger2 注解
//        gc.setSwagger2(true);
        // 将这个配置扔到我们的全局配置中
        mpg.setGlobalConfig(gc);


        /**
         * 配置你的数据源
         */
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        /**
         * 这里配置你的存放不同层次的bao(Controller\Service\Mapper)
         */
        // 包配置
        PackageConfig pc = new PackageConfig();
        // TODO 2020/6/25 包
//        pc.setModuleName("innermodle");
        pc.setParent("com.example.demo");
        // 设置存放包的名称
        pc.setEntity("proj");
        pc.setService("service");
        pc.setController("controller");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);


        /**
         * 配置一些mybatispluse的特殊性质
         *  自动填充
         *  乐观锁
         *  逻辑删除
         */
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置需要进行映射的表名
        // TODO 2020/6/24 这里是需要根据需求添加表
        strategy.setInclude("user","person");
        // 这里直接可以配置将名称中的下划线 _ 转化为 驼峰命名
        // 表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字段名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 你的实体类的父类
//        strategy.setSuperEntityClass("Object");
        // 自动生成lombok
        strategy.setEntityLombokModel(true);
        // 设置自动逻辑删除设置 deleted
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充策略 create_time update_time 的自动填充策略
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        // 配置Rest的使用风格
        strategy.setRestControllerStyle(true);
        // 这里是对Controller进行配置命名的下划线风格
        strategy.setControllerMappingHyphenStyle(true);// localhost:8080/hello_id_2
        // 配置总的
        mpg.setStrategy(strategy);

        // 最后执行所有配置
        mpg.execute();
    }
}