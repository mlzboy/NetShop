/*
MySQL Data Transfer
Source Host: localhost
Source Database: shop
Target Host: localhost
Target Database: shop
Date: 2007-6-11 20:53:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for attachment
-- ----------------------------
CREATE TABLE `attachment` (
  `pk_attachment_id` int(11) NOT NULL auto_increment,
  `attachment_title` varchar(50) default NULL,
  `attachment_url` varchar(500) default NULL,
  `attachment_type` int(11) default NULL,
  `attachment_description` varchar(500) default NULL,
  `extend_name` int(11) default NULL,
  `link_url` varchar(50) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_attachment_id`),
  UNIQUE KEY `Index_1` (`pk_attachment_id`),
  KEY `FK_Reference_16` (`extend_name`),
  KEY `FK_Reference_17` (`attachment_type`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`extend_name`) REFERENCES `dictionary_lib` (`pk_dictionary_lib_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`attachment_type`) REFERENCES `dictionary_lib` (`pk_dictionary_lib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
CREATE TABLE `dictionary` (
  `pk_dictionary_id` int(11) NOT NULL auto_increment,
  `dictionary_name` varchar(50) NOT NULL,
  `is_multinest` tinyint(4) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_dictionary_id`),
  UNIQUE KEY `Index_2` (`dictionary_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dictionary_lib
-- ----------------------------
CREATE TABLE `dictionary_lib` (
  `pk_dictionary_lib_id` int(11) NOT NULL auto_increment,
  `fk_dictionary_lib_parent_id` int(11) default NULL,
  `fk_dictionary_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) default NULL,
  `sequence` int(11) default NULL,
  `depth` tinyint(4) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_dictionary_lib_id`),
  KEY `Index_2` (`fk_dictionary_lib_parent_id`),
  KEY `Index_3` (`fk_dictionary_id`),
  KEY `Index_4` (`status`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`fk_dictionary_lib_parent_id`) REFERENCES `dictionary_lib` (`pk_dictionary_lib_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`fk_dictionary_id`) REFERENCES `dictionary` (`pk_dictionary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for field_name
-- ----------------------------
CREATE TABLE `field_name` (
  `pk_field_name_id` int(11) NOT NULL auto_increment,
  `field_name` varchar(50) NOT NULL,
  `field_type` varchar(50) default NULL,
  `field_default` varchar(50) default NULL,
  `field_description` varchar(500) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_field_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for log
-- ----------------------------
CREATE TABLE `log` (
  `pk_log_id` int(11) NOT NULL auto_increment,
  `fk_user_id` int(11) NOT NULL,
  `operate_description` varchar(500) default NULL,
  `operater_ip` char(15) default NULL,
  `checkin_time` datetime default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_log_id`),
  UNIQUE KEY `Index_1` (`pk_log_id`),
  KEY `Index_2` (`fk_user_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`pk_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
CREATE TABLE `product` (
  `pk_product_id` int(11) NOT NULL auto_increment,
  `product_name` varchar(50) default NULL,
  `product_description` varchar(500) default NULL,
  `product_categories` varchar(500) default NULL,
  `product_attachments` varchar(500) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_product_id`),
  UNIQUE KEY `Index_1` (`pk_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product_detail
-- ----------------------------
CREATE TABLE `product_detail` (
  `pk_fk_product_id` int(11) NOT NULL,
  `product_price` decimal(10,0) default NULL,
  `product_habitat` varchar(50) default NULL,
  PRIMARY KEY  (`pk_fk_product_id`),
  UNIQUE KEY `Index_1` (`pk_fk_product_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`pk_fk_product_id`) REFERENCES `product` (`pk_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_field_dict_mapping
-- ----------------------------
CREATE TABLE `table_field_dict_mapping` (
  `pk_fk_table_name_id` int(11) NOT NULL,
  `pk_fk_field_name_id` int(11) NOT NULL,
  `fk_dictionary_id` int(11) default NULL,
  `table_name` varchar(50) NOT NULL,
  `field_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`pk_fk_table_name_id`,`pk_fk_field_name_id`),
  UNIQUE KEY `Index_1` (`table_name`,`field_name`),
  KEY `FK_Reference_11` (`fk_dictionary_id`),
  KEY `FK_Reference_7` (`pk_fk_field_name_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`fk_dictionary_id`) REFERENCES `dictionary` (`pk_dictionary_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`pk_fk_field_name_id`) REFERENCES `field_name` (`pk_field_name_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`pk_fk_table_name_id`) REFERENCES `table_name` (`pk_table_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_name
-- ----------------------------
CREATE TABLE `table_name` (
  `pk_table_name_id` int(11) NOT NULL auto_increment,
  `table_name` varchar(50) NOT NULL,
  `description` varchar(500) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_table_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `pk_user_id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) default NULL,
  `nick_name` varchar(50) default NULL,
  `question` varchar(50) default NULL,
  `answer` varchar(50) default NULL,
  `last_login_ip` char(15) default NULL,
  `checkin_time` datetime default NULL,
  `update_time` datetime default NULL,
  `version` smallint(6) default NULL,
  `status` enum('NORMAL','LOCKED','DELETED') default NULL,
  PRIMARY KEY  (`pk_user_id`),
  KEY `AK_Identifier_2` (`username`),
  KEY `Index_3` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
CREATE TABLE `user_detail` (
  `pk_fk_user_id` int(11) NOT NULL,
  `real_name` varchar(50) default NULL,
  `gender` enum('MALE','FEMALE','UNKNOW') default NULL,
  `qq` varchar(500) default NULL,
  `homepage` varchar(500) default NULL,
  `birthday` date default NULL,
  `mobile_phone` varchar(500) default NULL,
  `phone` varchar(500) default NULL,
  `address` varchar(500) default NULL,
  `zip_code` varchar(500) default NULL,
  `interest` varchar(500) default NULL,
  `occupation` varchar(50) default NULL,
  `how_know` varchar(500) default NULL,
  `is_subscribe` enum('TRUE','FALSE') default NULL,
  `remark` varchar(500) default NULL,
  PRIMARY KEY  (`pk_fk_user_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`pk_fk_user_id`) REFERENCES `user` (`pk_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `attachment` VALUES ('32', null, 'manage\\upload\\2007060916519.jpg', '22', null, '23', null, '2007-06-09 03:35:19', '2007-06-09 03:35:19', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('33', null, 'manage\\upload\\2007060922227.jpg', '22', null, '23', null, '2007-06-09 03:35:36', '2007-06-09 03:35:36', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('34', null, 'manage\\upload\\2007060980080.jpg', '22', null, '23', null, '2007-06-09 03:35:53', '2007-06-09 03:35:53', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('35', null, 'manage\\upload\\2007060929707.jpg', '22', null, '23', null, '2007-06-09 03:36:17', '2007-06-09 03:36:17', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('36', null, 'manage\\upload\\2007060996507.jpg', '22', null, '23', null, '2007-06-09 03:38:24', '2007-06-09 03:38:24', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('37', null, 'manage\\upload\\2007060958457.jpg', '22', null, '23', null, '2007-06-09 03:38:47', '2007-06-09 03:38:47', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('38', null, 'manage\\upload\\2007060979163.jpg', '22', null, '23', null, '2007-06-09 03:39:26', '2007-06-09 03:39:26', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('39', null, 'manage\\upload\\2007060912059.jpg', '22', null, '23', null, '2007-06-09 03:40:16', '2007-06-09 03:40:16', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('40', null, 'manage\\upload\\2007060956976.jpg', '22', null, '23', null, '2007-06-09 03:40:38', '2007-06-09 03:40:38', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('41', null, 'manage\\upload\\2007060961495.jpg', '22', null, '23', null, '2007-06-09 03:41:02', '2007-06-09 03:41:02', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('42', null, 'manage\\upload\\20070609482.jpg', '22', null, '23', null, '2007-06-09 03:41:20', '2007-06-09 03:41:20', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('43', null, 'manage\\upload\\2007060976448.jpg', '22', null, '23', null, '2007-06-09 03:44:08', '2007-06-09 03:44:08', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('44', null, 'manage\\upload\\2007060947530.jpg', '22', null, '23', null, '2007-06-09 05:07:47', '2007-06-09 05:07:47', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('45', null, 'manage\\upload\\2007060910873.jpg', '22', null, '23', null, '2007-06-09 05:17:43', '2007-06-09 05:17:43', '1', 'NORMAL');
INSERT INTO `attachment` VALUES ('46', null, 'manage\\upload\\200706095964.jpg', '22', null, '23', null, '2007-06-09 05:36:23', '2007-06-09 05:36:23', '1', 'NORMAL');
INSERT INTO `dictionary` VALUES ('22', '产品字典', '0', '2007-05-07 19:38:16', '2007-06-07 01:14:00', '1', 'NORMAL');
INSERT INTO `dictionary` VALUES ('23', '扩展名字典', '1', '2007-05-30 18:29:41', '2007-06-07 01:14:09', '1', 'NORMAL');
INSERT INTO `dictionary` VALUES ('24', '附件字典', '1', '2007-06-04 00:26:17', '2007-06-07 01:14:14', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('22', null, '24', '图片', '图片', '1', '1', '2007-06-04 00:27:06', '2007-06-04 00:27:06', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('23', null, '23', 'jpg', 'jpg', '1', '1', '2007-06-04 00:27:48', '2007-06-04 00:27:48', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('24', null, '23', 'gif', 'gif', '2', '1', '2007-06-04 00:27:58', '2007-06-04 00:27:58', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('25', null, '23', 'bmp', 'bmp', '3', '1', '2007-06-04 00:28:06', '2007-06-04 00:28:06', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('30', null, '22', 'Books', 'Books', '2', '1', '2007-06-08 03:50:38', '2007-06-08 03:50:38', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('31', null, '22', 'Paper bags', 'Paper bags', '3', '1', '2007-06-08 03:50:59', '2007-06-08 03:50:59', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('32', null, '22', 'Paper boxes', 'Paper boxes', '4', '1', '2007-06-08 03:51:08', '2007-06-08 03:51:08', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('33', null, '22', 'Paper cups', 'Paper cups', '5', '1', '2007-06-08 03:51:19', '2007-06-08 03:51:19', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('34', null, '22', 'Paper bowls', 'Paper bowls', '6', '1', '2007-06-08 03:51:28', '2007-06-08 03:51:28', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('35', null, '22', 'Paper plates', 'Paper plates', '7', '1', '2007-06-08 03:51:42', '2007-06-08 03:51:42', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('36', null, '22', 'Magazines &Catalogue', 'Magazines &Catalogue', '8', '1', '2007-06-08 03:52:01', '2007-06-08 03:52:01', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('37', null, '22', 'Notebooks', 'Notebooks', '9', '1', '2007-06-08 03:52:11', '2007-06-08 03:52:11', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('38', null, '22', 'Calendars', 'Calendars', '10', '1', '2007-06-08 03:52:20', '2007-06-08 03:52:20', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('39', null, '22', 'Posters', 'Posters', '11', '1', '2007-06-08 03:52:30', '2007-06-08 03:52:30', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('40', null, '22', 'Cards', 'Cards', '12', '1', '2007-06-08 03:52:37', '2007-06-08 03:52:37', '1', 'NORMAL');
INSERT INTO `dictionary_lib` VALUES ('41', null, '22', 'Others', 'Others', '13', '1', '2007-06-08 03:52:46', '2007-06-08 03:52:46', '1', 'NORMAL');
INSERT INTO `field_name` VALUES ('1', 'attachment_type', 'int(11)', null, '附件类型', '2007-05-04 00:57:31', '2007-05-04 00:57:33', '1', 'NORMAL');
INSERT INTO `field_name` VALUES ('2', 'extend_name', 'int(11)', null, '扩展类型', '2007-05-04 00:57:51', '2007-05-04 00:57:48', '1', 'NORMAL');
INSERT INTO `product` VALUES ('41', 'Playing cards.jpg', '', '41', '32', '2007-06-09 03:35:19', '2007-06-09 03:35:19', '1', 'NORMAL');
INSERT INTO `product` VALUES ('42', 'SP-F01', '', '30', '33', '2007-06-09 03:35:36', '2007-06-09 03:35:36', '1', 'NORMAL');
INSERT INTO `product` VALUES ('43', 'SP-I01', '', '38', '34', '2007-06-09 03:35:53', '2007-06-09 03:35:53', '1', 'NORMAL');
INSERT INTO `product` VALUES ('44', 'SP-K01.jpg', '', '40', '35', '2007-06-09 03:36:17', '2007-06-09 03:36:17', '1', 'NORMAL');
INSERT INTO `product` VALUES ('45', 'SP-H01', '', '36', '36', '2007-06-09 03:38:24', '2007-06-09 03:38:24', '1', 'NORMAL');
INSERT INTO `product` VALUES ('46', 'SP-A01', '', '31', '37', '2007-06-09 03:38:47', '2007-06-09 03:38:47', '1', 'NORMAL');
INSERT INTO `product` VALUES ('47', 'SP-B01', '', '32', '38', '2007-06-09 03:39:26', '2007-06-09 03:39:26', '1', 'NORMAL');
INSERT INTO `product` VALUES ('48', 'SP-D01', '', '34', '39', '2007-06-09 03:40:16', '2007-06-09 03:40:16', '1', 'NORMAL');
INSERT INTO `product` VALUES ('49', 'SP-C01', '', '33', '40', '2007-06-09 03:40:38', '2007-06-09 03:40:38', '1', 'NORMAL');
INSERT INTO `product` VALUES ('50', 'SP-E01', '', '35', '41', '2007-06-09 03:41:02', '2007-06-09 03:41:02', '1', 'NORMAL');
INSERT INTO `product` VALUES ('51', 'SP-J01', '', '39', '42', '2007-06-09 03:41:20', '2007-06-09 03:41:20', '1', 'NORMAL');
INSERT INTO `product` VALUES ('52', 'SP-H01', '', '37', '43', '2007-06-09 03:44:08', '2007-06-09 03:44:08', '1', 'NORMAL');
INSERT INTO `product` VALUES ('53', 'SP-F02', 'test', '30', '44', '2007-06-09 05:07:47', '2007-06-09 05:07:47', '1', 'NORMAL');
INSERT INTO `product` VALUES ('54', 'SP-F03', 'aaa', '30', '45', '2007-06-09 05:17:43', '2007-06-09 05:17:43', '1', 'NORMAL');
INSERT INTO `product` VALUES ('55', 'SP-F04', '', '30', '46', '2007-06-09 05:36:23', '2007-06-09 05:36:23', '1', 'NORMAL');
INSERT INTO `product_detail` VALUES ('41', '0', '');
INSERT INTO `product_detail` VALUES ('42', '0', '');
INSERT INTO `product_detail` VALUES ('43', '0', '');
INSERT INTO `product_detail` VALUES ('44', '0', '');
INSERT INTO `product_detail` VALUES ('45', '0', '');
INSERT INTO `product_detail` VALUES ('46', '0', '');
INSERT INTO `product_detail` VALUES ('47', '0', '');
INSERT INTO `product_detail` VALUES ('48', '0', '');
INSERT INTO `product_detail` VALUES ('49', '0', '');
INSERT INTO `product_detail` VALUES ('50', '0', '');
INSERT INTO `product_detail` VALUES ('51', '0', '');
INSERT INTO `product_detail` VALUES ('52', '0', '');
INSERT INTO `product_detail` VALUES ('53', '0', '');
INSERT INTO `product_detail` VALUES ('54', '0', '');
INSERT INTO `product_detail` VALUES ('55', '0', '');
INSERT INTO `table_field_dict_mapping` VALUES ('1', '1', '24', 'attachment', 'attachment_type');
INSERT INTO `table_field_dict_mapping` VALUES ('1', '2', '23', 'attachment', 'extend_name');
INSERT INTO `table_name` VALUES ('1', 'attachment', null, '2007-05-04 00:56:04', '2007-05-04 00:56:07', '1', 'NORMAL');
INSERT INTO `user` VALUES ('2', 'ayi', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 02:40:43', '2007-05-02 02:40:43', '1', 'NORMAL');
INSERT INTO `user` VALUES ('11', 'aa', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 03:48:55', '2007-05-02 03:48:55', '1', 'NORMAL');
INSERT INTO `user` VALUES ('12', 'aaa', 'aaaaaa', null, null, null, null, '127.0.0.1', '2007-05-02 03:48:58', '2007-05-02 03:48:58', '1', 'LOCKED');
INSERT INTO `user` VALUES ('13', 'bbb', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:00', '2007-05-02 03:49:00', '1', 'LOCKED');
INSERT INTO `user` VALUES ('14', 'ccc', 'aaaaaa', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:02', '2007-05-02 03:49:02', '1', 'NORMAL');
INSERT INTO `user` VALUES ('15', 'ddd', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:03', '2007-05-02 03:49:03', '1', 'LOCKED');
INSERT INTO `user` VALUES ('16', 'eee', '123456', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:05', '2007-05-02 03:49:05', '1', 'NORMAL');
INSERT INTO `user` VALUES ('18', 'ggg', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:11', '2007-05-02 03:49:11', '1', 'NORMAL');
INSERT INTO `user` VALUES ('19', 'hhh', '111111', null, null, null, null, '127.0.0.1', '2007-05-02 03:49:14', '2007-05-02 03:49:14', '1', 'LOCKED');
INSERT INTO `user_detail` VALUES ('2', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('11', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('12', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('13', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('14', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('15', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('16', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('18', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_detail` VALUES ('19', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
