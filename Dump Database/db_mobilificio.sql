-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: mobilificio
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `articolo`
--

DROP TABLE IF EXISTS `articolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articolo` (
  `codice` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(60) NOT NULL,
  `colore` varchar(45) NOT NULL,
  `costo` double NOT NULL,
  `fornitore` varchar(45) NOT NULL,
  `arredamento` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articolo`
--

LOCK TABLES `articolo` WRITE;
/*!40000 ALTER TABLE `articolo` DISABLE KEYS */;
INSERT INTO `articolo` VALUES (1,'New Smart','Cucina completa di elettrodomestici','Legno',2440,'Netcucine','Cucina','Moderno'),(2,'Belvedere','Cucina completa di elettrodomestici','Tortora',3790,'Stosa','Cucina','Classico'),(3,'Incanto','Cucina dal design contemporaneo con anta telaio','Panna',2500,'Mobilturi','Cucina','Moderno'),(4,'Olimpia','Cucina completa di elettrodomestici.','Beige',3050,'Mobilturi','Cucina','Classico'),(5,'Tosca','Il classico rivisitato in cucina dallo stile raffinato','Beige',3580,'Stosa','Cucina','Classico'),(6,'Linea S Five','Cucina completa di elettrodomestici','Canapa',3090,'Stosa','Cucina','Classico'),(7,'New Kelly','Cucina completa di elettrodomestici','Pino',2550,'Netcucine','Cucina','Moderno'),(8,'Zen','Fantasia ricercata nello sile urban','Marmo',3550,'Mobilturi','Cucina','Moderno'),(9,'York','Lo stile raffinato incontra l’industrial','Rovere',3000,'Stosa','Cucina','Moderno'),(10,'Claudia','Il compromesso tra classico e moderno','Panna',2500,'Netcucine','Cucina','Classico'),(11,'Aura','Camera da letto elegante in stile Shabby','Bianco',3160,'Colombini','Camera da letto','Classico'),(12,'Green','Camera da letto dal design sostenibile','Beige',1950,'Sangiacomo','Camera da letto','Moderno'),(13,'Zeno','Camera da letto moderna','Olmo',2260,'Colombini','Camera da letto','Moderno'),(14,'Gioia','Camera in legno massello','Caffe',5990,'Colombini','Camera da letto','Classico'),(15,'Chloe','Camera da letto moderna e dal design originale','Grigio',1020,'RTL','Camera da letto','Moderno');
/*!40000 ALTER TABLE `articolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `sostituzione`
--

DROP TABLE IF EXISTS `sostituzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sostituzione` (
  `codiceArr` int NOT NULL,
  `nomeArr` varchar(45) NOT NULL,
  `descrizioneArt` varchar(45) NOT NULL,
  `coloreArr` varchar(45) NOT NULL,
  `fornitoreArr` varchar(45) NOT NULL,
  `arredamentoTipo` varchar(45) NOT NULL,
  `categoriaArr` varchar(45) NOT NULL,
  `nomeCliente` varchar(45) NOT NULL,
  `cognomeCliente` varchar(45) NOT NULL,
  `emailCliente` varchar(45) NOT NULL,
  `cellulareCliente` varchar(45) NOT NULL,
  PRIMARY KEY (`codiceArr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sostituzione`
--

LOCK TABLES `sostituzione` WRITE;
/*!40000 ALTER TABLE `sostituzione` DISABLE KEYS */;
INSERT INTO `sostituzione` VALUES (5,'Tosca','Maniglia uscita graffiata','Canapa','Stosa','Cucina','Classico','Claudia','Rossi','claudiarossi@gmail.com','3333635334'),(10,'Claudia','Top misura sbagliata','Panna','Netcucine','Cucina','Classico','Luca','Spinelli','lucaspinelli@gmail.com','3699955145'),(15,'Chloe','Anta del comodino scolorita','Grigio','RTL','Camera da letto','Moderno','Luigi','Pascarella','luigipascarella@gmail.com','3255844753');
/*!40000 ALTER TABLE `sostituzione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


--
-- Table structure for table `carrello`
--

DROP TABLE IF EXISTS `carrello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrello` (
  `codice` int NOT NULL AUTO_INCREMENT,
  `codiceA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codice`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrello`
--

LOCK TABLES `carrello` WRITE;
/*!40000 ALTER TABLE `carrello` DISABLE KEYS */;
INSERT INTO `carrello` VALUES (1,'15'),(2,'15'),(3,'14'),(4,'13');
/*!40000 ALTER TABLE `carrello` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form` (
  `email` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `cellulare` varchar(45) NOT NULL,
  `mansione` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES ('mariorossi@gmail.com','Mario','Rossi','324556987','Magazziniere'),('valeriarummo@gmail.com','Valeria','Rummo','3215544698','Venditore');
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14 19:42:39
