CREATE TABLE `RECURSOS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `disponible` int(2) NOT NULL,
  PRIMARY KEY (`id`,`nombre`)
) ENGINE=InnoDB;

