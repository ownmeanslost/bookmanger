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
INSERT INTO `administer` VALUES ('123456', '宋江', '111', '42028119940918131X');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` varchar(8) NOT NULL COMMENT 'ISDN',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `printer` varchar(20) DEFAULT NULL COMMENT '出版社',
  `order` varchar(10) DEFAULT NULL COMMENT '版次',
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
INSERT INTO `book` VALUES ('1212', '高数1', '123', '213', '3123', '2017-10-17', '1231', '12321', '计算机类', '2017-10-04 23:37:28');
INSERT INTO `book` VALUES ('123', '高数2', '哈哈', '哈哈', '哈哈', '2017-10-13', 'qwe', '的撒胡会撒谎对安徽四殴打户撒函数的还回答是U盾哈斯湖大随后对按时杜哈us和hiU盾哈是对阿水大事u', '计算机类', '2017-10-13 21:50:11');
INSERT INTO `book` VALUES ('123321', '高数3', '2312', '123', '123', '2017-10-17', '123', '123', '计算机类', '2017-10-05 23:37:32');
INSERT INTO `book` VALUES ('1234', '高数4', '132', '123', '123', '2017-10-17', '123', '123', '计算机类', '2017-10-06 23:37:35');
INSERT INTO `book` VALUES ('12345', '高数5', '23', '123', '123', '2017-10-17', '123', '123', '计算机类', '2017-10-07 23:37:38');
INSERT INTO `book` VALUES ('123451', '高数6', '123', '123', '123', '2017-10-17', '123', '13', '计算机类', '2017-10-08 23:37:43');

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
INSERT INTO `borrow_lab` VALUES ('1212', '9', null);
INSERT INTO `borrow_lab` VALUES ('123', '9', null);
INSERT INTO `borrow_lab` VALUES ('123321', '9', null);
INSERT INTO `borrow_lab` VALUES ('1234', '9', null);
INSERT INTO `borrow_lab` VALUES ('12345', '9', null);
INSERT INTO `borrow_lab` VALUES ('123451', '10', null);

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
  CONSTRAINT `borrow_list_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `borrow_list_ibfk_2` FOREIGN KEY (`Book_ID`) REFERENCES `book` (`Book_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow_list
-- ----------------------------
INSERT INTO `borrow_list` VALUES ('1', '13667108218', '123', '2017-11-05', '2017-11-20');
INSERT INTO `borrow_list` VALUES ('2', '13667108218', '1212', '2017-11-05', '2017-11-20');
INSERT INTO `borrow_list` VALUES ('3', '13667108218', '123321', '2017-11-05', '2017-11-20');
INSERT INTO `borrow_list` VALUES ('4', '13667108218', '12345', '2017-11-05', '2017-11-20');
INSERT INTO `borrow_list` VALUES ('5', '13667108218', '1234', '2017-11-05', '2017-11-20');

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
INSERT INTO `bulletin` VALUES ('123', '大叔大婶大所多所');
INSERT INTO `bulletin` VALUES ('1234', '的埃文斯的冯绍峰似懂非懂算法的');
INSERT INTO `bulletin` VALUES ('12312', '股后端死鬼');
INSERT INTO `bulletin` VALUES ('213123', '打色奥二群翁');
INSERT INTO `bulletin` VALUES ('123123', '娃儿无群二群翁群无');
INSERT INTO `bulletin` VALUES ('2132', '恶趣味无群二无');

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
INSERT INTO `user` VALUES ('13667108218', '张飞', '111', '男', '42028119940918131X');

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
  CONSTRAINT `user_list_ibfk_1` FOREIGN KEY (`Borrow_listnum1`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_2` FOREIGN KEY (`Borrow_listnum2`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_3` FOREIGN KEY (`Borrow_listnum3`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_4` FOREIGN KEY (`Borrow_listnum4`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `user_list_ibfk_5` FOREIGN KEY (`Borrow_listnum5`) REFERENCES `borrow_list` (`Borrow_listnum`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_list
-- ----------------------------
INSERT INTO `user_list` VALUES ('13667108218', '5', null, '1', '2', '3', '4', '5');
