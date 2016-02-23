/*
Navicat MySQL Data Transfer

Source Server         : jsp
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : jsp_bighomework

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2015-12-22 14:17:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attent
-- ----------------------------
DROP TABLE IF EXISTS `attent`;
CREATE TABLE `attent` (
  `UserName` varchar(20) NOT NULL,
  `AttentName` varchar(20) NOT NULL,
  `Summary` varchar(50) NOT NULL,
  `Sign` varchar(50) NOT NULL,
  `PostNumber` int(11) NOT NULL,
  `AttentNumber` int(11) NOT NULL,
  `AttentedNumber` int(11) NOT NULL,
  PRIMARY KEY (`UserName`,`AttentName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for attented
-- ----------------------------
DROP TABLE IF EXISTS `attented`;
CREATE TABLE `attented` (
  `UserName` varchar(20) NOT NULL,
  `AttentName` varchar(20) NOT NULL,
  `Summary` varchar(50) NOT NULL,
  `Sign` varchar(50) NOT NULL,
  `PostNumber` int(11) NOT NULL,
  `AttentNumber` int(11) NOT NULL,
  `AttentedNumber` int(11) NOT NULL,
  PRIMARY KEY (`UserName`,`AttentName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for habit
-- ----------------------------
DROP TABLE IF EXISTS `habit`;
CREATE TABLE `habit` (
  `UserName` varchar(20) NOT NULL,
  `Habit` varchar(50) NOT NULL,
  PRIMARY KEY (`UserName`,`Habit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `PostID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `Instance` varchar(500) NOT NULL,
  `DateTime` datetime NOT NULL,
  `ReplyNumber` int(11) DEFAULT '0',
  `ResendNumber` int(11) DEFAULT '0',
  `Zan` int(11) DEFAULT '0',
  `ResendFlag` int(11) DEFAULT '0',
  PRIMARY KEY (`PostID`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `PostID` int(11) NOT NULL,
  `ReplyID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `Instance` varchar(255) NOT NULL,
  `DateTime` datetime NOT NULL,
  PRIMARY KEY (`ReplyID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `PasswordHint` varchar(255) NOT NULL,
  `PasswordAnswer` varchar(255) NOT NULL,
  `RealName` varchar(10) NOT NULL,
  `FalseName` varchar(10) NOT NULL,
  `Sex` varchar(5) NOT NULL,
  `Age` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Summary` varchar(50) NOT NULL,
  `Sign` varchar(50) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `PostNumber` int(11) NOT NULL DEFAULT '0',
  `HeadPicture` longblob,
  `ManagerFlag` int(11) DEFAULT '0',
  `AttentNumber` int(11) NOT NULL DEFAULT '0',
  `AttentedNumber` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
