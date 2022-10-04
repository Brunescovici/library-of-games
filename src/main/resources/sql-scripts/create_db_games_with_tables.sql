DROP DATABASE IF EXISTS `brun_games`;

CREATE DATABASE IF NOT EXISTS `brun_games`;
USE `brun_games`;

DROP TABLE IF EXISTS `games`;

CREATE TABLE `games`(
	`id` bigint(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL UNIQUE,
    `description` varchar(200) NOT NULL,
    `price` float unsigned NOT NULL CHECK(price > 0),
    `price_type` varchar(10) NOT NULL,
    CONSTRAINT CHECK_PRICE_TYPE CHECK(
		price_type IN('CHEAP', 'REGULAR', 'EXPENSIVE')
    ),
    `genre` varchar(40) NOT NULL,
    `is_child_friendly` BIT NOT NULL,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;



INSERT INTO `games` (name, description, price, price_type, genre, is_child_friendly)
VALUES ('The Sims 4', "The Sims 4 is a 2014 social simulation game developed by Maxis and published by Electronic Arts. It is the fourth major title in The Sims series, and is the sequel to The Sims 3 (2009).", 40, 'EXPENSIVE', 'ACTION', 1),
('Spore', "Spore is a 2008 life simulation real-time strategy God game developed by Maxis and published by Electronic Arts for Microsoft Windows and Mac OS X. It was designed by Will Wright.", 10, 'CHEAP', 'ADVENTURE,RPG', 1),
('League of Legends', "League of Legends (LoL), commonly referred to as League, is a 2009 multiplayer online battle arena video game developed and published by Riot Games.", 5, 'CHEAP', 'STRATEGY,ACTION', 0);