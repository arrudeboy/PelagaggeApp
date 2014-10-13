-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: dbInmoPelagagge
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

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
-- Table structure for table `Alertas`
--

DROP TABLE IF EXISTS `Alertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alertas` (
  `idAlerta` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `idAlquiler` int(11) NOT NULL,
  PRIMARY KEY (`idAlerta`),
  KEY `fk_Alertas_Alquileres1` (`idAlquiler`),
  CONSTRAINT `fk_Alertas_Alquileres1` FOREIGN KEY (`idAlquiler`) REFERENCES `Alquileres` (`idAlquiler`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alertas`
--

LOCK TABLES `Alertas` WRITE;
/*!40000 ALTER TABLE `Alertas` DISABLE KEYS */;
INSERT INTO `Alertas` VALUES (1,'fin de contrato','2015-08-01',1),(2,'fin de contrato','2015-08-02',2);
/*!40000 ALTER TABLE `Alertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alquileres`
--

DROP TABLE IF EXISTS `Alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alquileres` (
  `idAlquiler` int(11) NOT NULL AUTO_INCREMENT,
  `idResponsablePago` int(11) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `valorAlquiler` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `eliminado` int(11) NOT NULL,
  PRIMARY KEY (`idAlquiler`),
  UNIQUE KEY `uk_alquiler` (`idDepartamento`,`fechaInicio`,`fechaFin`),
  KEY `fk_Alquileres_Personas2` (`idResponsablePago`),
  KEY `fk_Alquileres_Departamentos1` (`idDepartamento`),
  CONSTRAINT `fk_Alquileres_Departamentos1` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamentos` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Alquileres_Personas2` FOREIGN KEY (`idResponsablePago`) REFERENCES `Personas` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alquileres`
--

LOCK TABLES `Alquileres` WRITE;
/*!40000 ALTER TABLE `Alquileres` DISABLE KEYS */;
INSERT INTO `Alquileres` VALUES (1,23,1,6000,'2013-08-20','2015-08-01',0),(2,22,21,5000,'2013-08-02','2015-08-02',0);
/*!40000 ALTER TABLE `Alquileres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Backups`
--

DROP TABLE IF EXISTS `Backups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Backups` (
  `idBackup` int(11) NOT NULL AUTO_INCREMENT,
  `mes` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  PRIMARY KEY (`idBackup`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Backups`
--

LOCK TABLES `Backups` WRITE;
/*!40000 ALTER TABLE `Backups` DISABLE KEYS */;
INSERT INTO `Backups` VALUES (1,2,2014);
/*!40000 ALTER TABLE `Backups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Backups_config`
--

DROP TABLE IF EXISTS `Backups_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Backups_config` (
  `idBackup_config` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `dia_backup` int(11) NOT NULL,
  PRIMARY KEY (`idBackup_config`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Backups_config`
--

LOCK TABLES `Backups_config` WRITE;
/*!40000 ALTER TABLE `Backups_config` DISABLE KEYS */;
INSERT INTO `Backups_config` VALUES (2,'arturofelixchari@gmail.com','123456',13);
/*!40000 ALTER TABLE `Backups_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Blocks`
--

DROP TABLE IF EXISTS `Blocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Blocks` (
  `idBlock` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idBlock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Blocks`
--

LOCK TABLES `Blocks` WRITE;
/*!40000 ALTER TABLE `Blocks` DISABLE KEYS */;
/*!40000 ALTER TABLE `Blocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Departamentos`
--

DROP TABLE IF EXISTS `Departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Departamentos` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `idPropietario` int(11) NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  UNIQUE KEY `uk_departamento` (`direccion`),
  KEY `fk_Departamentos_Personas1` (`idPropietario`),
  CONSTRAINT `fk_Departamentos_Personas1` FOREIGN KEY (`idPropietario`) REFERENCES `Personas` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Departamentos`
--

LOCK TABLES `Departamentos` WRITE;
/*!40000 ALTER TABLE `Departamentos` DISABLE KEYS */;
INSERT INTO `Departamentos` VALUES (1,'Cabrera-118','Oficinas',4),(2,'Cabrera-118-A','Departamento',4),(3,'Lavalle-817','Casa',5),(4,'Lavalle-819','Duplex',5),(5,'Barrio Ferroviario - Manzana E-8','Casa',6),(6,'Lavalle-476-A','Departamento',7),(7,'Lavalle-476-B','Departamento',7),(8,'Lavalle-476-C','Departamento',7),(9,'Benito de Miguel-211','SalÃ³n y Departamento',7),(10,'General Paz-776-B','Departamento',8),(11,'Pastor Bauman-277','Departamento',9),(12,'Avda. San MartÃ­n-371-7-D','Departamento',10),(13,'Italia-389','Casa',11),(14,'Mayor LÃ³pez-374','Departamento',12),(15,'CuitiÃ±o-130','Casa',12),(16,'Urquiza-140','Casa',13),(17,'Siria-380-A','Departamento',14),(18,'Siria-380-B','Departamento',14),(19,'Belgrano-232','Oficina',15),(20,'Guido Spano-26','Casa',16),(21,'Guido Spano-26-A','Oficina',16),(22,'Ataliva Roca-175','Casa',17),(23,'Roque VÃ¡zquez-126-1','Departamento',17),(24,'Roque VÃ¡zquez-126-B','Departamento',17),(25,'Roque VÃ¡zquez-126-C','Departamento',17),(26,'Roque VÃ¡zquez-126-D','Departamento',17),(27,'Pastor Bauman-56','SalÃ³n',18),(28,'Pastor Bauman-52','SalÃ³n',18),(29,'Jorge Newbery-245-A','Departamento',20),(30,'Jorge Newbery-245-C','Departamento',20),(31,'Jorge Newbery-245-D','Departamento',20),(32,'Jorge Newbery-245-F','Departamento',20),(33,'Javier Muniz-229-B','Departamento',24),(34,'Francia-222','Departamento',14);
/*!40000 ALTER TABLE `Departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Intereses`
--

DROP TABLE IF EXISTS `Intereses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Intereses` (
  `idIntereses` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idIntereses`),
  UNIQUE KEY `uk_interes` (`descripcion`,`idDepartamento`),
  KEY `fk_Intereses_Departamentos` (`idDepartamento`),
  CONSTRAINT `fk_Intereses_Departamentos` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamentos` (`idDepartamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Intereses`
--

LOCK TABLES `Intereses` WRITE;
/*!40000 ALTER TABLE `Intereses` DISABLE KEYS */;
INSERT INTO `Intereses` VALUES (1,'agua',50,7),(2,'Gas',13.79,19),(3,'Agua',12.78,15);
/*!40000 ALTER TABLE `Intereses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NroRecibos`
--

DROP TABLE IF EXISTS `NroRecibos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NroRecibos` (
  `idNroRecibo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(80) NOT NULL,
  `valor` varchar(200) NOT NULL,
  PRIMARY KEY (`idNroRecibo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NroRecibos`
--

LOCK TABLES `NroRecibos` WRITE;
/*!40000 ALTER TABLE `NroRecibos` DISABLE KEYS */;
INSERT INTO `NroRecibos` VALUES (1,'inquilino','0001-00002494'),(2,'propietario','0001-00001025');
/*!40000 ALTER TABLE `NroRecibos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Personas`
--

DROP TABLE IF EXISTS `Personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Personas` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `uk_persona` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Personas`
--

LOCK TABLES `Personas` WRITE;
/*!40000 ALTER TABLE `Personas` DISABLE KEYS */;
INSERT INTO `Personas` VALUES (4,'Almarza','Ana MarÃ­a','--','xxx'),(5,'Altare','Gimena','--','25.564.424'),(6,'Alvarez','Juan Antonio','--','4.958.887'),(7,'Amigo','Alberto R.','--','4.961.823'),(8,'Andreani','Graciela','--','13.788.001'),(9,'Angeloni','Daniela E.','--','21.444.450'),(10,'Antonini','Carolina','--','13.582.201'),(11,'Barbella','Silvia R.','--','21.715.433'),(12,'Barberis','FÃ©lix','--','4.939.504'),(13,'Barberis','Nancy','--','13.250.661'),(14,'Baruscotti','AnÃ­bal','--','11.387.146'),(15,'Bede','Lidia','--','0.693.094'),(16,'Beltramone','Graciela','--','11.045.823'),(17,'Bertoni','MÃ¡ximo C.','--','8.428.042'),(18,'Bianchelli','Alfredo','--','4.962.813'),(20,'Braggio','Julio Alberto','--','4.974.487'),(21,'Camezzana','Enevilda','--','vbn'),(22,'Capogrosso','Carlos','--','xvb'),(23,'Chari','Arturo Felix','2352 15 418360','34.589.588'),(24,'Caballeiro','Olga','--','asd'),(25,'Garcia','SDF','1231','213');
/*!40000 ALTER TABLE `Personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Recibos`
--

DROP TABLE IF EXISTS `Recibos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Recibos` (
  `idRecibo` int(11) NOT NULL AUTO_INCREMENT,
  `idAlquiler` int(11) NOT NULL,
  `nro_recibo` varchar(100) NOT NULL,
  `mes` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `observacionAlquiler` varchar(100) NOT NULL,
  `entrega` double NOT NULL,
  PRIMARY KEY (`idRecibo`),
  UNIQUE KEY `uk_recibo` (`nro_recibo`),
  KEY `fk_Recibos_Alquileres1` (`idAlquiler`),
  CONSTRAINT `fk_Recibos_Alquileres1` FOREIGN KEY (`idAlquiler`) REFERENCES `Alquileres` (`idAlquiler`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Recibos`
--

LOCK TABLES `Recibos` WRITE;
/*!40000 ALTER TABLE `Recibos` DISABLE KEYS */;
INSERT INTO `Recibos` VALUES (6,2,'0001-00002482',9,2013,'--',5000),(7,2,'0001-00002483',8,2013,'--',5000),(8,2,'0001-00001023',8,2013,'--',4920),(9,1,'0001-00002484',8,2013,'--',6000),(10,1,'0001-00002486',6,2013,'--',6000),(11,2,'0001-00002487',6,2013,'--',5000),(12,1,'0001-00001024',8,2013,'--',5920),(13,2,'0001-00002488',11,2013,'--',5000),(14,2,'0001-00002489',12,2013,'--',5000),(15,2,'0001-00002490',10,2013,'--',5000),(16,2,'0001-00002491',1,2014,'--',5000),(17,2,'0001-00002492',2,2014,'--',5000),(18,1,'0001-00002493',2,2014,'--',6000);
/*!40000 ALTER TABLE `Recibos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-08 11:07:36
