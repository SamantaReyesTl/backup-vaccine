CREATE TABLE `vacunas` (
  `ID_vacunas` INT NOT NULL AUTO_INCREMENT,
  `nombre_vacuna` VARCHAR(255) NULL,
  `enfermedad` VARCHAR(255) NULL,
  `tomas` VARCHAR(255)  NULL,
  `frecuencia` VARCHAR(255) NULL,
  `edad` INT NULL,
  `fecha_vacunacion` VARCHAR(255) NULL,
  PRIMARY KEY (`ID_vacunas`));
