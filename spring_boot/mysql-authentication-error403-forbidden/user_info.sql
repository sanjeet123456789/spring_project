create table user(
`user_id` int,
`active` int,
`email` varchar(32) not null unique,
`last_name` varchar(32),
`name` varchar(32),
`password` varchar(32),
primary key(`user_id`)
);
INSERT into user values(1,1,'sanjeetpal007@gmail.com','pal','sanjeet','sanjeetpal');



create table role(
`role_id` int unique not null ,
`role` varchar(32) unique 
);





create table user_role(
`user_id` int unique,
`role_id` int unique
);
insert into role values(1,'ADMIN');
insert into user_role values(1,1);

--SET foreign_key_checks=0;
--alter table user_role add constraint FK5scdquo6f12cpstqai86x4biw foreign key (roles_role_id) references role (role_id);







DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`role_id`, `role`)
VALUES
	(1,'ADMIN');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`)
VALUES
	(1,1,'admin@gmail.com','s','Sam','sam'),
	(2,1,'admin@gmail.com','s','youtube','youtube');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
) ;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
	(1,1);

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;



alter table user_role add column roles_role_id integer not null;
alter table user_role drop index UK_5kaxls1hfq7tgnqrcylsf4gqv;
alter table user_role add constraint UK_5kaxls1hfq7tgnqrcylsf4gqv unique (roles_role_id);
alter table user_role add constraint FK5scdquo6f12cpstqai86x4biw foreign key (roles_role_id) references role (role_id);













