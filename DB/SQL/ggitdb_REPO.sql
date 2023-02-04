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
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repo`
--

LOCK TABLES `repo` WRITE;
/*!40000 ALTER TABLE `repo` DISABLE KEYS */;
INSERT INTO `repo` VALUES (1,'JavaProject','2023-01-07 05:00:47',1,1,0,'6yg4hw3bf029kuh8qzl732d87f9ai25d3t0','javaproject\n',2),(2,'AMProject','2023-01-07 05:09:25',1,2,0,'o35hi43d8hft5uzq790xt3xxtqk8t76y69a','학원관리프로젝트',3),(3,'GGitProject','2023-01-07 05:10:31',1,3,0,'6ahda8yts1pipc827p3m1p1i2zxvlx4l8g2','깃허브 협업 관리 프로그램',0),(4,'Gameproject','2022-12-19 02:09:33',1,1,0,'ov4ysrjf4s80noknm3jv262z2lmxbw4dob0','모두의마블구현중',0),(60,'README','2022-12-25 14:04:01',1,1,0,'833ty55hj67y39tebeu9ndsy9ujw49kxdm7','README',0),(61,'VueStudy','2022-12-29 05:49:16',1,1,0,'9070x8c4ovzd01u0qzo1855lo5s12wt2v61','오늘부터모두vue공부!!',0),(62,'GoogleAPI','2022-12-29 05:49:29',1,1,0,'61689gm03813gjn32tf2ctf6te127861380','GoogleAPI사용예제',0),(63,'Study','2022-12-29 05:49:36',1,1,0,'aa79zrq04tp8xv0n18x466f526y194kq2r3','코드공부',0),(64,'TestProject','2022-12-29 05:49:43',1,1,0,'1f60e9t4h0221j6bl9u444p276w5in4ui8l','프로젝트구상중',0),(65,'GGITStudy','2022-12-29 05:49:49',1,1,0,'2e051ji51tto61nb8hpns49v0e608kr9c57','낏허브공부내용',0),(66,'Clone','2022-12-29 05:49:57',1,1,0,'23456a73m84spoqx8e7y9i03pxby1aefz04','모든 걸 복사해주는 사이트',0),(67,'HTMLStudy','2022-12-29 05:50:04',1,1,0,'17v8n228qf7t1o64h0l2jt60ku9s19wf3ow','HTML',0),(68,'SpringProject','2022-12-29 05:50:14',1,1,0,'1j5h68mo334th68j4am5j7j8768caz0jx70','과외 매칭 사이트',0),(69,'MarkDown','2022-12-29 05:50:22',1,1,0,'0r78x2w28t593hj0g77n285ewql465k8016','마크다운언어',0),(70,'JavaScript','2022-12-29 05:50:31',1,1,0,'b1f90i6m1f90g1h8t5c4vp2nbhk6wc0c0p8','Vue 자바스크립트',0),(71,'React','2022-12-29 06:59:49',1,2,0,'l37478ha4s19rs1we31d0dq7jv2i49g26ql','React',0),(72,'NodeProject','2023-01-07 04:25:14',1,1,0,'xb03b25r7t4rhjut61jg35p1vqaz5h425g3','노드로 채팅구현',0),(103,'ChatModel','2023-01-12 02:39:48',1,3,0,'35412vggjxvh69k8a80636rwnfe5in2cbo3','채팅',1),(104,'InfiniteStairs','2023-01-14 05:57:26',1,1,0,'zf12857k5914y3z6e5qcl0173d23jc6821w','무한의계단 게임',0),(105,'GGITDATA','2023-01-14 05:58:42',1,1,0,'od20nb6m86yf4a6p29aom4k0d696h34oe93','GGITDATA',0),(106,'LProject','2023-01-15 08:59:43',1,2,0,'fj2e6b4k51xt42dojn24ihs17g9wiurfo7s','LProject',0),(107,'Team4','2023-01-15 09:00:32',1,2,0,'n616pb1833z1we40c7ep22kv55so2w234p3','Death Team 4',0),(108,'VueProject','2023-01-15 09:01:32',1,3,0,'vw064l46o881477m82d89a8w59dyazme3u7','Vue.js 연습 저장소입니다^^',0),(109,'javascript_project','2023-01-15 09:02:34',1,3,0,'l498wd3f26vb447694965wq1vt9943kgit4','자바스크립트 넌 나에게 모욕감을 줬어',0),(110,'맹고플레이트','2023-01-15 09:02:59',1,3,0,'9itn475ms6we94fk9e9gbp57dgu5y4f270o','망고맛집?',0),(111,'밥알이몇개고','2023-01-15 09:03:22',1,3,0,'1cn07o92oz1xw8u7i735xd9m8f2pbss71ry','ㅎ',0),(112,'おはよう','2023-01-15 09:21:13',1,7,0,'as6143vj6t2a4w88l4s3kevyo4x4d2bqwt1','こんばんは',0),(113,'HelloWorld','2023-01-15 09:21:46',1,7,0,'dyc054mo19d052lgaa5ig4hsepq4pbi9ky7','My First repository',0),(114,'java','2023-01-15 09:22:16',1,4,0,'b9khc6iu6j4khlkyxx297p37o76f9922ofj','자바는 처음이라..',0),(115,'Pray','2023-01-15 09:22:17',1,7,0,'56g673503hc1063780hn8njxqq0rzix6n54','A-men!',0),(116,'SQL','2023-01-15 09:23:59',1,5,0,'6135y4o21p0n0u5bw2s4xh2e3f04mzbnck5','sql쿼리',0),(117,'side-77','2023-01-15 09:24:19',1,8,0,'1t1352j7an5x996cm2nsi5uwl05chfh5n2e','77번 국도',0),(118,'NASA','2023-01-15 09:26:37',1,8,0,'n5d82g060u5qqk6673adi5sxz599b2b1ewc','USA nasa',0),(119,'Football','2023-01-15 09:29:04',1,9,0,'o4u3k75g73c6k48d1157g319afy0kjipf85','Football club repo',0),(120,'PremierLeague','2023-01-15 09:29:58',1,9,0,'69my53lhj449tcct8s1tik46r47z407nm83','my team Tottenham Hotspur Football Club',0),(121,'soccer','2023-01-15 09:31:51',1,10,0,'9wh07008w795811908u29bmqg2yu06i8202','축구선수는 역시 메시지',0),(122,'메메메이플스토뤼','2023-01-15 09:34:02',1,12,0,'gqhny4tj973zljw935096o20ofpn59lx533','메메메ㅔ',0),(123,'벌써12시','2023-01-15 09:35:35',1,11,0,'i06fyr4j53678f5urlr6953apz24x8ax49a','12시',0),(127,'abc','2023-02-03 06:05:05',1,1,0,'3x33ek4v771366a99x584se6hh9lq1mje17','abc',0),(128,'asdf','2023-02-03 06:08:31',1,1,0,'s3q2650l0w5o261es17ld98pt79ey216otd','asdf',0);
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

-- Dump completed on 2023-02-05  0:41:03
