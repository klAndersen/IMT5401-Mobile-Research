-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: trackmyteacherdb
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblaccesspoints`
--

DROP TABLE IF EXISTS `tblaccesspoints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblaccesspoints` (
  `accessPointID` int(11) NOT NULL AUTO_INCREMENT,
  `BSSID` longtext NOT NULL,
  `MAC` longtext NOT NULL,
  `signalStrength` double NOT NULL,
  `fk_tblRoom` int(11) NOT NULL,
  `fk_tblRoomCorner` int(11) NOT NULL,
  `fk_tblWifiNetworks` int(11) NOT NULL,
  PRIMARY KEY (`accessPointID`),
  KEY `fk_tblAccessPoints_tblRoom1_idx` (`fk_tblRoom`),
  KEY `fk_tblAccessPoints_tblRoomCorner1_idx` (`fk_tblRoomCorner`),
  KEY `fk_tblAccessPoints_tblWifiNetworks1_idx` (`fk_tblWifiNetworks`),
  CONSTRAINT `fk_tblRoom` FOREIGN KEY (`fk_tblRoom`) REFERENCES `tblroom` (`roomID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tblRoomCorner` FOREIGN KEY (`fk_tblRoomCorner`) REFERENCES `tblroomcorner` (`roomCornerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tblWifiNetworks` FOREIGN KEY (`fk_tblWifiNetworks`) REFERENCES `tblwifinetworks` (`wifiID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblaccesspoints`
--

LOCK TABLES `tblaccesspoints` WRITE;
/*!40000 ALTER TABLE `tblaccesspoints` DISABLE KEYS */;
INSERT INTO `tblaccesspoints` VALUES (30,'0c:68:03:39:bc:bd','FC:C2:DE:EE:C8:EC',4,14,5,1),(31,'0c:68:03:39:bc:bd','FC:C2:DE:EE:C8:EC',3,14,3,1),(32,'0c:68:03:39:bc:bd','FC:C2:DE:EE:C8:EC',4,14,4,1),(33,'0c:68:03:39:bc:bd','FC:C2:DE:EE:C8:EC',3,14,1,1),(34,'0c:68:03:39:bc:bd','FC:C2:DE:EE:C8:EC',3,14,2,1),(35,'0c:68:03:39:bc:dd','FC:C2:DE:EE:C8:EC',4,18,2,1),(36,'0c:68:03:39:bc:dd','FC:C2:DE:EE:C8:EC',4,18,1,1),(37,'0c:68:03:84:bd:bd','FC:C2:DE:EE:C8:EC',4,18,3,1),(38,'0c:68:03:84:bd:bd','FC:C2:DE:EE:C8:EC',4,18,4,1),(39,'0c:68:03:84:bd:bd','FC:C2:DE:EE:C8:EC',3,18,5,1),(40,'0c:68:03:39:bf:cd','FC:C2:DE:EE:C8:EC',4,17,1,1),(41,'0c:68:03:39:bf:cd','FC:C2:DE:EE:C8:EC',4,17,2,1),(42,'0c:68:03:39:bf:cd','FC:C2:DE:EE:C8:EC',3,17,5,1),(43,'0c:68:03:39:c2:b2','FC:C2:DE:EE:C8:EC',4,17,3,1),(44,'0c:68:03:39:c2:b2','FC:C2:DE:EE:C8:EC',4,17,4,1),(45,'0c:68:03:39:bf:c2','FC:C2:DE:EE:C8:EC',3,15,1,1),(46,'0c:68:03:39:bf:c2','FC:C2:DE:EE:C8:EC',3,15,2,1),(47,'0c:68:03:39:bf:c2','FC:C2:DE:EE:C8:EC',3,15,5,1),(48,'0c:68:03:39:c2:ed','FC:C2:DE:EE:C8:EC',4,15,3,1),(49,'0c:68:03:39:c2:ed','FC:C2:DE:EE:C8:EC',4,15,4,1),(57,'c0:25:5c:c6:0b:a4','FC:C2:DE:EE:C8:EC',3,120,1,1),(58,'c0:25:5c:c6:0b:a4','FC:C2:DE:EE:C8:EC',3,120,2,1),(59,'c0:25:5c:c6:0b:a4','FC:C2:DE:EE:C8:EC',3,120,4,1),(60,'3c:0e:23:b5:4e:6b','FC:C2:DE:EE:C8:EC',3,120,3,1),(61,'3c:0e:23:b5:4e:6b','FC:C2:DE:EE:C8:EC',4,120,5,1),(62,'3c:0e:23:b5:4b:bb','FC:C2:DE:EE:C8:EC',3,1,2,1),(63,'3c:0e:23:b5:4b:bb','FC:C2:DE:EE:C8:EC',4,1,1,1),(64,'3c:0e:23:b5:4b:bb','FC:C2:DE:EE:C8:EC',3,1,3,1),(65,'3c:0e:23:b5:4b:bb','FC:C2:DE:EE:C8:EC',3,1,4,1),(66,'3c:0e:23:b5:4b:bb','FC:C2:DE:EE:C8:EC',4,1,5,1),(67,'c4:14:3c:4a:27:bb','FC:C2:DE:EE:C8:EC',4,2,2,1),(68,'c4:14:3c:4a:27:bb','FC:C2:DE:EE:C8:EC',4,2,4,1),(69,'c4:14:3c:4a:27:bb','FC:C2:DE:EE:C8:EC',4,2,3,1),(70,'c4:14:3c:4a:27:bb','FC:C2:DE:EE:C8:EC',4,2,1,1),(71,'c4:14:3c:4a:27:bb','FC:C2:DE:EE:C8:EC',4,2,5,1),(72,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',2,121,1,1),(73,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,121,3,1),(74,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,121,5,1),(75,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,121,4,1),(76,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',2,121,2,1),(77,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,122,1,1),(78,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,122,2,1),(79,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,122,4,1),(80,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,122,3,1),(81,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,122,5,1),(82,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,123,1,1),(83,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,123,3,1),(84,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,123,4,1),(85,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,123,2,1),(86,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,123,5,1),(87,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,124,1,1),(88,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',3,124,3,1),(89,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',3,124,4,1),(90,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',4,124,5,1),(91,'c0:25:5c:c6:0b:ab','FC:C2:DE:EE:C8:EC',3,124,2,1),(92,'c4:14:3c:4a:27:1b','FC:C2:DE:EE:C8:EC',3,125,1,1),(93,'c4:14:3c:4a:27:1b','FC:C2:DE:EE:C8:EC',3,125,3,1),(94,'c4:14:3c:4a:27:1b','FC:C2:DE:EE:C8:EC',3,125,4,1),(95,'c4:14:3c:4a:27:1b','FC:C2:DE:EE:C8:EC',3,125,2,1),(96,'c4:14:3c:4a:27:1b','FC:C2:DE:EE:C8:EC',3,125,5,1),(97,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,126,1,1),(98,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,126,3,1),(99,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,126,4,1),(100,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,126,5,1),(101,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,126,2,1),(102,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,127,1,1),(103,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,127,3,1),(104,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,127,4,1),(105,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,127,2,1),(106,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,127,5,1),(107,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,128,1,1),(108,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,128,3,1),(109,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,128,4,1),(110,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,128,2,1),(111,'3c:0e:23:b5:56:5b','FC:C2:DE:EE:C8:EC',4,128,5,1),(112,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',3,129,1,1),(113,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',4,129,2,1),(114,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',3,129,5,1),(115,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',3,129,3,1),(116,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',3,129,4,1),(117,'c4:14:3c:28:61:e4','FC:C2:DE:EE:C8:EC',3,9,1,1),(118,'c4:14:3c:28:61:e4','FC:C2:DE:EE:C8:EC',3,9,3,1),(119,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',4,9,5,1),(120,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',4,9,4,1),(121,'3c:0e:23:b5:44:7b','FC:C2:DE:EE:C8:EC',4,9,2,1),(122,'3c:0e:23:b5:4a:6b','FC:C2:DE:EE:C8:EC',4,5,2,1),(123,'3c:0e:23:b5:4a:6b','FC:C2:DE:EE:C8:EC',3,5,4,1),(124,'3c:0e:23:b5:4a:6b','FC:C2:DE:EE:C8:EC',3,5,5,1),(125,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,130,1,1),(126,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',4,130,3,1),(127,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',2,130,5,1),(128,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',3,130,4,1),(129,'3c:0e:23:b5:4a:5b','FC:C2:DE:EE:C8:EC',2,130,2,1),(130,'c0:25:5c:4e:37:0b','FC:C2:DE:EE:C8:EC',3,3,1,1),(131,'c0:25:5c:4e:37:0b','FC:C2:DE:EE:C8:EC',3,3,3,1),(132,'c0:25:5c:c6:13:2b','FC:C2:DE:EE:C8:EC',3,3,4,1),(133,'c0:25:5c:c6:13:2b','FC:C2:DE:EE:C8:EC',3,3,2,1),(134,'c0:25:5c:c6:13:2b','FC:C2:DE:EE:C8:EC',3,3,5,1);
/*!40000 ALTER TABLE `tblaccesspoints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbuilding`
--

DROP TABLE IF EXISTS `tblbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblbuilding` (
  `buildingID` int(11) NOT NULL AUTO_INCREMENT,
  `buildingName` varchar(45) NOT NULL,
  PRIMARY KEY (`buildingID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbuilding`
--

LOCK TABLES `tblbuilding` WRITE;
/*!40000 ALTER TABLE `tblbuilding` DISABLE KEYS */;
INSERT INTO `tblbuilding` VALUES (1,'A'),(2,'B'),(3,'C'),(4,'D'),(5,'E'),(6,'F'),(7,'G'),(8,'K'),(9,'L'),(10,'M'),(11,'N'),(12,'O'),(13,'R'),(14,'S'),(15,'T'),(16,'Kallerud (SB)');
/*!40000 ALTER TABLE `tblbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblfloor`
--

DROP TABLE IF EXISTS `tblfloor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblfloor` (
  `floorID` int(11) NOT NULL AUTO_INCREMENT,
  `floorName` varchar(45) NOT NULL,
  PRIMARY KEY (`floorID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblfloor`
--

LOCK TABLES `tblfloor` WRITE;
/*!40000 ALTER TABLE `tblfloor` DISABLE KEYS */;
INSERT INTO `tblfloor` VALUES (1,'0/Basement'),(2,'1'),(3,'2'),(4,'3'),(5,'4'),(6,'5');
/*!40000 ALTER TABLE `tblfloor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblroom`
--

DROP TABLE IF EXISTS `tblroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblroom` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `roomName` varchar(45) NOT NULL,
  `fk_tblFloor` int(11) NOT NULL,
  `fk_tblBuilding` int(11) NOT NULL,
  PRIMARY KEY (`roomID`),
  KEY `fk_tblRoom_tblFloor_idx` (`fk_tblFloor`),
  KEY `fk_tblRoom_tblBuilding1_idx` (`fk_tblBuilding`),
  CONSTRAINT `fk_tblBuilding` FOREIGN KEY (`fk_tblBuilding`) REFERENCES `tblbuilding` (`buildingID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tblFloor` FOREIGN KEY (`fk_tblFloor`) REFERENCES `tblfloor` (`floorID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblroom`
--

LOCK TABLES `tblroom` WRITE;
/*!40000 ALTER TABLE `tblroom` DISABLE KEYS */;
INSERT INTO `tblroom` VALUES (1,'A253/GameLab',3,1),(2,'A254',3,1),(3,'Cafeteria/Cantine',2,7),(4,'Library',3,7),(5,'A154',2,1),(6,'K109',2,8),(7,'IT-departement',1,8),(8,'H402',5,16),(9,'A153',2,1),(10,'A152',2,1),(11,'B110',2,2),(12,'B210',2,2),(13,'K113',2,8),(14,'Hallway 4th floor',5,16),(15,'Hallway 1th floor',2,16),(16,'Hallway Basement',1,16),(17,'Hallway 2th floor',3,16),(18,'Hallway 3th floor',4,16),(19,'A215',3,1),(120,'Cantine A-building',2,1),(121,'A255',3,1),(122,'A269',3,1),(123,'A268',3,1),(124,'A267',3,1),(125,'A266',3,1),(126,'A161',2,1),(127,'A159',2,1),(128,'A158',2,1),(129,'A052 (Toilet: Men)',1,1),(130,'A146',2,1),(131,'12',1,1),(132,'13',1,1),(133,'14',1,1),(134,'15',1,1),(135,'16',1,1),(136,'17',1,1),(137,'18',1,1),(138,'19',1,1),(139,'20',1,1),(140,'21',1,1),(141,'22',1,1),(142,'23',1,1),(143,'24',1,1),(144,'25',1,1),(145,'26',1,1),(146,'27',1,1),(147,'28',1,1),(148,'29',1,1),(149,'30',1,1),(150,'31',1,1),(151,'32',1,1),(152,'33',1,1),(153,'34',1,1),(154,'35',1,1),(155,'36',1,1),(156,'37',1,1),(157,'38',1,1),(158,'39',1,1),(159,'40',1,1),(160,'41',1,1),(161,'42',1,1),(162,'43',1,1),(163,'44',1,1),(164,'45',1,1),(165,'46',1,1),(166,'47',1,1),(167,'48',1,1),(168,'49',1,1),(169,'50',1,1),(170,'51',1,1),(171,'52',1,1),(172,'53',1,1),(173,'54',1,1),(174,'55',1,1),(175,'56',1,1),(176,'57',1,1),(177,'58',1,1),(178,'59',1,1),(179,'60',1,1),(180,'61',1,1),(181,'62',1,1),(182,'63',1,1),(183,'64',1,1),(184,'65',1,1),(185,'66',1,1),(186,'67',1,1),(187,'68',1,1),(188,'69',1,1),(189,'70',1,1),(190,'71',1,1),(191,'72',1,1),(192,'73',1,1),(193,'74',1,1),(194,'75',1,1),(195,'76',1,1),(196,'77',1,1),(197,'78',1,1),(198,'79',1,1),(199,'80',1,1),(200,'81',1,1),(201,'82',1,1),(202,'83',1,1),(203,'84',1,1),(204,'85',1,1),(205,'86',1,1),(206,'87',1,1),(207,'88',1,1),(208,'89',1,1),(209,'90',1,1),(210,'91',1,1),(211,'92',1,1),(212,'93',1,1),(213,'94',1,1),(214,'95',1,1),(215,'96',1,1),(216,'97',1,1),(217,'98',1,1),(218,'99',1,1),(219,'100',1,1);
/*!40000 ALTER TABLE `tblroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblroomcorner`
--

DROP TABLE IF EXISTS `tblroomcorner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblroomcorner` (
  `roomCornerID` int(11) NOT NULL AUTO_INCREMENT,
  `cornerName` varchar(45) NOT NULL,
  PRIMARY KEY (`roomCornerID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblroomcorner`
--

LOCK TABLES `tblroomcorner` WRITE;
/*!40000 ALTER TABLE `tblroomcorner` DISABLE KEYS */;
INSERT INTO `tblroomcorner` VALUES (1,'Left Corner (closest to entrance)'),(2,'Righ Corner (closest to entrance)'),(3,'Left Corner (opposite of entrance)'),(4,'Righ Corner (opposite of entrance)'),(5,'Center of the room (approx)');
/*!40000 ALTER TABLE `tblroomcorner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltrackinguser`
--

DROP TABLE IF EXISTS `tbltrackinguser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbltrackinguser` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` longtext NOT NULL,
  `lastName` longtext NOT NULL,
  `isTeacher` tinyint(1) NOT NULL,
  `gcmRegistrationID` longtext NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltrackinguser`
--

LOCK TABLES `tbltrackinguser` WRITE;
/*!40000 ALTER TABLE `tbltrackinguser` DISABLE KEYS */;
INSERT INTO `tbltrackinguser` VALUES (1,'sMcCallum','','Simon','McCallum',1,'1'),(2,'mNowostawski','','Mariusz','Nowostawski',1,''),(3,'klAndersen','','Knut Lucas','Andersen',0,'d6Yf5yo7Usk:APA91bFJB0brjFC19KX5KNgDCi5Iqh749PbOOZo5KwjzCZAfQUZiXoao1-Xts1SLfG6N6fJiw4zjhf8aOKsV0OMTwd4QVBH_p_e-eDynq2Ey71J25IVad0-OzflahtAOb7oZ8ckNiEtP');
/*!40000 ALTER TABLE `tbltrackinguser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblwebadmin`
--

DROP TABLE IF EXISTS `tblwebadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblwebadmin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) NOT NULL,
  `adminEmail` varchar(255) NOT NULL,
  `adminPwd` longtext NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblwebadmin`
--

LOCK TABLES `tblwebadmin` WRITE;
/*!40000 ALTER TABLE `tblwebadmin` DISABLE KEYS */;
INSERT INTO `tblwebadmin` VALUES (1,'Knut Lucas Andersen','knut.andersen@hig.no','$2y$10$T9zJqhKViiTZsnTM32Evzuq4TRgyt9SwmDdqMkhgBlNJoWZtT4GAW');
/*!40000 ALTER TABLE `tblwebadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblwifinetworks`
--

DROP TABLE IF EXISTS `tblwifinetworks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblwifinetworks` (
  `wifiID` int(11) NOT NULL AUTO_INCREMENT,
  `wifiName` varchar(100) NOT NULL,
  PRIMARY KEY (`wifiID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblwifinetworks`
--

LOCK TABLES `tblwifinetworks` WRITE;
/*!40000 ALTER TABLE `tblwifinetworks` DISABLE KEYS */;
INSERT INTO `tblwifinetworks` VALUES (1,'eduroam'),(2,'Hig-W');
/*!40000 ALTER TABLE `tblwifinetworks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'trackmyteacherdb'
--

--
-- Dumping routines for database 'trackmyteacherdb'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert100RoomsFunction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`s130533`@`%` PROCEDURE `insert100RoomsFunction`()
BEGIN

DECLARE i INT DEFAULT 1;

WHILE (i<=100) DO
             INSERT INTO tblroom VALUES(null, i, 1, 1);
               SET i=i+1;
END WHILE;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-10  4:45:41
