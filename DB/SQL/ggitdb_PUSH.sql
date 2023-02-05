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
  `main_token` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `push`
--

LOCK TABLES `push` WRITE;
/*!40000 ALTER TABLE `push` DISABLE KEYS */;
INSERT INTO `push` VALUES ('05b2tli5p9ts9yg',1,72,'저장소 생성','2023-01-07 04:25:14',0,NULL,'0',0,NULL),('089uhlur7j2285q',3,111,'저장소 생성','2023-01-15 09:03:23',0,NULL,'0',0,NULL),('09rv8e1sbq82901',3,109,'저장소 생성','2023-01-15 09:02:34',0,NULL,'0',0,NULL),('0c6pc408lkj8dbi',11,123,'저장소 생성','2023-01-15 09:35:35',0,NULL,'0',0,NULL),('0o6gn8m2hnlc3du',7,115,'저장소 생성','2023-01-15 09:22:18',0,NULL,'0',0,NULL),('0vt1fbbk5nahmb3',3,103,'112233','2023-01-12 03:06:06',3,'8o65us57o167w98','0',0,'8o65us57o167w98'),('15092zppqebyl3x',9,120,'저장소 생성','2023-01-15 09:29:58',0,NULL,'0',0,NULL),('1564ofh8362406e',1,126,'저장소 생성','2023-02-03 06:04:01',1,'042w85garqg8j8a','0',1,'042w85garqg8j8a'),('1iqs0h32d45h3n1',2,107,'저장소 생성','2023-01-15 09:00:32',0,NULL,'0',0,NULL),('1j3592w4fba8tx3',1,127,'저장소 생성','2023-02-03 06:05:05',1,'042w85garqg8j8a','0',1,'042w85garqg8j8a'),('1y804h4d51sndoq',1,66,'저장소 생성','2022-12-29 05:49:57',0,NULL,'0',0,NULL),('2w6y02i54a16o3z',3,3,'저장소 생성','2023-01-07 05:10:31',0,NULL,'0',0,NULL),('38o0142pft16o60',7,112,'저장소 생성','2023-01-15 09:21:13',0,NULL,'0',0,NULL),('3u610k5j8407c90',12,122,'저장소 생성','2023-01-15 09:34:03',0,NULL,'0',0,NULL),('45a54889r48o216',1,104,'저장소 생성','2023-01-14 05:57:27',0,NULL,'0',0,NULL),('49g4q544j10rm01',3,110,'저장소 생성','2023-01-15 09:03:00',0,NULL,'0',0,NULL),('4j033ajf4i74krg',3,108,'저장소 생성','2023-01-15 09:01:33',0,NULL,'0',0,NULL),('4m316ox6711ja13',1,128,'111123','2023-02-03 06:11:10',1,'r50tv09z5i9405v','0',0,'r50tv09z5i9405v'),('5k20hjf9k642g03',1,4,'저장소 생성','2022-12-19 02:09:33',0,NULL,'0',0,NULL),('661g69igkei04v4',1,125,'저장소 생성','2023-02-03 06:02:29',1,'042w85garqg8j8a','0',1,'042w85garqg8j8a'),('76698sy1olgm960',1,128,'메인 저장소에서 가져옴','2023-02-03 06:21:29',1,'r50tv09z5i9405v','0',1,'r50tv09z5i9405v'),('88v275135bl6obq',1,128,'업데이트됨','2023-02-03 06:23:23',1,'76698sy1olgm960','1',0,'r50tv09z5i9405v'),('8o65us57o167w98',3,103,'저장소 생성','2023-01-12 02:39:49',0,NULL,'0',0,NULL),('8ty741l691243e9',1,60,'저장소 생성','2022-12-25 14:04:01',0,NULL,'0',0,NULL),('9c9kqkpxd37eaji',5,116,'저장소 생성','2023-01-15 09:23:59',0,NULL,'0',0,NULL),('9kbq49uial2qm96',1,1,'저장소 생성','2023-01-07 05:00:47',0,NULL,'0',0,NULL),('a4a4nnaokx57d6e',1,62,'저장소 생성','2022-12-29 05:49:29',0,NULL,'0',0,NULL),('cl98wag8go21k33',1,128,'\'GGitHub\'로부터 병합','2023-02-03 06:23:37',0,'cl98wag8go21k33','0',0,'r50tv09z5i9405v'),('hd4jx4jgc5q39tk',1,70,'저장소 생성','2022-12-29 05:50:31',0,NULL,'0',0,NULL),('hl1621y3s98mrao',7,113,'저장소 생성','2023-01-15 09:21:47',0,NULL,'0',0,NULL),('hmi5d10p1i93d37',2,106,'저장소 생성','2023-01-15 08:59:44',0,NULL,'0',0,NULL),('ixstrt8177k87r7',1,64,'저장소 생성','2022-12-29 05:49:43',0,NULL,'0',0,NULL),('jz8h9t9z5x7qut8',1,69,'저장소 생성','2022-12-29 05:50:22',0,NULL,'0',0,NULL),('k8q4731ddr8ie4p',1,65,'저장소 생성','2022-12-29 05:49:49',0,NULL,'0',0,NULL),('kb8695377s1xe3q',1,63,'저장소 생성','2022-12-29 05:49:36',0,NULL,'0',0,NULL),('o96be6ev2qswc41',8,118,'저장소 생성','2023-01-15 09:26:37',0,NULL,'0',0,NULL),('oie138mb536jcs6',10,121,'저장소 생성','2023-01-15 09:31:51',0,NULL,'0',0,NULL),('oy2e359t81ag281',3,1,'메인 저장소에서 가져옴','2023-01-10 05:00:07',3,'9kbq49uial2qm96','1',1,NULL),('r0q669lm0d605cg',2,71,'저장소 생성','2022-12-29 06:59:49',0,NULL,'0',0,NULL),('r16i256z67pfzj0',1,103,'ggg','2023-01-14 08:43:37',1,'8o65us57o167w98','1',0,'8o65us57o167w98'),('r50tv09z5i9405v',1,128,'저장소 생성','2023-02-03 06:08:31',0,NULL,'0',0,NULL),('srqho957gy82du7',4,114,'저장소 생성','2023-01-15 09:22:16',0,NULL,'0',0,NULL),('u02ia2kntd8z2q0',1,68,'저장소 생성','2022-12-29 05:50:14',0,NULL,'0',0,NULL),('u1l5c982f3ot6k8',1,67,'저장소 생성','2022-12-29 05:50:04',0,NULL,'0',0,NULL),('u60iejm7t4iarg9',8,117,'저장소 생성','2023-01-15 09:24:19',0,NULL,'0',0,NULL),('v0a47l3ef56vl7b',2,2,'저장소 생성','2023-01-07 05:09:25',0,NULL,'0',0,NULL),('v6ya52h7tz2gp53',3,103,'qwe','2023-01-12 03:09:55',3,'0vt1fbbk5nahmb3','1',0,'8o65us579167w98'),('vup893emni8hp97',1,2,'새폴더 추가,파일수정','2023-01-07 07:25:58',1,'v0a47l3ef56vl7b','1',0,NULL),('wvnjdd822h8bh34',1,105,'저장소 생성','2023-01-14 05:58:42',0,NULL,'0',0,NULL),('y06i0q41eh9rz86',1,61,'저장소 생성','2022-12-29 05:49:16',0,NULL,'0',0,NULL),('yxj8n211g7o9s5g',9,119,'저장소 생성','2023-01-15 09:29:05',0,NULL,'0',0,NULL);
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

-- Dump completed on 2023-02-05  0:41:03
