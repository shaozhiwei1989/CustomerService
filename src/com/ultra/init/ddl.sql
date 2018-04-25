drop table if exists cs_customer_config
drop table if exists cs_system_config
drop table if exists cs_type_config
drop table if exists cs_cusaccount_config

CREATE TABLE `cs_customer_config` (`id_` bigint(20) NOT NULL AUTO_INCREMENT,`system_` varchar(512) DEFAULT NULL,`type_` varchar(512)DEFAULT NULL,`current_account_` varchar(512) DEFAULT NULL,PRIMARY KEY (`id_`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
CREATE TABLE `cs_system_config` (`id_` bigint(20) NOT NULL AUTO_INCREMENT,`name_` varchar(100) DEFAULT NULL,`order_` bigint(20) DEFAULT NULL,`icon_` varchar(100) DEFAULT NULL,PRIMARY KEY (`id_`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
CREATE TABLE `cs_type_config` (`id_` bigint(20) NOT NULL AUTO_INCREMENT,`name_` varchar(100) DEFAULT NULL,`order_` bigint(20) DEFAULT NULL,PRIMARY KEY (`id_`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
CREATE TABLE `cs_cusaccount_config` (`id_` bigint(20) NOT NULL AUTO_INCREMENT,`account_` varchar(512) DEFAULT NULL,`name_` varchar(512)DEFAULT NULL,`cus_config_id_` bigint(20) DEFAULT NULL,PRIMARY KEY (`id_`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
