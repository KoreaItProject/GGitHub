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
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `push`
--

LOCK TABLES `push` WRITE;
/*!40000 ALTER TABLE `push` DISABLE KEYS */;
INSERT INTO `push` VALUES ('07a8c34k0a20ak9',1,2,'업데이트됨','2022-12-19 04:55:03',1,'siwlc45e1g45d87','0'),('1x0l85dg45f9150',2,52,'저장소 생성','2022-12-21 01:47:03',0,NULL,'0'),('4e76g094jppe4qj',2,1,'메인 저장소에서 가져옴','2022-12-21 03:41:08',2,'puhdj7wu628iety','1'),('542de5i0fmzc36y',1,2,'dd','2022-12-22 02:22:21',1,'siwlc45e1g45d87','0'),('58b67b6k4551gqz',1,2,'제발','2022-12-22 02:28:47',1,'siwlc45e1g45d87','1'),('5k20hjf9k642g03',1,4,'저장소 생성','2022-12-19 02:09:33',0,NULL,'0'),('67ak09q6sr38567',1,1,'메인 저장소에서 가져옴','2022-12-20 03:28:59',1,'puhdj7wu628iety','1'),('9k6p0bow1701ocr',1,2,'gggg','2022-12-19 07:22:21',1,'siwlc45e1g45d87','0'),('9vufu5e8f9zklyd',2,1,'메인 저장소에서 가져옴','2022-12-21 03:41:11',2,'puhdj7wu628iety','0'),('c0ac9n2dost56ih',1,2,'fgdfg','2022-12-19 07:21:22',1,'siwlc45e1g45d87','0'),('puhdj7wu628iety',1,1,'저장소 생성','2022-12-16 05:00:07',0,NULL,'0'),('sefg8yrz38r85r8',1,50,'저장소 생성','2022-12-20 02:25:01',0,NULL,'0'),('siwlc45e1g45d87',2,2,'저장소 생성','2022-11-17 06:24:38',0,NULL,'0'),('t309s7sm3x224i5',2,2,'메인 저장소에서 가져옴','2022-12-21 03:31:53',2,'siwlc45e1g45d87','1'),('tf1x83wn0oe084o',1,51,'저장소 생성','2022-12-20 07:19:07',0,NULL,'0'),('za84vbed01blram',3,3,'저장소 생성','2022-10-21 05:21:19',0,NULL,'0');
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

-- Dump completed on 2022-12-22 12:18:12
