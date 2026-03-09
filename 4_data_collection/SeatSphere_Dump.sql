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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total_amount` double NOT NULL,
  `showtime_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc7q4u7vleq90vlvy8c7lmwtyl` (`showtime_id`),
  KEY `FKeyog2oic85xg7hsu2je2lx3s6` (`user_id`),
  CONSTRAINT `FKc7q4u7vleq90vlvy8c7lmwtyl` FOREIGN KEY (`showtime_id`) REFERENCES `showtimes` (`id`),
  CONSTRAINT `FKeyog2oic85xg7hsu2je2lx3s6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_occupied` bit(1) NOT NULL,
  `seat_number` int NOT NULL,
  `seat_row` varchar(255) DEFAULT NULL,
  `hall_id` bigint DEFAULT NULL,
  `is_handicap` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK1afc0885p1c87ytyro30elp0r` (`hall_id`),
  CONSTRAINT `FK1afc0885p1c87ytyro30elp0r` FOREIGN KEY (`hall_id`) REFERENCES `theater_halls` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (1,_binary '\0',1,'A',2,0),(2,_binary '\0',2,'A',2,0),(3,_binary '\0',3,'A',2,0),(4,_binary '\0',4,'A',2,0),(5,_binary '\0',1,'B',2,0),(6,_binary '\0',2,'B',2,0),(7,_binary '\0',3,'B',2,0),(8,_binary '\0',4,'B',2,0),(9,_binary '\0',5,'B',2,0),(10,_binary '\0',1,'C',2,0),(11,_binary '\0',2,'C',2,0),(12,_binary '\0',3,'C',2,0),(13,_binary '\0',4,'C',2,0),(14,_binary '\0',5,'C',2,0),(15,_binary '\0',1,'D',2,0),(16,_binary '\0',2,'D',2,0),(17,_binary '\0',3,'D',2,0),(18,_binary '\0',4,'D',2,0),(19,_binary '\0',5,'D',2,0),(20,_binary '\0',1,'E',2,0),(21,_binary '\0',2,'E',2,0),(22,_binary '\0',3,'E',2,0),(23,_binary '\0',4,'E',2,0),(24,_binary '\0',5,'E',2,0),(25,_binary '\0',6,'E',2,0);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtimes`
--

DROP TABLE IF EXISTS `showtimes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtimes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `start_time` datetime(6) DEFAULT NULL,
  `movie_id` bigint DEFAULT NULL,
  `hall_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hall_id` (`hall_id`,`start_time`),
  KEY `FKeltpyuei1d5g3n6ikpsjwwil6` (`movie_id`),
  CONSTRAINT `fk_showtimes_hall` FOREIGN KEY (`hall_id`) REFERENCES `theater_halls` (`id`),
  CONSTRAINT `FKeltpyuei1d5g3n6ikpsjwwil6` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FKs2y0upn1sunf6o6qy50olxm83` FOREIGN KEY (`hall_id`) REFERENCES `theater_halls` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtimes`
--

