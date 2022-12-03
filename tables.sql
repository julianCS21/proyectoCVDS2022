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
	`nombre` VARCHAR(50) NOT NULL ,
	`correo` VARCHAR(50) NOT NULL ,
	`contraseña` VARCHAR(15) NOT NULL,
	`rol` VARCHAR(15) NOT NULL ,
	`carrera` VARCHAR(50) NULL DEFAULT,
	PRIMARY KEY (`carnet`) USING BTREE,
	UNIQUE INDEX `UK_correo` (`correo`) USING BTREE
)
ENGINE=InnoDB
;