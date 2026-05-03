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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `price` double NOT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Horror','Dracula',129,4,'R','/media/dracula.jpg'),(2,'Adventure','Zootopia 2',108,4,'PG','/media/zootopia2.jpg'),(3,'Musical','The Greatest Showman',105,4,'PG','/media/thegreatestshowman.jpg'),(4,'Sci-Fi','Cosmic Drift',124,12.5,'PG-13','/media/cosmicdrift.jpg'),(5,'Action','Star Wars: A New Hope',121,15,'PG','/media/starwars.jpg'),(6,'Musical/Action','K-Pop Demon Hunter',95,8,'PG','/media/kpopdemonhunters.jpg'),(7,'Fantasy','Game of Thrones',134,8,'R','/media/gameofthrones.jpg'),(8,'Sci-Fi','Avatar 3',180,15,'PG-13','/media/avatar3.jpg'),(9,'Action','The Batman',175,13,'PG-13','/media/thebatman.jpg'),(10,'Family','Toy Story 5',95,10,'G','/media/toystory5.jpg'),(11,'Sci-Fi','Inception',148,12,'PG-13','/media/inception.jpg'),(12,'Drama','Interstellar',169,12,'PG-13','/media/interstellar.jpg'),(13,'Epic','Gladiator II',150,14,'R','/media/gladiator2.jpg');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
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
