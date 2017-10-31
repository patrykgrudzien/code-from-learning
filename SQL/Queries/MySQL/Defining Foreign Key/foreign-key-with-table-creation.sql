CREATE TABLE `instructor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),

  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
  REFERENCES `instructor_detail` (`id`)
);
