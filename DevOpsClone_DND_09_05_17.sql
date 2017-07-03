-- MySQL dump 10.13  Distrib 5.5.52, for Linux (x86_64)
--
-- Host: localhost    Database: DevOpsClone
-- ------------------------------------------------------
-- Server version	5.5.52

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
-- Table structure for table `account_master`
--

DROP TABLE IF EXISTS `account_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_master` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(100) NOT NULL,
  `isActive` tinyint(4) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_master`
--

LOCK TABLES `account_master` WRITE;
/*!40000 ALTER TABLE `account_master` DISABLE KEYS */;
INSERT INTO `account_master` VALUES (1,'Morgan Stanley',1),(2,'CVS Caremark',1),(3,'CACIB',1),(4,'Jeffries',1),(5,'Goldman sachs',1),(6,'Otsuka',1),(7,'Jefferies 1',1),(8,'Jefferies_1',1),(9,'1 Bank',1),(10,'Micro1one',1),(11,'Apache',1),(12,'Morgan Stanley',1);
/*!40000 ALTER TABLE `account_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_businessunit_mapping`
--

DROP TABLE IF EXISTS `application_businessunit_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_businessunit_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) DEFAULT NULL,
  `business_unit_id` int(11) DEFAULT NULL,
  `active_flag` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_businessunit_mapping`
--

LOCK TABLES `application_businessunit_mapping` WRITE;
/*!40000 ALTER TABLE `application_businessunit_mapping` DISABLE KEYS */;
INSERT INTO `application_businessunit_mapping` VALUES (26,26,16,1),(27,27,16,1),(28,28,17,1),(29,29,17,1),(30,30,18,1);
/*!40000 ALTER TABLE `application_businessunit_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_master`
--

DROP TABLE IF EXISTS `application_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_master` (
  `application_id` int(11) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(100) NOT NULL,
  PRIMARY KEY (`application_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_master`
--

LOCK TABLES `application_master` WRITE;
/*!40000 ALTER TABLE `application_master` DISABLE KEYS */;
INSERT INTO `application_master` VALUES (26,'App1_BU1_Caremark'),(27,'App2_BU1_Caremark'),(28,'App1_BU1_Morgan_Stanley'),(29,'App2_BU1_Morgan_Stanley'),(30,'APP3_BU1_Jeffries');
/*!40000 ALTER TABLE `application_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_application_mapping`
--

DROP TABLE IF EXISTS `assessment_application_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_application_mapping` (
  `assessment_id` int(11) NOT NULL,
  `application_id` int(11) NOT NULL,
  `active_flag` tinyint(4) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_application_mapping`
--

