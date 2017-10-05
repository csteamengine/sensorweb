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
-- Table structure for table `homenode_leafnodes`
--

DROP TABLE IF EXISTS `homenode_leafnodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homenode_leafnodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homenode_id` int(11) NOT NULL,
  `leafnode_id` int(11) NOT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homenode_leafnodes`
--

LOCK TABLES `homenode_leafnodes` WRITE;
/*!40000 ALTER TABLE `homenode_leafnodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `homenode_leafnodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homenodes`
--

DROP TABLE IF EXISTS `homenodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homenodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unique_id` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homenodes`
--

LOCK TABLES `homenodes` WRITE;
/*!40000 ALTER TABLE `homenodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `homenodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leafnodes`
--

DROP TABLE IF EXISTS `leafnodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leafnodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homenode_id` int(11) NOT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leafnodes`
--

LOCK TABLES `leafnodes` WRITE;
/*!40000 ALTER TABLE `leafnodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `leafnodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readings`
--

DROP TABLE IF EXISTS `readings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leafnode_id` int(11) NOT NULL,
  `datatype_id` int(11) DEFAULT NULL,
  `value` varchar(1024) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readings`
--

LOCK TABLES `readings` WRITE;
/*!40000 ALTER TABLE `readings` DISABLE KEYS */;
/*!40000 ALTER TABLE `readings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_homenodes`
--

DROP TABLE IF EXISTS `user_homenodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_homenodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `homenode_id` int(11) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_homenodes`
--

LOCK TABLES `user_homenodes` WRITE;
/*!40000 ALTER TABLE `user_homenodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_homenodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `remember_token` text,
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  `timestamp` time DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,'csteen1005@gmail.com','Gregory C Steenhagen',NULL,NULL,'$2y$10$zNOH9..FTiprli6tydVfJOj9It9I9lxzgPBnO3W0Xi3ibsq0sensu',NULL,NULL,NULL,NULL,NULL,'UCeuzEgeXAENfD8fvOB9Is3fBVnuexamCHacZ3oloMExMJHxTph9zSJykmzV','',NULL,'2017-10-05 00:33:15','2017-10-05 00:33:15'),(2,NULL,'gcs@iastate.edu','Gregory C Steenhagen',NULL,NULL,'$2y$10$ia8lilwNlqrN/HomC1A4y.Z4kjiBkIrQPQBlGqnQiFdubIKwVudOO',NULL,NULL,NULL,NULL,NULL,'DtYvFYNvdr1VrZvSbM7IX9L07sbVg86RijsaTUfFK709b87HdZOr4eoaKOOR','',NULL,'2017-10-05 01:45:41','2017-10-05 01:45:41');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-04 22:40:01
