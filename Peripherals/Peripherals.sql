DROP TABLE IF EXISTS `peripherals`.`peri`;
CREATE TABLE  `peripherals`.`peri` (
  `itemCode` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;