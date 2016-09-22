/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50137
Source Host           : localhost:3306
Source Database       : testcase_ds2

Target Server Type    : MYSQL
Target Server Version : 50137
File Encoding         : 65001

Date: 2015-11-18 19:01:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(255) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user_4518', '');
INSERT INTO `user` VALUES ('user_4518', '');
INSERT INTO `user` VALUES ('user_1367', '');
INSERT INTO `user` VALUES ('user_4580', '');
INSERT INTO `user` VALUES ('user_3768', '');
INSERT INTO `user` VALUES ('user_5641', '');
INSERT INTO `user` VALUES ('user_7219', '');
INSERT INTO `user` VALUES ('user_6448', '');
