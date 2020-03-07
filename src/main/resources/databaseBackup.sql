-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: practiceHacker
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `instruments`
--

DROP TABLE IF EXISTS `instruments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instruments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `instrument` varchar(35) NOT NULL,
  `skill_level` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `instruments_id_uindex` (`id`),
  KEY `instruments_users_id_fk` (`user_id`),
  CONSTRAINT `instruments_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruments`
--

LOCK TABLES `instruments` WRITE;
/*!40000 ALTER TABLE `instruments` DISABLE KEYS */;
INSERT INTO `instruments` VALUES (1,1,'violin','professional'),(2,2,'viola','advanced'),(3,3,'viola','professional');
/*!40000 ALTER TABLE `instruments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practice_hacks`
--

DROP TABLE IF EXISTS `practice_hacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practice_hacks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `skill_level` varchar(45) NOT NULL,
  `instrument` varchar(35) DEFAULT NULL,
  `text_body` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `practice_hacks_id_uindex` (`id`),
  KEY `practice_hacks_users_id_fk` (`user_id`),
  CONSTRAINT `practice_hacks_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practice_hacks`
--

LOCK TABLES `practice_hacks` WRITE;
/*!40000 ALTER TABLE `practice_hacks` DISABLE KEYS */;
INSERT INTO `practice_hacks` VALUES (1,3,'Advanced','Viola','Only practice in 50-minute hours. Giving yourself breaks keeps your mind fresh!');
/*!40000 ALTER TABLE `practice_hacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practice_logs`
--

DROP TABLE IF EXISTS `practice_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practice_logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `practice_date` date NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `activities` varchar(150) NOT NULL,
  `notes` longtext NOT NULL,
  `teacher_comments` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `practice_logs_id_uindex` (`id`),
  KEY `practice_logs_users_id_fk` (`user_id`),
  CONSTRAINT `practice_logs_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practice_logs`
--

LOCK TABLES `practice_logs` WRITE;
/*!40000 ALTER TABLE `practice_logs` DISABLE KEYS */;
INSERT INTO `practice_logs` VALUES (1,1,'2020-03-04','2020-03-04 01:01:01','2020-03-04 20:20:20','Ein Heldenleben','I practiced some difficult runs slowly with a friend, and also drilled some shifts.',NULL),(2,1,'2020-03-05','2020-03-05 01:01:01','2020-03-05 20:20:20','Ein Heldenleben','I attempted to play the piece through with a recording. We have clearly got a long way to go, but the choreography is coming along nicely...',NULL),(3,2,'2020-03-05','2020-03-05 01:01:01','2020-03-05 20:20:20','Scales, Arpeggios, and Walton','I practiced two 50-minute hours today. The first was spent playing scales and arpeggio sets, while the second was entirely devoted to the Walton concerto. I did a run-through of the first movement in preparation for my upcoming concerto competition, and I feel that I am rushing through difficult passages. Tomorrow, I will do some metronome work and continuously remind myself that I have more time than I think I do!',NULL);
/*!40000 ALTER TABLE `practice_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio_students`
--

DROP TABLE IF EXISTS `studio_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studio_students` (
  `studio_id` int NOT NULL,
  `student_id` int NOT NULL,
  UNIQUE KEY `studio_students_pk` (`studio_id`,`student_id`),
  KEY `studio_students_users_id_fk` (`student_id`),
  CONSTRAINT `studio_students_studios_id_fk` FOREIGN KEY (`studio_id`) REFERENCES `studios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studio_students_users_id_fk` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio_students`
--

LOCK TABLES `studio_students` WRITE;
/*!40000 ALTER TABLE `studio_students` DISABLE KEYS */;
INSERT INTO `studio_students` VALUES (1,2);
/*!40000 ALTER TABLE `studio_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studios`
--

DROP TABLE IF EXISTS `studios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` int NOT NULL,
  `instrument` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `studios_id_uindex` (`id`),
  KEY `studios_users_id_fk` (`teacher_id`),
  CONSTRAINT `studios_users_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studios`
--

LOCK TABLES `studios` WRITE;
/*!40000 ALTER TABLE `studios` DISABLE KEYS */;
INSERT INTO `studios` VALUES (1,3,'Viola');
/*!40000 ALTER TABLE `studios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `role_name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_roles_id_uindex` (`id`),
  KEY `user_roles_users_id_fk` (`user_id`),
  CONSTRAINT `user_roles_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,'sheepAntler','practiceHacker'),(2,2,'madBratsche','student'),(3,3,'saveTheViola','teacher');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  `practice_counter` int DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `city` varchar(35) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'sheepAntler','password','Elspeth','Stalter','sheepantler@gmail.com',15,'1989-12-25','Madison','WI',53703),(2,'madBratsche','password','Jonathan','Dunlop','madbratsche@gmail.com',45,'2004-01-12','Madison','WI',53715),(3,'saveTheViola','password','Viola','Happenstance','violaViolist@gmail.com',102,'1990-01-12','Madison','WI',53711);
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

-- Dump completed on 2020-03-07 17:24:13
