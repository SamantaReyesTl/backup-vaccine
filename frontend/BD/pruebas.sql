USE vaccine;
SELECT * FROM datos_clinicos;
SELECT *FROM vacunas;

CREATE TABLE nueva_Vacuna(
id int(11) unsigned NOT NULL AUTO_INCREMENT,
nombre_vacuna VARCHAR(50),
cantidad_dosis INT(10),	/*el miligramo de dosis que se aplica*/	
dosis varchar(100), /* cantidad de dosis que se aplican por vacuna*/
periodo VARCHAR(100), /*CADA CUANTO se aplica la vacuna*/
descripcion VARCHAR(255), /* notas o especificaciones de la vacuna*/
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM nueva_vacuna;










RENAME TABLE nueva_vacuna TO vacuna_nueva;
RENAME TABLE vacunas TO vacuna_regitrada;

CREATE TABLE `vacunas` (
  `ID_vacunas` INT NOT NULL AUTO_INCREMENT,
  `nombre_vacuna` VARCHAR(255) NULL,
  `enfermedad` VARCHAR(255) NULL,
  `tomas` VARCHAR(255)  NULL,
  `frecuencia` VARCHAR(255) NULL,
  `edad` INT NULL,
  `fecha_vacunacion` VARCHAR(255) NULL,
  PRIMARY KEY (`ID_vacunas`));

SELECT * FROM vacunas;
DELIMITER //
create definer = root@localhost trigger calcular_edad
    before insert
    on personas
    for each row
BEGIN 
        SET NEW.edad = YEAR(CURDATE()) - YEAR(NEW.fecha_nacimiento) - 
        (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(NEW.fecha_nacimiento, '%m%d'));
END;
//






