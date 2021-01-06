-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: web_ban_quan_ao
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` varchar(50) NOT NULL,
  `u_id` int NOT NULL,
  `buyDate` date DEFAULT NULL,
  `action` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8y8lc3tcss60692qojy63o8di` (`u_id`),
  CONSTRAINT `FK8y8lc3tcss60692qojy63o8di` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES ('32',1,'2020-12-13',_binary '');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_cartitem`
--

DROP TABLE IF EXISTS `cart_cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_cartitem` (
  `CartEntity_id` varchar(255) NOT NULL,
  `cartitemEntities_id` int NOT NULL,
  UNIQUE KEY `UK_rsw720jkegakvfxmw1s0thgom` (`cartitemEntities_id`),
  KEY `FK39repijm06a6pqlkfl2cig2f8` (`CartEntity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_cartitem`
--

LOCK TABLES `cart_cartitem` WRITE;
/*!40000 ALTER TABLE `cart_cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `id` varchar(50) NOT NULL,
  `quantity` int DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `pro_id` int NOT NULL,
  `cat_id` varchar(50) NOT NULL,
  `cart_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcj0jvvlv7mum72m5qblw5m1tc` (`cart_id`),
  KEY `FKokhfy7klj0ansiaf47idk6tc` (`pro_id`),
  CONSTRAINT `FKcj0jvvlv7mum72m5qblw5m1tc` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKokhfy7klj0ansiaf47idk6tc` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cate_id` int NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) NOT NULL,
  `cate_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Giày nike','image1.png'),(2,'Giày adidas','image1.png'),(3,'Qu&#7847;n kaki nam','image1.png'),(4,'Qu&#7847;n jean n&#7919;','image1.png'),(5,'Qu&#7847;n jean nam','image1.png'),(6,'Áo s&#417; mi n&#7919;','image1.png'),(7,'Áo s&#417; mi nam','image1.png'),(8,'Áo thun n&#7919;','image1.png'),(9,'Áo thun nam','image1.png');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile` char(15) DEFAULT NULL,
  `subject` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (7,'ng',NULL,' ff','ff'),(8,'dsfsdf',NULL,' sadad','dfd'),(9,'dd',NULL,' dd','dd');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` float DEFAULT NULL,
  `cate_id` int NOT NULL,
  `des` varchar(2000) DEFAULT NULL,
  `categoryEntity_cate_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsf82h33wnq4y5d53p8vpn3ear` (`categoryEntity_cate_id`),
  KEY `FKll9b6w9lwjkhiymqatom6jbd` (`cate_id`),
  CONSTRAINT `FKll9b6w9lwjkhiymqatom6jbd` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`),
  CONSTRAINT `FKsf82h33wnq4y5d53p8vpn3ear` FOREIGN KEY (`categoryEntity_cate_id`) REFERENCES `category` (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'jordan-max-200-shoe-C2S1xN.jpg','Giày nike SF AF1',10000,1,'<p>SF AF1 l&agrave; vi&#7871;t t&#7855;t c&#7911;a Special Field Air Force 1 &ndash; &#272;&ocirc;i gi&agrave;y &#273;&#432;&#7907;c l&#7845;y &yacute; t&#432;&#7903;ng t&#7915; c&aacute;c &#273;&ocirc;i Combat Boots c&#7911;a qu&acirc;n &#273;&#7897;i, v&#7915;a m&#7841;nh m&#7869; v&#7915;a hi&#7879;n &#273;&#7841;i.</p>\r\n',1),(2,'Nike Air Max Impact 2.jpg','Giày nike Air force 1',10000,1,'<p>Nike Air Force 1 (AF1) &#273;&#432;&#7907;c Nike debut l&#7847;n &#273;&#7847;u ti&ecirc;n v&agrave;o n&#259;m 1982. Thi&#7871;t k&#7871; ban &#273;&#7847;u d&agrave;nh cho c&aacute;c v&#7853;n &#273;&#7897;ng vi&ecirc;n b&oacute;ng r&#7893; nh&#432;ng v&igrave; v&#7867; &#273;&#7865;p kh&#7887;e kho&#7855;n v&agrave; thanh l&#7883;ch c&#7911;a Air Force 1, n&oacute; d&#7847;n tr&#7903; th&agrave;nh m&#7897;t &#273;&ocirc;i gi&agrave;y &ldquo;ai ai c&#361;ng c&oacute;&rdquo;.</p>\r\n',1),(3,'Nike Air Max 97 By You.jpg','Giày adidas ULTRA BOOST 4.0',10000,2,'<p>M&#7897;t huy&#7873;n tho&#7841;i tr&#7867;. D&ograve;ng adidas Ultraboost ra m&#7855;t n&#259;m 2015 v&agrave; c&oacute; s&#7913;c &#7843;nh h&#432;&#7903;ng m&#7841;nh m&#7869; kh&ocirc;ng ch&#7881; trong gi&#7899;i ch&#7841;y b&#7897;.</p>\r\n',2),(4,'4d-run-1.0.jpg','Giày adidas Stansmith Boosts',10000,2,'<p><em>adidas Stan Smith</em>&nbsp;l&agrave; m&#7897;t trong nh&#7919;ng m&#7851;u&nbsp;<em>gi&agrave;y</em>&nbsp;b&aacute;n ch&#7841;y nh&#7845;t m&#7885;i th&#7901;i &#273;&#7841;i, t&#7845;t c&#7843; nh&#7901; v&agrave;o v&#7867; ngo&agrave;i &#273;&#417;n gi&#7843;n tinh t&#7871; v&agrave; kh&#7843; n&#259;ng ph&#7889;i &#273;&#7891; c&#7921;c k&igrave; d&#7877; d&agrave;ng;&nbsp;</p>\r\n',2),(5,'kaki1.jpg','Qu&#7847;n kaki baggy nam',10000,3,'<p>Ch&#7881; c&#7847;n ph&#7889;i v&#7899;i1 chi&#7871;c &aacute;o thun ho&#7863;c s&#417; mi , c&#361;ng l&agrave;m n&ecirc;n 1 restock c&#7921;c ch&#7845;t n&agrave;y<br />\r\nQu&#7847;n kaki baggy basic pants qu&#7889;c d&acirc;n - ai ch&#432;a c&oacute; n&ecirc;n t&#7853;u 1 em nh&eacute;<br />\r\n&#272;i &#273;&acirc;u c&#361;ng &#273;&#7865;p , ph&#7889;i &#273;&#7891; g&igrave; c&#361;ng n&#259;ng &#273;&#7897;ng<br />\r\nCh&#7845;t li&#7879;u : kaki d&agrave;y d&#7863;n , &#272;&#7843;m b&#7843;o ch&#7845;t li&#7879;u kaki ( kh&ocirc;ng ph&#7843;i v&#7843;i d&ugrave; )</p>\r\n',3),(6,'kaki2.jpg','Qu&#7847;n Kaki Nam &#272;en QKK0012',10000,3,'<p>Qu&#7847;n kaki nam Kenta v&#7899;i form d&aacute;ng Slim tr&#7867; trung v&agrave; th&#7901;i th&#432;&#7907;ng. Ch&#7845;t kaki co gi&atilde;n, v&#7843;i si&ecirc;u m&aacute;t, tho&#7843;i m&aacute;i trong m&#7885;i chuy&#7875;n &#273;&#7897;ng.</p>\r\n',3),(7,'Basic Jean.jpg','Qu&#7847;n jean n&#7919; Th&#7901;i Trang QJN03',10000,4,'<p>M&#7897;t chi&#7871;c qu&#7847;n kh&ocirc;ng th&#7875; thi&#7871;u trong t&#7911; &#273;&#7891; c&#7911;a m&#7885;i ph&#7909; n&#7919; n&#259;ng &#273;&#7897;ng<br />\r\nM&agrave;u xanh bi&#7875;n &#273;&#432;&#7907;c xem l&agrave; &#273;&#7865;p nh&#7845;t v&agrave; &#273;&#432;&#7907;c &#432;a chu&#7897;ng nh&#7845;t trong c&aacute;c m&agrave;u qu&#7847;n jeans<br />\r\nS&#7843;n ph&#7849;m &#273;&#432;&#7907;c m&agrave;i nh&#7865; th&#7901;i trang &#7903; ph&#7847;n &#273;&ugrave;i t&#7841;o c&#7843;m gi&aacute;c s&#7889;ng &#273;&#7897;ng v&agrave; tr&agrave;n &#273;&#7847;y n&#259;ng l&#432;&#7907;ng</p>\r\n',4),(8,'Jean Trendy.jpg','Qu&#7847;n Jean N&#7919; &#7888;ng &#272;&#7913;ng L&#432;ng Cao Aaa Jeans ',10000,4,'<p>Thi&#7871;t k&#7871; mang h&#417;i h&#432;&#7899;ng vintage v&#7899;i form qu&#7847;n l&#7883;ch s&#7921; ph&ugrave; h&#7907;p &#273;&#7875; m&#7863;c &#273;i l&agrave;m ho&#7863;c &#273;i ch&#417;i<br />\r\nM&agrave;u s&#7855;c c&#259;n b&#7843;n wash nh&#7865; c&oacute; th&#7875; thay th&#7871; nh&#7919;ng chi&#7871;c qu&#7847;n t&acirc;y trong m&ocirc;i tr&#432;&#7901;ng c&ocirc;ng s&#7903;<br />\r\nCh&#7845;t v&#7843;i thun gi&atilde;n, m&#7873;m gi&uacute;p b&#7841;n c&#7843;m th&#7845;y d&#7877; ch&#7883;u khi m&#7863;c<br />\r\nD&aacute;ng qu&#7847;n &#7889;ng &#273;&#7913;ng t&ocirc;n d&aacute;ng khi&#7871;n ch&acirc;n b&#7841;n tr&ocirc;ng th&#7859;ng h&#417;n</p>\r\n',4),(9,'Jean Trendy.jpg','Quâ&#768;n jeans nam VNXK &#7889;ng &#273;&#7913;ng co gi&#7843;n tr&#7855;ng xanh 2018',10000,4,'<p>Qu&acirc;&#768;n jeans nam &#7889;ng su&ocirc;ng &#7889;ng &#273;&#7913;ng Mansio Regular Ph&ugrave; h&#7907;p cho c&aacute;c b&#7841;n nam t&#7915; 22-45 tu&#7893;i &#272;&#417;n gi&#7843;n, Tr&#7867; trung, L&#7883;ch l&atilde;m.Ch&#7845;t li&#7879;u v&#7843;i thun cao c&#7845;p co gi&#7843;n nh&#7865; t&#7841;o c&#7843;m gi&aacute;c&nbsp;tho&#7843;i m&aacute;i Form qu&#7847;n t&#432;&#417;ng &#273;&#432;&#417;ng LV5114 t&uacute;i qu&#7847;n l&#7899;n r&#7845;t thu&#7853;n ti&#7879;n cho vi&#7879;c &#273;&#7921;ng smart phone ho&#7863;c v&iacute; c&#7905; b&#7921;</p>\r\n',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `new_id` varchar(20) NOT NULL,
  `new_name` varchar(150) DEFAULT NULL,
  `date_create` date DEFAULT NULL,
  `new_category` varchar(50) DEFAULT NULL,
  `date_open` date DEFAULT NULL,
  `date_close` date DEFAULT NULL,
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(36) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `permission` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'6.jpg','huynhtrongnghia1090@gmail.com','Hu?nh Tr?ng Ngh?a','123456','134 Tân V?nh Thu?n',1),(2,'22.jpg','bvnghia0000@gmail.com','ffff','ffffff','ff',1),(5,'333.jpg','','jjj','222','11',1),(6,'bbb.jpg','22','333','22','22',2),(7,'1607017286296.jpg','nguyenvanphap013@gmail.com','B1ZT668H','6666','HCM',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-02 21:36:51
