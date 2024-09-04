-- MySQL dump 10.13  Distribute 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: interest_calculator
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `calculator`
--

DROP TABLE IF EXISTS `calculator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calculator` (
  `calculator_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  `months` varchar(45) DEFAULT NULL,
  `interest` varchar(45) DEFAULT NULL,
  `offers_name` varchar(45) DEFAULT NULL,
  `loan_amount` varchar(45) DEFAULT NULL,
  `interest_amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`calculator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calculator`
--

LOCK TABLES `calculator` WRITE;
/*!40000 ALTER TABLE `calculator` DISABLE KEYS */;
INSERT INTO `calculator` VALUES (1,0,'26588.92','81','4.82',NULL,NULL,NULL),(2,0,'26588.92','80','4.82',NULL,'',''),(3,0,'26588.92','81','4.82',NULL,NULL,''),(4,0,'26588.92','80','4.82',NULL,NULL,''),(5,0,'26588.92','81','4.82',NULL,NULL,NULL),(6,0,'26588.92','80','4.82',NULL,NULL,NULL);
/*!40000 ALTER TABLE `calculator` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-04 20:30:54
