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
INSERT INTO `auth_tokens` VALUES ('T{��\0#�l�','Xz�{��\0#�l�'),('�٢|\n�H\0#�l�','�X`|\n�H\0#�l�'),('UD)	{��\0#�l�','UF�X{��\0#�l�'),('_�g�{��\0#�l�','_�7{��\0#�l�');
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
INSERT INTO `comments` VALUES ('��}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:12:04','2015-10-28 18:12:04','4��x}��L\0#�l�'),('\Z��}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:12:45','2015-10-28 18:12:45','4��x}��L\0#�l�'),('$�/�}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 16:51:33','2015-10-28 17:51:33','4��x}��L\0#�l�'),('8�@v}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 16:52:06','2015-10-28 17:52:06','4��x}��L\0#�l�'),('9x��}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 16:52:08','2015-10-28 17:52:08','4��x}��L\0#�l�'),('C�kF}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:13:54','2015-10-28 18:13:54','4��x}��L\0#�l�'),('bTAt}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:07:35','2015-10-28 18:07:35','4��x}��L\0#�l�'),('~���}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:01:13','2015-10-28 18:01:13','4��x}��L\0#�l�'),('� ��}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:15:38','2015-10-28 18:15:38','4��x}��L\0#�l�'),('��;C}��g\0#�l�','T{��\0#�l�','Increible, me encanta!','2015-10-28 20:57:36','2015-10-28 21:57:36','\\F}��g\0#�l�'),('��~�}��g\0#�l�','T{��\0#�l�','Increible, me encanta!','2015-10-28 20:57:42','2015-10-28 21:57:42','\\F}��g\0#�l�'),('�4�}��g\0#�l�','T{��\0#�l�','Increible, me encanta!','2015-10-28 20:57:42','2015-10-28 21:57:42','\\F}��g\0#�l�'),('�ҁ	}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:09:31','2015-10-28 18:09:31','4��x}��L\0#�l�'),('�/H�}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:02:03','2015-10-28 18:02:03','4��x}��L\0#�l�'),('�0:~}��L\0#�l�','T{��\0#�l�','Ya he comprado mis entradas para el pre estreno que ganas','2015-10-28 16:26:20','2015-10-28 17:26:20','4��x}��L\0#�l�'),('��ZD}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:11:04','2015-10-28 18:11:04','4��x}��L\0#�l�'),('�VP}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:18:18','2015-10-28 18:18:18','4��x}��L\0#�l�'),('�F�}��L\0#�l�','T{��\0#�l�','Luke es el malo!','2015-10-28 17:18:53','2015-10-28 18:18:53','4��x}��L\0#�l�');
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
INSERT INTO `interestgroups` VALUES ('��\r}��L\0#�l�','T{��\0#�l�','Peliculas','2015-10-28 15:53:46','2015-10-28 16:53:46'),('j3��}��g\0#�l�','T{��\0#�l�','Videojuegos','2015-10-28 20:49:43','2015-10-28 21:49:43');
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
INSERT INTO `themes` VALUES ('\0cW}��g\0#�l�','T{��\0#�l�','World of Warcraft','Role-playing game','2015-10-28 20:53:54','2015-10-28 21:53:54','j3��}��g\0#�l�'),('(΃}��L\0#�l�','T{��\0#�l�','Trilogía cinematográfica de El Señor de los Anillos ','El señor de los Anillos','2015-10-28 17:20:18','2015-10-28 18:20:18','��\r}��L\0#�l�'),('4��x}��L\0#�l�','T{��\0#�l�','Star Wars VII','Star Wars: Episode VII - The Force Awakens','2015-10-28 16:16:12','2015-10-28 17:16:12','��\r}��L\0#�l�'),('\\F}��g\0#�l�','T{��\0#�l�','Counter-Strike: Global Offensive','First Person Shooter','2015-10-28 20:56:28','2015-10-28 21:56:28','j3��}��g\0#�l�'),('���}��L\0#�l�','T{��\0#�l�','Tomates verdes fritos','Peliculon','2015-10-28 17:23:31','2015-10-28 18:23:31','��\r}��L\0#�l�'),('�O�}��g\0#�l�','T{��\0#�l�','League of Legueds','Multiplayer online battle arena game','2015-10-28 20:51:40','2015-10-28 21:51:40','j3��}��g\0#�l�');
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
INSERT INTO `user_roles` VALUES ('T{��\0#�l�','admin'),('�٢|\n�H\0#�l�','registered'),('UD)	{��\0#�l�','registered'),('_�g�{��\0#�l�','registered');
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
INSERT INTO `users` VALUES ('T{��\0#�l�','jlopez','�ܛ�R�M�\06��1>�U','jlopez@grouptalk.dsa.upc.edu','Jordi Lopez'),('�٢|\n�H\0#�l�','test','�ܛ�R�M�\06��1>�U','test_user@test.com','Test fullname'),('UD)	{��\0#�l�','rmolina','�ܛ�R�M�\06��1>�U','rmolina@grouptalk.dsa.upc.edu','Ruben Molina'),('_�g�{��\0#�l�','mzeron','�ܛ�R�M�\06��1>�U','mzeron@grouptalk.dsa.upc.edu','Marcelus Zeron');
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
