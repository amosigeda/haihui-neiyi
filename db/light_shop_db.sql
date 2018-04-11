/*
Navicat MySQL Data Transfer

Source Server         : hishopweb
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : light_shop_db

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-20 10:30:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(128) NOT NULL COMMENT '订单编号',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `num` int(11) NOT NULL COMMENT '数量',
  `total_price` decimal(10,0) NOT NULL COMMENT '不能为空',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `status` tinyint(2) DEFAULT NULL COMMENT '1有效 0无效',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `size` varchar(5) DEFAULT NULL,
  `address` varchar(500) NOT NULL COMMENT '收货地址',
  `telnumber` varchar(22) DEFAULT NULL COMMENT '电话',
  `name` varchar(128) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '商品名称',
  `sale_price` decimal(10,0) DEFAULT NULL COMMENT '售价',
  `photo` varchar(200) DEFAULT NULL COMMENT '图片',
  `original_price` decimal(10,0) DEFAULT NULL COMMENT '原价',
  `type` char(2) DEFAULT NULL COMMENT '产品种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for product_detail_info
-- ----------------------------
DROP TABLE IF EXISTS `product_detail_info`;
CREATE TABLE `product_detail_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `photo` varchar(200) DEFAULT NULL COMMENT '图片',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` tinyint(2) NOT NULL COMMENT '1显示0不显示',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_detail_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  `registertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nickname` varchar(128) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别，0：男性，1: 女性',
  `weight` varchar(8) DEFAULT NULL,
  `height` varchar(8) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  `head` varchar(200) DEFAULT NULL COMMENT '头像',
  `type` int(2) DEFAULT '1' COMMENT '1正常注册用户  2facebook',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
