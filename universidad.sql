CREATE DATABASE  IF NOT EXISTS `universidad` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `universidad`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: universidad
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(15) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `mes_nacimiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=320 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'terefdgq','Roberto','Menendez',5),(2,'12345e','Laura','Fernandez',5),(3,'12345','Juan','de la Puente',10),(4,'987654321B','Carlos','Whirlpool',10),(6,'666','Arturo','Cercadillo Sánchez',3),(9,'45879','Johnny','Nmenomic',4),(10,'447825','Pepe','Botella',7),(11,'569841','Arrieros','Somos',5),(12,'1234','El Venezolano','CULPABLE',5),(13,'Y65665566','Armando','ELBola',6),(14,'123456','Perico','Silencio',99),(15,'123456','Fulanito','Silencio',300),(16,'1234567890','Manuel','Silencio',5),(18,'12121212','Pancho','Silencio',1),(19,'65465465w','pepito','Silencio',4),(20,'22','Lilla','Silencio',5),(21,'978432','Pepe','Silencio',1),(22,'18','LUIS','ARCE',20),(23,'334123312','Maria','Magdalena',24),(24,'24644792Q','Ignacio','Gonzalez',10),(25,'18','LUIS','ARCE',20),(26,'8654','NiArrieros','NiArrieras',7),(27,'445879','Chema','Pamundi',1),(28,'40','Jorge','Menor',2),(35,'8654','NiArrieros','NiArrieras',7),(37,'40','Jorge','Menor',2),(40,'40','Jorge','Menor',2),(41,'40','Jorge','Menor',2),(43,'22','Lilla','Annecchino',5),(44,'789972424','Jorge','Menor',2),(45,'12345678T','Marcos','Navas',9),(46,'503','Alfredo','Estébanez',7),(49,'123456G','José Manuel','Prieto Blázquez',3),(50,'34567','BRITNEY','SPEARS',10),(51,'fck','system','.in',9),(55,'12345','Pepito','Clavito',4),(59,'345678','Fabio','Carbone',2),(60,'3y45678','Fabio','Carbone',2),(64,'12345678A','Prueba','Ejercicios',10),(66,'134347','MICHAEL','JORDAN',8),(70,'1212123A','MiTubo','Bonito',5),(140,'35567','GERMAN','RODRIGUEZ',9),(141,'454554545','Jon','Perez',11),(143,'1212123A','MiTubo','Bonito',5),(148,'134333','TORCUATO','JONES',6),(149,'666','Valeria','Cercadillo Sánchez',3),(151,'xxx','mark','le',9),(152,'123456P','Josito','Piscinas Gomez',3),(153,'987654321','MARIA','Fernandez',5),(155,'Sara','Baras','Mantequilla',4),(163,'567898H','Gorka','Extebarruska',11),(165,'789w','prueba','jorge',NULL),(169,'345','PEPE','GUTIERREZ',5),(170,'0000','Pedro','Jimenez',5),(171,'345h','PEPE','GUTIERREZ',4),(172,'0000','Pedro','Jimenez',5),(173,'3412h','PEPE','GUTIERREZ',3),(174,'0000','Pedro','Jimenez',5),(175,'123456789','Cristina','Fernandez',1),(176,'ghtyr56','Oliver','Stone',5),(177,'123123g','Jacinto','Lopez',11),(178,'123123t','Luis','Nuñez',2),(182,'0000','Pedro','Jimenez',5),(184,'0000','Pedro','Jimenez',5),(186,'0000','Pedro','Jimenez',5),(188,'0000','Pedro','Jimenez',5),(189,'25457056X','Alejandro','Garcia Perez',10),(191,'0000','Pedro','Jimenez',5),(193,'0000','Pedro','Jimenez',5),(195,'0000','Pedro','Jimenez',5),(197,'0000','Pedro','Jimenez',5),(199,'0000','Pedro','Jimenez',5),(201,'0000','Pedro','Jimenez',5),(203,'0000','Pedro','Jimenez',5),(205,'0000','Pedro','Jimenez',5),(207,'0000','Pedro','Jimenez',5),(209,'0000','Pedro','Jimenez',5),(211,'0000','Pedro','Jimenez',5),(213,'0000','Pedro','Jimenez',5),(215,'0000','Pedro','Jimenez',5),(217,'0000','Pedro','Jimenez',5),(219,'0000','Pedro','Jimenez',5),(221,'0000','Pedro','Jimenez',5),(223,'0000','Pedro','Jimenez',5),(225,'0000','Pedro','Jimenez',5),(226,NULL,'PEPE','GUTIERREZ',NULL),(227,'0000','Pedro','Jimenez',5),(228,NULL,'PEPE','GUTIERREZ',NULL),(229,'0000','Pedro','Jimenez',5),(230,NULL,'PEPE','GUTIERREZ',NULL),(231,'0000','Pedro','Jimenez',5),(232,'123456789R','Nombre prueba','Apellido prueba',4),(233,NULL,'PEPE','GUTIERREZ',NULL),(234,'0000','Pedro','Jimenez',5),(235,NULL,'PEPE','GUTIERREZ',NULL),(236,'0000','Pedro','Jimenez',5),(237,'51','Juanito','Manzanas Verdes',5),(238,NULL,'PEPE','GUTIERREZ',NULL),(239,'0000','Pedro','Jimenez',5),(240,NULL,'PEPE','GUTIERREZ',NULL),(241,'0000','Pedro','Jimenez',5),(242,'51','Juanito','Manzanas Verdes',5),(243,'41','Juanito','Manzanas Verdes',5),(244,NULL,'PEPE','GUTIERREZ',NULL),(245,'0000','Pedro','Jimenez',5),(246,NULL,'PEPE','GUTIERREZ',NULL),(247,'0000','Pedro','Jimenez',5),(248,NULL,'PEPE','GUTIERREZ',NULL),(249,'0000','Pedro','Jimenez',5),(250,NULL,'PEPE','GUTIERREZ',NULL),(251,'0000','Pedro','Jimenez',5),(252,NULL,'PEPE','GUTIERREZ',NULL),(253,'0000','Pedro','Jimenez',5),(254,NULL,'PEPE','GUTIERREZ',NULL),(255,'0000','Pedro','Jimenez',5),(256,NULL,'PEPE','GUTIERREZ',NULL),(257,'0000','Pedro','Jimenez',5),(258,NULL,'PEPE','GUTIERREZ',NULL),(259,'0000','Pedro','Jimenez',5),(260,'123456789','Cristina','Fernandez',1),(261,NULL,'PEPE','GUTIERREZ',NULL),(262,'0000','Pedro','Jimenez',5),(263,NULL,'PEPE','GUTIERREZ',NULL),(264,'0000','Pedro','Jimenez',5),(265,NULL,'PEPE','GUTIERREZ',NULL),(266,'0000','Pedro','Jimenez',5),(267,NULL,'PEPE','GUTIERREZ',NULL),(268,'0000','Pedro','Jimenez',5),(269,'123456789','Cristina','Fernandez',1),(270,'123456789','Cristina','Fernandez',1),(271,'123456789','Cristina','Fernandez',1),(272,'123456789','Cristina','Fernandez',1),(273,'4545646p','Hola','Mundo :)',2),(274,NULL,'PEPE','GUTIERREZ',NULL),(275,'0000','Pedro','Jimenez',5),(276,'123456789','Cristina','Fernandez',1),(277,NULL,'PEPE','GUTIERREZ',NULL),(278,'0000','Pedro','Jimenez',5),(279,'2342r','adfa','adsfads',4),(280,'1234','Perico','El de los palotes',6),(281,'fjkjhg4','lilla','anne',5),(282,'1234','Perico','Flautas',9),(283,'jhsflal6','fabio','carbone',5),(284,'23423542g','Gonzalo','Saez Treviso',1),(285,'lkhfñ6','sergio','andrés',7),(286,'11w','qwe','asdf asdfsdf f',4),(287,'231435t','fer','nando pe',8),(288,'11w','Perico','prieto',3),(289,'11w','José','Prieto Blazquez',3),(290,NULL,'PEPE','GUTIERREZ',NULL),(291,'0000','Pedro','Jimenez',5),(292,'adfa','234234','234234',2),(293,'12345678y','pepe','perez marin',1),(294,NULL,'PEPE','GUTIERREZ',NULL),(295,'0000','Pedro','Jimenez',5),(296,'15424','Luis','Perez',5),(297,'555','chochito','lindo',5),(298,'123456A','Desde','Web ',2),(299,'4545','hoasdfas','asdflkjasdflkj',3),(300,'232','23423423','4234',4),(301,'14411414','Juanito','Manzanas Verdes',9),(302,'3463','Juanito','Manzanas Verdes',3),(303,'hldahl6','Sara','Martinez',8),(304,'1212123A','MiTubo','Bonito',5),(305,'null','NombrePrueba','ApellidoPrueba',12),(306,'73556963L','nombre2','apellido2',2),(307,'89283571D','nombre3','apellido3',4),(308,'6','gnf','null',5),(309,'6','gnf','null',5),(310,'6','gnf','null',5),(311,'6','gnf','null',5),(312,'6','gnf','null',5),(313,'6','gnf','null',5),(314,'80041637G','nombre4','apellido4',5),(315,'6','gnf','null',5),(316,'454','gjh','null',2),(317,'89440238T','nombre5','apellido5',6),(318,'54176011V','nombre6','apellido6',12),(319,'45','Hola','Que tal',4);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos_has_asignaturas`
--

