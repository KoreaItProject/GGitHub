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
  `email_check` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'GGitHub','ggit@naver.com','1234',0,'2022-10-21 05:11:22','1.jpg','시연용 아이디 입니다.','11@url.com','코리아아이티아카데미','신촌',1),(2,'JUNSEONG','2@naver.com','2',0,'2022-10-21 05:11:22','2.jpg','민준성입니다.','2@url.com','4조','조장',1),(3,'JINRYEOL','3@naver.com','3',0,'2022-10-21 05:11:22','3.png','JIN-RYEOL 입니다 ^^','3@url.com','Gooogle','오사카',1),(4,'JAVAKING','4@naver.com','1234',0,'2022-10-21 05:11:22','4.jpg','자바 너무 쉽다',NULL,NULL,'바다',1),(5,'SQLMASTER','5@gmail.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL,1),(6,'LeeTaeHyeon','6@hanmail.net','1234',0,'2022-10-21 05:11:22','6.jpg','이태현입니다.',NULL,NULL,NULL,1),(7,'こんにちは','7@naver.com','1234',0,'2022-10-21 05:11:22','7.jpg','よろしくお願いいたします','','たく','Tokyo',1),(8,'Alex','8@naver.com','1234',0,'2022-10-21 05:11:22','8.JPG','Hello',NULL,'NASA','Moon',1),(9,'SON','9@gmail.com','1234',0,'2022-10-21 05:11:22','9.jpg','나는야 득점왕','','Tottenham Hotspur Football Club','Premier League',1),(10,'MESSI','10@naver.com','1234',0,'2022-10-21 05:11:22','10.jpg','으ㅏㅏ아악!!!!!',NULL,NULL,'이집트',0),(11,'술은역시청하','11@gmail.com','1234',0,'2022-10-21 05:11:22','11.jpg','반갑습니다~^^',NULL,NULL,'USA',1),(12,'maplestory','abc12@gmail.com','1234',0,'2022-10-21 05:11:22','12.jpg','안경잡이 개발자 입니다~^^',NULL,NULL,'인천',0),(13,'harry','abc13@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL,1),(14,'kim','abc14@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL,1),(15,'Lee','abc15@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL,1),(16,'park','abc16@naver.com','1234',0,'2022-10-21 05:11:22',NULL,NULL,NULL,NULL,NULL,1),(23,'mem1','abc17@naver.com','1234',0,'2023-01-15 09:13:29',NULL,NULL,NULL,NULL,NULL,1),(24,'mem2','abc18@naver.com','1234',0,'2023-01-15 09:13:29',NULL,NULL,NULL,NULL,NULL,1),(25,'mem3','abc19@naver.com','1234',0,'2023-01-15 09:13:29',NULL,NULL,NULL,NULL,NULL,1),(26,'mem4','abc20@naver.com','1234',0,'2023-01-15 09:13:29',NULL,NULL,NULL,NULL,NULL,1);
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

-- Dump completed on 2023-02-05  0:41:03
