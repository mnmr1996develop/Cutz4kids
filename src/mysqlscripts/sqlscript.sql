-- create schema `Cutz4kids`;

use `Cutz4kids`;

drop table if exists `user`, `authorities`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `locked` boolean,
  `enabled` boolean,
  `discriminator` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `authorities`(
	`id` int(11) unsigned NOT NULL,
    `authority` varchar(50) NOT NULL,
    unique key `authorities_idx_1` (`id`, `authority`),
    constraint `authorities_ibfk_1` foreign key(`id`)
    references `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 drop view if exists `Managers`, `Customers`;
 
CREATE VIEW Managers AS
    SELECT 
        *
    FROM
        user
	Where user.discriminator = "Manager";
    
CREATE VIEW Customers AS
    SELECT 
        *
    FROM
        user
	Where user.discriminator = "User";
    