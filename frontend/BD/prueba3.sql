SELECT * FROM vacunas;

CREATE TABLE nueva_Vacuna(
id int(11) unsigned NOT NULL AUTO_INCREMENT,
nombre_vacuna VARCHAR(50),
folio INT(50),
cantidad_dosis INT(10),	/*el miligramo de dosis que se aplica*/	
dosis varchar(100), /* cantidad de dosis que se aplican por vacuna*/
periodo VARCHAR(100), /*CADA CUANTO se aplica la vacuna*/
descripcion VARCHAR(255), /* notas o especificaciones de la vacuna*/
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
