
cd ..
cd ..
cd xampp/mysql/bin
mysql -u springstudent -p
springstudent



DROP SCHEMA IF EXISTS `spring_multidrop_dropdown`;

CREATE SCHEMA `spring_multidrop_dropdown`;

use `spring_multidrop_dropdown`;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE if exists `country`;
create table `country`(

	`id` int(11) not null auto_increment,
	`name` varchar(255) not null,
	primary key(`id`)
);


insert into country(`name`) values("country 1");
insert into country(`name`) values("country 2");
insert into country(`name`) values("country 3");
insert into country(`name`) values("country 4");
insert into country(`name`) values("country 5");
insert into country(`name`) values("country 6");
insert into country(`name`) values("country 7");
insert into country(`name`) values("country 8");


drop table if exists `state`;
create table `state`(
	`id` int(11) not null auto_increment,
	`name` varchar(255) not null,
	`country_id` int(11) not null,
	primary key(`id`),
	foreign key(`country_id`) references `country`(`id`)



)
SET FOREIGN_KEY_CHECKS = 1;

insert into state(`name`,`country_id`) values("state 1",1);
insert into state(`name`,`country_id`) values("state 2",1);
insert into state(`name`,`country_id`) values("state 3",1);
insert into state(`name`,`country_id`) values("state 4",1);
insert into state(`name`,`country_id`) values("state 1",2);
insert into state(`name`,`country_id`) values("state 2",2);
insert into state(`name`,`country_id`) values("state 3",2);
insert into state(`name`,`country_id`) values("state 1",3);
insert into state(`name`,`country_id`) values("state 2",3);
insert into state(`name`,`country_id`) values("state 3",3);
insert into state(`name`,`country_id`) values("state 4",3);








drop table if exists `city`;
create table `city`(
	`id` int(11) not null auto_increment,
	`name` varchar(255) not null,
	`state_id` int(11) not null,
	primary key(`id`),
	foreign key(`state_id`) references `state`(`id`)

)
set foreign_key_check=1;


insert into city(`name`,`state_id`) values("state 1",1);
insert into city(`name`,`state_id`) values("state 2",1);
insert into city(`name`,`state_id`) values("state 3",1);
insert into city(`name`,`state_id`) values("state 1",2);
insert into city(`name`,`state_id`) values("state 2",2);
insert into city(`name`,`state_id`) values("state 3",2);
insert into city(`name`,`state_id`) values("state 1",3);
insert into city(`name`,`state_id`) values("state 2",3);
insert into city(`name`,`state_id`) values("state 3",3);
insert into city(`name`,`state_id`) values("state 4",3);
insert into city(`name`,`state_id`) values("state 1",4);
insert into city(`name`,`state_id`) values("state 2",4);












