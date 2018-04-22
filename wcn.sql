/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.35 : Database - wcn
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wcn` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wcn`;

/*Table structure for table `friendly` */

DROP TABLE IF EXISTS `friendly`;

CREATE TABLE `friendly` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `a_id` varchar(255) NOT NULL,
  `b_id` varchar(255) NOT NULL,
  `b_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `friendly` */

insert  into `friendly`(`id`,`a_id`,`b_id`,`b_name`) values (1,'1','2','136'),(2,'2','2','本人'),(3,'1','3','亲人'),(4,'2','4','新加好友！');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`) values (1,'111','698d51a19d8a121ce581499d7b701668'),(2,'222','698d51a19d8a121ce581499d7b701668'),(4,'333','698d51a19d8a121ce581499d7b701668');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
