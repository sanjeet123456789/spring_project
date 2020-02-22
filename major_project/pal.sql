DROP TABLE IF EXISTS `class_t`;
CREATE TABLE `class_t`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`class` varchar(45) NOT NULL UNIQUE,
	`section` varchar(45) NOT NULL,
	PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;



DROP TABLE IF EXISTS `teachers_t`;
CREATE TABLE `teachers_t`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`t_name` varchar(45) NOT NULL,
	`teach_id` varchar(45) NOT NULL UNIQUE,
	PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;



DROP TABLE IF EXISTS `subject_t`;
CREATE TABLE `subject_t`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`subject_name` varchar(45) NOT NULL,
	`s_class` varchar(45) NOT NULL,
	`total_in_week` int(11) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `FK_CLASS_T`
	FOREIGN KEY(`s_class`) 
	REFERENCES `class_t`(`class`)
	ON DELETE NO ACTION ON UPDATE NO ACTION 
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;




DROP TABLE IF EXISTS `teacher_subject_t`;
CREATE TABLE `teacher_subject_t`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`teacher_id` int(11) NOT NULL,
	`subject_id` int(11) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `FK_TEACHERS`
	FOREIGN KEY(`teacher_id`) REFERENCES `teachers_t`(`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `FK_SUBJECT`
	FOREIGN KEY(`subject_id`) REFERENCES `subject_t`(`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;



DROP TABLE IF EXISTS `check_subject`;
CREATE TABLE `check_subject`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`class_section` varchar(45) NOT NULL,
	`subject_name` varchar(45) NOT NULL,
	`teachers_id` int(11) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `FK_TEACHERS_CHECK_SUBJECT`
	FOREIGN KEY(`teachers_id`) REFERENCES `teachers_t`(`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;





DROP TABLE IF EXISTS `check_busy`;
CREATE TABLE `check_busy`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`day` varchar(45) NOT NULL,
	`period` varchar(45) NOT NULL,
	`teachers_id` int(11) NOT NULL,
	PRIMARY KEY(`id`),
	CONSTRAINT `FK_TEACHERS_CHECK_BUSY`
	FOREIGN KEY(`teachers_id`) REFERENCES `teachers_t`(`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;







DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('mary','{noop}test123',1),
('susan','{noop}test123',1);



DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');















