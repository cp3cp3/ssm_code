/*
SQLyog Ultimate v8.32 
MySQL - 5.1.37-community : Database - testbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `testbs`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ausername` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(17) NOT NULL,
  `astate` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ausername` (`ausername`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

insert  into `admins`(`id`,`ausername`,`password`,`email`,`astate`) values (1,'admin','123456','12876@qq.com',0),(2,'qwe','qwe','5656889@qq.com',0),(3,'qqq','123','235698@qq.com',1);

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `cusername` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `email` varchar(17) NOT NULL,
  `address` varchar(100) NOT NULL,
  `cstate` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`cusername`),
  UNIQUE KEY `cname` (`cname`),
  UNIQUE KEY `cname1` (`cname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`cusername`,`password`,`cname`,`email`,`address`,`cstate`) values ('111','123456','华为','5689@qq.com','天津市',0),('123','123456','搜狐','23568@qq.com','浙江省',0),('2356589','123456','爱ws奇艺公司','1252389739@qq.com','广东省深圳市',0),('56565656','123456','爱奇及公司','1252389347@qq.com','广东省深圳市',1),('589623','123456','腾讯公司吗','1252386897@qq.com','广东省深圳市',1),('666','123456','海尔','365984@qq.com','背景市',1),('cp3','123456','乐视网','23568@qq.com','江苏省南京市',1),('ererer','123456','呼呼','1252389567@qq.com','广东省深圳市',1),('ererere','123456','爱奇艺公','12523897@qq.com','广东省深圳市',1),('fws','123456','天猫','12523897@qq.com','广东省深圳市',0),('qqq','123456','优酷','2689745@qq.com','北京市',0),('qwe','123456','爱奇艺公司','12345@qq.com','上海',1),('qwqwq','123456','爱奇公司','12523897@qq.com','广东省深圳市',1),('tttttt','123456','爱奇艺公司rtr','458659@qq.com','广东省深圳市',1),('xal','123456','爱奇司','12523897@qq.com','广东省深圳市',1),('ydd','123456','腾讯科技','123985@qq.com','广东省深圳市',1),('ywz','123456','爱奇艺','122879@qq.com','广东省广州增城区朱村镇广州大学松田学院隔壁',0);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `nid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ausername` varchar(16) NOT NULL,
  `title` varchar(1000) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `time` varchar(100) NOT NULL,
  `nstate` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`nid`,`ausername`,`title`,`content`,`time`,`nstate`) values (2,'admin','122','12121','2017-11-02',1),(3,'admin','1444','444','2017-11-04',0),(4,'qwe','1212','121212','2017-11-14',0),(5,'admin','465','456','2017-11-22',0);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `resumeid` int(10) NOT NULL AUTO_INCREMENT,
  `cusername` varchar(16) NOT NULL,
  `username` varchar(16) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `sex` varchar(2) NOT NULL DEFAULT '男',
  `skill` varbinary(100) NOT NULL,
  `experience` int(4) NOT NULL,
  `degree` varchar(100) NOT NULL,
  `appraise` varchar(1000) NOT NULL,
  `email` varchar(17) NOT NULL,
  `pstate` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`resumeid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`resumeid`,`cusername`,`username`,`uname`,`sex`,`skill`,`experience`,`degree`,`appraise`,`email`,`pstate`) values (1,'111','abc','杨文章','男','PHP',3,'本科','我欧文我我区','1252343897@qq.com',0),(2,'111','ywz','杨文章','男','JAVA',1,'研究生','对方是否是佛的','125897@qq.com',0),(6,'ywz','abc','奥巴马','男','JSP',3,'研究生','大大大神大大缩短大道双山大道','12523897@qq.com',1),(7,'ywz','abc','保罗','男','JQuery',3,'本科','453334553543','1252343897@qq.com',0),(8,'ywz','abc','奥巴马','男','JSP',3,'本科','我欧文大大缩短我我区而二二而','458659@qq.com',0);

/*Table structure for table `recruit` */

DROP TABLE IF EXISTS `recruit`;

CREATE TABLE `recruit` (
  `recid` int(10) NOT NULL AUTO_INCREMENT,
  `recname` varchar(100) NOT NULL,
  `type` varchar(50) NOT NULL,
  `degree` varchar(100) NOT NULL,
  `experience` int(4) NOT NULL,
  `extent` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `cusername` varchar(16) NOT NULL,
  `rstate` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `recruit` */

insert  into `recruit`(`recid`,`recname`,`type`,`degree`,`experience`,`extent`,`address`,`cusername`,`rstate`) values (1,'PHP','技术','大专以上',2,'20','广东省','111',0),(2,'JAVA','技术','本科以上',3,'25','海南省','qqq',0),(3,'安卓','技术','本科以上',4,'2000','浙江省','ywz',1),(4,'JSP','技术','本科以上',3,'15','北京市','ywz',0),(5,'C++','技术','本科以上',5,'18','广州','111',0),(6,'C语言','技术','大专以上',4,'15','江苏','qqq',0),(7,'JAVA','技术','本科以上',2,'18','广东省','ywz',0),(8,'JSP','技术','本科以上',3,'20','广东省','ywz',0),(9,'JAVA','技术','本科以上',3,'20','广东省','111',0),(10,'JQuery','技术','本科以上',3,'18','广东省','111',0),(11,'JQuery','技术','大专以上',2,'12','海南省','ywz',0),(12,'PHP','技术','本科',3,'15','广东省深圳市','ywz',0),(13,'JAVA11','技术','本科',2,'12','广东省深圳市','ywz',0),(14,'教师','文化','大专',5,'6','广东省深圳市','ywz',0);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `email` varchar(17) NOT NULL,
  `ustate` int(1) DEFAULT '0',
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`username`,`password`,`email`,`ustate`) values ('abc','123456','123456@qq.com',0),('abcabc','123','4586526989@qq.com',0),('bbb','123456','12587897@qq.com',0),('ttt','123456','458659@qq.com',0),('uuu','123456','23456@qq.com',0),('wer','123456','458659862@qq.com',0),('www','123456','3456271@qq.com',0),('ywz','123456','4586567459@qq.com',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