LOCK TABLES `assessment_application_mapping` WRITE;
/*!40000 ALTER TABLE `assessment_application_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessment_application_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_category_mapping`
--

DROP TABLE IF EXISTS `assessment_category_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_category_mapping` (
  `assessment_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `category_weightage` int(11) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_category_mapping`
--

LOCK TABLES `assessment_category_mapping` WRITE;
/*!40000 ALTER TABLE `assessment_category_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessment_category_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assessment_master`
--

DROP TABLE IF EXISTS `assessment_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment_master` (
  `assessment_id` int(11) NOT NULL AUTO_INCREMENT,
  `assessment_name` varchar(50) DEFAULT NULL,
  `assessment_weightage` int(11) NOT NULL,
  `active_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment_master`
--

LOCK TABLES `assessment_master` WRITE;
/*!40000 ALTER TABLE `assessment_master` DISABLE KEYS */;
INSERT INTO `assessment_master` VALUES (1,'Business Needs',35,1),(2,'Business and Environment Complexity',20,1),(3,'Delivery Maturity',40,1);
/*!40000 ALTER TABLE `assessment_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `business_unit_master`
--

DROP TABLE IF EXISTS `business_unit_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_unit_master` (
  `business_unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_unit_name` varchar(100) NOT NULL,
  PRIMARY KEY (`business_unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_unit_master`
--

LOCK TABLES `business_unit_master` WRITE;
/*!40000 ALTER TABLE `business_unit_master` DISABLE KEYS */;
INSERT INTO `business_unit_master` VALUES (16,'BU_1_Caremark'),(17,'BU_1_Morgan_Stanley'),(18,'BU_1_Jeffries');
/*!40000 ALTER TABLE `business_unit_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businessunit_account_mapping`
--

DROP TABLE IF EXISTS `businessunit_account_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businessunit_account_mapping` (
  `business_unit_id` int(11) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `isActive` tinyint(4) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businessunit_account_mapping`
--

LOCK TABLES `businessunit_account_mapping` WRITE;
/*!40000 ALTER TABLE `businessunit_account_mapping` DISABLE KEYS */;
INSERT INTO `businessunit_account_mapping` VALUES (16,2,1,16),(17,1,1,17),(18,4,1,18);
/*!40000 ALTER TABLE `businessunit_account_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_master`
--

DROP TABLE IF EXISTS `category_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_master` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `category_weightage` int(11) NOT NULL,
  `active_flag` tinyint(4) NOT NULL,
  `questionnaire_type_id` int(11) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_master`
--

LOCK TABLES `category_master` WRITE;
/*!40000 ALTER TABLE `category_master` DISABLE KEYS */;
INSERT INTO `category_master` VALUES (1,'Business Criticality',12,1,1),(2,'Time to Market',22,1,1),(3,'User Experience Impact',24,1,1),(4,'Regulatory Or Compliance Impact',1,1,1),(5,'Volatility',1,1,1),(6,'Business Complexity',0,0,1),(7,'Maintainability',0,1,1),(8,'Technical Complexity',0,1,1),(9,'Documentation',0,1,1),(10,'Environment',0,1,1),(11,'Scoping and Planning',0,1,1),(12,'Initiation',1,1,1),(13,'Design',1,1,1),(14,'Build',1,1,1),(15,'Test',1,1,1),(16,'Deploy',1,1,1),(17,'Monitor',1,1,1),(18,'Governance',1,1,1),(19,'Culture',1,1,1),(20,'Leadership',1,1,1),(21,'AHI Delivery',1,1,2),(22,'AHI Transparency',1,1,2),(23,'AHI Foundation',1,1,2),(24,'AHI Culture',1,1,2),(25,'AHI Leadership',1,1,2),(26,'AHI',1,1,1),(27,'Technical Dependence',1,1,1),(28,'Third Party Interaction',1,1,1),(36,'Volatility',0,1,1);
/*!40000 ALTER TABLE `category_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_subcategory_mapping`
--

DROP TABLE IF EXISTS `category_subcategory_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_subcategory_mapping` (
  `subcategory_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`subcategory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_subcategory_mapping`
--

LOCK TABLES `category_subcategory_mapping` WRITE;
/*!40000 ALTER TABLE `category_subcategory_mapping` DISABLE KEYS */;
INSERT INTO `category_subcategory_mapping` VALUES (1,12),(2,11),(3,11),(4,11),(5,13),(6,13),(7,13),(8,14),(9,14),(10,14),(11,14),(12,15),(13,15),(14,15),(15,15),(16,15),(17,16),(18,16),(19,17),(20,17),(21,17),(22,17),(23,17),(24,18),(25,18),(26,18),(27,18),(28,18),(29,18),(30,19),(31,19),(32,20),(33,11),(34,18),(35,13),(36,17),(37,26),(38,21),(39,21),(40,21),(41,21),(42,21),(43,22),(44,22),(45,22),(46,22),(47,22),(48,22),(49,23),(50,23),(51,23),(52,23),(53,23),(54,23),(55,23),(56,23),(57,24),(58,24),(59,24),(60,24),(61,25),(62,25),(63,25),(64,25);
/*!40000 ALTER TABLE `category_subcategory_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_form_data`
--

DROP TABLE IF EXISTS `feedback_form_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback_form_data` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `feedback` varchar(50) NOT NULL,
  `file_path` varchar(50) NOT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_form_data`
--

LOCK TABLES `feedback_form_data` WRITE;
/*!40000 ALTER TABLE `feedback_form_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_form_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_data_mapping`
--

DROP TABLE IF EXISTS `master_data_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `master_data_mapping` (
  `account_id` int(11) NOT NULL,
  `business_unit_id` int(11) NOT NULL,
  `business_needs` int(11) DEFAULT NULL,
  `business_env_complexity` int(11) DEFAULT NULL,
  `delivery_maturity` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`,`business_unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_data_mapping`
--

LOCK TABLES `master_data_mapping` WRITE;
/*!40000 ALTER TABLE `master_data_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `master_data_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_master`
--

DROP TABLE IF EXISTS `notification_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_master` (
  `notification_id` int(11) NOT NULL,
  `notification_name` varchar(50) NOT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_master`
--

LOCK TABLES `notification_master` WRITE;
/*!40000 ALTER TABLE `notification_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_indicative_values`
--

DROP TABLE IF EXISTS `question_indicative_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_indicative_values` (
  `questionId` int(11) NOT NULL,
  `option1Val` varchar(100) NOT NULL,
  `option2Val` varchar(100) NOT NULL,
  `option3Val` varchar(100) NOT NULL,
  `option4Val` varchar(100) NOT NULL,
  `option5Val` varchar(100) NOT NULL,
  PRIMARY KEY (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_indicative_values`
--

LOCK TABLES `question_indicative_values` WRITE;
/*!40000 ALTER TABLE `question_indicative_values` DISABLE KEYS */;
INSERT INTO `question_indicative_values` VALUES (1,'low - no or minimal operational impact','','medium - workarounds','','High-no ops w/o app'),(2,'Support Utility functions','Supports non-core functions','Support non- revenue generation core functions','Indirectly supports revenue generation','Directly supports revenue generation'),(3,'No competitive advantage','','Roadmap defined for gaining more CA','','Provides exclusive product/ service offering'),(4,' No impact','','Marginal Impact','','Highly impacted'),(5,'No','','','','Yes'),(6,'No','','','','Yes'),(7,'No','','','','Yes'),(8,'Satisfied','','Somewhat satisfied','','Not Satisfied'),(9,'Satisfied','','Somewhat satisfied','','Not Satisfied'),(10,'less than 4 users','(4 - 10 Users)','(11 - 100 Users)','(101 - 1000 Users)','greater than 1000 Users'),(11,'No direct interaction','','(Single Channel)','','(Multiple channels of interaction e.g. Web\nDesktop, IVR, Hand held devices)'),(12,'Localized Usage','External general public users/ Community users','Intranet / Corporate users ','External registered users','Public Site/ External Regulatory users'),(13,'Rarely','','Sometimes','','Very Often'),(14,'Not much change','','Some Changes','','Rapidly Changing'),(15,'Low','','Medium','','High'),(16,'Low','','Medium','','High'),(17,'less than 75% Available','','greater than 75% Available','','100% Available'),(18,'Not Available','','','','Available'),(19,'Not Available','','','','Available'),(20,'Not Available','','','','Available'),(21,'Not Available','','','','Available'),(22,'','','','',''),(23,'(Less than 10 GB)','',' (Between 10 - 100 GB)','',' ( Greater than 100 GB)'),(24,'(Less than 250000LOC)','','Between 500000 LOC and 250000LOC','','Greater than or equal to 500000 LOC'),(25,'(Less than 10)','(Between 10 to 100)','(Between 100 - 500)','(500 - 1000)','(Greater than 1000 batch program)'),(26,' (less than 25)',' (25 - 50)','(50 - 100)','(100 - 500)','(greater than 500)'),(27,'(less than 10)','(10 - 50)','(50 - 100)','(100 - 150)','(greater than 150)'),(28,'(less than 5)','(5 - 10)','(10-20)',' (20 - 30)','(greater than 30)'),(29,'less than or equal to 500 MB','500 MB - 1 GB','1  - 10 GB','10 - 100 GB','greater than 100 GB'),(30,'','','','',''),(31,'','','','',''),(32,'','','','',''),(33,'No','','','','Yes'),(34,'No','','','','Yes'),(35,'No','','','','Yes'),(36,'No','','','','Yes'),(37,'Receive','Sends feeds ','Receive on-demand','','bidirectional'),(38,'Receive','','Receive on-demand','','bidirectional'),(39,'Component-based modules','','Mix of component and traditional modules','','Traditional modules'),(40,'1','',' (2 - 5)','','(greater than 5)'),(41,'2','',' (2 - 5)','','(greater than 5)'),(42,'No','','','','Yes'),(43,'Yes','','','','No'),(44,'Low','','Medium','','High'),(45,'Low','','Medium','','High'),(46,'Low','','Medium','','High'),(47,'Low','','Medium','','High'),(48,'Low','','Medium','','High'),(49,'Low','','Medium','','High'),(50,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available , but created for major changes','','Does not exist'),(51,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available , but created for major changes','','Does not exist'),(52,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available , but created for major changes','','Does not exist'),(53,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available , but created for major changes','','Does not exist'),(54,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available but created for major changes','','Does not exist'),(55,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available but created for major changes','','Does not exist'),(56,'Comprehensive and up-to-date','Exists but not up-to-date','Overall not available but created for major changes','','Does not exist'),(57,'Exhaustive; Queries are resolved with minimal Level 1 queries ','','Queries divided between Level 1 and online','','Exhaustive; Queries are resolved with minimal Level 1 queries '),(58,'No','','','','Yes'),(59,'Low','','Medium','','High'),(60,'No','','','','Yes'),(61,'No','','','','Yes'),(62,'Yes critical gaps','','Less than 10% and Non critical','','No'),(63,'No','','','','Yes'),(64,'No','','','','Yes'),(65,'greater than 2 person days','','1 to 2 person days','','less than 1 person day'),(66,'Yes','','','','No'),(67,'Yes','','','','No'),(68,'No','','','','Yes'),(69,'No','','','','Yes'),(70,'No','','','','Yes'),(71,'No','','','','Yes'),(72,'High level','','Some Details','','Very detailed'),(73,'No','','','','Yes'),(74,'No','','','','Yes'),(75,'No','','','','Yes'),(76,'No','','','','Yes'),(77,'No','','','','Yes'),(78,'No','','','','Yes'),(79,'No','','','','Yes'),(80,'No','','','','Yes'),(81,'No','','','','Yes'),(82,'No','','','','Yes'),(83,'greater than 20%','','10%-20%','','less than 10%'),(84,'No','','','','Yes'),(85,'greater than 2 person days','','1 to 2 person days','','less than 1 person day'),(86,'No','','','','Yes'),(87,'No','','','','Yes'),(88,'No','','','','Yes'),(89,'No','','','','Yes'),(90,'No','','','','Yes'),(91,'No','','','','Yes'),(92,'less than 80%','','80% to 95%','','95% to 100%'),(93,'No','','','','Yes'),(94,'No','','','','Yes'),(95,'less than 80%','','80% to 95%','','95% to 100%'),(96,'No','','','','Yes'),(97,'less than 80%','','80% to 95%','','95% to 100%'),(98,'No','','','','Yes'),(99,'No','','','','Yes'),(100,'None','','At least 1','',' 2 or more'),(101,'No','','','','Yes'),(102,'No','','','','Yes'),(103,'No','','','','Yes'),(104,'No','','','','Yes'),(105,'Known defects','','','','No defects'),(106,'Known defects','','','','No defects'),(107,'No','','','','Yes'),(108,'Neither','','Mainline Based Development','','Trunk Based Development'),(109,'No','','','','Yes'),(110,'No','','','','Yes'),(111,'No','','','','Yes'),(112,'No','','','','Yes'),(113,'(greater than 5%)','','less than 5%','','None'),(114,'No','','','','Yes'),(115,'No','','','','Yes'),(116,'No','','','','Yes'),(117,'No','','','','Yes'),(118,'No','','','','Yes'),(119,'No','','','','Yes'),(120,'No','','','','Yes'),(121,'No','','','','Yes'),(122,'No','','','','Yes'),(123,'Never','Sometimes','Mostly','','always'),(124,'No','','','','Yes'),(125,'more than 30% of S1/S2 tickets','','between 10% to 30% of overall S1/S2 tickets','','less than 10% of  S1/S2 overall tickets'),(126,'No','','','','Yes'),(127,'No','','','','Yes'),(128,'No','','Sometimes','','Yes'),(129,'No','','','','Yes'),(130,'No','','','','Yes'),(131,'No','','','','Yes'),(132,'No','','','','Yes'),(133,'No','','','','Yes'),(134,'No','','','','Yes'),(135,'No','','','','Yes'),(136,'No','','','','Yes'),(137,'No','','','','Yes'),(138,'No','','','','Yes'),(139,'No','','','','Yes'),(140,'No','','','','Yes'),(141,'No','','','','Yes'),(142,'No','','','','Yes'),(143,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(144,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(145,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(146,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(147,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(148,'Does not exist','Overall not available but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(149,'Does not exist','Overall not available , but created for major changes','Exists but not up-to-date','','Comprehensive and up-to-date'),(150,'Does not exist','',' Queries divided between Level 1 and online','','Exhaustive; Queries are resolved with minimal Level 1 queries '),(151,'No','','','','Yes'),(152,'No','','Exist for some areas','','Yes'),(153,'No','','','','Yes'),(154,'No','','','','Yes'),(155,'No','','','','Yes'),(156,'No','','','','Yes'),(157,'No','','','','Yes'),(158,'Lack of ownership and accountability in the team','','Some team members display accountability','','Team is highly accountable'),(159,'Innovation Journey has to be initiated','','Some ideas of Innovation have been shared with the customer','','Customer percieves the team to be very Innovative'),(160,'No','','','','Yes'),(161,'Siloed work culture','','Team collaborates within itself and business but not Ops or other stakeholders','','Highly Collaborative across the board'),(162,'No','','','','Yes'),(163,'No','','','','Yes'),(164,'No One','','Their Own Managers','',' Their counterparts in other teams'),(165,'Lots of gaps','','Some Gaps','','No Gaps'),(166,'Waterfall','','Iterative','','Agile'),(167,'No','','','','Yes'),(168,'No','','','','Yes'),(169,'No','','','','Yes'),(170,'No','','','','Yes'),(171,'No','','','','Yes'),(172,'No','','','','Yes'),(173,'No','','','','Yes'),(174,'No','','','','Yes'),(175,'No','','','','Yes'),(176,'No','','','','Yes'),(177,'No','','','','Yes'),(178,'No','','','','Yes'),(179,'','','','',''),(180,'Not able to predict with accuracy','','Ability to predict with 10% variatio','','consistently able to predict with less than 5% variance'),(181,'Not able to predict with accuracy','','Ability to predict with 10% variation','','consistently able to predict with less than 5% variance'),(182,'Not able to predict with accuracy','','Ability to predict with 10% variatio','','consistently able to predict with less than 5% variance'),(183,'S1, S2 and other defects','','No S1, few S2 defects','','No S1, S2 defects'),(184,' Never','',' Sometimes','','Yes most of the times'),(185,'Not clear at all','','Know some elements of the vision and purpose','','Very Clear'),(186,'No','','Some members are aware of some elements','','Yes'),(187,'No','','Some members are aware of some elements','','Yes'),(188,'No','','Some members are aware of some elements','','Yes'),(189,'No','','Some members are aware of some elements','','Yes'),(190,'No','','Some members are aware of some elements','','Yes'),(191,'No','','','','Yes'),(192,'Needs a lot of hand holding','','Needs some external Support','','Yes, Fully self organized'),(193,'Needs a lot of hand holding','','Needs some external Support','','Yes, Fully self organized'),(194,'(less than 10%)','','(10%-20%)','','(greater than 20%)'),(195,'Over 30 mins','','20 to 30 mins','','15 to 20 mins'),(196,'over 12 members','','9 to 12 members','','5 to 9 members'),(197,'Lot of external help is needed','','Some external help is taken','','All skills present'),(198,'unstable team','',' Some team members might be rotating','',' Very Stable'),(199,'Highly unstable environments','','All environments are not available','','All environments are available and stable'),(200,' Lack of ownership and accountability in the team','','Some team members display accountability','','Team is highly accountable'),(201,' Innovation Journey has to be initiated','','Some ideas of Innovation have been shared with the customer','','Customer percieves the team to be very Innovative'),(202,'No','','','','Yes'),(203,' Siloed work culture','','Team collaborates within itself and business but not Ops or other stakeholders','','Highly Collaborative across the board'),(204,'Limited role play','','Partially','','Yes'),(205,'Limited role play','','Partially','','Yes'),(206,'Limited role play','','Partially','','Yes'),(207,'Limited role play','','Partially','','Yes'),(208,'','','','','');
/*!40000 ALTER TABLE `question_indicative_values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_master`
--

DROP TABLE IF EXISTS `question_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_master` (
  `questionID` int(11) NOT NULL AUTO_INCREMENT,
  `question_Description` varchar(1000) NOT NULL,
  `assessment_Id` int(11) NOT NULL,
  `category_Id` int(11) NOT NULL,
  `subcategory_Id` int(11) NOT NULL,
  `isActive` tinyint(4) NOT NULL,
  `questionnaire_type` int(11) NOT NULL,
  PRIMARY KEY (`questionID`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_master`
--

LOCK TABLES `question_master` WRITE;
/*!40000 ALTER TABLE `question_master` DISABLE KEYS */;
INSERT INTO `question_master` VALUES (1,'What is the Criticality of the application availability to the business?',1,1,65,1,1),(2,'What is the impact of this application on organisation\'s business?',1,1,65,1,1),(3,'What is the  applicatio\'s competitive advantage?',1,1,65,1,1),(4,'Will revenue be impacted if releases get delayed?',1,2,65,1,1),(5,'Are releases timed to gain or protect competitve advantage?',1,2,65,1,1),(6,'Are releases timed to meet regulatory or compliance requirements?',1,2,65,1,1),(7,'Are users facing issues where transactions are not being completed?',1,3,65,1,1),(8,'Are users satisfied with the performance times of the application?',1,3,65,1,1),(9,'In case of issues, are users satisfied with the turn around times on issue resolution times',1,3,65,1,1),(10,'# of direct Application Userss',1,3,65,1,1),(11,'Channels of Interaction for the User',1,3,65,1,1),(12,'What are the different types of Application Users?',1,3,65,1,1),(13,'How often are changes to the app needed due to regulatory/compliance reasons?',1,4,65,1,1),(14,'Is the business environment constantly changing and volatile?',1,5,65,1,1),(15,'Is the application very narrow in scope, e.g. specific to an asset class and a function or is it more broadbased, e.g. shared service?',2,6,65,1,1),(16,'For Future Use',2,6,65,1,1),(17,'Availability of Source Code?',2,7,65,1,1),(18,'Coding Standards - Doc?',2,7,65,1,1),(19,'Naming conv - Doc?',2,7,65,1,1),(20,'Frame-work for Maintenance exists?',2,7,65,1,1),(21,'System generated notifications?',2,7,65,1,1),(22,'Approximate number of database objects',2,8,65,1,1),(23,'Database Size',2,8,65,1,1),(24,'# of Total LOC',2,8,65,1,1),(25,'# of Batch Programs, JCLs, Process\n(Count of batch and automated processes that need no manual intervention - exclude batch reports)',2,8,65,1,1),(26,'# of Online Screens',2,8,65,1,1),(27,'# of Reports',2,8,65,1,1),(28,'# of Modules - Subsystems',2,8,65,1,1),(29,'Data transmission - interchange volumes (within / outside organization)',2,8,65,1,1),(30,'Describe your application\'s Connectivity, Layout and Network Topology.',2,8,65,1,1),(31,'Describe the application\'s Security authentication.',2,8,65,1,1),(32,'Does the application have a DR environment?',2,8,65,1,1),(33,'Multi-lingual deployment',2,8,65,1,1),(34,'Multi-platform deployment',2,8,65,1,1),(35,'Multi-site deployment',2,8,65,1,1),(36,'Multiple versions of same application in use ?',2,8,65,1,1),(37,'What is the degree of dependencies the application has on integration with internal applications?',2,27,65,1,1),(38,'What is the degree of dependencies the application has on integration with external/third-party applications?',2,27,65,1,1),(39,'What is the applicatio\'s Integration and Interfacing capabilities?',2,27,65,1,1),(40,'Enter # of Inbound Interfaces with Other Systems',2,27,65,1,1),(41,'Enter # of Outbound Interfaces to Other Systems',2,27,65,1,1),(42,'Use of third party products ?',2,28,65,1,1),(43,'Product vendor support for the product(s) / compoenent(s)',2,28,65,1,1),(44,'Application support team\'s role in support of Third party product',2,28,65,1,1),(45,'Total No. of Enhancement Requests in Last 6 months',2,5,65,1,1),(46,'Total No. of Enhancement Requests in past 6-12 months',2,5,65,1,1),(47,'Average no. of enhancement requests per month',2,5,65,1,1),(48,'Current backlog of open enhancement requests',2,5,65,1,1),(49,'Number of enhancement releases made in past 1 year / since application is moved into production (whichever is earlier)',2,5,65,1,1),(50,'Requirement Specifications',2,9,65,1,1),(51,'Functional Specifications',2,9,65,1,1),(52,'Design and Technical Specifications',2,9,65,1,1),(53,'Test Cases and Scenarios',2,9,65,1,1),(54,'User Manuals',2,9,65,1,1),(55,'Maintenance Manuals and Support Procedures',2,9,65,1,1),(56,'Installation Guides',2,9,65,1,1),(57,'What is the effectiveness of applications online help?',2,9,65,1,1),(58,'Is the application or any part of it hosted on a public/private cloud?',2,10,65,1,1),(59,'How many tickets in the last year have been due to infrastructure issues?',2,10,65,1,1),(60,'Is there an Initiation excercise formally conducted to form a core team and arrive at a ball park estimate and feasability of execution?',3,12,1,1,1),(61,'Is the full team identified at the start of the project?',3,11,2,1,1),(62,'Are there any skill gaps in the team?',3,11,2,1,1),(63,'Is the team in distributed geographical locations?',3,11,2,1,1),(64,'Are requirements captured in a BRD or as Epics/Stories?',3,11,3,1,1),(65,'What is the atomocity of requirements?',3,11,3,1,1),(66,'Have there been any cases in the last 5 releases where requirments have been missed or misunderstood?',3,11,3,1,1),(67,'Have there been changes to requirements during the build phase?',3,11,3,1,1),(68,'Are UAT test cases written and shared along with the requirements?',3,11,3,1,1),(69,'Have the inputs of the operations team been taken into consideration while drafting the requirements?',3,11,3,1,1),(70,'Have all aspects been considered when planning apart from the project schedule viz. environment availability, external dependencies, communication plan, leave plan, contingency, Risks and Issues etc.',3,11,4,1,1),(71,'Is the plan communicated and available to all the team members?',3,11,4,1,1),(72,'How detailed is the Technical Design?',3,13,5,1,1),(73,'Are Technical risk items highlighted in the design?',3,13,5,1,1),(74,'Is there a Technical Debt register maintained?',3,13,5,1,1),(75,'Are reusable components used or created as part of the Technical Design?',3,13,5,1,1),(76,'Are any design patterns used in the Technical Design?',3,13,5,1,1),(77,'Has rapid prototyping been used to get business/user feedback when designing?',3,13,6,1,1),(78,'Have any tools been used to monitor user behavior and have the learnings been factored in the design?',3,13,6,1,1),(79,'Has the Ui/UX design  factored in mutiple delivery channels?',3,13,6,1,1),(80,'Have the technology teams been involved in this process to validate that the design being proposed is technically feasible?',3,13,6,1,1),(81,'Have the Security requirements of the application captured?',3,13,7,1,1),(82,'Are the security best practices incorporated in coding and operations?',3,13,7,1,1),(83,'What is the deviation observed on estimates vs actuals over the last 5 releases?',3,14,8,1,1),(84,'Has the deviation shown a downward trend?',3,14,8,1,1),(85,'What is the size of the lowest atomic unit of a task in hours?',3,14,8,1,1),(86,'Is an IDE used for development?',3,14,9,1,1),(87,'Is a source control tool deployed across all the applications?',3,14,10,1,1),(88,'Is the code segregated into main trunk and branches and are the branches tagged specifically for each version?',3,14,10,1,1),(89,'Are peer to peer code reviews conducted?',3,14,11,1,1),(90,'Does a coding guidline document exist?',3,14,11,1,1),(91,'Is there a code quality review tool in use?',3,14,11,1,1),(92,'What is the coverage of the code quality review?',3,14,11,1,1),(93,'Are unit test cases written by developers?',3,15,12,1,1),(94,'Is unit testing automated?',3,15,12,1,1),(95,'What is the coverage of functional testing?',3,15,13,1,1),(96,'Is any tool used to measure and check code coverage during functional testing?',3,15,13,1,1),(97,'What is the coverage of Regression Testing?',3,15,14,1,1),(98,'Is Regression Testing automated?',3,15,14,1,1),(99,'Has a subset of the regression test suite been identified for smoke/sanity testing?',3,15,14,1,1),(100,'How many regression cycles are run before a release?',3,15,14,1,1),(101,'Do the non-functional requirements clearly specify the perfomance expectations?',3,15,15,1,1),(102,'Have any light weight performance tests been conducted early in the life cycle to validate high risk technical components of the application?',3,15,15,1,1),(103,'Are any automated tools used for performance testing?',3,15,15,1,1),(104,'Has enough time been planned for performance test scripts to be written and performance tuning to be done ?',3,15,15,1,1),(105,'Were there any reported defects at the entry into UAT ?',3,15,16,1,1),(106,'Does the exit criteria of the UAT allow any know issues/defects ?',3,15,16,1,1),(107,'Do you have a Release Manager in the team?',3,16,17,1,1),(108,'Does the team use Trunk based Development or Mainline Based Development for managing releases?',3,16,17,1,1),(109,'Is Continuous Integration used during development?',3,16,17,1,1),(110,'Tools being used for Automated Build creation',3,16,17,1,1),(111,'Tools being used for Automated Build Deployment',3,16,18,1,1),(112,'Standard runbooks in place for each deployment',3,16,18,1,1),(113,'How many post release issues have occurred in last 2 years resulting into patch release',3,16,18,1,1),(114,'Separate team supporting Build Deployment',3,16,18,1,1),(115,'SLA\'s for Response and Resolution has been defined and formally agreed with client',3,17,19,1,1),(116,'RCA for each incident is done and reviewed with client',3,17,19,1,1),(117,'Incident resolution is logged and tracked whenever there is a repetition of the incident',3,17,19,1,1),(118,'Is there a Tool to log service requests',3,17,19,1,1),(119,'All the service requests are tracked to closure',3,17,20,1,1),(120,'KPI\'s defined for response and closure of each service request',3,17,20,1,1),(121,'Do we have standard methodology defined for environment provisioning',3,17,20,1,1),(122,'Review mechanism defined before the environment is handed over',3,17,21,1,1),(123,'The requested and delivered environments are either same or better',3,17,21,1,1),(124,'Is the application or any part of it hosted on a public/private cloud?',3,17,21,1,1),(125,'How many tickets in the last year have been due to infrastructure issues?',3,17,22,1,1),(126,'SLA\'s defined for Monitoring',3,17,22,1,1),(127,'RFB checks defined and done regularly',3,17,23,1,1),(128,'Monitoring resulted in proactive avoidance of production issues',3,17,23,1,1),(129,'Change Control Board defined and members allocated',3,18,24,1,1),(130,'Approval from CCB is taken for any changes',3,18,24,1,1),(131,'Estimates and plans revised based on inputs from CCB',3,18,24,1,1),(132,'Is a Change Management Tool used  to track and manage changes',3,18,24,1,1),(133,'Proper tool defined for Task / Time tracking',3,18,25,1,1),(134,'Reports generated and shared with stakeholders',3,18,25,1,1),(135,'Any delays have RCA and mitigation plan is identified',3,18,25,1,1),(136,'Delays updated in Risk Register',3,18,25,1,1),(137,'Learnings from delays tracked and updated in Knowledge repository',3,18,25,1,1),(138,'Productivity measures defined and updated to team',3,18,25,1,1),(139,'Tools in place for velocity / productivity monitoring',3,18,26,1,1),(140,'Productivity of team is monitored and closed',3,18,26,1,1),(141,'Estimations and Sprints planned based on the team capacity',3,18,27,1,1),(142,'Capacity utilization Monitored and Reported',3,18,27,1,1),(143,'Requirement Specifications',3,18,28,1,1),(144,'Functional Specifications',3,18,28,1,1),(145,'Design and Technical Specifications',3,18,28,1,1),(146,'Test Cases and Scenarios',3,18,28,1,1),(147,'User Manuals',3,18,28,1,1),(148,'Maintenance Manuals and Support Procedures',3,18,28,1,1),(149,'Installation Guides',3,18,28,1,1),(150,'What is the effectiveness of applications online help?',3,18,28,1,1),(151,'Centralized repository for Development Standards / Best Practices',3,18,28,1,1),(152,'Do Coding guidelines, naming conventions exist by technology area?',3,18,29,1,1),(153,'Are case studies, best practices for different scenarios available at a central repository?',3,18,29,1,1),(154,'Is a re usable component/template/framework catalog available centrally for teams across the board to refer and use?',3,18,29,1,1),(155,'Issues and Risks tracked in Risk register with proper mitigation plan',3,19,30,1,1),(156,'Escalation Matrix defined',3,19,30,1,1),(157,'Quarterly Business review happening with client',3,19,30,1,1),(158,'Is there a culture of accountability in the team?',3,19,30,1,1),(159,'Is there a track record of customer recognized innovation by the team?',3,19,31,1,1),(160,'Is there Trust and Respect among all the team members?',3,19,31,1,1),(161,'Does the team collaborate between themselves, business, operations and other stakeholders?',3,19,31,1,1),(162,'The ownership with the leader is clear and defined',3,19,31,1,1),(163,'Does the leadership help in removing the bottlenecks for the team?',3,20,32,1,1),(164,'When there is a need for collaboration across cross functional teams, whom do the Team managers reach out to first, their counterparts in other teams or they seek the help of their managers to do the needful?',3,20,32,1,1),(165,'Are the managers equipped to play their roles effectively or are there any gaps in the roles?',3,20,32,1,1),(166,'What is your SDLC mechanism?',3,11,33,1,1),(167,'Is there a dedicated Operations team?',3,18,29,1,1),(168,'Is there a Change management process in place for Ops?',3,17,23,1,1),(169,'Have the business stakeholders been interviewed for clearly capturing the business objectives of the product/project?',3,16,6,1,1),(170,'Are Dev, QA and Ops teams working together as one single team?',3,18,29,1,1),(171,'Is a tool used for configuration management?',3,17,22,1,1),(172,'Is a tool used for Release Management?',3,16,18,1,1),(173,'Are self healing practices using automation used in the production environments?',3,17,23,1,1),(174,'Is an Application Performance Management Tool used to monitor real time performance in the production environment?',3,17,23,1,1),(175,'Has the APM tool helped reduce the MTTR of a ticket?',3,17,23,1,1),(176,'Have any AI tools been used for Self Healing like Nueral Chat?',3,17,23,1,1),(177,'Have you prevented any outages or disruptions to service based on analysis of past data and trends?',3,17,23,1,1),(178,'Have you prevented any outages or disruptions to services through RFB checks?',3,17,23,1,1),(179,'Agile Health Index ',3,26,37,1,1),(180,'Is the team able to predict the velocity for upcoming sprints?',3,21,38,1,2),(181,'Are the deliveries able to meet the Time to Market objectives?',3,21,39,1,2),(182,'Is the team able to quantify the value delivered in each release?',3,21,40,1,2),(183,'What are the number of defects reported in production after a release?',3,21,41,1,2),(184,'Has the team been able to accommodate changes to the original scope (we are not talking about any change while a sprint is underway)',3,21,42,1,2),(185,'Is the team always clear about the vision and purpose of the applications?',3,22,43,1,2),(186,'Has the measure of success been clearly defined and communicated to the team?',3,22,44,1,2),(187,'Is the team clear of the roadmap for the application and the business unit and/or organization and how the application/product fits in the roadmap?',3,22,45,1,2),(188,'Is a release plan in place which is understood by all the team mebers?',3,22,46,1,2),(189,'Is an iteration plan in place which is understood by all the team mebers?',3,22,47,1,2),(190,'Are Roles and Responsibilities clearly defined and does each team memebr understand the roles of all other team members and stakeholders?',3,22,48,1,2),(191,'Has the team achieved sustainable pace over the last 5 releases?',3,23,49,1,2),(192,'Is the team self organized without much external support?',3,23,50,1,2),(193,'Has the team been consistently delivering to a high technical standard without external help?',3,23,51,1,2),(194,'What is the deviation observed on estimates vs actuals over the last 5 releases?',3,23,52,1,2),(195,'How long do  Daily Scrum meetings last on an average?',3,23,53,1,2),(196,'What is the size of the scrum teams?',3,23,54,1,2),(197,'Are all the required skills to deliver present in the team?',3,23,54,1,2),(198,'Is the team stable?',3,23,55,1,2),(199,'Are all environments available and stable?',3,23,56,1,2),(200,'Is there a culture of accountability in the team?',3,24,57,1,2),(201,'Is there a track record of customer recognized innovtion by the team?',3,24,58,1,2),(202,'Is there Trust and Respect among all the team members?',3,24,59,1,2),(203,'Does the team collaborate between themselves, business, operations and other stakeholders?',3,24,60,1,2),(204,'Are all the responsibilities of this role fullfilled?',3,25,61,1,2),(205,'Are all the responsibilities of this role fullfilled?',3,25,62,1,2),(206,'Are all the responsibilities of this role fullfilled?',3,25,63,1,2),(207,'Are all the responsibilities of this role fullfilled?',3,25,64,1,2);
/*!40000 ALTER TABLE `question_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_score`
--

DROP TABLE IF EXISTS `question_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_score` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `business_unit_id` int(11) DEFAULT NULL,
  `application_id` int(11) DEFAULT NULL,
  `report_id` int(11) DEFAULT NULL,
  `questionID` int(11) DEFAULT NULL,
  `score_admin` int(11) DEFAULT NULL,
  `score_user` int(11) DEFAULT NULL,
  `comments` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `submitted_by` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `assessment_id` int(11) DEFAULT NULL,
  `isAssessmentIdActive` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5738 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_score`
--

LOCK TABLES `question_score` WRITE;
/*!40000 ALTER TABLE `question_score` DISABLE KEYS */;
INSERT INTO `question_score` VALUES (4675,2,16,26,0,1,3,3,'','Allen',1,1),(4676,2,16,26,0,2,2,2,'','Allen',1,1),(4677,2,16,26,0,3,5,5,'','Allen',1,1),(4678,2,16,26,0,4,3,3,'','Allen',1,1),(4679,2,16,26,0,5,5,5,'','Allen',1,1),(4680,2,16,26,0,6,3,5,'','Allen',1,1),(4681,2,16,26,0,7,4,1,'','Allen',1,1),(4682,2,16,26,0,8,4,3,'','Allen',1,1),(4683,2,16,26,0,9,2,5,'','Allen',1,1),(4684,2,16,26,0,10,4,3,'','Allen',1,1),(4685,2,16,26,0,11,4,3,'','Allen',1,1),(4686,2,16,26,0,12,1,3,'','Allen',1,1),(4687,2,16,26,0,13,3,5,'','Allen',1,1),(4688,2,16,26,0,14,5,1,'','Allen',1,1),(4689,2,16,26,0,15,3,3,'','Allen',2,1),(4690,2,16,26,0,16,5,5,'','Allen',2,1),(4691,2,16,26,0,17,1,1,'','Allen',2,1),(4692,2,16,26,0,18,1,1,'','Allen',2,1),(4693,2,16,26,0,19,1,1,'','Allen',2,1),(4694,2,16,26,0,20,1,1,'','Allen',2,1),(4695,2,16,26,0,21,5,5,'','Allen',2,1),(4696,2,16,26,0,22,0,0,'','Allen',2,1),(4697,2,16,26,0,23,5,5,'','Allen',2,1),(4698,2,16,26,0,24,0,0,'','Allen',2,1),(4699,2,16,26,0,25,2,0,'','Allen',2,1),(4700,2,16,26,0,26,1,0,'','Allen',2,1),(4701,2,16,26,0,27,3,0,'','Allen',2,1),(4702,2,16,26,0,28,4,0,'','Allen',2,1),(4703,2,16,26,0,29,4,0,'','Allen',2,1),(4704,2,16,26,0,30,1,0,'','Allen',2,1),(4705,2,16,26,0,31,1,0,'','Allen',2,1),(4706,2,16,26,0,32,4,0,'','Allen',2,1),(4707,2,16,26,0,33,5,0,'','Allen',2,1),(4708,2,16,26,0,34,5,0,'','Allen',2,1),(4709,2,16,26,0,35,5,0,'','Allen',2,1),(4710,2,16,26,0,36,4,0,'','Allen',2,1),(4711,2,16,26,0,37,1,0,'','Allen',2,1),(4712,2,16,26,0,38,2,0,'','Allen',2,1),(4713,2,16,26,0,39,5,0,'','Allen',2,1),(4714,2,16,26,0,40,1,0,'','Allen',2,1),(4715,2,16,26,0,41,3,0,'','Allen',2,1),(4716,2,16,26,0,42,3,0,'','Allen',2,1),(4717,2,16,26,0,43,4,0,'','Allen',2,1),(4718,2,16,26,0,44,5,0,'','Allen',2,1),(4719,2,16,26,0,45,4,0,'','Allen',2,1),(4720,2,16,26,0,46,5,0,'','Allen',2,1),(4721,2,16,26,0,47,4,0,'','Allen',2,1),(4722,2,16,26,0,48,1,0,'','Allen',2,1),(4723,2,16,26,0,49,3,0,'','Allen',2,1),(4724,2,16,26,0,50,1,0,'','Allen',2,1),(4725,2,16,26,0,51,2,0,'','Allen',2,1),(4726,2,16,26,0,52,5,0,'','Allen',2,1),(4727,2,16,26,0,53,4,0,'','Allen',2,1),(4728,2,16,26,0,54,4,0,'','Allen',2,1),(4729,2,16,26,0,55,3,0,'','Allen',2,1),(4730,2,16,26,0,56,4,0,'','Allen',2,1),(4731,2,16,26,0,57,0,0,'','Allen',2,1),(4732,2,16,26,0,58,1,0,'','Allen',2,1),(4733,2,16,26,0,59,5,0,'','Allen',2,1),(4734,2,16,26,0,60,2,0,'','Allen',3,1),(4735,2,16,26,0,61,3,0,'','Allen',3,1),(4736,2,16,26,0,62,1,0,'','Allen',3,1),(4737,2,16,26,0,63,1,0,'','Allen',3,1),(4738,2,16,26,0,64,4,0,'','Allen',3,1),(4739,2,16,26,0,65,3,0,'','Allen',3,1),(4740,2,16,26,0,66,5,0,'','Allen',3,1),(4741,2,16,26,0,67,2,0,'','Allen',3,1),(4742,2,16,26,0,68,1,0,'','Allen',3,1),(4743,2,16,26,0,69,2,0,'','Allen',3,1),(4744,2,16,26,0,70,5,0,'','Allen',3,1),(4745,2,16,26,0,71,1,0,'','Allen',3,1),(4746,2,16,26,0,72,1,0,'','Allen',3,1),(4747,2,16,26,0,73,3,0,'','Allen',3,1),(4748,2,16,26,0,74,4,0,'','Allen',3,1),(4749,2,16,26,0,75,3,0,'','Allen',3,1),(4750,2,16,26,0,76,5,0,'','Allen',3,1),(4751,2,16,26,0,77,5,0,'','Allen',3,1),(4752,2,16,26,0,78,2,0,'','Allen',3,1),(4753,2,16,26,0,79,4,0,'','Allen',3,1),(4754,2,16,26,0,80,2,0,'','Allen',3,1),(4755,2,16,26,0,81,1,0,'','Allen',3,1),(4756,2,16,26,0,82,3,0,'','Allen',3,1),(4757,2,16,26,0,83,1,0,'','Allen',3,1),(4758,2,16,26,0,84,4,0,'','Allen',3,1),(4759,2,16,26,0,85,1,0,'','Allen',3,1),(4760,2,16,26,0,86,5,0,'','Allen',3,1),(4761,2,16,26,0,87,3,0,'','Allen',3,1),(4762,2,16,26,0,88,2,0,'','Allen',3,1),(4763,2,16,26,0,89,5,0,'','Allen',3,1),(4764,2,16,26,0,90,5,0,'','Allen',3,1),(4765,2,16,26,0,91,4,0,'','Allen',3,1),(4766,2,16,26,0,92,2,0,'','Allen',3,1),(4767,2,16,26,0,93,2,0,'','Allen',3,1),(4768,2,16,26,0,94,5,0,'','Allen',3,1),(4769,2,16,26,0,95,5,0,'','Allen',3,1),(4770,2,16,26,0,96,1,0,'','Allen',3,1),(4771,2,16,26,0,97,3,0,'','Allen',3,1),(4772,2,16,26,0,98,5,0,'','Allen',3,1),(4773,2,16,26,0,99,4,0,'','Allen',3,1),(4774,2,16,26,0,100,5,0,'','Allen',3,1),(4775,2,16,26,0,101,1,0,'','Allen',3,1),(4776,2,16,26,0,102,1,0,'','Allen',3,1),(4777,2,16,26,0,103,3,0,'','Allen',3,1),(4778,2,16,26,0,104,5,0,'','Allen',3,1),(4779,2,16,26,0,105,4,0,'','Allen',3,1),(4780,2,16,26,0,106,2,0,'','Allen',3,1),(4781,2,16,26,0,107,4,0,'','Allen',3,1),(4782,2,16,26,0,108,5,0,'','Allen',3,1),(4783,2,16,26,0,109,1,0,'','Allen',3,1),(4784,2,16,26,0,110,3,0,'','Allen',3,1),(4785,2,16,26,0,111,2,0,'','Allen',3,1),(4786,2,16,26,0,112,1,0,'','Allen',3,1),(4787,2,16,26,0,113,2,0,'','Allen',3,1),(4788,2,16,26,0,114,4,0,'','Allen',3,1),(4789,2,16,26,0,115,1,0,'','Allen',3,1),(4790,2,16,26,0,116,4,0,'','Allen',3,1),(4791,2,16,26,0,117,2,0,'','Allen',3,1),(4792,2,16,26,0,118,3,0,'','Allen',3,1),(4793,2,16,26,0,119,5,0,'','Allen',3,1),(4794,2,16,26,0,120,4,0,'','Allen',3,1),(4795,2,16,26,0,121,2,0,'','Allen',3,1),(4796,2,16,26,0,122,3,0,'','Allen',3,1),(4797,2,16,26,0,123,2,0,'','Allen',3,1),(4798,2,16,26,0,124,1,0,'','Allen',3,1),(4799,2,16,26,0,125,1,0,'','Allen',3,1),(4800,2,16,26,0,126,1,0,'','Allen',3,1),(4801,2,16,26,0,127,3,0,'','Allen',3,1),(4802,2,16,26,0,128,2,0,'','Allen',3,1),(4803,2,16,26,0,129,5,0,'','Allen',3,1),(4804,2,16,26,0,130,1,0,'','Allen',3,1),(4805,2,16,26,0,131,4,0,'','Allen',3,1),(4806,2,16,26,0,132,4,0,'','Allen',3,1),(4807,2,16,26,0,133,5,0,'','Allen',3,1),(4808,2,16,26,0,134,4,0,'','Allen',3,1),(4809,2,16,26,0,135,5,0,'','Allen',3,1),(4810,2,16,26,0,136,2,0,'','Allen',3,1),(4811,2,16,26,0,137,5,0,'','Allen',3,1),(4812,2,16,26,0,138,1,0,'','Allen',3,1),(4813,2,16,26,0,139,5,0,'','Allen',3,1),(4814,2,16,26,0,140,1,0,'','Allen',3,1),(4815,2,16,26,0,141,1,0,'','Allen',3,1),(4816,2,16,26,0,142,2,0,'','Allen',3,1),(4817,2,16,26,0,143,3,0,'','Allen',3,1),(4818,2,16,26,0,144,5,0,'','Allen',3,1),(4819,2,16,26,0,145,2,0,'','Allen',3,1),(4820,2,16,26,0,146,2,0,'','Allen',3,1),(4821,2,16,26,0,147,5,0,'','Allen',3,1),(4822,2,16,26,0,148,5,0,'','Allen',3,1),(4823,2,16,26,0,149,4,0,'','Allen',3,1),(4824,2,16,26,0,150,2,0,'','Allen',3,1),(4825,2,16,26,0,151,3,0,'','Allen',3,1),(4826,2,16,26,0,152,1,0,'','Allen',3,1),(4827,2,16,26,0,153,3,0,'','Allen',3,1),(4828,2,16,26,0,154,5,0,'','Allen',3,1),(4829,2,16,26,0,155,1,0,'','Allen',3,1),(4830,2,16,26,0,156,4,0,'','Allen',3,1),(4831,2,16,26,0,157,2,0,'','Allen',3,1),(4832,2,16,26,0,158,2,0,'','Allen',3,1),(4833,2,16,26,0,159,5,0,'','Allen',3,1),(4834,2,16,26,0,160,2,0,'','Allen',3,1),(4835,2,16,26,0,161,1,0,'','Allen',3,1),(4836,2,16,26,0,162,5,0,'','Allen',3,1),(4837,2,16,26,0,163,4,0,'','Allen',3,1),(4838,2,16,26,0,164,2,0,'','Allen',3,1),(4839,2,16,26,0,165,4,0,'','Allen',3,1),(4840,2,16,26,0,166,3,0,'','Allen',3,1),(4841,2,16,26,0,167,2,0,'','Allen',3,1),(4842,2,16,26,0,168,2,0,'','Allen',3,1),(4843,2,16,26,0,169,5,0,'','Allen',3,1),(4844,2,16,26,0,170,2,0,'','Allen',3,1),(4845,2,16,26,0,171,3,0,'','Allen',3,1),(4846,2,16,26,0,172,1,0,'','Allen',3,1),(4847,2,16,26,0,173,4,0,'','Allen',3,1),(4848,2,16,26,0,174,5,0,'','Allen',3,1),(4849,2,16,26,0,175,4,0,'','Allen',3,1),(4850,2,16,26,0,176,1,0,'','Allen',3,1),(4851,2,16,26,0,177,2,0,'','Allen',3,1),(4852,2,16,26,0,178,4,0,'','Allen',3,1),(4853,2,16,26,0,179,4,0,'','Allen',3,1),(4854,2,16,26,0,180,0,0,'',NULL,3,1),(4855,2,16,26,0,181,0,0,'',NULL,3,1),(4856,2,16,26,0,182,0,0,'',NULL,3,1),(4857,2,16,26,0,183,0,0,'',NULL,3,1),(4858,2,16,26,0,184,0,0,'',NULL,3,1),(4859,2,16,26,0,185,0,0,'',NULL,3,1),(4860,2,16,26,0,186,0,0,'',NULL,3,1),(4861,2,16,26,0,187,0,0,'',NULL,3,1),(4862,2,16,26,0,188,0,0,'',NULL,3,1),(4863,2,16,26,0,189,0,0,'',NULL,3,1),(4864,2,16,26,0,190,0,0,'',NULL,3,1),(4865,2,16,26,0,191,0,0,'',NULL,3,1),(4866,2,16,26,0,192,0,0,'',NULL,3,1),(4867,2,16,26,0,193,0,0,'',NULL,3,1),(4868,2,16,26,0,194,0,0,'',NULL,3,1),(4869,2,16,26,0,195,0,0,'',NULL,3,1),(4870,2,16,26,0,196,0,0,'',NULL,3,1),(4871,2,16,26,0,197,0,0,'',NULL,3,1),(4872,2,16,26,0,198,0,0,'',NULL,3,1),(4873,2,16,26,0,199,0,0,'',NULL,3,1),(4874,2,16,26,0,200,0,0,'',NULL,3,1),(4875,2,16,26,0,201,0,0,'',NULL,3,1),(4876,2,16,26,0,202,0,0,'',NULL,3,1),(4877,2,16,26,0,203,0,0,'',NULL,3,1),(4878,2,16,26,0,204,0,0,'',NULL,3,1),(4879,2,16,26,0,205,0,0,'',NULL,3,1),(4880,2,16,26,0,206,0,0,'',NULL,3,1),(4881,2,16,26,0,207,0,0,'',NULL,3,1),(4882,2,16,27,0,1,0,0,'',NULL,1,1),(4883,2,16,27,0,2,0,0,'',NULL,1,1),(4884,2,16,27,0,3,0,0,'',NULL,1,1),(4885,2,16,27,0,4,0,0,'',NULL,1,1),(4886,2,16,27,0,5,0,0,'',NULL,1,1),(4887,2,16,27,0,6,0,0,'',NULL,1,1),(4888,2,16,27,0,7,0,0,'',NULL,1,1),(4889,2,16,27,0,8,0,0,'',NULL,1,1),(4890,2,16,27,0,9,0,0,'',NULL,1,1),(4891,2,16,27,0,10,0,0,'',NULL,1,1),(4892,2,16,27,0,11,0,0,'',NULL,1,1),(4893,2,16,27,0,12,0,0,'',NULL,1,1),(4894,2,16,27,0,13,0,0,'',NULL,1,1),(4895,2,16,27,0,14,0,0,'',NULL,1,1),(4896,2,16,27,0,15,0,0,'',NULL,2,1),(4897,2,16,27,0,16,0,0,'',NULL,2,1),(4898,2,16,27,0,17,0,0,'',NULL,2,1),(4899,2,16,27,0,18,0,0,'',NULL,2,1),(4900,2,16,27,0,19,0,0,'',NULL,2,1),(4901,2,16,27,0,20,0,0,'',NULL,2,1),(4902,2,16,27,0,21,0,0,'',NULL,2,1),(4903,2,16,27,0,22,0,0,'',NULL,2,1),(4904,2,16,27,0,23,0,0,'',NULL,2,1),(4905,2,16,27,0,24,0,0,'',NULL,2,1),(4906,2,16,27,0,25,0,0,'',NULL,2,1),(4907,2,16,27,0,26,0,0,'',NULL,2,1),(4908,2,16,27,0,27,0,0,'',NULL,2,1),(4909,2,16,27,0,28,0,0,'',NULL,2,1),(4910,2,16,27,0,29,0,0,'',NULL,2,1),(4911,2,16,27,0,30,0,0,'',NULL,2,1),(4912,2,16,27,0,31,0,0,'',NULL,2,1),(4913,2,16,27,0,32,0,0,'',NULL,2,1),(4914,2,16,27,0,33,0,0,'',NULL,2,1),(4915,2,16,27,0,34,0,0,'',NULL,2,1),(4916,2,16,27,0,35,0,0,'',NULL,2,1),(4917,2,16,27,0,36,0,0,'',NULL,2,1),(4918,2,16,27,0,37,0,0,'',NULL,2,1),(4919,2,16,27,0,38,0,0,'',NULL,2,1),(4920,2,16,27,0,39,0,0,'',NULL,2,1),(4921,2,16,27,0,40,0,0,'',NULL,2,1),(4922,2,16,27,0,41,0,0,'',NULL,2,1),(4923,2,16,27,0,42,0,0,'',NULL,2,1),(4924,2,16,27,0,43,0,0,'',NULL,2,1),(4925,2,16,27,0,44,0,0,'',NULL,2,1),(4926,2,16,27,0,45,0,0,'',NULL,2,1),(4927,2,16,27,0,46,0,0,'',NULL,2,1),(4928,2,16,27,0,47,0,0,'',NULL,2,1),(4929,2,16,27,0,48,0,0,'',NULL,2,1),(4930,2,16,27,0,49,0,0,'',NULL,2,1),(4931,2,16,27,0,50,0,0,'',NULL,2,1),(4932,2,16,27,0,51,0,0,'',NULL,2,1),(4933,2,16,27,0,52,0,0,'',NULL,2,1),(4934,2,16,27,0,53,0,0,'',NULL,2,1),(4935,2,16,27,0,54,0,0,'',NULL,2,1),(4936,2,16,27,0,55,0,0,'',NULL,2,1),(4937,2,16,27,0,56,0,0,'',NULL,2,1),(4938,2,16,27,0,57,0,0,'',NULL,2,1),(4939,2,16,27,0,58,0,0,'',NULL,2,1),(4940,2,16,27,0,59,0,0,'',NULL,2,1),(4941,2,16,27,0,60,0,0,'',NULL,3,1),(4942,2,16,27,0,61,0,0,'',NULL,3,1),(4943,2,16,27,0,62,0,0,'',NULL,3,1),(4944,2,16,27,0,63,0,0,'',NULL,3,1),(4945,2,16,27,0,64,0,0,'',NULL,3,1),(4946,2,16,27,0,65,0,0,'',NULL,3,1),(4947,2,16,27,0,66,0,0,'',NULL,3,1),(4948,2,16,27,0,67,0,0,'',NULL,3,1),(4949,2,16,27,0,68,0,0,'',NULL,3,1),(4950,2,16,27,0,69,0,0,'',NULL,3,1),(4951,2,16,27,0,70,0,0,'',NULL,3,1),(4952,2,16,27,0,71,0,0,'',NULL,3,1),(4953,2,16,27,0,72,0,0,'',NULL,3,1),(4954,2,16,27,0,73,0,0,'',NULL,3,1),(4955,2,16,27,0,74,0,0,'',NULL,3,1),(4956,2,16,27,0,75,0,0,'',NULL,3,1),(4957,2,16,27,0,76,0,0,'',NULL,3,1),(4958,2,16,27,0,77,0,0,'',NULL,3,1),(4959,2,16,27,0,78,0,0,'',NULL,3,1),(4960,2,16,27,0,79,0,0,'',NULL,3,1),(4961,2,16,27,0,80,0,0,'',NULL,3,1),(4962,2,16,27,0,81,0,0,'',NULL,3,1),(4963,2,16,27,0,82,0,0,'',NULL,3,1),(4964,2,16,27,0,83,0,0,'',NULL,3,1),(4965,2,16,27,0,84,0,0,'',NULL,3,1),(4966,2,16,27,0,85,0,0,'',NULL,3,1),(4967,2,16,27,0,86,0,0,'',NULL,3,1),(4968,2,16,27,0,87,0,0,'',NULL,3,1),(4969,2,16,27,0,88,0,0,'',NULL,3,1),(4970,2,16,27,0,89,0,0,'',NULL,3,1),(4971,2,16,27,0,90,0,0,'',NULL,3,1),(4972,2,16,27,0,91,0,0,'',NULL,3,1),(4973,2,16,27,0,92,0,0,'',NULL,3,1),(4974,2,16,27,0,93,0,0,'',NULL,3,1),(4975,2,16,27,0,94,0,0,'',NULL,3,1),(4976,2,16,27,0,95,0,0,'',NULL,3,1),(4977,2,16,27,0,96,0,0,'',NULL,3,1),(4978,2,16,27,0,97,0,0,'',NULL,3,1),(4979,2,16,27,0,98,0,0,'',NULL,3,1),(4980,2,16,27,0,99,0,0,'',NULL,3,1),(4981,2,16,27,0,100,0,0,'',NULL,3,1),(4982,2,16,27,0,101,0,0,'',NULL,3,1),(4983,2,16,27,0,102,0,0,'',NULL,3,1),(4984,2,16,27,0,103,0,0,'',NULL,3,1),(4985,2,16,27,0,104,0,0,'',NULL,3,1),(4986,2,16,27,0,105,0,0,'',NULL,3,1),(4987,2,16,27,0,106,0,0,'',NULL,3,1),(4988,2,16,27,0,107,0,0,'',NULL,3,1),(4989,2,16,27,0,108,0,0,'',NULL,3,1),(4990,2,16,27,0,109,0,0,'',NULL,3,1),(4991,2,16,27,0,110,0,0,'',NULL,3,1),(4992,2,16,27,0,111,0,0,'',NULL,3,1),(4993,2,16,27,0,112,0,0,'',NULL,3,1),(4994,2,16,27,0,113,0,0,'',NULL,3,1),(4995,2,16,27,0,114,0,0,'',NULL,3,1),(4996,2,16,27,0,115,0,0,'',NULL,3,1),(4997,2,16,27,0,116,0,0,'',NULL,3,1),(4998,2,16,27,0,117,0,0,'',NULL,3,1),(4999,2,16,27,0,118,0,0,'',NULL,3,1),(5000,2,16,27,0,119,0,0,'',NULL,3,1),(5001,2,16,27,0,120,0,0,'',NULL,3,1),(5002,2,16,27,0,121,0,0,'',NULL,3,1),(5003,2,16,27,0,122,0,0,'',NULL,3,1),(5004,2,16,27,0,123,0,0,'',NULL,3,1),(5005,2,16,27,0,124,0,0,'',NULL,3,1),(5006,2,16,27,0,125,0,0,'',NULL,3,1),(5007,2,16,27,0,126,0,0,'',NULL,3,1),(5008,2,16,27,0,127,0,0,'',NULL,3,1),(5009,2,16,27,0,128,0,0,'',NULL,3,1),(5010,2,16,27,0,129,0,0,'',NULL,3,1),(5011,2,16,27,0,130,0,0,'',NULL,3,1),(5012,2,16,27,0,131,0,0,'',NULL,3,1),(5013,2,16,27,0,132,0,0,'',NULL,3,1),(5014,2,16,27,0,133,0,0,'',NULL,3,1),(5015,2,16,27,0,134,0,0,'',NULL,3,1),(5016,2,16,27,0,135,0,0,'',NULL,3,1),(5017,2,16,27,0,136,0,0,'',NULL,3,1),(5018,2,16,27,0,137,0,0,'',NULL,3,1),(5019,2,16,27,0,138,0,0,'',NULL,3,1),(5020,2,16,27,0,139,0,0,'',NULL,3,1),(5021,2,16,27,0,140,0,0,'',NULL,3,1),(5022,2,16,27,0,141,0,0,'',NULL,3,1),(5023,2,16,27,0,142,0,0,'',NULL,3,1),(5024,2,16,27,0,143,0,0,'',NULL,3,1),(5025,2,16,27,0,144,0,0,'',NULL,3,1),(5026,2,16,27,0,145,0,0,'',NULL,3,1),(5027,2,16,27,0,146,0,0,'',NULL,3,1),(5028,2,16,27,0,147,0,0,'',NULL,3,1),(5029,2,16,27,0,148,0,0,'',NULL,3,1),(5030,2,16,27,0,149,0,0,'',NULL,3,1),(5031,2,16,27,0,150,0,0,'',NULL,3,1),(5032,2,16,27,0,151,0,0,'',NULL,3,1),(5033,2,16,27,0,152,0,0,'',NULL,3,1),(5034,2,16,27,0,153,0,0,'',NULL,3,1),(5035,2,16,27,0,154,0,0,'',NULL,3,1),(5036,2,16,27,0,155,0,0,'',NULL,3,1),(5037,2,16,27,0,156,0,0,'',NULL,3,1),(5038,2,16,27,0,157,0,0,'',NULL,3,1),(5039,2,16,27,0,158,0,0,'',NULL,3,1),(5040,2,16,27,0,159,0,0,'',NULL,3,1),(5041,2,16,27,0,160,0,0,'',NULL,3,1),(5042,2,16,27,0,161,0,0,'',NULL,3,1),(5043,2,16,27,0,162,0,0,'',NULL,3,1),(5044,2,16,27,0,163,0,0,'',NULL,3,1),(5045,2,16,27,0,164,0,0,'',NULL,3,1),(5046,2,16,27,0,165,0,0,'',NULL,3,1),(5047,2,16,27,0,166,0,0,'',NULL,3,1),(5048,2,16,27,0,167,0,0,'',NULL,3,1),(5049,2,16,27,0,168,0,0,'',NULL,3,1),(5050,2,16,27,0,169,0,0,'',NULL,3,1),(5051,2,16,27,0,170,0,0,'',NULL,3,1),(5052,2,16,27,0,171,0,0,'',NULL,3,1),(5053,2,16,27,0,172,0,0,'',NULL,3,1),(5054,2,16,27,0,173,0,0,'',NULL,3,1),(5055,2,16,27,0,174,0,0,'',NULL,3,1),(5056,2,16,27,0,175,0,0,'',NULL,3,1),(5057,2,16,27,0,176,0,0,'',NULL,3,1),(5058,2,16,27,0,177,0,0,'',NULL,3,1),(5059,2,16,27,0,178,0,0,'',NULL,3,1),(5060,2,16,27,0,179,0,0,'',NULL,3,1),(5061,2,16,27,0,180,0,0,'',NULL,3,1),(5062,2,16,27,0,181,0,0,'',NULL,3,1),(5063,2,16,27,0,182,0,0,'',NULL,3,1),(5064,2,16,27,0,183,0,0,'',NULL,3,1),(5065,2,16,27,0,184,0,0,'',NULL,3,1),(5066,2,16,27,0,185,0,0,'',NULL,3,1),(5067,2,16,27,0,186,0,0,'',NULL,3,1),(5068,2,16,27,0,187,0,0,'',NULL,3,1),(5069,2,16,27,0,188,0,0,'',NULL,3,1),(5070,2,16,27,0,189,0,0,'',NULL,3,1),(5071,2,16,27,0,190,0,0,'',NULL,3,1),(5072,2,16,27,0,191,0,0,'',NULL,3,1),(5073,2,16,27,0,192,0,0,'',NULL,3,1),(5074,2,16,27,0,193,0,0,'',NULL,3,1),(5075,2,16,27,0,194,0,0,'',NULL,3,1),(5076,2,16,27,0,195,0,0,'',NULL,3,1),(5077,2,16,27,0,196,0,0,'',NULL,3,1),(5078,2,16,27,0,197,0,0,'',NULL,3,1),(5079,2,16,27,0,198,0,0,'',NULL,3,1),(5080,2,16,27,0,199,0,0,'',NULL,3,1),(5081,2,16,27,0,200,0,0,'',NULL,3,1),(5082,2,16,27,0,201,0,0,'',NULL,3,1),(5083,2,16,27,0,202,0,0,'',NULL,3,1),(5084,2,16,27,0,203,0,0,'',NULL,3,1),(5085,2,16,27,0,204,0,0,'',NULL,3,1),(5086,2,16,27,0,205,0,0,'',NULL,3,1),(5087,2,16,27,0,206,0,0,'',NULL,3,1),(5088,2,16,27,0,207,0,0,'',NULL,3,1),(5089,1,17,28,0,1,0,0,'',NULL,1,1),(5090,1,17,28,0,2,0,0,'',NULL,1,1),(5091,1,17,28,0,3,0,0,'',NULL,1,1),(5092,1,17,28,0,4,0,0,'',NULL,1,1),(5093,1,17,28,0,5,0,0,'',NULL,1,1),(5094,1,17,28,0,6,0,0,'',NULL,1,1),(5095,1,17,28,0,7,0,0,'',NULL,1,1),(5096,1,17,28,0,8,0,0,'',NULL,1,1),(5097,1,17,28,0,9,0,0,'',NULL,1,1),(5098,1,17,28,0,10,0,0,'',NULL,1,1),(5099,1,17,28,0,11,0,0,'',NULL,1,1),(5100,1,17,28,0,12,0,0,'',NULL,1,1),(5101,1,17,28,0,13,0,0,'',NULL,1,1),(5102,1,17,28,0,14,0,0,'',NULL,1,1),(5103,1,17,28,0,15,0,0,'',NULL,2,1),(5104,1,17,28,0,16,0,0,'',NULL,2,1),(5105,1,17,28,0,17,0,0,'',NULL,2,1),(5106,1,17,28,0,18,0,0,'',NULL,2,1),(5107,1,17,28,0,19,0,0,'',NULL,2,1),(5108,1,17,28,0,20,0,0,'',NULL,2,1),(5109,1,17,28,0,21,0,0,'',NULL,2,1),(5110,1,17,28,0,22,0,0,'',NULL,2,1),(5111,1,17,28,0,23,0,0,'',NULL,2,1),(5112,1,17,28,0,24,0,0,'',NULL,2,1),(5113,1,17,28,0,25,0,0,'',NULL,2,1),(5114,1,17,28,0,26,0,0,'',NULL,2,1),(5115,1,17,28,0,27,0,0,'',NULL,2,1),(5116,1,17,28,0,28,0,0,'',NULL,2,1),(5117,1,17,28,0,29,0,0,'',NULL,2,1),(5118,1,17,28,0,30,0,0,'',NULL,2,1),(5119,1,17,28,0,31,0,0,'',NULL,2,1),(5120,1,17,28,0,32,0,0,'',NULL,2,1),(5121,1,17,28,0,33,0,0,'',NULL,2,1),(5122,1,17,28,0,34,0,0,'',NULL,2,1),(5123,1,17,28,0,35,0,0,'',NULL,2,1),(5124,1,17,28,0,36,0,0,'',NULL,2,1),(5125,1,17,28,0,37,0,0,'',NULL,2,1),(5126,1,17,28,0,38,0,0,'',NULL,2,1),(5127,1,17,28,0,39,0,0,'',NULL,2,1),(5128,1,17,28,0,40,0,0,'',NULL,2,1),(5129,1,17,28,0,41,0,0,'',NULL,2,1),(5130,1,17,28,0,42,0,0,'',NULL,2,1),(5131,1,17,28,0,43,0,0,'',NULL,2,1),(5132,1,17,28,0,44,0,0,'',NULL,2,1),(5133,1,17,28,0,45,0,0,'',NULL,2,1),(5134,1,17,28,0,46,0,0,'',NULL,2,1),(5135,1,17,28,0,47,0,0,'',NULL,2,1),(5136,1,17,28,0,48,0,0,'',NULL,2,1),(5137,1,17,28,0,49,0,0,'',NULL,2,1),(5138,1,17,28,0,50,0,0,'',NULL,2,1),(5139,1,17,28,0,51,0,0,'',NULL,2,1),(5140,1,17,28,0,52,0,0,'',NULL,2,1),(5141,1,17,28,0,53,0,0,'',NULL,2,1),(5142,1,17,28,0,54,0,0,'',NULL,2,1),(5143,1,17,28,0,55,0,0,'',NULL,2,1),(5144,1,17,28,0,56,0,0,'',NULL,2,1),(5145,1,17,28,0,57,0,0,'',NULL,2,1),(5146,1,17,28,0,58,0,0,'',NULL,2,1),(5147,1,17,28,0,59,0,0,'',NULL,2,1),(5148,1,17,28,0,60,0,0,'',NULL,3,1),(5149,1,17,28,0,61,0,0,'',NULL,3,1),(5150,1,17,28,0,62,0,0,'',NULL,3,1),(5151,1,17,28,0,63,0,0,'',NULL,3,1),(5152,1,17,28,0,64,0,0,'',NULL,3,1),(5153,1,17,28,0,65,0,0,'',NULL,3,1),(5154,1,17,28,0,66,0,0,'',NULL,3,1),(5155,1,17,28,0,67,0,0,'',NULL,3,1),(5156,1,17,28,0,68,0,0,'',NULL,3,1),(5157,1,17,28,0,69,0,0,'',NULL,3,1),(5158,1,17,28,0,70,0,0,'',NULL,3,1),(5159,1,17,28,0,71,0,0,'',NULL,3,1),(5160,1,17,28,0,72,0,0,'',NULL,3,1),(5161,1,17,28,0,73,0,0,'',NULL,3,1),(5162,1,17,28,0,74,0,0,'',NULL,3,1),(5163,1,17,28,0,75,0,0,'',NULL,3,1),(5164,1,17,28,0,76,0,0,'',NULL,3,1),(5165,1,17,28,0,77,0,0,'',NULL,3,1),(5166,1,17,28,0,78,0,0,'',NULL,3,1),(5167,1,17,28,0,79,0,0,'',NULL,3,1),(5168,1,17,28,0,80,0,0,'',NULL,3,1),(5169,1,17,28,0,81,0,0,'',NULL,3,1),(5170,1,17,28,0,82,0,0,'',NULL,3,1),(5171,1,17,28,0,83,0,0,'',NULL,3,1),(5172,1,17,28,0,84,0,0,'',NULL,3,1),(5173,1,17,28,0,85,0,0,'',NULL,3,1),(5174,1,17,28,0,86,0,0,'',NULL,3,1),(5175,1,17,28,0,87,0,0,'',NULL,3,1),(5176,1,17,28,0,88,0,0,'',NULL,3,1),(5177,1,17,28,0,89,0,0,'',NULL,3,1),(5178,1,17,28,0,90,0,0,'',NULL,3,1),(5179,1,17,28,0,91,0,0,'',NULL,3,1),(5180,1,17,28,0,92,0,0,'',NULL,3,1),(5181,1,17,28,0,93,0,0,'',NULL,3,1),(5182,1,17,28,0,94,0,0,'',NULL,3,1),(5183,1,17,28,0,95,0,0,'',NULL,3,1),(5184,1,17,28,0,96,0,0,'',NULL,3,1),(5185,1,17,28,0,97,0,0,'',NULL,3,1),(5186,1,17,28,0,98,0,0,'',NULL,3,1),(5187,1,17,28,0,99,0,0,'',NULL,3,1),(5188,1,17,28,0,100,0,0,'',NULL,3,1),(5189,1,17,28,0,101,0,0,'',NULL,3,1),(5190,1,17,28,0,102,0,0,'',NULL,3,1),(5191,1,17,28,0,103,0,0,'',NULL,3,1),(5192,1,17,28,0,104,0,0,'',NULL,3,1),(5193,1,17,28,0,105,0,0,'',NULL,3,1),(5194,1,17,28,0,106,0,0,'',NULL,3,1),(5195,1,17,28,0,107,0,0,'',NULL,3,1),(5196,1,17,28,0,108,0,0,'',NULL,3,1),(5197,1,17,28,0,109,0,0,'',NULL,3,1),(5198,1,17,28,0,110,0,0,'',NULL,3,1),(5199,1,17,28,0,111,0,0,'',NULL,3,1),(5200,1,17,28,0,112,0,0,'',NULL,3,1),(5201,1,17,28,0,113,0,0,'',NULL,3,1),(5202,1,17,28,0,114,0,0,'',NULL,3,1),(5203,1,17,28,0,115,0,0,'',NULL,3,1),(5204,1,17,28,0,116,0,0,'',NULL,3,1),(5205,1,17,28,0,117,0,0,'',NULL,3,1),(5206,1,17,28,0,118,0,0,'',NULL,3,1),(5207,1,17,28,0,119,0,0,'',NULL,3,1),(5208,1,17,28,0,120,0,0,'',NULL,3,1),(5209,1,17,28,0,121,0,0,'',NULL,3,1),(5210,1,17,28,0,122,0,0,'',NULL,3,1),(5211,1,17,28,0,123,0,0,'',NULL,3,1),(5212,1,17,28,0,124,0,0,'',NULL,3,1),(5213,1,17,28,0,125,0,0,'',NULL,3,1),(5214,1,17,28,0,126,0,0,'',NULL,3,1),(5215,1,17,28,0,127,0,0,'',NULL,3,1),(5216,1,17,28,0,128,0,0,'',NULL,3,1),(5217,1,17,28,0,129,0,0,'',NULL,3,1),(5218,1,17,28,0,130,0,0,'',NULL,3,1),(5219,1,17,28,0,131,0,0,'',NULL,3,1),(5220,1,17,28,0,132,0,0,'',NULL,3,1),(5221,1,17,28,0,133,0,0,'',NULL,3,1),(5222,1,17,28,0,134,0,0,'',NULL,3,1),(5223,1,17,28,0,135,0,0,'',NULL,3,1),(5224,1,17,28,0,136,0,0,'',NULL,3,1),(5225,1,17,28,0,137,0,0,'',NULL,3,1),(5226,1,17,28,0,138,0,0,'',NULL,3,1),(5227,1,17,28,0,139,0,0,'',NULL,3,1),(5228,1,17,28,0,140,0,0,'',NULL,3,1),(5229,1,17,28,0,141,0,0,'',NULL,3,1),(5230,1,17,28,0,142,0,0,'',NULL,3,1),(5231,1,17,28,0,143,0,0,'',NULL,3,1),(5232,1,17,28,0,144,0,0,'',NULL,3,1),(5233,1,17,28,0,145,0,0,'',NULL,3,1),(5234,1,17,28,0,146,0,0,'',NULL,3,1),(5235,1,17,28,0,147,0,0,'',NULL,3,1),(5236,1,17,28,0,148,0,0,'',NULL,3,1),(5237,1,17,28,0,149,0,0,'',NULL,3,1),(5238,1,17,28,0,150,0,0,'',NULL,3,1),(5239,1,17,28,0,151,0,0,'',NULL,3,1),(5240,1,17,28,0,152,0,0,'',NULL,3,1),(5241,1,17,28,0,153,0,0,'',NULL,3,1),(5242,1,17,28,0,154,0,0,'',NULL,3,1),(5243,1,17,28,0,155,0,0,'',NULL,3,1),(5244,1,17,28,0,156,0,0,'',NULL,3,1),(5245,1,17,28,0,157,0,0,'',NULL,3,1),(5246,1,17,28,0,158,0,0,'',NULL,3,1),(5247,1,17,28,0,159,0,0,'',NULL,3,1),(5248,1,17,28,0,160,0,0,'',NULL,3,1),(5249,1,17,28,0,161,0,0,'',NULL,3,1),(5250,1,17,28,0,162,0,0,'',NULL,3,1),(5251,1,17,28,0,163,0,0,'',NULL,3,1),(5252,1,17,28,0,164,0,0,'',NULL,3,1),(5253,1,17,28,0,165,0,0,'',NULL,3,1),(5254,1,17,28,0,166,0,0,'',NULL,3,1),(5255,1,17,28,0,167,0,0,'',NULL,3,1),(5256,1,17,28,0,168,0,0,'',NULL,3,1),(5257,1,17,28,0,169,0,0,'',NULL,3,1),(5258,1,17,28,0,170,0,0,'',NULL,3,1),(5259,1,17,28,0,171,0,0,'',NULL,3,1),(5260,1,17,28,0,172,0,0,'',NULL,3,1),(5261,1,17,28,0,173,0,0,'',NULL,3,1),(5262,1,17,28,0,174,0,0,'',NULL,3,1),(5263,1,17,28,0,175,0,0,'',NULL,3,1),(5264,1,17,28,0,176,0,0,'',NULL,3,1),(5265,1,17,28,0,177,0,0,'',NULL,3,1),(5266,1,17,28,0,178,0,0,'',NULL,3,1),(5267,1,17,28,0,179,0,0,'',NULL,3,1),(5268,1,17,28,0,180,0,0,'',NULL,3,1),(5269,1,17,28,0,181,0,0,'',NULL,3,1),(5270,1,17,28,0,182,0,0,'',NULL,3,1),(5271,1,17,28,0,183,0,0,'',NULL,3,1),(5272,1,17,28,0,184,0,0,'',NULL,3,1),(5273,1,17,28,0,185,0,0,'',NULL,3,1),(5274,1,17,28,0,186,0,0,'',NULL,3,1),(5275,1,17,28,0,187,0,0,'',NULL,3,1),(5276,1,17,28,0,188,0,0,'',NULL,3,1),(5277,1,17,28,0,189,0,0,'',NULL,3,1),(5278,1,17,28,0,190,0,0,'',NULL,3,1),(5279,1,17,28,0,191,0,0,'',NULL,3,1),(5280,1,17,28,0,192,0,0,'',NULL,3,1),(5281,1,17,28,0,193,0,0,'',NULL,3,1),(5282,1,17,28,0,194,0,0,'',NULL,3,1),(5283,1,17,28,0,195,0,0,'',NULL,3,1),(5284,1,17,28,0,196,0,0,'',NULL,3,1),(5285,1,17,28,0,197,0,0,'',NULL,3,1),(5286,1,17,28,0,198,0,0,'',NULL,3,1),(5287,1,17,28,0,199,0,0,'',NULL,3,1),(5288,1,17,28,0,200,0,0,'',NULL,3,1),(5289,1,17,28,0,201,0,0,'',NULL,3,1),(5290,1,17,28,0,202,0,0,'',NULL,3,1),(5291,1,17,28,0,203,0,0,'',NULL,3,1),(5292,1,17,28,0,204,0,0,'',NULL,3,1),(5293,1,17,28,0,205,0,0,'',NULL,3,1),(5294,1,17,28,0,206,0,0,'',NULL,3,1),(5295,1,17,28,0,207,0,0,'',NULL,3,1),(5296,1,17,29,0,1,0,0,'',NULL,1,1),(5297,1,17,29,0,2,0,0,'',NULL,1,1),(5298,1,17,29,0,3,0,0,'',NULL,1,1),(5299,1,17,29,0,4,0,0,'',NULL,1,1),(5300,1,17,29,0,5,0,0,'',NULL,1,1),(5301,1,17,29,0,6,0,0,'',NULL,1,1),(5302,1,17,29,0,7,0,0,'',NULL,1,1),(5303,1,17,29,0,8,0,0,'',NULL,1,1),(5304,1,17,29,0,9,0,0,'',NULL,1,1),(5305,1,17,29,0,10,0,0,'',NULL,1,1),(5306,1,17,29,0,11,0,0,'',NULL,1,1),(5307,1,17,29,0,12,0,0,'',NULL,1,1),(5308,1,17,29,0,13,0,0,'',NULL,1,1),(5309,1,17,29,0,14,0,0,'',NULL,1,1),(5310,1,17,29,0,15,0,0,'',NULL,2,1),(5311,1,17,29,0,16,0,0,'',NULL,2,1),(5312,1,17,29,0,17,0,0,'',NULL,2,1),(5313,1,17,29,0,18,0,0,'',NULL,2,1),(5314,1,17,29,0,19,0,0,'',NULL,2,1),(5315,1,17,29,0,20,0,0,'',NULL,2,1),(5316,1,17,29,0,21,0,0,'',NULL,2,1),(5317,1,17,29,0,22,0,0,'',NULL,2,1),(5318,1,17,29,0,23,0,0,'',NULL,2,1),(5319,1,17,29,0,24,0,0,'',NULL,2,1),(5320,1,17,29,0,25,0,0,'',NULL,2,1),(5321,1,17,29,0,26,0,0,'',NULL,2,1),(5322,1,17,29,0,27,0,0,'',NULL,2,1),(5323,1,17,29,0,28,0,0,'',NULL,2,1),(5324,1,17,29,0,29,0,0,'',NULL,2,1),(5325,1,17,29,0,30,0,0,'',NULL,2,1),(5326,1,17,29,0,31,0,0,'',NULL,2,1),(5327,1,17,29,0,32,0,0,'',NULL,2,1),(5328,1,17,29,0,33,0,0,'',NULL,2,1),(5329,1,17,29,0,34,0,0,'',NULL,2,1),(5330,1,17,29,0,35,0,0,'',NULL,2,1),(5331,1,17,29,0,36,0,0,'',NULL,2,1),(5332,1,17,29,0,37,0,0,'',NULL,2,1),(5333,1,17,29,0,38,0,0,'',NULL,2,1),(5334,1,17,29,0,39,0,0,'',NULL,2,1),(5335,1,17,29,0,40,0,0,'',NULL,2,1),(5336,1,17,29,0,41,0,0,'',NULL,2,1),(5337,1,17,29,0,42,0,0,'',NULL,2,1),(5338,1,17,29,0,43,0,0,'',NULL,2,1),(5339,1,17,29,0,44,0,0,'',NULL,2,1),(5340,1,17,29,0,45,0,0,'',NULL,2,1),(5341,1,17,29,0,46,0,0,'',NULL,2,1),(5342,1,17,29,0,47,0,0,'',NULL,2,1),(5343,1,17,29,0,48,0,0,'',NULL,2,1),(5344,1,17,29,0,49,0,0,'',NULL,2,1),(5345,1,17,29,0,50,0,0,'',NULL,2,1),(5346,1,17,29,0,51,0,0,'',NULL,2,1),(5347,1,17,29,0,52,0,0,'',NULL,2,1),(5348,1,17,29,0,53,0,0,'',NULL,2,1),(5349,1,17,29,0,54,0,0,'',NULL,2,1),(5350,1,17,29,0,55,0,0,'',NULL,2,1),(5351,1,17,29,0,56,0,0,'',NULL,2,1),(5352,1,17,29,0,57,0,0,'',NULL,2,1),(5353,1,17,29,0,58,0,0,'',NULL,2,1),(5354,1,17,29,0,59,0,0,'',NULL,2,1),(5355,1,17,29,0,60,0,0,'',NULL,3,1),(5356,1,17,29,0,61,0,0,'',NULL,3,1),(5357,1,17,29,0,62,0,0,'',NULL,3,1),(5358,1,17,29,0,63,0,0,'',NULL,3,1),(5359,1,17,29,0,64,0,0,'',NULL,3,1),(5360,1,17,29,0,65,0,0,'',NULL,3,1),(5361,1,17,29,0,66,0,0,'',NULL,3,1),(5362,1,17,29,0,67,0,0,'',NULL,3,1),(5363,1,17,29,0,68,0,0,'',NULL,3,1),(5364,1,17,29,0,69,0,0,'',NULL,3,1),(5365,1,17,29,0,70,0,0,'',NULL,3,1),(5366,1,17,29,0,71,0,0,'',NULL,3,1),(5367,1,17,29,0,72,0,0,'',NULL,3,1),(5368,1,17,29,0,73,0,0,'',NULL,3,1),(5369,1,17,29,0,74,0,0,'',NULL,3,1),(5370,1,17,29,0,75,0,0,'',NULL,3,1),(5371,1,17,29,0,76,0,0,'',NULL,3,1),(5372,1,17,29,0,77,0,0,'',NULL,3,1),(5373,1,17,29,0,78,0,0,'',NULL,3,1),(5374,1,17,29,0,79,0,0,'',NULL,3,1),(5375,1,17,29,0,80,0,0,'',NULL,3,1),(5376,1,17,29,0,81,0,0,'',NULL,3,1),(5377,1,17,29,0,82,0,0,'',NULL,3,1),(5378,1,17,29,0,83,0,0,'',NULL,3,1),(5379,1,17,29,0,84,0,0,'',NULL,3,1),(5380,1,17,29,0,85,0,0,'',NULL,3,1),(5381,1,17,29,0,86,0,0,'',NULL,3,1),(5382,1,17,29,0,87,0,0,'',NULL,3,1),(5383,1,17,29,0,88,0,0,'',NULL,3,1),(5384,1,17,29,0,89,0,0,'',NULL,3,1),(5385,1,17,29,0,90,0,0,'',NULL,3,1),(5386,1,17,29,0,91,0,0,'',NULL,3,1),(5387,1,17,29,0,92,0,0,'',NULL,3,1),(5388,1,17,29,0,93,0,0,'',NULL,3,1),(5389,1,17,29,0,94,0,0,'',NULL,3,1),(5390,1,17,29,0,95,0,0,'',NULL,3,1),(5391,1,17,29,0,96,0,0,'',NULL,3,1),(5392,1,17,29,0,97,0,0,'',NULL,3,1),(5393,1,17,29,0,98,0,0,'',NULL,3,1),(5394,1,17,29,0,99,0,0,'',NULL,3,1),(5395,1,17,29,0,100,0,0,'',NULL,3,1),(5396,1,17,29,0,101,0,0,'',NULL,3,1),(5397,1,17,29,0,102,0,0,'',NULL,3,1),(5398,1,17,29,0,103,0,0,'',NULL,3,1),(5399,1,17,29,0,104,0,0,'',NULL,3,1),(5400,1,17,29,0,105,0,0,'',NULL,3,1),(5401,1,17,29,0,106,0,0,'',NULL,3,1),(5402,1,17,29,0,107,0,0,'',NULL,3,1),(5403,1,17,29,0,108,0,0,'',NULL,3,1),(5404,1,17,29,0,109,0,0,'',NULL,3,1),(5405,1,17,29,0,110,0,0,'',NULL,3,1),(5406,1,17,29,0,111,0,0,'',NULL,3,1),(5407,1,17,29,0,112,0,0,'',NULL,3,1),(5408,1,17,29,0,113,0,0,'',NULL,3,1),(5409,1,17,29,0,114,0,0,'',NULL,3,1),(5410,1,17,29,0,115,0,0,'',NULL,3,1),(5411,1,17,29,0,116,0,0,'',NULL,3,1),(5412,1,17,29,0,117,0,0,'',NULL,3,1),(5413,1,17,29,0,118,0,0,'',NULL,3,1),(5414,1,17,29,0,119,0,0,'',NULL,3,1),(5415,1,17,29,0,120,0,0,'',NULL,3,1),(5416,1,17,29,0,121,0,0,'',NULL,3,1),(5417,1,17,29,0,122,0,0,'',NULL,3,1),(5418,1,17,29,0,123,0,0,'',NULL,3,1),(5419,1,17,29,0,124,0,0,'',NULL,3,1),(5420,1,17,29,0,125,0,0,'',NULL,3,1),(5421,1,17,29,0,126,0,0,'',NULL,3,1),(5422,1,17,29,0,127,0,0,'',NULL,3,1),(5423,1,17,29,0,128,0,0,'',NULL,3,1),(5424,1,17,29,0,129,0,0,'',NULL,3,1),(5425,1,17,29,0,130,0,0,'',NULL,3,1),(5426,1,17,29,0,131,0,0,'',NULL,3,1),(5427,1,17,29,0,132,0,0,'',NULL,3,1),(5428,1,17,29,0,133,0,0,'',NULL,3,1),(5429,1,17,29,0,134,0,0,'',NULL,3,1),(5430,1,17,29,0,135,0,0,'',NULL,3,1),(5431,1,17,29,0,136,0,0,'',NULL,3,1),(5432,1,17,29,0,137,0,0,'',NULL,3,1),(5433,1,17,29,0,138,0,0,'',NULL,3,1),(5434,1,17,29,0,139,0,0,'',NULL,3,1),(5435,1,17,29,0,140,0,0,'',NULL,3,1),(5436,1,17,29,0,141,0,0,'',NULL,3,1),(5437,1,17,29,0,142,0,0,'',NULL,3,1),(5438,1,17,29,0,143,0,0,'',NULL,3,1),(5439,1,17,29,0,144,0,0,'',NULL,3,1),(5440,1,17,29,0,145,0,0,'',NULL,3,1),(5441,1,17,29,0,146,0,0,'',NULL,3,1),(5442,1,17,29,0,147,0,0,'',NULL,3,1),(5443,1,17,29,0,148,0,0,'',NULL,3,1),(5444,1,17,29,0,149,0,0,'',NULL,3,1),(5445,1,17,29,0,150,0,0,'',NULL,3,1),(5446,1,17,29,0,151,0,0,'',NULL,3,1),(5447,1,17,29,0,152,0,0,'',NULL,3,1),(5448,1,17,29,0,153,0,0,'',NULL,3,1),(5449,1,17,29,0,154,0,0,'',NULL,3,1),(5450,1,17,29,0,155,0,0,'',NULL,3,1),(5451,1,17,29,0,156,0,0,'',NULL,3,1),(5452,1,17,29,0,157,0,0,'',NULL,3,1),(5453,1,17,29,0,158,0,0,'',NULL,3,1),(5454,1,17,29,0,159,0,0,'',NULL,3,1),(5455,1,17,29,0,160,0,0,'',NULL,3,1),(5456,1,17,29,0,161,0,0,'',NULL,3,1),(5457,1,17,29,0,162,0,0,'',NULL,3,1),(5458,1,17,29,0,163,0,0,'',NULL,3,1),(5459,1,17,29,0,164,0,0,'',NULL,3,1),(5460,1,17,29,0,165,0,0,'',NULL,3,1),(5461,1,17,29,0,166,0,0,'',NULL,3,1),(5462,1,17,29,0,167,0,0,'',NULL,3,1),(5463,1,17,29,0,168,0,0,'',NULL,3,1),(5464,1,17,29,0,169,0,0,'',NULL,3,1),(5465,1,17,29,0,170,0,0,'',NULL,3,1),(5466,1,17,29,0,171,0,0,'',NULL,3,1),(5467,1,17,29,0,172,0,0,'',NULL,3,1),(5468,1,17,29,0,173,0,0,'',NULL,3,1),(5469,1,17,29,0,174,0,0,'',NULL,3,1),(5470,1,17,29,0,175,0,0,'',NULL,3,1),(5471,1,17,29,0,176,0,0,'',NULL,3,1),(5472,1,17,29,0,177,0,0,'',NULL,3,1),(5473,1,17,29,0,178,0,0,'',NULL,3,1),(5474,1,17,29,0,179,0,0,'',NULL,3,1),(5475,1,17,29,0,180,0,0,'',NULL,3,1),(5476,1,17,29,0,181,0,0,'',NULL,3,1),(5477,1,17,29,0,182,0,0,'',NULL,3,1),(5478,1,17,29,0,183,0,0,'',NULL,3,1),(5479,1,17,29,0,184,0,0,'',NULL,3,1),(5480,1,17,29,0,185,0,0,'',NULL,3,1),(5481,1,17,29,0,186,0,0,'',NULL,3,1),(5482,1,17,29,0,187,0,0,'',NULL,3,1),(5483,1,17,29,0,188,0,0,'',NULL,3,1),(5484,1,17,29,0,189,0,0,'',NULL,3,1),(5485,1,17,29,0,190,0,0,'',NULL,3,1),(5486,1,17,29,0,191,0,0,'',NULL,3,1),(5487,1,17,29,0,192,0,0,'',NULL,3,1),(5488,1,17,29,0,193,0,0,'',NULL,3,1),(5489,1,17,29,0,194,0,0,'',NULL,3,1),(5490,1,17,29,0,195,0,0,'',NULL,3,1),(5491,1,17,29,0,196,0,0,'',NULL,3,1),(5492,1,17,29,0,197,0,0,'',NULL,3,1),(5493,1,17,29,0,198,0,0,'',NULL,3,1),(5494,1,17,29,0,199,0,0,'',NULL,3,1),(5495,1,17,29,0,200,0,0,'',NULL,3,1),(5496,1,17,29,0,201,0,0,'',NULL,3,1),(5497,1,17,29,0,202,0,0,'',NULL,3,1),(5498,1,17,29,0,203,0,0,'',NULL,3,1),(5499,1,17,29,0,204,0,0,'',NULL,3,1),(5500,1,17,29,0,205,0,0,'',NULL,3,1),(5501,1,17,29,0,206,0,0,'',NULL,3,1),(5502,1,17,29,0,207,0,0,'',NULL,3,1),(5503,4,18,30,0,1,5,5,'','Allen',1,1),(5504,4,18,30,0,2,4,4,'','Allen',1,1),(5505,4,18,30,0,3,3,3,'','Allen',1,1),(5506,4,18,30,0,4,1,1,'','Allen',1,1),(5507,4,18,30,0,5,1,1,'','Allen',1,1),(5508,4,18,30,0,6,5,5,'','Allen',1,1),(5509,4,18,30,0,7,1,1,'','Allen',1,1),(5510,4,18,30,0,8,1,1,'','Allen',1,1),(5511,4,18,30,0,9,5,5,'','Allen',1,1),(5512,4,18,30,0,10,3,3,'','Allen',1,1),(5513,4,18,30,0,11,5,5,'','Allen',1,1),(5514,4,18,30,0,12,3,3,'','Allen',1,1),(5515,4,18,30,0,13,3,3,'','Allen',1,1),(5516,4,18,30,0,14,5,5,'','Allen',1,1),(5517,4,18,30,0,15,1,1,'','Allen',2,1),(5518,4,18,30,0,16,1,1,'','Allen',2,1),(5519,4,18,30,0,17,5,5,'','Allen',2,1),(5520,4,18,30,0,18,5,5,'','Allen',2,1),(5521,4,18,30,0,19,5,5,'','Allen',2,1),(5522,4,18,30,0,20,5,5,'','Allen',2,1),(5523,4,18,30,0,21,5,5,'','Allen',2,1),(5524,4,18,30,0,22,5,0,'','Allen',2,1),(5525,4,18,30,0,23,5,5,'','Allen',2,1),(5526,4,18,30,0,24,4,4,'','Allen',2,1),(5527,4,18,30,0,25,4,4,'','Allen',2,1),(5528,4,18,30,0,26,1,1,'','Allen',2,1),(5529,4,18,30,0,27,2,2,'','Allen',2,1),(5530,4,18,30,0,28,2,2,'','Allen',2,1),(5531,4,18,30,0,29,3,3,'','Allen',2,1),(5532,4,18,30,0,30,1,0,'','Allen',2,1),(5533,4,18,30,0,31,1,0,'','Allen',2,1),(5534,4,18,30,0,32,5,0,'','Allen',2,1),(5535,4,18,30,0,33,1,1,'','Allen',2,1),(5536,4,18,30,0,34,1,1,'','Allen',2,1),(5537,4,18,30,0,35,1,1,'','Allen',2,1),(5538,4,18,30,0,36,1,1,'','Allen',2,1),(5539,4,18,30,0,37,5,5,'','Allen',2,1),(5540,4,18,30,0,38,1,1,'','Allen',2,1),(5541,4,18,30,0,39,1,1,'','Allen',2,1),(5542,4,18,30,0,40,5,5,'','Allen',2,1),(5543,4,18,30,0,41,5,5,'','Allen',2,1),(5544,4,18,30,0,42,5,5,'','Allen',2,1),(5545,4,18,30,0,43,5,5,'','Allen',2,1),(5546,4,18,30,0,44,3,3,'','Allen',2,1),(5547,4,18,30,0,45,5,5,'','Allen',2,1),(5548,4,18,30,0,46,5,5,'','Allen',2,1),(5549,4,18,30,0,47,5,5,'','Allen',2,1),(5550,4,18,30,0,48,3,3,'','Allen',2,1),(5551,4,18,30,0,49,5,5,'','Allen',2,1),(5552,4,18,30,0,50,3,3,'','Allen',2,1),(5553,4,18,30,0,51,3,3,'','Allen',2,1),(5554,4,18,30,0,52,2,2,'','Allen',2,1),(5555,4,18,30,0,53,3,3,'','Allen',2,1),(5556,4,18,30,0,54,5,5,'','Allen',2,1),(5557,4,18,30,0,55,1,1,'','Allen',2,1),(5558,4,18,30,0,56,5,4,'','Allen',2,1),(5559,4,18,30,0,57,3,3,'','Allen',2,1),(5560,4,18,30,0,58,1,1,'','Allen',2,1),(5561,4,18,30,0,59,3,3,'','Allen',2,1),(5562,4,18,30,0,60,1,1,'','Allen',3,1),(5563,4,18,30,0,61,1,1,'','Allen',3,1),(5564,4,18,30,0,62,3,2,'','Allen',3,1),(5565,4,18,30,0,63,5,5,'','Allen',3,1),(5566,4,18,30,0,64,1,1,'','Allen',3,1),(5567,4,18,30,0,65,3,3,'','Allen',3,1),(5568,4,18,30,0,66,5,5,'','Allen',3,1),(5569,4,18,30,0,67,1,1,'','Allen',3,1),(5570,4,18,30,0,68,1,1,'','Allen',3,1),(5571,4,18,30,0,69,1,1,'','Allen',3,1),(5572,4,18,30,0,70,5,5,'','Allen',3,1),(5573,4,18,30,0,71,1,1,'','Allen',3,1),(5574,4,18,30,0,72,3,3,'','Allen',3,1),(5575,4,18,30,0,73,5,5,'','Allen',3,1),(5576,4,18,30,0,74,1,1,'','Allen',3,1),(5577,4,18,30,0,75,5,5,'','Allen',3,1),(5578,4,18,30,0,76,1,1,'','Allen',3,1),(5579,4,18,30,0,77,5,5,'','Allen',3,1),(5580,4,18,30,0,78,1,1,'','Allen',3,1),(5581,4,18,30,0,79,1,1,'','Allen',3,1),(5582,4,18,30,0,80,5,5,'','Allen',3,1),(5583,4,18,30,0,81,5,5,'','Allen',3,1),(5584,4,18,30,0,82,5,5,'','Allen',3,1),(5585,4,18,30,0,83,1,1,'','Allen',3,1),(5586,4,18,30,0,84,5,5,'','Allen',3,1),(5587,4,18,30,0,85,1,1,'','Allen',3,1),(5588,4,18,30,0,86,5,5,'','Allen',3,1),(5589,4,18,30,0,87,5,5,'','Allen',3,1),(5590,4,18,30,0,88,1,1,'','Allen',3,1),(5591,4,18,30,0,89,1,1,'','Allen',3,1),(5592,4,18,30,0,90,5,5,'','Allen',3,1),(5593,4,18,30,0,91,1,1,'','Allen',3,1),(5594,4,18,30,0,92,1,1,'','Allen',3,1),(5595,4,18,30,0,93,5,5,'','Allen',3,1),(5596,4,18,30,0,94,1,1,'','Allen',3,1),(5597,4,18,30,0,95,5,5,'','Allen',3,1),(5598,4,18,30,0,96,1,1,'','Allen',3,1),(5599,4,18,30,0,97,1,1,'','Allen',3,1),(5600,4,18,30,0,98,1,1,'','Allen',3,1),(5601,4,18,30,0,99,5,5,'','Allen',3,1),(5602,4,18,30,0,100,5,5,'','Allen',3,1),(5603,4,18,30,0,101,1,1,'','Allen',3,1),(5604,4,18,30,0,102,5,5,'','Allen',3,1),(5605,4,18,30,0,103,1,1,'','Allen',3,1),(5606,4,18,30,0,104,1,1,'','Allen',3,1),(5607,4,18,30,0,105,1,1,'','Allen',3,1),(5608,4,18,30,0,106,1,1,'','Allen',3,1),(5609,4,18,30,0,107,1,1,'','Allen',3,1),(5610,4,18,30,0,108,1,1,'','Allen',3,1),(5611,4,18,30,0,109,1,1,'','Allen',3,1),(5612,4,18,30,0,110,1,1,'','Allen',3,1),(5613,4,18,30,0,111,1,1,'','Allen',3,1),(5614,4,18,30,0,112,5,5,'','Allen',3,1),(5615,4,18,30,0,113,1,1,'','Allen',3,1),(5616,4,18,30,0,114,5,5,'','Allen',3,1),(5617,4,18,30,0,115,5,5,'','Allen',3,1),(5618,4,18,30,0,116,5,5,'','Allen',3,1),(5619,4,18,30,0,117,5,5,'','Allen',3,1),(5620,4,18,30,0,118,5,5,'','Allen',3,1),(5621,4,18,30,0,119,5,5,'','Allen',3,1),(5622,4,18,30,0,120,1,1,'','Allen',3,1),(5623,4,18,30,0,121,5,5,'','Allen',3,1),(5624,4,18,30,0,122,5,5,'','Allen',3,1),(5625,4,18,30,0,123,3,3,'','Allen',3,1),(5626,4,18,30,0,124,1,1,'','Allen',3,1),(5627,4,18,30,0,125,5,5,'','Allen',3,1),(5628,4,18,30,0,126,5,5,'','Allen',3,1),(5629,4,18,30,0,127,5,5,'','Allen',3,1),(5630,4,18,30,0,128,5,5,'','Allen',3,1),(5631,4,18,30,0,129,5,5,'','Allen',3,1),(5632,4,18,30,0,130,5,5,'','Allen',3,1),(5633,4,18,30,0,131,1,1,'','Allen',3,1),(5634,4,18,30,0,132,1,1,'','Allen',3,1),(5635,4,18,30,0,133,1,1,'','Allen',3,1),(5636,4,18,30,0,134,1,1,'','Allen',3,1),(5637,4,18,30,0,135,5,5,'','Allen',3,1),(5638,4,18,30,0,136,1,1,'','Allen',3,1),(5639,4,18,30,0,137,1,1,'','Allen',3,1),(5640,4,18,30,0,138,1,1,'','Allen',3,1),(5641,4,18,30,0,139,1,1,'','Allen',3,1),(5642,4,18,30,0,140,1,1,'','Allen',3,1),(5643,4,18,30,0,141,5,5,'','Allen',3,1),(5644,4,18,30,0,142,1,1,'','Allen',3,1),(5645,4,18,30,0,143,2,2,'','Allen',3,1),(5646,4,18,30,0,144,2,2,'','Allen',3,1),(5647,4,18,30,0,145,3,3,'','Allen',3,1),(5648,4,18,30,0,146,2,2,'','Allen',3,1),(5649,4,18,30,0,147,1,1,'','Allen',3,1),(5650,4,18,30,0,148,5,5,'','Allen',3,1),(5651,4,18,30,0,149,2,2,'','Allen',3,1),(5652,4,18,30,0,150,3,3,'','Allen',3,1),(5653,4,18,30,0,151,5,5,'','Allen',3,1),(5654,4,18,30,0,152,5,5,'','Allen',3,1),(5655,4,18,30,0,153,1,1,'','Allen',3,1),(5656,4,18,30,0,154,5,5,'','Allen',3,1),(5657,4,18,30,0,155,1,1,'','Allen',3,1),(5658,4,18,30,0,156,5,5,'','Allen',3,1),(5659,4,18,30,0,157,5,5,'','Allen',3,1),(5660,4,18,30,0,158,5,5,'','Allen',3,1),(5661,4,18,30,0,159,3,3,'','Allen',3,1),(5662,4,18,30,0,160,5,5,'','Allen',3,1),(5663,4,18,30,0,161,3,3,'','Allen',3,1),(5664,4,18,30,0,162,5,5,'','Allen',3,1),(5665,4,18,30,0,163,5,5,'','Allen',3,1),(5666,4,18,30,0,164,3,3,'','Allen',3,1),(5667,4,18,30,0,165,3,3,'','Allen',3,1),(5668,4,18,30,0,166,3,3,'','Allen',3,1),(5669,4,18,30,0,167,5,5,'','Allen',3,1),(5670,4,18,30,0,168,5,5,'','Allen',3,1),(5671,4,18,30,0,169,1,1,'','Allen',3,1),(5672,4,18,30,0,170,5,5,'','Allen',3,1),(5673,4,18,30,0,171,5,5,'','Allen',3,1),(5674,4,18,30,0,172,5,5,'','Allen',3,1),(5675,4,18,30,0,173,5,5,'','Allen',3,1),(5676,4,18,30,0,174,1,1,'','Allen',3,1),(5677,4,18,30,0,175,1,1,'','Allen',3,1),(5678,4,18,30,0,176,1,1,'','Allen',3,1),(5679,4,18,30,0,177,5,5,'','Allen',3,1),(5680,4,18,30,0,178,5,5,'','Allen',3,1),(5681,4,18,30,0,179,4,0,'','Allen',3,1),(5682,4,18,30,0,180,1,1,'','Allen',3,1),(5683,4,18,30,0,181,3,3,'','Allen',3,1),(5684,4,18,30,0,182,1,1,'','Allen',3,1),(5685,4,18,30,0,183,3,3,'','Allen',3,1),(5686,4,18,30,0,184,3,3,'','Allen',3,1),(5687,4,18,30,0,185,3,3,'','Allen',3,1),(5688,4,18,30,0,186,3,3,'','Allen',3,1),(5689,4,18,30,0,187,3,3,'','Allen',3,1),(5690,4,18,30,0,188,5,5,'','Allen',3,1),(5691,4,18,30,0,189,3,3,'','Allen',3,1),(5692,4,18,30,0,190,5,5,'','Allen',3,1),(5693,4,18,30,0,191,5,5,'','Allen',3,1),(5694,4,18,30,0,192,5,5,'','Allen',3,1),(5695,4,18,30,0,193,5,5,'','Allen',3,1),(5696,4,18,30,0,194,3,3,'','Allen',3,1),(5697,4,18,30,0,195,3,3,'','Allen',3,1),(5698,4,18,30,0,196,5,5,'','Allen',3,1),(5699,4,18,30,0,197,3,3,'','Allen',3,1),(5700,4,18,30,0,198,5,5,'','Allen',3,1),(5701,4,18,30,0,199,5,5,'','Allen',3,1),(5702,4,18,30,0,200,5,5,'','Allen',3,1),(5703,4,18,30,0,201,3,3,'','Allen',3,1),(5704,4,18,30,0,202,5,5,'','Allen',3,1),(5705,4,18,30,0,203,3,3,'','Allen',3,1),(5706,4,18,30,0,204,3,3,'','Allen',3,1),(5707,4,18,30,0,205,5,5,'','Allen',3,1),(5708,4,18,30,0,206,3,3,'','Allen',3,1),(5709,4,18,30,0,207,3,3,'','Allen',3,1),(5710,0,0,0,0,180,1,0,'','Allen',0,0),(5711,0,0,0,0,181,3,0,'','Allen',0,0),(5712,0,0,0,0,182,1,0,'','Allen',0,0),(5713,0,0,0,0,183,0,0,'','Allen',0,0),(5714,0,0,0,0,184,3,0,'','Allen',0,0),(5715,0,0,0,0,185,3,0,'','Allen',0,0),(5716,0,0,0,0,186,3,0,'','Allen',0,0),(5717,0,0,0,0,187,3,0,'','Allen',0,0),(5718,0,0,0,0,188,5,0,'','Allen',0,0),(5719,0,0,0,0,189,3,0,'','Allen',0,0),(5720,0,0,0,0,190,5,0,'','Allen',0,0),(5721,0,0,0,0,191,5,0,'','Allen',0,0),(5722,0,0,0,0,192,5,0,'','Allen',0,0),(5723,0,0,0,0,193,5,0,'','Allen',0,0),(5724,0,0,0,0,194,3,0,'','Allen',0,0),(5725,0,0,0,0,195,3,0,'','Allen',0,0),(5726,0,0,0,0,196,5,0,'','Allen',0,0),(5727,0,0,0,0,197,3,0,'','Allen',0,0),(5728,0,0,0,0,198,5,0,'','Allen',0,0),(5729,0,0,0,0,199,5,0,'','Allen',0,0),(5730,0,0,0,0,200,5,0,'','Allen',0,0),(5731,0,0,0,0,201,3,0,'','Allen',0,0),(5732,0,0,0,0,202,5,0,'','Allen',0,0),(5733,0,0,0,0,203,3,0,'','Allen',0,0),(5734,0,0,0,0,204,3,0,'','Allen',0,0),(5735,0,0,0,0,205,5,0,'','Allen',0,0),(5736,0,0,0,0,206,5,0,'','Allen',0,0),(5737,0,0,0,0,207,3,0,'','Allen',0,0);
/*!40000 ALTER TABLE `question_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionnaire_type`
--

DROP TABLE IF EXISTS `questionnaire_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionnaire_type` (
  `question_type_id` int(11) NOT NULL,
  `question_type_name` varchar(100) NOT NULL,
  PRIMARY KEY (`question_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire_type`
--

LOCK TABLES `questionnaire_type` WRITE;
/*!40000 ALTER TABLE `questionnaire_type` DISABLE KEYS */;
INSERT INTO `questionnaire_type` VALUES (1,'Assessment Questionnaire'),(2,'Agile Questionnaire');
/*!40000 ALTER TABLE `questionnaire_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_master`
--

DROP TABLE IF EXISTS `role_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_master` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL,
  `isActive` tinyint(4) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_master`
--

LOCK TABLES `role_master` WRITE;
/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
INSERT INTO `role_master` VALUES (1,'Assessor',1),(2,'Lead Assessor',1);
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory_master`
--

DROP TABLE IF EXISTS `subcategory_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategory_master` (
  `subcategory_Id` int(11) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(100) NOT NULL,
  `active_flag` tinyint(4) NOT NULL,
  `subcategory_weightage` int(11) NOT NULL,
  `questionnaire_type_id` int(11) NOT NULL,
  PRIMARY KEY (`subcategory_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory_master`
--

LOCK TABLES `subcategory_master` WRITE;
/*!40000 ALTER TABLE `subcategory_master` DISABLE KEYS */;
INSERT INTO `subcategory_master` VALUES (1,'Initiation',1,30,1),(2,'Team SetUp',1,12,1),(3,'Requirements Management',1,21,1),(4,'Planning',1,1,1),(5,'Technical Design',1,21,1),(6,'UI/UX Design',1,1,1),(7,'Security Management',1,1,1),(8,'Estimation',1,1,1),(9,'IDE',1,1,1),(10,'Source Control',1,1,1),(11,'Code Quality Review',1,1,1),(12,'Unit Test',1,1,1),(13,'Functional Testing',1,1,1),(14,'Regression Testing',1,1,1),(15,'Performance Testing',1,1,1),(16,'UAT',1,1,1),(17,'Build Management',1,1,1),(18,'Deployment / Release Management',1,1,1),(19,'Incident Management',1,1,1),(20,'Service Request Management',1,1,1),(21,'Environment Provisioning',1,1,1),(22,'Infrastructure Configuration Management',1,1,1),(23,'Monitoring',1,1,1),(24,'Change Management',1,1,1),(25,'Task / Time Tracking',1,1,1),(26,'Productivity Tracking',1,1,1),(27,'Capacity Management',1,1,1),(28,'Knowledge Management',1,1,1),(29,'Dev Stds / Best Practices',1,1,1),(30,'Communication',1,1,1),(31,'Culture',1,1,1),(32,'Leadership',1,1,1),(33,'Planning',1,1,1),(34,'Dev Stds / Best Practices',1,1,1),(35,'UI/UX Design',1,1,1),(36,'Infrastructure Configuration Management',1,1,1),(37,'AHI',1,1,1),(38,'Predictable Velocity',1,1,2),(39,'Time to Market',1,1,2),(40,'Value Delivered',1,1,2),(41,'Quality',1,1,2),(42,'Response to change',1,1,2),(43,'Vision and Purpose',1,1,2),(44,'Measure of Success',1,1,2),(45,'Roadmap',1,1,2),(46,'Release Plan',1,1,2),(47,'Iteration Plan',1,1,2),(48,'Roles',1,1,2),(49,'Sustainable Pace',1,1,2),(50,'Self Organization',1,1,2),(51,'Technical Excellence',1,1,2),(52,'Planning and Estimating',1,1,2),(53,'Effective Meetings',1,1,2),(54,'Size and Skills',1,1,2),(55,'Allocation and Stability',1,1,2),(56,'Environment',1,1,2),(57,'Accountability',1,1,2),(58,'Innovation',1,1,2),(59,'Trust and Respect',1,1,2),(60,'Collaboration',1,1,2),(61,'Product Owner',1,1,2),(62,'Technical Lead',1,1,2),(63,'Scrum Master',1,1,2),(64,'Project Manager',1,1,2);
/*!40000 ALTER TABLE `subcategory_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `employee_guest_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `isActive` tinyint(4) NOT NULL,
  PRIMARY KEY (`employee_guest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (400207695,'CACIB',1,3,'sa:1:1:1',1),(400207820,'Hitesh Verma',2,2,'pass1',1),(400218542,'Neha Mahajan',2,2,'',1),(703192650,'Morgan Stanley',1,1,'sa:1:1:1',1),(750008406,'Haranath Lokanadham',2,5,'pass1',1);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-09  8:39:54
