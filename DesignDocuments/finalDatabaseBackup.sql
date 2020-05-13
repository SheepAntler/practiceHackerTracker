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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruments`
--

LOCK TABLES `instruments` WRITE;
/*!40000 ALTER TABLE `instruments` DISABLE KEYS */;
INSERT INTO `instruments` VALUES (1,1,'Violin','professional'),(2,2,'Viola','Advanced'),(3,3,'Viola','Professional'),(4,4,'Viola','Advanced'),(5,5,'Viola','Pre-Professional'),(6,6,'Viola','Beginner'),(8,7,'Bagpipes','Intermediate'),(12,11,'Piano','Advanced'),(13,12,'Piano','Professional');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practice_hacks`
--

LOCK TABLES `practice_hacks` WRITE;
/*!40000 ALTER TABLE `practice_hacks` DISABLE KEYS */;
INSERT INTO `practice_hacks` VALUES (1,3,'Advanced','viola','Only practice in 50-minute hours. Giving yourself breaks keeps your mind fresh!'),(3,3,'Pre-Professional','viola','To prep for your college auditions, practice performing your audition materials in unfamiliar rooms as frequently as possible. Preparing yourself psychologically is just as important as woodshedding difficult passages.'),(4,3,'beginner','viola','<p>Have you gotten your metronome out lately? Use this quarantine as a chance to finally get that fast passage up to speed, one click at a time!</p>'),(7,3,'Advanced','viola','<p>How many minutes do you practice a day? Now that we\'re in the QuaranTimes, you can <i>probably</i> swing 10-15 more, right? Give that a try tomorrow!</p>'),(9,12,'Intermediate','Piano','<p>Practice performing for folks you know regularly! Especially now that we\'re quarantined and living a recital-free lifestyle, it\'s important for us to keep our performance practice going for our nerves\' sake.&nbsp;</p>'),(10,12,'Advanced','Piano','<p>Try playing an entire circle-of-fifth\'s worth of scales each and every day this week, and watch your dexterity improve! Yeah, it might take a long time, but it\'s character-building.</p>');
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
  `practice_date` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `activities` varchar(150) NOT NULL,
  `notes` longtext NOT NULL,
  `teacher_comments` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `practice_logs_id_uindex` (`id`),
  KEY `practice_logs_users_id_fk` (`user_id`),
  CONSTRAINT `practice_logs_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practice_logs`
--

LOCK TABLES `practice_logs` WRITE;
/*!40000 ALTER TABLE `practice_logs` DISABLE KEYS */;
INSERT INTO `practice_logs` VALUES (1,1,'2020-03-04 00:00:00','2020-03-04 01:01:01','2020-03-04 20:20:20','Ein Heldenleben','<p>I practiced some difficult runs slowly with a friend, and also drilled some shifts.</p>',NULL),(2,1,'2020-03-05 00:00:00','2020-03-05 01:01:01','2020-03-05 20:20:20','Ein Heldenleben','<p>I attempted to play the piece through with a recording. We have clearly got a long way to go, but the choreography is coming along nicely...</p>',NULL),(18,2,'2020-05-02 00:00:00','2020-05-06 12:30:00','2020-05-06 13:30:00','scales','<p>and other things</p>',NULL),(19,2,'2020-05-03 00:00:00','2020-05-06 11:20:00','2020-05-06 11:30:00','test','<p>test</p>',NULL),(23,2,'2020-05-04 00:00:00','2020-05-06 19:00:00','2020-05-06 19:35:00','Nothing','<p>I am just curious about time formats.</p>',NULL),(24,2,'2020-05-05 00:00:00','2020-05-06 19:45:00','2020-05-06 19:50:00','Will this....','<p>�..change my dates to 5/4?</p>',NULL),(25,2,'2020-05-06 20:10:34','2020-05-06 16:30:00','2020-05-06 18:30:00','Paganini Caprices','<p>Violinists complain so much about these; they should try playing them on the viola!</p>',NULL),(26,1,'2020-05-06 11:36:38','2020-05-07 07:00:00','2020-05-07 09:00:00','Etudes, Scales, Mozart','<p>I did a bunch of review today.&nbsp;</p>',NULL),(27,1,'2020-05-07 11:55:52','2020-05-07 09:00:00','2020-05-07 10:00:00','Bach Chaconne','<p>I am planning on playing this for the windowsill symphony performance tonight at 5:30, so I thought I would brush up on it a little bit since I am SUPER RUSTY.&nbsp;</p>',NULL),(28,1,'2020-05-08 23:00:12','2020-05-09 12:00:00','2020-05-09 13:00:00','Autoharp','<p>Alright, so I didn\'t practice the violin�but at least I played an instrument! It\'s so much more comforting to play something that is so low-stakes. It\'s easier for me to feel free to do creative stuff when I\'m not playing the violin, too, which is always interesting.&nbsp;</p>',NULL),(29,3,'2020-05-10 16:38:41','2020-05-10 11:30:00','2020-05-10 14:00:00','Unaccompanied Bach','<p>I read through Bach suites for fun.</p>',NULL),(30,1,'2020-05-10 22:39:06','2020-05-10 14:45:00','2020-05-10 15:45:00','Tin Whistle','<p>Honestly, it\'s like I\'m allergic to the violin these days.</p>',NULL),(31,1,'2020-05-11 22:38:03','2020-05-11 15:50:00','2020-05-11 16:30:00','Mazas Etudes','<p>I revisited some old Etudes from my younger days this evening, just to get a little bit of playing in before the week was out.&nbsp;</p>',NULL),(32,11,'2020-05-08 16:10:26','2020-05-08 11:00:00','2020-05-08 11:45:00','Scales','<p>I played scales for 45 minutes. It was exactly as fun as it sounds.</p>',NULL),(33,11,'2020-05-09 16:11:26','2020-05-09 12:00:00','2020-05-09 12:45:00','Chopin','<p>I practiced the beginning of the second movement. I still need to work on the end a little bit�it\'s not memorized yet.</p>',NULL),(34,11,'2020-05-10 16:20:44','2020-05-10 15:00:00','2020-05-10 15:30:00','Scales','<p>This is really just a test.</p>',NULL),(35,11,'2020-05-11 16:24:15','2020-05-11 12:00:00','2020-05-11 12:30:00','test','<p>test</p>',NULL),(37,11,'2020-05-12 16:34:07','2020-05-12 22:11:00','2020-05-12 22:12:00','I looked at my keyboard.','<p>No, seriously. That was it. I may have played a C?</p>',NULL),(38,11,'2020-05-12 16:34:30','2020-05-12 11:12:00','2020-05-12 11:20:00','Test','<p>Test</p>',NULL);
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
INSERT INTO `studio_students` VALUES (1,2),(1,4),(1,5),(1,6),(18,11);
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
  `organization_name` varchar(100) DEFAULT NULL,
  `street_address` varchar(100) DEFAULT NULL,
  `city` varchar(35) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `studios_id_uindex` (`id`),
  KEY `studios_users_id_fk` (`teacher_id`),
  CONSTRAINT `studios_users_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studios`
