CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addresser` varchar(45) DEFAULT NULL,
  `receiver` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `d_name` varchar(45) DEFAULT NULL,
  `message` longtext,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;