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

drop table if exists `orders`;
create table if not exists `orders` (
    `id` int(15) not null AUTO_INCREMENT,
    `cust_id` int(15) default null,
    `item_id` int(15) default null,
    primary key(`id`),
    foreign key(`cust_id`) references `customers`(`id`),
    foreign key(`item_id`) references `items`(`id`)
    );
    drop table if exists `basket`;
    create table if not exists `basket` (
    `basket_id` int(15) NOT NULL auto_increment,
    `orders_id` int(15) default null,
    `items_id` int(15) default null,
	`quantity` int(5) default null,
    `total_cost` double default null,
    primary key(`basket_id`),
    foreign key (`orders_id`) references `orders`(`id`),
    foreign key(`items_id`) references `items`(`id`));
)
