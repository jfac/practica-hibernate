create DATABASE javapractico;

CREATE TABLE `javapractico`.`user` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `ApellidoPaterno` VARCHAR(45) NOT NULL,
  `ApellidoMaterno` VARCHAR(45) NOT NULL,
  `RFC` VARCHAR(13) NOT NULL,
  `CorreoElectronico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`));