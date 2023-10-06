-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: parking_car
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (45,'lsyh31@gmail.com','$2a$10$LSEKwtmf4PMRbkfMoHGpz.FBcVNaR5b5Bnd.uEl16/WndooYispii',1),(42,'hoa@gmail.com','$2a$10$CNE9aqF6hEIaNa5FZLlYqucmO0dbkejT4fT8p2MSonSd2XoJUwPEq',2),(43,'kiet@gmail.com','$2a$10$CNE9aqF6hEIaNa5FZLlYqucmO0dbkejT4fT8p2MSonSd2XoJUwPEq',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `flag_delete` bit(1) NOT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `license_plates` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `purse` float NOT NULL,
  `verification_code` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jwt2qo9oj3wd7ribjkymryp8s` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (40,'lsyh31@gmail.com',_binary '',NULL,_binary '\0','123546987','','Yến Hoa','0397234354',4077500,'eynLpZTjRyJhqINeK0wPlAWFiXP3egdpwMBk9ZsApcBkqyWlvwghIAi0RVaTrfmt',45),(38,'kiet@gmail.com',_binary '',NULL,_binary '\0','0315445254','81B1-19968','Tuấn Kiệt','0382007466',987500,'dXVKmtqDSVv6HvgfcFMssfmofTtHpeScHJDLLxQNgb1KqRoDLQ1yQ0M4vNhmIVny',43);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcfg6ajo8oske94exynxpf7tf9` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'hoa@gmail.com','Hoa',42);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floor_parking`
--

DROP TABLE IF EXISTS `floor_parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floor_parking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `parking_car_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcb1lt39al9lpjpw19u50k438v` (`parking_car_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floor_parking`
--

LOCK TABLES `floor_parking` WRITE;
/*!40000 ALTER TABLE `floor_parking` DISABLE KEYS */;
INSERT INTO `floor_parking` VALUES (1,20,1),(2,20,1),(3,20,1),(4,20,1),(5,20,1),(6,20,1),(7,20,1),(8,20,1);
/*!40000 ALTER TABLE `floor_parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_car`
--

DROP TABLE IF EXISTS `parking_car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `floors` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_car`
--

LOCK TABLES `parking_car` WRITE;
/*!40000 ALTER TABLE `parking_car` DISABLE KEYS */;
INSERT INTO `parking_car` VALUES (1,8);
/*!40000 ALTER TABLE `parking_car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_slot`
--

DROP TABLE IF EXISTS `parking_slot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_slot` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `availability` bit(1) NOT NULL,
  `price_slot` float NOT NULL,
  `version` bit(1) NOT NULL,
  `floor_parking_id` bigint DEFAULT NULL,
  `reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgy7e7rcv6m2yohxn2uakdhlir` (`reservation_id`),
  KEY `FKb8r016l0bpr70677hb6c9ykxl` (`floor_parking_id`)
) ENGINE=MyISAM AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_slot`
--

LOCK TABLES `parking_slot` WRITE;
/*!40000 ALTER TABLE `parking_slot` DISABLE KEYS */;
INSERT INTO `parking_slot` VALUES (1,_binary '',5000,_binary '',1,NULL),(2,_binary '',5000,_binary '',1,NULL),(3,_binary '',5000,_binary '',1,NULL),(4,_binary '\0',5000,_binary '\0',1,NULL),(5,_binary '\0',5000,_binary '\0',1,NULL),(6,_binary '\0',5000,_binary '\0',1,NULL),(7,_binary '\0',5000,_binary '\0',1,NULL),(8,_binary '\0',5000,_binary '\0',1,NULL),(9,_binary '\0',5000,_binary '\0',1,NULL),(10,_binary '\0',5000,_binary '\0',1,NULL),(11,_binary '\0',5000,_binary '\0',1,NULL),(12,_binary '\0',5000,_binary '\0',1,NULL),(13,_binary '\0',5000,_binary '\0',1,NULL),(14,_binary '\0',5000,_binary '\0',1,NULL),(15,_binary '\0',5000,_binary '\0',1,NULL),(16,_binary '\0',5000,_binary '\0',1,NULL),(17,_binary '\0',5000,_binary '\0',1,NULL),(18,_binary '\0',5000,_binary '\0',1,NULL),(19,_binary '\0',5000,_binary '\0',1,NULL),(20,_binary '\0',5000,_binary '\0',1,NULL),(21,_binary '',5000,_binary '',2,NULL),(22,_binary '\0',5000,_binary '\0',2,NULL),(23,_binary '\0',5000,_binary '\0',2,NULL),(24,_binary '\0',5000,_binary '\0',2,NULL),(25,_binary '\0',5000,_binary '\0',2,NULL),(26,_binary '\0',5000,_binary '\0',2,NULL),(27,_binary '\0',5000,_binary '\0',2,NULL),(28,_binary '\0',5000,_binary '\0',2,NULL),(29,_binary '\0',5000,_binary '\0',2,NULL),(30,_binary '\0',5000,_binary '\0',2,NULL),(31,_binary '\0',5000,_binary '\0',2,NULL),(32,_binary '\0',5000,_binary '\0',2,NULL),(33,_binary '\0',5000,_binary '\0',2,NULL),(34,_binary '\0',5000,_binary '\0',2,NULL),(35,_binary '\0',5000,_binary '\0',2,NULL),(36,_binary '\0',5000,_binary '\0',2,NULL),(37,_binary '\0',5000,_binary '\0',2,NULL),(38,_binary '\0',5000,_binary '\0',2,NULL),(39,_binary '\0',5000,_binary '\0',2,NULL),(40,_binary '\0',5000,_binary '\0',2,NULL),(41,_binary '\0',5000,_binary '\0',3,NULL),(42,_binary '\0',5000,_binary '\0',3,NULL),(43,_binary '\0',5000,_binary '\0',3,NULL),(44,_binary '\0',5000,_binary '\0',3,NULL),(45,_binary '\0',5000,_binary '\0',3,NULL),(46,_binary '\0',5000,_binary '\0',3,NULL),(47,_binary '\0',5000,_binary '\0',3,NULL),(48,_binary '\0',5000,_binary '\0',3,NULL),(49,_binary '\0',5000,_binary '\0',3,NULL),(50,_binary '\0',5000,_binary '\0',3,NULL),(51,_binary '\0',5000,_binary '\0',3,NULL),(52,_binary '\0',5000,_binary '\0',3,NULL),(53,_binary '\0',5000,_binary '\0',3,NULL),(54,_binary '\0',5000,_binary '\0',3,NULL),(55,_binary '\0',5000,_binary '\0',3,NULL),(56,_binary '\0',5000,_binary '\0',3,NULL),(57,_binary '\0',5000,_binary '\0',3,NULL),(58,_binary '\0',5000,_binary '\0',3,NULL),(59,_binary '\0',5000,_binary '\0',3,NULL),(60,_binary '\0',5000,_binary '\0',3,NULL),(61,_binary '\0',5000,_binary '\0',4,NULL),(62,_binary '\0',5000,_binary '\0',4,NULL),(63,_binary '\0',5000,_binary '\0',4,NULL),(64,_binary '\0',5000,_binary '\0',4,NULL),(65,_binary '\0',5000,_binary '\0',4,NULL),(66,_binary '\0',5000,_binary '\0',4,NULL),(67,_binary '\0',5000,_binary '\0',4,NULL),(68,_binary '\0',5000,_binary '\0',4,NULL),(69,_binary '\0',5000,_binary '\0',4,NULL),(70,_binary '\0',5000,_binary '\0',4,NULL),(71,_binary '\0',5000,_binary '\0',4,NULL),(72,_binary '\0',5000,_binary '\0',4,NULL),(73,_binary '\0',5000,_binary '\0',4,NULL),(74,_binary '\0',5000,_binary '\0',4,NULL),(75,_binary '\0',5000,_binary '\0',4,NULL),(76,_binary '\0',5000,_binary '\0',4,NULL),(77,_binary '\0',5000,_binary '\0',4,NULL),(78,_binary '\0',5000,_binary '\0',4,NULL),(79,_binary '\0',5000,_binary '\0',4,NULL),(80,_binary '\0',5000,_binary '\0',4,NULL),(81,_binary '\0',5000,_binary '\0',5,NULL),(82,_binary '\0',5000,_binary '\0',5,NULL),(83,_binary '\0',5000,_binary '\0',5,NULL),(84,_binary '\0',5000,_binary '\0',5,NULL),(85,_binary '\0',5000,_binary '\0',5,NULL),(86,_binary '\0',5000,_binary '\0',5,NULL),(87,_binary '\0',5000,_binary '\0',5,NULL),(88,_binary '\0',5000,_binary '\0',5,NULL),(89,_binary '\0',5000,_binary '\0',5,NULL),(90,_binary '\0',5000,_binary '\0',5,NULL),(91,_binary '\0',5000,_binary '\0',5,NULL),(92,_binary '\0',5000,_binary '\0',5,NULL),(93,_binary '\0',5000,_binary '\0',5,NULL),(94,_binary '\0',5000,_binary '\0',5,NULL),(95,_binary '\0',5000,_binary '\0',5,NULL),(96,_binary '\0',5000,_binary '\0',5,NULL),(97,_binary '\0',5000,_binary '\0',5,NULL),(98,_binary '\0',5000,_binary '\0',5,NULL),(99,_binary '\0',5000,_binary '\0',5,NULL),(100,_binary '\0',5000,_binary '\0',5,NULL),(101,_binary '\0',5000,_binary '\0',6,NULL),(102,_binary '\0',5000,_binary '\0',6,NULL),(103,_binary '\0',5000,_binary '\0',6,NULL),(104,_binary '\0',5000,_binary '\0',6,NULL),(105,_binary '\0',5000,_binary '\0',6,NULL),(106,_binary '\0',5000,_binary '\0',6,NULL),(107,_binary '\0',5000,_binary '\0',6,NULL),(108,_binary '\0',5000,_binary '\0',6,NULL),(109,_binary '\0',5000,_binary '\0',6,NULL),(110,_binary '\0',5000,_binary '\0',6,NULL),(111,_binary '\0',5000,_binary '\0',6,NULL),(112,_binary '\0',5000,_binary '\0',6,NULL),(113,_binary '\0',5000,_binary '\0',6,NULL),(114,_binary '\0',5000,_binary '\0',6,NULL),(115,_binary '\0',5000,_binary '\0',6,NULL),(116,_binary '\0',5000,_binary '\0',6,NULL),(117,_binary '\0',5000,_binary '\0',6,NULL),(118,_binary '\0',5000,_binary '\0',6,NULL),(119,_binary '\0',5000,_binary '\0',6,NULL),(120,_binary '\0',5000,_binary '\0',6,NULL),(121,_binary '\0',5000,_binary '\0',7,NULL),(122,_binary '\0',5000,_binary '\0',7,NULL),(123,_binary '\0',5000,_binary '\0',7,NULL),(124,_binary '\0',5000,_binary '\0',7,NULL),(125,_binary '\0',5000,_binary '\0',7,NULL),(126,_binary '\0',5000,_binary '\0',7,NULL),(127,_binary '\0',5000,_binary '\0',7,NULL),(128,_binary '\0',5000,_binary '\0',7,NULL),(129,_binary '\0',5000,_binary '\0',7,NULL),(130,_binary '\0',5000,_binary '\0',7,NULL),(131,_binary '\0',5000,_binary '\0',7,NULL),(132,_binary '\0',5000,_binary '\0',7,NULL),(133,_binary '\0',5000,_binary '\0',7,NULL),(134,_binary '\0',5000,_binary '\0',7,NULL),(135,_binary '\0',5000,_binary '\0',7,NULL),(136,_binary '\0',5000,_binary '\0',7,NULL),(137,_binary '\0',5000,_binary '\0',7,NULL),(138,_binary '\0',5000,_binary '\0',7,NULL),(139,_binary '\0',5000,_binary '\0',7,NULL),(140,_binary '\0',5000,_binary '\0',7,NULL),(141,_binary '\0',5000,_binary '\0',8,NULL),(142,_binary '\0',5000,_binary '\0',8,NULL),(143,_binary '\0',5000,_binary '\0',8,NULL),(144,_binary '\0',5000,_binary '\0',8,NULL),(145,_binary '\0',5000,_binary '\0',8,NULL),(146,_binary '\0',5000,_binary '\0',8,NULL),(147,_binary '\0',5000,_binary '\0',8,NULL),(148,_binary '\0',5000,_binary '\0',8,NULL),(149,_binary '\0',5000,_binary '\0',8,NULL),(150,_binary '\0',5000,_binary '\0',8,NULL),(151,_binary '\0',5000,_binary '\0',8,NULL),(152,_binary '\0',5000,_binary '\0',8,NULL),(153,_binary '\0',5000,_binary '\0',8,NULL),(154,_binary '\0',5000,_binary '\0',8,NULL),(155,_binary '\0',5000,_binary '\0',8,NULL),(156,_binary '\0',5000,_binary '\0',8,NULL),(157,_binary '\0',5000,_binary '\0',8,NULL),(158,_binary '\0',5000,_binary '\0',8,NULL),(159,_binary '\0',5000,_binary '\0',8,NULL),(160,_binary '\0',5000,_binary '\0',8,NULL);
/*!40000 ALTER TABLE `parking_slot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penalty`
--

DROP TABLE IF EXISTS `penalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `penalty` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `penalty_hour` int NOT NULL,
  `penalty_price` float NOT NULL,
  `reservation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKds6fn1q08u5syl9de7s9y3onc` (`reservation_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penalty`
--

LOCK TABLES `penalty` WRITE;
/*!40000 ALTER TABLE `penalty` DISABLE KEYS */;
/*!40000 ALTER TABLE `penalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_time` varchar(255) DEFAULT NULL,
  `number_plate` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `total_price` float NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `parking_slot_id` bigint DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpuht7aanh4i4be0i58jofg56b` (`account_id`),
  KEY `FKs497bxeyt3u5vt8k7i6s87252` (`parking_slot_id`),
  KEY `FK492s0ly1osg0u7rkijwpeftvm` (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=266 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (265,'2023-09-22 11:15','2121','2023-09-22 10:45',2500,45,3,1,'2121'),(263,'2023-09-22 10:40','21210','2023-09-22 10:10',2500,43,2,1,'2121'),(264,'2023-09-22 15:00','21221','2023-09-22 11:00',20000,45,21,1,'2121'),(262,'2023-09-22 16:00','81B1-19968','2023-09-22 14:00',10000,43,1,1,'031456247895');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_CUSTOMER'),(2,'ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `discount` float NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,0,'Giờ'),(2,0.02,'Ngày (-2%)'),(3,0.05,'Tuần (-5%)'),(4,0.1,'Tháng (-10%)');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-06 14:09:53
