-- MySQL dump 10.13  Distrib 5.7.17, for osx10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: sensorweb
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `home_node`
--

DROP TABLE IF EXISTS `home_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home_node` (
  `home_node_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`home_node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_node`
--

LOCK TABLES `home_node` WRITE;
/*!40000 ALTER TABLE `home_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `home_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaf_node`
--

DROP TABLE IF EXISTS `leaf_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaf_node` (
  `leaf_node_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` varchar(255) DEFAULT NULL,
  `home_node_id` int(11) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaf_node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaf_node`
--

LOCK TABLES `leaf_node` WRITE;
/*!40000 ALTER TABLE `leaf_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `leaf_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_reading`
--

DROP TABLE IF EXISTS `sensor_reading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor_reading` (
  `sensor_reading_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` varchar(255) DEFAULT NULL,
  `home_node_id` int(11) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `leaf_node_id` int(11) DEFAULT NULL,
  `reading_value` float NOT NULL,
  PRIMARY KEY (`sensor_reading_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_reading`
--

LOCK TABLES `sensor_reading` WRITE;
/*!40000 ALTER TABLE `sensor_reading` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor_reading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `date_created` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'113 East 6th Street',NULL,'Ames','09/07/2017','gcs@iastate.edu','Gregory','','Steenhagen','IA','csteamengine','50010',NULL),(7,NULL,NULL,NULL,'2017/10/03 18:11:36','gcs@iastate.edu','Gregory','\0','Steenhagen',NULL,'csteen1005',NULL,'0oGG0QfsZ76bvysqrZqB/WoOnMdDIQEEHEt0VEDMAr0=$/qqUM/6MCv1oq9vxOoOThpkgg0zW2mnnR0Y3nA3oxcU='),(8,NULL,NULL,NULL,'2017/10/03 18:15:35','gcs@iastate.edu','Gregory','\0','Steenhagen',NULL,'test',NULL,'N/DWY0CkK24KEjb7cJXXM3OwMy81IaohYx4nehIPnD8=$e7r2uoSV2GgPQs/8ewsB7XHkDV3oeLo5r3IOKUY+wrw=');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-03 20:50:51
