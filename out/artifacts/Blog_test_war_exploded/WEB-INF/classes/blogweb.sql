/*
Navicat MySQL Data Transfer

Source Server         : User_localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : blogweb

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-07-17 00:31:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_title` varchar(255) NOT NULL,
  `a_cid` int(255) DEFAULT NULL,
  `a_context` longtext,
  `a_ldate` varchar(255) DEFAULT NULL,
  `a_date` varchar(255) DEFAULT NULL,
  `a_view` int(5) DEFAULT NULL,
  `a_del` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`a_id`),
  KEY `a_cid` (`a_cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES ('1', '这是测试文章', '1', '# 这是一个测试文章\r\n\r\n## 测试Markdown的语法源码是否可以存到数据库中\r\n\r\n### 主要包括一些符号\r\n\r\n**例如加粗**\r\n\r\n```\r\n例如代码高亮\r\n```\r\n\r\n- 例如序号点\r\n\r\n> 或者是引用\r\n\r\n再或者，插入图片试试？建议使用图床\r\n\r\n![TIM截图20200716233300.png](https://i.loli.net/2020/07/16/ymFExKItMDki3gf.png)\r\n\r\n另外或者是`局部代码突出`\r\n\r\n我能想到的大概就是这些吧', '2020-07-16', '2020-07-16', '10', '0');

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `class_del` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', '测试', '0');

-- ----------------------------
-- Table structure for remark_info
-- ----------------------------
DROP TABLE IF EXISTS `remark_info`;
CREATE TABLE `remark_info` (
  `remark_id` int(11) NOT NULL,
  `remark_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark_context` longtext,
  `remark_aid` int(11) DEFAULT NULL,
  `reamrk_email` varchar(255) DEFAULT NULL,
  `remark_date` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark_del` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`remark_id`),
  KEY `remark_aid` (`remark_aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remark_info
-- ----------------------------