--

LOCK TABLES `studios` WRITE;
/*!40000 ALTER TABLE `studios` DISABLE KEYS */;
INSERT INTO `studios` VALUES (1,3,'Viola','The Viola Foundation','123 ABC Street','Madison','WI',53715),(4,3,'Violin','The Suzuki House','456 W. McMoreland Ave.','Waunakee','WI',34567),(11,3,'Trombone','Test Organization','123 ABC Street','Madison','WI',53715),(14,3,'Accordion','The Suzuki House','456 W. McMoreland Ave.','Waunakee','WI',52246),(16,12,'Piano','Test Organization','123 ABC Street','Madison','WI',53703),(17,12,'Piano','Test Organization','123 ABC Street','Waukesha','WI',46752),(18,12,'Piano','Test Organization','123 ABC Street','Nome','AK',12345),(19,12,'Harpsichord','Test Organization','123 ABC Street','Madison','WI',53715);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1,'sheepAntler','practiceHacker'),(2,2,'madBratsche','student'),(3,3,'saveTheViola','teacher'),(4,4,'anaBanana','student'),(5,5,'philFrond','student'),(6,6,'monsterTrucks4Ever','student'),(7,7,'sillyBilly','practiceHacker'),(11,11,'Zachammer','student'),(12,12,'pianoPedagogue','teacher');
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
  `practice_counter` int DEFAULT '0',
  `birth_date` date DEFAULT NULL,
  `city` varchar(35) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `zip` int DEFAULT NULL,
  `longest_streak` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'sheepAntler','password','Elspeth','Stalter','sheepantler@gmail.com',4,'1989-12-25','Madison','WI',53703,100),(2,'madBratsche','password','Jonathan','Dunlop','madbratsche@gmail.com',6,'2004-01-12','Madison','WI',53715,65),(3,'saveTheViola','password','Viola','Happenstance','violaViolist@gmail.com',1,'1990-01-12','Madison','WI',53711,1),(4,'anaBanana','password','Ana','Holmquist','anaBanana@yahoo.com',24,'2002-04-27','Madison','WI',53705,26),(5,'philFrond','password','Phillip','Frond','phil.frond@gmail.com',98,'2002-02-20','Madison','WI',53711,120),(6,'monsterTrucks4Ever','password','Millie','Marlowe','milliesmom@hotmail.com',0,'2011-10-07','Madison','WI',53703,0),(7,'sillyBilly','password','Silly','Billy','sillyBilly@gmail.com',0,NULL,'Madison','WI',53715,0),(11,'Zachammer','password','Zach','Hammer','zachammer@gmail.com',5,'1989-12-19','Nome','AK',12345,5),(12,'pianoPedagogue','password','Piano','Pianola','fortePiano@gmail.com',0,NULL,'Madison','WI',53703,0);
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

-- Dump completed on 2020-05-12 19:03:33
