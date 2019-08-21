/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : db_stu1

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-08-21 15:06:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(7) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `identity` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('10086', 'admin', '123', '0');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `hour` int(2) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', 'C++', '48', '3', 'C++面向对象', '无', '1', '40');
INSERT INTO `t_course` VALUES ('2', '化学物理', '56', '2', '有关物理的化学', '选课请加群：23333333', '2', '30');
INSERT INTO `t_course` VALUES ('3', '数据结构与算法', '36', '4', '计算机专业必修课之一', '无', '2', '40');
INSERT INTO `t_course` VALUES ('44', 'Linux', '32', '2', 'Linux操作系统的原理及其应用', '无', '1', '30');
INSERT INTO `t_course` VALUES ('1221', '概率论', '32', '3', '系统学习概率论知识', '无', null, '30');
INSERT INTO `t_course` VALUES ('1231', 'Java Web', '32', '2', '学习Java Web', '无', null, '30');

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `stu_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`,`course_id`),
  KEY `t_item_ibfk_2` (`course_id`),
  CONSTRAINT `t_item_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `t_stu` (`id`),
  CONSTRAINT `t_item_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item
-- ----------------------------
INSERT INTO `t_item` VALUES ('100001', '1');
INSERT INTO `t_item` VALUES ('100003', '2');
INSERT INTO `t_item` VALUES ('123311', '2');
INSERT INTO `t_item` VALUES ('100124', '44');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '10086', '100001', '测试通知', '...................12222222', '2019-08-17 20:54:22');
INSERT INTO `t_notice` VALUES ('2', '10086', '100001', '调课通知', '调课或换教室或换教师提醒:张碧娥老师于第1-12周星期一第5-6节在理科南410', '2019-08-17 22:19:51');
INSERT INTO `t_notice` VALUES ('3', '10086', '100001', '广州大学大一学生新民主主义革命与旧民主主义了解情况调查报告', '~!@#$%^&*()_+_)(*&^%$#@!~WERTYUIOP{}\":LKJHGFDSXCVBNM<>?', '2019-08-20 15:14:11');

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(3) NOT NULL,
  `identity` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES ('100001', 'sss', '123456', '男', '20', '-1');
INSERT INTO `t_stu` VALUES ('100003', '育', '666666', '男', '22', '-1');
INSERT INTO `t_stu` VALUES ('100124', '域', '', '男', '18', '-1');
INSERT INTO `t_stu` VALUES ('103102', '佚名', '123456', '女', '20', '-1');
INSERT INTO `t_stu` VALUES ('121112', '月光', '233312', '女', '17', '-1');
INSERT INTO `t_stu` VALUES ('123311', '未来', '', '女', '18', '-1');
INSERT INTO `t_stu` VALUES ('142123', '李四', '121111', '男', '24', '-1');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `identity` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('23001', 'dwsd', '123456', '男', '-1');
INSERT INTO `t_teacher` VALUES ('23111', 'xxx', '', '女', '-2');
INSERT INTO `t_teacher` VALUES ('23131', '月', '123456', '女', '-2');
INSERT INTO `t_teacher` VALUES ('23555', 'aaa', '', '女', '-2');
