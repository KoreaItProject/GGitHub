-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ggitdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `repomem`
--

DROP TABLE IF EXISTS `repomem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repomem` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `repo` int NOT NULL COMMENT '저장소 번호\n',
  `member` int NOT NULL COMMENT '회원번호',
  `sort` int DEFAULT '0',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repomem`
--

LOCK TABLES `repomem` WRITE;
/*!40000 ALTER TABLE `repomem` DISABLE KEYS */;
INSERT INTO `repomem` VALUES (1,1,1,0),(2,1,2,3),(3,1,3,1),(4,2,1,2),(5,2,2,0),(6,2,3,0),(7,3,1,3),(8,3,2,2),(9,3,3,2),(10,4,1,4),(61,60,1,1),(62,61,1,0),(63,62,1,0),(64,63,1,0),(65,64,1,0),(66,65,1,0),(67,66,1,0),(68,67,1,0),(69,68,1,0),(70,69,1,0),(71,70,1,0),(72,71,2,0),(73,72,1,0),(77,76,3,0),(78,77,3,0),(79,78,3,0),(80,79,3,0),(81,80,3,0),(82,81,3,0),(83,82,3,0),(84,83,3,0),(85,84,3,0),(86,85,3,0),(87,86,3,0);
/*!40000 ALTER TABLE `repomem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-07 16:31:16
