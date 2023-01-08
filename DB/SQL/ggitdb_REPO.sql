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
  `download` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repo`
--

LOCK TABLES `repo` WRITE;
/*!40000 ALTER TABLE `repo` DISABLE KEYS */;
INSERT INTO `repo` VALUES (1,'JavaProject','2023-01-07 05:00:47',1,1,0,'6yg4hw3bf029kuh8qzl732d87f9ai25d3t0','javaproject\n',0),(2,'AMProject','2023-01-07 05:09:25',1,2,0,'o35hi43d8hft5uzq790xt3xxtqk8t76y69a','학원관리프로젝트',3),(3,'GGitProject','2023-01-07 05:10:31',1,3,0,'6ahda8yts1pipc827p3m1p1i2zxvlx4l8g2','깃허브 협업 관리 프로그램',0),(4,'test','2022-12-19 02:09:33',1,1,0,'ov4ysrjf4s80noknm3jv262z2lmxbw4dob0','test',0),(60,'README','2022-12-25 14:04:01',1,1,0,'833ty55hj67y39tebeu9ndsy9ujw49kxdm7','README',0),(61,'test1','2022-12-29 05:49:16',1,1,0,'9070x8c4ovzd01u0qzo1855lo5s12wt2v61','test1',0),(62,'test2','2022-12-29 05:49:29',1,1,0,'61689gm03813gjn32tf2ctf6te127861380','test2',0),(63,'test3','2022-12-29 05:49:36',1,1,0,'aa79zrq04tp8xv0n18x466f526y194kq2r3','test3',0),(64,'test4','2022-12-29 05:49:43',1,1,0,'1f60e9t4h0221j6bl9u444p276w5in4ui8l','test4',0),(65,'test5','2022-12-29 05:49:49',1,1,0,'2e051ji51tto61nb8hpns49v0e608kr9c57','test5',0),(66,'test6','2022-12-29 05:49:57',1,1,0,'23456a73m84spoqx8e7y9i03pxby1aefz04','test6',0),(67,'test7','2022-12-29 05:50:04',1,1,0,'17v8n228qf7t1o64h0l2jt60ku9s19wf3ow','test7',0),(68,'test8','2022-12-29 05:50:14',1,1,0,'1j5h68mo334th68j4am5j7j8768caz0jx70','test8',0),(69,'test9','2022-12-29 05:50:22',1,1,0,'0r78x2w28t593hj0g77n285ewql465k8016','test9',0),(70,'test10','2022-12-29 05:50:31',1,1,0,'b1f90i6m1f90g1h8t5c4vp2nbhk6wc0c0p8','ty\nt\nt\n',0),(71,'ff','2022-12-29 06:59:49',1,2,0,'l37478ha4s19rs1we31d0dq7jv2i49g26ql','ff',0),(72,'gg','2023-01-07 04:25:14',1,1,0,'xb03b25r7t4rhjut61jg35p1vqaz5h425g3','gg',0);
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

-- Dump completed on 2023-01-07 16:31:16
