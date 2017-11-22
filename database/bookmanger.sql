/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : bookmanger

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-11-05 20:51:06
*/
CREATE DATABASE `bookmanger` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administer
-- ----------------------------
DROP TABLE IF EXISTS `administer`;
CREATE TABLE `administer` (
  `adm_id` varchar(11) NOT NULL COMMENT 'keyword,手机号注册',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `password` varchar(8) DEFAULT NULL COMMENT '密码',
  `id_num` varchar(18) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administer
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` varchar(8) NOT NULL COMMENT 'ISDN',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `printer` varchar(20) DEFAULT NULL COMMENT '出版社',
  `book_order` varchar(10) DEFAULT NULL COMMENT '版次',
  `print_time` date DEFAULT NULL COMMENT '出版时间',
  `list` varchar(255) DEFAULT NULL COMMENT '目录',
  `intruduce` varchar(200) DEFAULT NULL,
  `include` enum('计算机类','文学类','艺术类','历史类') DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for borrow_lab
-- ----------------------------
DROP TABLE IF EXISTS `borrow_lab`;
CREATE TABLE `borrow_lab` (
  `book_id` varchar(8) NOT NULL,
  `kucun` int(4) DEFAULT NULL COMMENT '库存数量',
  `return_time` date DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_lab
-- ----------------------------

-- ----------------------------
-- Table structure for borrow_list
-- ----------------------------
DROP TABLE IF EXISTS `borrow_list`;
CREATE TABLE `borrow_list` (
  `borrow_listnum` int(8) NOT NULL AUTO_INCREMENT COMMENT '借阅清单编号',
  `user_id` varchar(11) DEFAULT NULL,
  `book_id` varchar(8) DEFAULT NULL,
  `borrow_time` date DEFAULT NULL,
  `return_time` date DEFAULT NULL,
  PRIMARY KEY (`borrow_listnum`),
  KEY `User_ID` (`user_id`),
  KEY `Book_ID` (`book_id`),
  CONSTRAINT `borrow_list_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_list
-- ----------------------------
-- ----------------------------
-- Table structure for bulletin
-- ----------------------------
DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin` (
  `guid` varchar(32) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`guid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bulletin
-- ----------------------------
-- ----------------------------
-- Table structure for c3p0testtable
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `guid` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `newsContent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`guid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('123', 'hdauihd ', 'idioashidhiashiohd');
INSERT INTO `news` VALUES ('1233123', 'dsahuih', 'HUDHASUIHDUSAIH');
INSERT INTO `news` VALUES ('1233', 'DHAUSHUID', 'DJASIOJDOIASJODIHAS');
INSERT INTO `news` VALUES ('111', 'DASUIDUIASG', 'DSAHIUDHSAUIH');
INSERT INTO `news` VALUES ('1', '打死哦', '大声道');
INSERT INTO `news` VALUES ('2', '定级赛和', '多撒囧很骄傲死哦地哦啊是滴哦啊是U盾哈搜和会打死');
INSERT INTO `news` VALUES ('3', '多撒后丢失', '大叔大婶对谁都会');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `password` varchar(8) NOT NULL COMMENT '密码',
  `sex` enum('男','女') NOT NULL DEFAULT '男' COMMENT '性别',
  `id_num` varchar(18) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`user_id`),
  KEY `User_ID` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
-- ----------------------------
-- Table structure for user_list
-- ----------------------------
DROP TABLE IF EXISTS `user_list`;
CREATE TABLE `user_list` (
  `user_id` varchar(11) NOT NULL,
  `borrow_num` int(4) DEFAULT NULL COMMENT '借阅数量',
  `return_time` date DEFAULT NULL,
  `borrow_listnum1` int(8) DEFAULT NULL,
  `borrow_listnum2` int(8) DEFAULT NULL,
  `borrow_listnum3` int(8) DEFAULT NULL,
  `borrow_listnum4` int(8) DEFAULT NULL,
  `borrow_listnum5` int(8) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `Borrow_listnum1` (`borrow_listnum1`),
  KEY `Borrow_listnum2` (`borrow_listnum2`),
  KEY `Borrow_listnum3` (`borrow_listnum3`),
  KEY `Borrow_listnum4` (`borrow_listnum4`),
  KEY `Borrow_listnum5` (`borrow_listnum5`),
  CONSTRAINT `user_list_ibfk_6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE NO ACTION,
  CONSTRAINT `user_list_ibfk_1` FOREIGN KEY (`Borrow_listnum1`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_2` FOREIGN KEY (`Borrow_listnum2`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_3` FOREIGN KEY (`Borrow_listnum3`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_4` FOREIGN KEY (`Borrow_listnum4`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_5` FOREIGN KEY (`borrow_listnum5`) REFERENCES `borrow_list` (`borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_list
-- ----------------------------
