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
-- Table structure for table `pullreq`
--

DROP TABLE IF EXISTS `pullreq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pullreq` (
  `idx` int NOT NULL AUTO_INCREMENT COMMENT 'Idx',
  `repo` int NOT NULL COMMENT '저장소 번호',
  `member` int NOT NULL COMMENT '회원번호',
  `message` longtext COMMENT 'EX)병합 요청합니다. / 내용',
  `token` varchar(45) NOT NULL COMMENT 'a(원래저장소)에서 b(fork한)를 병합할때 b의 토큰 / ex)bx32sg3ko',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '시간 / EX)2022-10-17 11:31:41',
  `marged` tinyint(1) NOT NULL DEFAULT '0' COMMENT '요청을 수락했을때 1이 된다.',
  `end_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pullreq`
--

LOCK TABLES `pullreq` WRITE;
/*!40000 ALTER TABLE `pullreq` DISABLE KEYS */;
INSERT INTO `pullreq` VALUES (20,103,3,'112233','0vt1fbbk5nahmb3','2023-01-12 03:06:22',2,'2023-01-15 08:12:50'),(21,103,3,'ㅂㅈㄷㅂㅈㄷ','v6ya52h7tz2gp53','2023-01-12 03:10:06',1,'2023-01-15 08:14:02'),(22,103,2,'병합 시켜줘 쭈발','8o65us57o167w98','2023-01-14 08:43:54',0,NULL),(30,128,1,'123','88v275135bl6obq','2023-02-03 06:23:29',2,'2023-02-03 06:23:36');
/*!40000 ALTER TABLE `pullreq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-05  0:41:03
