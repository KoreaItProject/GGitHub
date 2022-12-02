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
-- Table structure for table `push`
--

DROP TABLE IF EXISTS `push`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `push` (
  `token` varchar(45) NOT NULL COMMENT 'Ex) bx32sg3ko / push의 고유 토큰\n',
  `member` int NOT NULL,
  `repo` int NOT NULL,
  `message` longtext COMMENT 'Ex) 함수 수정하였음 / push 메시지',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Push 일자 / EX) 2022-10-17-11:13:41',
  `branch` int NOT NULL DEFAULT '0' COMMENT '브랜치 번호  (0은 메인)',
  `from` varchar(45) DEFAULT NULL COMMENT 'pull했던 토큰 값 / ex)sjg3125qs',
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `push`
--

LOCK TABLES `push` WRITE;
/*!40000 ALTER TABLE `push` DISABLE KEYS */;
INSERT INTO `push` VALUES ('0z5p55g9d5',1,25,'프로젝트 생성','2022-12-02 07:37:00',0,NULL),('3713e8458j',1,24,'프로젝트 생성','2022-12-02 07:36:34',0,NULL),('aj87hd8k9',4,11,NULL,'2022-10-21 05:21:19',0,NULL),('ap08bj1kq',1,5,NULL,'2022-10-21 05:21:19',0,NULL),('as81di82',8,9,NULL,'2022-10-21 05:21:19',0,NULL),('asda231',1,1,NULL,'2022-11-17 06:24:38',0,'asdf8a2'),('asdf8a2',1,1,'','2022-11-17 06:10:50',0,NULL),('g7nb959qf9',1,23,'프로젝트 생성','2022-12-02 07:34:01',0,NULL),('id99hj2ah',8,3,NULL,'2022-10-21 05:21:19',0,NULL),('kta410wv36',1,26,'프로젝트 생성','2022-12-02 07:37:31',0,NULL),('kv87gi9kq',1,2,NULL,'2022-10-21 05:21:19',0,NULL),('ma98ko2i',6,7,NULL,'2022-10-21 05:21:19',0,NULL),('mq9s3p9x3j',1,27,'프로젝트 생성','2022-12-02 07:39:49',0,NULL),('nj28yt7ot',9,8,NULL,'2022-10-21 05:21:19',0,NULL),('nv29ai2ka',6,6,NULL,'2022-10-21 05:21:19',0,NULL),('op76aa9bn',3,4,NULL,'2022-10-21 05:21:19',0,NULL),('sd8c7s6a5s',3,10,NULL,'2022-10-21 05:21:19',0,NULL),('si8w72ud6s',7,12,NULL,'2022-10-21 05:21:19',0,NULL),('sys11py901',1,21,'프로젝트 생성','2022-12-02 07:24:52',0,NULL),('t8qy4r051j',1,22,'프로젝트 생성','2022-12-02 07:32:26',0,NULL);
/*!40000 ALTER TABLE `push` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 19:37:48
