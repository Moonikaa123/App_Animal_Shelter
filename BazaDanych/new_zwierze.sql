CREATE DATABASE  IF NOT EXISTS `new` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `new`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: new
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `zwierze`
--

DROP TABLE IF EXISTS `zwierze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zwierze` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `typ` varchar(20) DEFAULT NULL,
  `plec` varchar(20) DEFAULT NULL,
  `rasa` varchar(20) DEFAULT NULL,
  `wiek` int NOT NULL,
  `waga` double NOT NULL,
  `nazwa` varchar(20) DEFAULT NULL,
  `opis` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zwierze`
--

LOCK TABLES `zwierze` WRITE;
/*!40000 ALTER TABLE `zwierze` DISABLE KEYS */;
INSERT INTO `zwierze` VALUES (1,'Kot','Samica','brak',1,5,'brak','brak'),(10,'Kot','Samiec','Kot perski',5,3,'Persian','Biały Kot Perski'),(11,'Pies','Samiec','Owczarek niemiecki',12,30,'Bambi','brak'),(12,'Pies','Samica','Labrador',2,9,'Lily','Barwa jasna'),(13,'Pies','Samiec','Bokser',11,25,'brak','brak'),(15,'Kot','Samica','Kot domowy',10,5,'brak','brak'),(16,'Kot','Samiec','Sfinks',2,1,'Sfinks','brak'),(32,'Pies','Samiec','brak',4,3,'brak','brak');
/*!40000 ALTER TABLE `zwierze` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-04 22:17:59
