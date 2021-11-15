CREATE TABLE `course` (
  `course_id` varchar(10) NOT NULL,
  `course_name_cn` varchar(45) DEFAULT NULL,
  `course_name_en` varchar(45) DEFAULT NULL,
  `obligatory` varchar(45) DEFAULT NULL,
  `discipline` varchar(45) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `practice_hour` int(11) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `reviewer` varchar(45) DEFAULT NULL,
  `precondition` varchar(45) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;