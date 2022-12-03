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



CREATE TABLE `USUARIOS` (
	`carnet` INT(7) NOT NULL,
	`nombre` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`correo` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`contraseña` VARCHAR(15) NOT NULL COLLATE 'latin1_swedish_ci',
	`rol` VARCHAR(15) NOT NULL COLLATE 'latin1_swedish_ci',
	`carrera` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`carnet`) USING BTREE,
	UNIQUE INDEX `UK_correo` (`correo`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;