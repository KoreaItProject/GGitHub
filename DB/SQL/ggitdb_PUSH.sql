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
  `before_token` varchar(45) DEFAULT NULL COMMENT 'pull했던 토큰 값 / ex)sjg3125qs',
  `selected` varchar(45) DEFAULT '0',
  `fromMain` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `push`
--

LOCK TABLES `push` WRITE;
/*!40000 ALTER TABLE `push` DISABLE KEYS */;
INSERT INTO `push` VALUES ('223hl46xfrpn6l3',1,1,'새폴더 안에 새폴더 삭제 텍스트 수정','2022-12-25 14:03:04',1,'puhdj7wu628iety','1',0),('36ocvtf40278t7d',1,1,'새폴더 안에 텍스트와 새폴더 추가','2022-12-25 14:02:34',1,'puhdj7wu628iety','0',0),('5k20hjf9k642g03',1,4,'저장소 생성','2022-12-19 02:09:33',0,NULL,'0',0),('8ty741l691243e9',1,60,'저장소 생성','2022-12-25 14:04:01',0,NULL,'0',0),('puhdj7wu628iety',1,1,'저장소 생성','2022-12-16 05:00:07',0,NULL,'0',0),('siwlc45e1g45d87',2,2,'저장소 생성','2022-11-17 06:24:38',0,NULL,'0',0),('t3nyt5313sumkiq',1,1,'새폴더 만듬','2022-12-25 14:02:13',1,'puhdj7wu628iety','0',0),('za84vbed01blram',3,3,'저장소 생성','2022-10-21 05:21:19',0,NULL,'0',0);
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

-- Dump completed on 2022-12-25 23:06:31
