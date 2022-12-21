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
-- Table structure for table `repo`
--

DROP TABLE IF EXISTS `repo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repo` (
  `idx` int NOT NULL AUTO_INCREMENT COMMENT '저장소 번호',
  `name` varchar(45) NOT NULL COMMENT 'Repositories 이름',
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `public` tinyint NOT NULL COMMENT '공개여부 ',
  `owner` int NOT NULL COMMENT '소유자',
  `fork` tinyint NOT NULL DEFAULT '0' COMMENT '포크한 저장소(Repo-idx) / 0일경우 포크저장소가 아니다.',
  `clone` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repo`
--

LOCK TABLES `repo` WRITE;
/*!40000 ALTER TABLE `repo` DISABLE KEYS */;
INSERT INTO `repo` VALUES (1,'JavaProject','2022-10-21 05:09:54',1,1,0,'6l6pm2s8337d8yxqire71j947ue84xtb7mw','aaaa'),(2,'AMPProject','2022-10-21 05:09:54',1,2,0,'1sl47k1ja58e39313p9895xlef7b38m4uv4','bbbb'),(3,'GitProject','2022-10-21 05:09:54',1,3,0,'zhlwa0ezt6bc98u08twd4wnt87t2pxj94lz','ccccc'),(4,'test','2022-12-19 02:09:33',1,1,0,'ov4ysrjf4s80noknm3jv262z2lmxbw4dob0','test'),(50,'test2','2022-12-20 02:25:01',1,1,0,'gw9gs3yb304rsofpoj64bfi3348u93co6cg',''),(51,'README','2022-12-20 07:19:07',0,1,0,'qw826ma81hi5o1sbiq270g1g2kf9s5ng4g8','ㅇㅇ'),(52,'README','2022-12-21 01:47:03',1,2,0,'lg69st403f42461dps6848i23po6ho2l6ww','readme');
/*!40000 ALTER TABLE `repo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 15:12:30