LOCK TABLES `showtimes` WRITE;
/*!40000 ALTER TABLE `showtimes` DISABLE KEYS */;
INSERT INTO `showtimes` VALUES (1,'2026-03-13 17:00:00.000000',1,1),(2,'2026-03-13 20:30:00.000000',1,1),(3,'2026-03-13 23:30:00.000000',1,1),(4,'2026-03-13 18:00:00.000000',2,2),(5,'2026-03-13 21:00:00.000000',8,2),(6,'2026-03-13 16:30:00.000000',3,3),(7,'2026-03-13 19:30:00.000000',9,3),(8,'2026-03-13 22:30:00.000000',3,3),(9,'2026-03-13 17:30:00.000000',4,4),(10,'2026-03-13 20:45:00.000000',10,4),(11,'2026-03-13 18:15:00.000000',5,5),(12,'2026-03-13 21:15:00.000000',11,5),(14,'2026-03-13 22:00:00.000000',13,6),(16,'2026-03-14 14:00:00.000000',1,1),(17,'2026-03-14 17:30:00.000000',1,1),(19,'2026-03-14 12:00:00.000000',8,2),(20,'2026-03-14 15:30:00.000000',2,2),(21,'2026-03-14 19:00:00.000000',8,2),(22,'2026-03-14 22:30:00.000000',2,2),(23,'2026-03-14 10:30:00.000000',9,3),(24,'2026-03-14 13:30:00.000000',3,3),(25,'2026-03-14 16:45:00.000000',9,3),(26,'2026-03-14 20:00:00.000000',3,3),(27,'2026-03-14 11:30:00.000000',10,4),(28,'2026-03-14 14:45:00.000000',4,4),(29,'2026-03-14 18:15:00.000000',10,4),(30,'2026-03-14 21:45:00.000000',4,4),(31,'2026-03-14 12:30:00.000000',11,5),(32,'2026-03-14 15:45:00.000000',5,5),(33,'2026-03-14 19:15:00.000000',11,5),(34,'2026-03-14 22:30:00.000000',5,5),(35,'2026-03-14 13:00:00.000000',12,6),(37,'2026-03-14 19:45:00.000000',13,6),(38,'2026-03-14 23:00:00.000000',12,6),(39,'2026-03-15 10:00:00.000000',1,1),(41,'2026-03-15 17:00:00.000000',1,1),(42,'2026-03-15 11:30:00.000000',2,2),(43,'2026-03-15 15:00:00.000000',8,2),(44,'2026-03-15 18:30:00.000000',2,2),(45,'2026-03-15 10:30:00.000000',3,3),(46,'2026-03-15 14:00:00.000000',9,3),(47,'2026-03-15 17:30:00.000000',3,3),(48,'2026-03-15 11:00:00.000000',4,4),(49,'2026-03-15 14:30:00.000000',10,4),(50,'2026-03-15 18:00:00.000000',4,4),(51,'2026-03-15 12:00:00.000000',5,5),(52,'2026-03-15 15:30:00.000000',11,5),(53,'2026-03-15 19:00:00.000000',5,5),(55,'2026-03-15 16:00:00.000000',12,6),(57,'2026-03-13 19:30:00.000000',6,6),(58,'2026-03-14 15:45:00.000000',6,1),(59,'2026-03-14 18:00:00.000000',6,6),(60,'2026-03-15 11:45:00.000000',6,1),(61,'2026-03-15 14:00:00.000000',6,6),(62,'2026-03-15 18:30:00.000000',6,6);
/*!40000 ALTER TABLE `showtimes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater_halls`
--

DROP TABLE IF EXISTS `theater_halls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater_halls` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `total_seats` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater_halls`
--

LOCK TABLES `theater_halls` WRITE;
/*!40000 ALTER TABLE `theater_halls` DISABLE KEYS */;
INSERT INTO `theater_halls` VALUES (1,'Hall 1',20),(2,'Hall 2',25),(3,'Hall 3',20),(4,'Hall 4',25),(5,'Hall 5',20),(6,'Hall 6',25);
/*!40000 ALTER TABLE `theater_halls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qr_code_data` varchar(255) DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKefja4avuu7g29t78mxifrsynb` (`booking_id`),
  KEY `FK1f6n3pv4b80wl6gj4ra32ctxk` (`seat_id`),
  CONSTRAINT `FK1f6n3pv4b80wl6gj4ra32ctxk` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`),
  CONSTRAINT `FKefja4avuu7g29t78mxifrsynb` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'REDACTED_PASSWORD','ADMIN','admin_system','root@seatsphere.com','',''),(2,'REDACTED_PASSWORD','MANAGER','manager_Jane','manager@cinema.com','',''),(3,'REDACTED_PASSWORD','STAFF','staff_alex','staff@cinema.com','',''),(4,'REDACTED_PASSWORD','CUSTOMER','customer_joe','customer@gmail.com','','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-09 15:41:52
