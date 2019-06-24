/*
Navicat MySQL Data Transfer

Source Server         : gg
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-06-24 17:59:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `book_face` varchar(30) NOT NULL,
  `book_create` date NOT NULL,
  `book_author` varchar(10) NOT NULL,
  `book_press` varchar(20) NOT NULL,
  `book_address` varchar(20) NOT NULL,
  `book_num` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`book_name`),
  KEY `book_name` (`book_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'jsp程序语言设计', '一本jsp程序语言设计', '2016-06-04', '老马', '清华', '二楼', '9');
INSERT INTO `book` VALUES ('2', 'Java程序设计', '一本Java', '2016-07-01', '老六', '清华', '一楼', '5');
INSERT INTO `book` VALUES ('3', '生物', '生物书', '2015-01-15', '老马', '清华同方', '三楼', '4');
INSERT INTO `book` VALUES ('4', '历史', '历史书', '2014-04-11', '老王', '武汉', '三楼', '5');

-- ----------------------------
-- Table structure for `tb_book`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `bookname` varchar(20) NOT NULL,
  `lendtime` date NOT NULL,
  `backtime` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bookname` (`bookname`),
  KEY `userid` (`userid`),
  CONSTRAINT `bookname` FOREIGN KEY (`bookname`) REFERENCES `book` (`book_name`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('1', '1', 'jsp程序语言设计', '2019-06-23', '2019-08-23');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `pwd` varchar(10) NOT NULL,
  `statue` varchar(2) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `classs` varchar(10) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'kim', '123456', '1', '女', '131154568', '2');
INSERT INTO `users` VALUES ('2', 'lbq', '123456', '0', '男', '132123456', '1');
