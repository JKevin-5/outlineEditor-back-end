CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `t_id` int(11) NOT NULL,
  `content` longtext NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `d_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;