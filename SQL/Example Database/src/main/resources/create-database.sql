CREATE DATABASE IF NOT EXISTS `example_student_database`;
USE `example_student_database`;

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`
(
  `id`         INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45)      DEFAULT NULL,
  `last_name`  VARCHAR(45)      DEFAULT NULL,
  `email`      VARCHAR(45)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = latin1;

INSERT INTO `students` VALUES
  (1, 'Mary', 'Public', 'mary@luv2code.com'),
  (2, 'John', 'Doe', 'john@luv2code.com'),
  (3, 'Ajay', 'Rao', 'ajay@luv2code.com'),
  (4, 'Bill', 'Neely', 'bill@luv2code.com'),
  (5, 'Maxwell', 'Dixon', 'max@luv2code.com');