DROP TABLE IF EXISTS `alumnos_has_asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos_has_asignaturas` (
  `alumno` int(11) NOT NULL,
  `asignatura` int(11) NOT NULL,
  PRIMARY KEY (`alumno`,`asignatura`),
  KEY `fk_alumnos_has_asignaturas_asignaturas1_idx` (`asignatura`),
  KEY `fk_alumnos_has_asignaturas_alumnos1_idx` (`alumno`),
  CONSTRAINT `fk_alumnos_has_asignaturas_alumnos1` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnos_has_asignaturas_asignaturas1` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_has_asignaturas`
--

LOCK TABLES `alumnos_has_asignaturas` WRITE;
/*!40000 ALTER TABLE `alumnos_has_asignaturas` DISABLE KEYS */;
INSERT INTO `alumnos_has_asignaturas` VALUES (4,1),(6,1),(10,1),(23,1),(24,1),(43,1),(45,1),(46,1),(49,1),(4,3),(6,3),(13,3),(46,3),(49,3),(4,5),(6,5),(13,5),(49,5),(4,6),(6,6),(49,6),(6,7),(43,7),(46,7),(70,7),(13,9),(24,9),(43,9),(46,9),(49,9),(24,10),(43,10),(43,11),(3,13),(43,13),(3,14),(49,14),(3,15),(4,15),(3,16),(176,19),(3,22),(4,22),(46,22),(3,23),(24,23),(24,24),(24,25),(13,26),(13,27),(13,28),(4,33),(6,40),(149,40),(152,47);
/*!40000 ALTER TABLE `alumnos_has_asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignaturas`
--

DROP TABLE IF EXISTS `asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignaturas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `profesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_asignaturas_profesores1_idx` (`profesor`),
  CONSTRAINT `fk_asignaturas_profesores1` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignaturas`
--

LOCK TABLES `asignaturas` WRITE;
/*!40000 ALTER TABLE `asignaturas` DISABLE KEYS */;
INSERT INTO `asignaturas` VALUES (1,'Dibujo Tecnico',1),(3,'Ecuaciones Diferenciales',3),(5,'Cuantica',7),(6,'POO',10),(7,'Ecuaciones Diferenciales II',9),(9,'Derecho',11),(10,'Negociacion',11),(11,'Lolología',2),(13,'Cocologia',2),(14,'Geografía',3),(15,'Dibujo Tecnico',1),(16,'Equestrelogía',4),(18,'Lolología',2),(19,'Geografía',3),(20,'Dibujo Tecnico',1),(21,'Equestrelogía',4),(22,'Frikismo',2),(23,'Politica',11),(24,'Oratoria',11),(25,'Turismo',11),(26,'Futbol BUeno',14),(27,'Tiqui Taca',15),(28,'Estadistica',12),(29,'Matematicas',13),(33,'MATENIMIENTO DE PERFIL DE FACEBOOK',3),(34,'ESTILISMO PARA REALITIES Y ENVENTO',3),(35,'PLAYBACK PARA CONCIENTOS',3),(37,'Matlab II',13),(38,'Matlab',13),(40,'Ornitologia II',20),(41,'Geomorfologia',21),(44,'Master en Burrologia',26),(47,'Ciencia del suelo',25),(48,'PamplinasMOD',28),(49,'historia',10),(50,'Dibujo Tecnico',1),(51,'Geometria Descriptiva I',1),(53,'Dibujo Tecnico',1),(54,'Dibujo Tecnico',1),(55,'Dibujo Tecnico',1),(56,'Dibujo Tecnico',1),(57,'Dibujo Tecnico',1),(60,'Frances',30),(61,'Tecnol.',30),(62,'Tecnol.',30),(66,'Dibujo Tecnico',1),(67,'Tecnologia industrial',1),(68,'Tecnol.',30),(69,'Tecnol.',30),(70,'Tecnol.',30),(71,'Tecnol.',30),(72,'Tecnol.',30),(73,'Tecnol.',30),(74,'Tecnol.',30),(75,'Tecnol.',30),(76,'Tecnol.',30),(77,'Tecnol.',30),(78,'Tecnol.',30),(79,'Tecnol.',30),(80,'Tecnol.',30),(81,'Tecnol.',30),(82,'Tecnol.',30),(83,'Tecnol.',30),(84,'Tecnol.',30),(85,'Tecnol.',30),(86,'Tecnol.',30),(89,'Ingles Avanzado',30),(90,'Tecnol.',30),(91,'',1),(92,'Ingles Avanzado',30),(93,'Tecnol.',30),(94,'Tecnol.',30),(95,'Tecnol.',30),(96,'prueba asignatura 17',NULL),(97,'prueba asignatura 18',NULL),(98,'prueba asignatura 19',NULL),(99,'Podologia aplicada',NULL),(100,'ya no se que poner',NULL),(101,'jsldhflsdhf',15),(102,'Una asignatura',1),(103,'Una asignatura',12),(104,'Una asignatura',23),(105,'Una asignatura',23),(106,'Una asignatura',1);
/*!40000 ALTER TABLE `asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direcciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) DEFAULT NULL,
  `municipio` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `alumno` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_direcciones_alumnos1_idx` (`alumno`),
  CONSTRAINT `fk_direcciones_alumnos1` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (3,'RUE DEL CARACOL','leganés','Cadiz',1),(4,'rue del percebe','carabanchel','Cadiz',1),(5,'Conde de Vilches','Las Ventas','Cadiz',4),(6,'Paseo de la Manzana','JAEN','ANDALUCIA',3),(7,'Salitre','Lavapiés Bajo','Cadiz',46),(8,'Agapito Agamenón','Segovia','Monopoly',3),(9,'Calle','Segovia','Cadiz',4),(10,'Calle Leganitos. 3','Cantipalo','Cadiz',24),(13,'Calle prueba','Segovia','Cadiz',64),(14,'Calle Princesa, 5','Sotillo de la Adrada','Ávila',55),(16,'Arce','Aravaca','Cadiz',70),(17,'Arce','Aravaca','Cadiz',70),(20,'Rios Rosas','Segovia','Cadiz',1),(21,'Rios Rosas','Segovia','Cadiz',1),(23,'Dr.Esquerdo','Segovia','Cadiz',149),(25,'Avenida Primera 3','Villa Arriba','Lugo',152),(26,'Don benito','Camelas','Babylon',151),(29,'PRIMERA','ZAMORA','MIRANDA',153),(30,'Calle actualizada','Municipio actualizado','Provincia actualizada',4),(32,'calle prueba 24',NULL,NULL,165),(33,'Araujo','Perniles de la Mora','Segovia',163),(35,'PRIMERA','ZAMORA','MIRANDA',153),(75,'PRIMERA','ZAMORA','MIRANDA',153),(79,'PRIMERA','ZAMORA','MIRANDA',153),(80,'PRIMERA','ZAMORA','MIRANDA',153),(81,'PRIMERA','ZAMORA','MIRANDA',153),(82,'PRIMERA','ZAMORA','MIRANDA',153),(84,'PRIMERA','ZAMORA','MIRANDA',153);
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alumno` int(11) NOT NULL,
  `calificacion` int(11) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `asignatura` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_notas_alumnos_idx` (`alumno`),
  KEY `fk_notas_asignaturas1_idx` (`asignatura`),
  CONSTRAINT `fk_notas_alumnos` FOREIGN KEY (`alumno`) REFERENCES `alumnos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_notas_asignaturas1` FOREIGN KEY (`asignatura`) REFERENCES `asignaturas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,46,7,'Lenguaje',1),(2,46,7,'Lenguaje',1),(3,46,7,'Lenguaje',1),(4,46,7,'Lenguaje',1),(6,13,7,'no me digas',5),(7,24,15,'Aprobado',9),(8,19,9,'MAKINA',3),(9,46,7,'Lenguaje',1),(11,13,6,'ya no tan Bien',26),(12,46,7,'Lenguaje',1),(13,13,6,'ya no tan Bien',28),(14,13,6,'ya no tan Bien',3),(15,46,7,'Lenguaje',1),(16,4,30,'Es un borrico',1),(17,149,11,'Perfecto',40),(19,149,10,'IN-CREIBLE',40),(20,4,33,'Es un borrico',1),(21,1,10,'Matricula',1),(23,4,10,'Matricula',3),(24,4,20,'Matricula',6),(25,3,25,'DE P... MADRE',14),(26,2,12,'rrrr',1),(27,2,5,'eeee',3),(28,2,50,'NOTAZA',1),(30,152,10,'1S',47),(31,1,8,'Dibujo Tecnico',6),(32,2,8,'Dibujo Tecnico',1),(33,46,7,'Lenguaje',1),(34,46,4,'Lenguaje',1),(35,46,7,'Lenguaje',1),(36,46,3,'Lengua',1),(40,46,0,'Repite curso',6),(41,46,0,'Repite curso',6),(42,46,0,'Repite curso',6),(43,6,10,'IN-CREIBLE',40),(44,6,7,'IN-CREIBLE',40),(45,6,7,'IN-CREIBLE',7),(46,6,4,'IN-CREIBLE',7);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `despacho` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'Guzman','Teacher',123),(2,'Guzmán','de Alfarache',301),(3,'PEPE','PEREZ',301),(4,'Guzmán','Jones',13),(7,'Tito','Alvarez',510),(9,'John','Smith',23),(10,'Alfredo','El Profe',10),(11,'Esperanza','Aguirre',8),(12,'Luis','Mendes',104),(13,'Paco','Mut',101),(14,'Jose','Mouriño',56),(15,'PEPE','GUARDIOLO',65),(16,'Nombre actualizado','Apellidos actualizados',302),(18,'Juan','Gomez',100),(20,'Guzmán','El Bueno',15),(21,'Jacinto','Benavente',251),(22,'Ines','Carbone',8),(23,'Guzmán','Arce',5),(25,'Quique','Garcia Perez',236),(26,'Pepe','Perez',18),(27,'Actualizado','Actualizado',123),(28,'Ramiro','Ostiacas',5),(29,'Guzmán','El Malo',11),(30,'Rosa Elena','Hernández',69),(33,'ZAMORA','MIRANDA',153),(34,'ZAMORA','MIRANDA',153),(35,'ZAMORA','MIRANDA',153),(36,'ZAMORA','MIRANDA',153),(37,'ZAMORA','MIRANDA',153);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 20:23:48
