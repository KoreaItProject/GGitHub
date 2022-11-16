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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `idx` int NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `nick` varchar(45) NOT NULL COMMENT '''harry'' / 닉네임',
  `email` varchar(45) NOT NULL COMMENT '''harry@naver.com’/ 이메일',
  `pw` varchar(45) NOT NULL COMMENT '''패스워드''',
  `auth` tinyint NOT NULL DEFAULT '0' COMMENT '이메일 인증여부',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입일자',
  `img` varchar(45) DEFAULT NULL COMMENT '프로필 이미지 주소 / ''src/img/pro/img.jpg''',
  `con` varchar(200) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'leetaehyeon123','1@naver.com','1',0,'2022-10-21 05:11:22','people/tae.jpg','나는야 이태현 왼쪽어깨 부서짐','1@url.com','구글','센프란시스코'),(2,'Jun_Sung','2@naver.com','2',0,'2022-10-21 05:11:22','people/jun.jpg','나는야 민준성 허리디스크 무야호','2@url.com','나사','모스크바'),(3,'JIN-RYEOL','3@naver.com','3',0,'2022-10-21 05:11:22','people/jin.jpg','나는야 김진렬 오늘도 학교감','3@url.com','도쿄핫','도쿄'),(4,'abc4','abc4@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(5,'abc5','abc5@gmail.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(6,'abc6','abc6@hanmail.net','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(7,'abc7','abc7@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(8,'abc8','abc8@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(9,'abc9','abc9@gmail.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(10,'abc10','abc10@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(11,'abc11','abc11@gmail.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(12,'abc12','abc12@gmail.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(13,'abc13','abc13@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(14,'abc14','abc14@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(15,'abc15','abc15@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(16,'abc16','abc16@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(17,'abc17','abc17@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(18,'abc18','abc18@gamil.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(19,'abc19','abc19@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL),(20,'abc20','abc20@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-16 16:44:24
