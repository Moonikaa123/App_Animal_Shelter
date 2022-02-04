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
-- Table structure for table `pracownik`
--

DROP TABLE IF EXISTS `pracownik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pracownik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `idPlec` int NOT NULL,
  `wiek` int NOT NULL,
  `idStanowisko` int NOT NULL,
  `miejscowosc` varchar(45) DEFAULT NULL,
  `ulica` varchar(45) DEFAULT NULL,
  `numer` varchar(45) DEFAULT NULL,
  `telefon` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `plec_idx` (`idPlec`),
  KEY `stanowisko_idx` (`idStanowisko`),
  CONSTRAINT `fkPlec` FOREIGN KEY (`idPlec`) REFERENCES `plec` (`id`),
  CONSTRAINT `fkStanowisko` FOREIGN KEY (`idStanowisko`) REFERENCES `stanowisko` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pracownik`
--

LOCK TABLES `pracownik` WRITE;
/*!40000 ALTER TABLE `pracownik` DISABLE KEYS */;
INSERT INTO `pracownik` VALUES (73,'Jan','Kowalski',1,35,1,'Warszawa','Koszykowa','21',123456789,'jan.kowalski@gmail.com'),(78,'Mariusz','Wójcik',1,20,4,'Warszawa','Miła','8',123456789,'aa@gmail.com'),(81,'Katarzyna','Nowak',2,56,6,'Warszawa','Długa','10/3',987654321,'bb@gmail.com'),(82,'Paulina','Kowalczyk',2,39,2,'Warszawa','Jutrzenki','20/12',456734561,'cc@gmail.com'),(83,'Anna','Kowalik',2,26,4,'Warszawa','Lwowska','15',123567345,'dd@gmail.com'),(84,'Karolina','Kamińska',2,35,5,'Warszawa','Rzymska','15/4',987567345,'ee@gmail.com'),(85,'Monika','Piątek',2,28,4,'Warszawa','Taborowa','25',444267345,'ff@gmail.com'),(87,'Gracjan','Zieliński',1,22,4,'Warszawa','Nutki','21',111267345,'gg@gmail.com'),(88,'Adam','Nowak',1,46,7,'Wyszków','Handlowa','116',654836542,'hh@gmail.com'),(100,'Karolina','Świat',2,47,2,'Warszawa','Lipowa','10/6',65498897,'abc@gmail.com');
/*!40000 ALTER TABLE `pracownik` ENABLE KEYS */;
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
