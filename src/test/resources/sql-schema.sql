DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
drop table if exists `items`;
CREATE TABLE IF NOT EXISTS `items` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`product_name` VARCHAR(40) DEFAULT NULL,
	`product_price` DOUBLE DEFAULT NULL,
    PRIMARY KEY(`id`)
    );
