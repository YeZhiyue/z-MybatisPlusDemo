/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.29-log : Database - mybatisplus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisplus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatisplus`;

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`name`,`age`,`email`,`create_time`,`update_time`,`version`,`deleted`) values (1,'Daming',18,'test5@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(2,'Jack',20,'test2@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(3,'Tom',28,'test3@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(4,'Sandy',21,'test4@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(5,'Billie',36,'test4@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`age`,`email`,`create_time`,`update_time`,`version`,`deleted`) values (1,'Daming',18,'test5@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(2,'Jack',20,'test2@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(3,'Tom',28,'test3@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(4,'Sandy',21,'test4@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0),(5,'Billie',36,'test4@baomidou.com','2020-06-24 17:59:08','2020-06-24 17:59:08',1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
