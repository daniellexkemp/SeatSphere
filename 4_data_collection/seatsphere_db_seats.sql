-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: seatsphere_db
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `seat_number` int NOT NULL,
  `seat_row` varchar(255) DEFAULT NULL,
  `hall_id` bigint DEFAULT NULL,
  `is_handicap` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK1afc0885p1c87ytyro30elp0r` (`hall_id`),
  CONSTRAINT `FK1afc0885p1c87ytyro30elp0r` FOREIGN KEY (`hall_id`) REFERENCES `theater_halls` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (1,1,'A',1,1),(2,2,'A',1,0),(3,3,'A',1,0),(4,4,'A',1,0),(5,5,'A',1,1),(6,1,'B',1,0),(7,2,'B',1,0),(8,3,'B',1,0),(9,4,'B',1,0),(10,5,'B',1,0),(11,6,'B',1,0),(12,1,'C',1,0),(13,2,'C',1,0),(14,3,'C',1,0),(15,4,'C',1,0),(16,5,'C',1,0),(17,6,'C',1,0),(18,1,'D',1,0),(19,2,'D',1,0),(20,3,'D',1,0),(21,4,'D',1,0),(22,5,'D',1,0),(23,6,'D',1,0),(24,7,'D',1,0),(25,1,'A',3,1),(26,2,'A',3,0),(27,3,'A',3,0),(28,4,'A',3,0),(29,5,'A',3,1),(30,1,'B',3,0),(31,2,'B',3,0),(32,3,'B',3,0),(33,4,'B',3,0),(34,5,'B',3,0),(35,6,'B',3,0),(36,1,'C',3,0),(37,2,'C',3,0),(38,3,'C',3,0),(39,4,'C',3,0),(40,5,'C',3,0),(41,6,'C',3,0),(42,1,'D',3,0),(43,2,'D',3,0),(44,3,'D',3,0),(45,4,'D',3,0),(46,5,'D',3,0),(47,6,'D',3,0),(48,7,'D',3,0),(56,1,'A',5,1),(57,2,'A',5,0),(58,3,'A',5,0),(59,4,'A',5,0),(60,5,'A',5,1),(61,1,'B',5,0),(62,2,'B',5,0),(63,3,'B',5,0),(64,4,'B',5,0),(65,5,'B',5,0),(66,6,'B',5,0),(67,1,'C',5,0),(68,2,'C',5,0),(69,3,'C',5,0),(70,4,'C',5,0),(71,5,'C',5,0),(72,6,'C',5,0),(73,1,'D',5,0),(74,2,'D',5,0),(75,3,'D',5,0),(76,4,'D',5,0),(77,5,'D',5,0),(78,6,'D',5,0),(79,7,'D',5,0),(87,1,'A',2,1),(88,2,'A',2,0),(89,3,'A',2,0),(90,4,'A',2,0),(91,5,'A',2,1),(92,1,'B',2,0),(93,2,'B',2,0),(94,3,'B',2,0),(95,4,'B',2,0),(96,5,'B',2,0),(97,6,'B',2,0),(98,1,'C',2,0),(99,2,'C',2,0),(100,3,'C',2,0),(101,4,'C',2,0),(102,5,'C',2,0),(103,6,'C',2,0),(104,1,'D',2,0),(105,2,'D',2,0),(106,3,'D',2,0),(107,4,'D',2,0),(108,5,'D',2,0),(109,6,'D',2,0),(110,7,'D',2,0),(111,1,'E',2,0),(112,2,'E',2,0),(113,3,'E',2,0),(114,4,'E',2,0),(115,5,'E',2,0),(116,6,'E',2,0),(117,7,'E',2,0),(118,8,'E',2,0),(119,1,'A',4,1),(120,2,'A',4,0),(121,3,'A',4,0),(122,4,'A',4,0),(123,5,'A',4,1),(124,1,'B',4,0),(125,2,'B',4,0),(126,3,'B',4,0),(127,4,'B',4,0),(128,5,'B',4,0),(129,6,'B',4,0),(130,1,'C',4,0),(131,2,'C',4,0),(132,3,'C',4,0),(133,4,'C',4,0),(134,5,'C',4,0),(135,6,'C',4,0),(136,1,'D',4,0),(137,2,'D',4,0),(138,3,'D',4,0),(139,4,'D',4,0),(140,5,'D',4,0),(141,6,'D',4,0),(142,7,'D',4,0),(143,1,'E',4,0),(144,2,'E',4,0),(145,3,'E',4,0),(146,4,'E',4,0),(147,5,'E',4,0),(148,6,'E',4,0),(149,7,'E',4,0),(150,8,'E',4,0),(182,1,'A',6,1),(183,2,'A',6,0),(184,3,'A',6,0),(185,4,'A',6,0),(186,5,'A',6,1),(187,1,'B',6,0),(188,2,'B',6,0),(189,3,'B',6,0),(190,4,'B',6,0),(191,5,'B',6,0),(192,6,'B',6,0),(193,1,'C',6,0),(194,2,'C',6,0),(195,3,'C',6,0),(196,4,'C',6,0),(197,5,'C',6,0),(198,6,'C',6,0),(199,1,'D',6,0),(200,2,'D',6,0),(201,3,'D',6,0),(202,4,'D',6,0),(203,5,'D',6,0),(204,6,'D',6,0),(205,7,'D',6,0),(206,1,'E',6,0),(207,2,'E',6,0),(208,3,'E',6,0),(209,4,'E',6,0),(210,5,'E',6,0),(211,6,'E',6,0),(212,7,'E',6,0),(213,8,'E',6,0);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-02 16:01:11
