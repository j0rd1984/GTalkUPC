-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: grouptalkdb
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `auth_tokens`
--

DROP TABLE IF EXISTS `auth_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_tokens` (
  `userid` binary(16) NOT NULL,
  `token` binary(16) NOT NULL,
  PRIMARY KEY (`token`),
  KEY `userid` (`userid`),
  CONSTRAINT `auth_tokens_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_tokens`
--

LOCK TABLES `auth_tokens` WRITE;
/*!40000 ALTER TABLE `auth_tokens` DISABLE KEYS */;
INSERT INTO `auth_tokens` VALUES ('T{ùå´\0#¥lŒ','XzÕ{ùå´\0#¥lŒ'),('«Ù¢|\nå±H\0#¥lŒ','¯X`|\nå±H\0#¥lŒ'),('UD)	{ùå´\0#¥lŒ','UF˜X{ùå´\0#¥lŒ'),('_g{ùå´\0#¥lŒ','_ƒ7{ùå´\0#¥lŒ');
/*!40000 ALTER TABLE `auth_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` binary(16) NOT NULL,
  `userid` binary(16) NOT NULL,
  `content` varchar(500) NOT NULL,
  `last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creation_timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `themeid` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `themeid` (`themeid`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`themeid`) REFERENCES `themes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES ('”ä·}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:12:04','2015-10-28 18:12:04','4¢µx}å‘L\0#¥lŒ'),('\Züå¾}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:12:45','2015-10-28 18:12:45','4¢µx}å‘L\0#¥lŒ'),('$þ/»}”å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 16:51:33','2015-10-28 17:51:33','4¢µx}å‘L\0#¥lŒ'),('8Ÿ@v}”å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 16:52:06','2015-10-28 17:52:06','4¢µx}å‘L\0#¥lŒ'),('9x‹”}”å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 16:52:08','2015-10-28 17:52:08','4¢µx}å‘L\0#¥lŒ'),('CùkF}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:13:54','2015-10-28 18:13:54','4¢µx}å‘L\0#¥lŒ'),('bTAt}–å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:07:35','2015-10-28 18:07:35','4¢µx}å‘L\0#¥lŒ'),('~¥ê}•å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:01:13','2015-10-28 18:01:13','4¢µx}å‘L\0#¥lŒ'),('‚ þÎ}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:15:38','2015-10-28 18:15:38','4¢µx}å‘L\0#¥lŒ'),('„–;C}¶å°g\0#¥lŒ','T{ùå´\0#¥lŒ','Increible, me encanta!','2015-10-28 20:57:36','2015-10-28 21:57:36','\\F}¶å°g\0#¥lŒ'),('‡Ì~Ì}¶å°g\0#¥lŒ','T{ùå´\0#¥lŒ','Increible, me encanta!','2015-10-28 20:57:42','2015-10-28 21:57:42','\\F}¶å°g\0#¥lŒ'),('ˆ4³}¶å°g\0#¥lŒ','T{ùå´\0#¥lŒ','Increible, me encanta!','2015-10-28 20:57:42','2015-10-28 21:57:42','\\F}¶å°g\0#¥lŒ'),('›Ò	}–å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:09:31','2015-10-28 18:09:31','4¢µx}å‘L\0#¥lŒ'),('œ/HÀ}•å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:02:03','2015-10-28 18:02:03','4¢µx}å‘L\0#¥lŒ'),('Ÿ0:~}å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Ya he comprado mis entradas para el pre estreno que ganas','2015-10-28 16:26:20','2015-10-28 17:26:20','4¢µx}å‘L\0#¥lŒ'),('ÞüZD}–å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:11:04','2015-10-28 18:11:04','4¢µx}å‘L\0#¥lŒ'),('á³VP}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:18:18','2015-10-28 18:18:18','4¢µx}å‘L\0#¥lŒ'),('öF‹}—å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Luke es el malo!','2015-10-28 17:18:53','2015-10-28 18:18:53','4¢µx}å‘L\0#¥lŒ');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interestgroups`
--

DROP TABLE IF EXISTS `interestgroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interestgroups` (
  `id` binary(16) NOT NULL,
  `userid` binary(16) NOT NULL,
  `content` varchar(500) NOT NULL,
  `last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creation_timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `interestgroups_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interestgroups`
--

LOCK TABLES `interestgroups` WRITE;
/*!40000 ALTER TABLE `interestgroups` DISABLE KEYS */;
INSERT INTO `interestgroups` VALUES ('“»\r}Œå‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Peliculas','2015-10-28 15:53:46','2015-10-28 16:53:46'),('j3œ}µå°g\0#¥lŒ','T{ùå´\0#¥lŒ','Videojuegos','2015-10-28 20:49:43','2015-10-28 21:49:43');
/*!40000 ALTER TABLE `interestgroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themes`
--

DROP TABLE IF EXISTS `themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themes` (
  `id` binary(16) NOT NULL,
  `userid` binary(16) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `content` varchar(500) NOT NULL,
  `last_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creation_timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `interestgroupid` binary(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `interestgroupid` (`interestgroupid`),
  CONSTRAINT `themes_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `themes_ibfk_2` FOREIGN KEY (`interestgroupid`) REFERENCES `interestgroups` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themes`
--

LOCK TABLES `themes` WRITE;
/*!40000 ALTER TABLE `themes` DISABLE KEYS */;
INSERT INTO `themes` VALUES ('\0cW}¶å°g\0#¥lŒ','T{ùå´\0#¥lŒ','World of Warcraft','Role-playing game','2015-10-28 20:53:54','2015-10-28 21:53:54','j3œ}µå°g\0#¥lŒ'),('(Îƒ}˜å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','TrilogÃ­a cinematogrÃ¡fica de El SeÃ±or de los Anillos ','El seÃ±or de los Anillos','2015-10-28 17:20:18','2015-10-28 18:20:18','“»\r}Œå‘L\0#¥lŒ'),('4¢µx}å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Star Wars VII','Star Wars: Episode VII - The Force Awakens','2015-10-28 16:16:12','2015-10-28 17:16:12','“»\r}Œå‘L\0#¥lŒ'),('\\F}¶å°g\0#¥lŒ','T{ùå´\0#¥lŒ','Counter-Strike: Global Offensive','First Person Shooter','2015-10-28 20:56:28','2015-10-28 21:56:28','j3œ}µå°g\0#¥lŒ'),('›îÛ}˜å‘L\0#¥lŒ','T{ùå´\0#¥lŒ','Tomates verdes fritos','Peliculon','2015-10-28 17:23:31','2015-10-28 18:23:31','“»\r}Œå‘L\0#¥lŒ'),('°O¯}µå°g\0#¥lŒ','T{ùå´\0#¥lŒ','League of Legueds','Multiplayer online battle arena game','2015-10-28 20:51:40','2015-10-28 21:51:40','j3œ}µå°g\0#¥lŒ');
/*!40000 ALTER TABLE `themes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group`
--

DROP TABLE IF EXISTS `user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group` (
  `userid` binary(16) NOT NULL,
  `interestgroup` binary(16) NOT NULL,
  PRIMARY KEY (`userid`,`interestgroup`),
  KEY `interestgroup` (`interestgroup`),
  CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_group_ibfk_2` FOREIGN KEY (`interestgroup`) REFERENCES `interestgroups` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group`
--

LOCK TABLES `user_group` WRITE;
/*!40000 ALTER TABLE `user_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `userid` binary(16) NOT NULL,
  `role` enum('registered','admin') NOT NULL DEFAULT 'registered',
  PRIMARY KEY (`userid`,`role`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('T{ùå´\0#¥lŒ','admin'),('«Ù¢|\nå±H\0#¥lŒ','registered'),('UD)	{ùå´\0#¥lŒ','registered'),('_g{ùå´\0#¥lŒ','registered');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` binary(16) NOT NULL,
  `loginid` varchar(15) NOT NULL,
  `password` binary(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginid` (`loginid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('T{ùå´\0#¥lŒ','jlopez','Ü›ÛRÐMÂ\06ÛØ1>ÐU','jlopez@grouptalk.dsa.upc.edu','Jordi Lopez'),('«Ù¢|\nå±H\0#¥lŒ','test','Ü›ÛRÐMÂ\06ÛØ1>ÐU','test_user@test.com','Test fullname'),('UD)	{ùå´\0#¥lŒ','rmolina','Ü›ÛRÐMÂ\06ÛØ1>ÐU','rmolina@grouptalk.dsa.upc.edu','Ruben Molina'),('_g{ùå´\0#¥lŒ','mzeron','Ü›ÛRÐMÂ\06ÛØ1>ÐU','mzeron@grouptalk.dsa.upc.edu','Marcelus Zeron');
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

-- Dump completed on 2015-10-28 21:59:57
