
CREATE TABLE nueva_Vacuna(
id int(11) unsigned NOT NULL AUTO_INCREMENT,
nombre_vacuna VARCHAR(50),
folio INT(50),
cantidad_dosis INT(10),	/* cantidad de dosis que se aplican por vacuna*/
dosis INT(10), /*el miligramo de dosis que se aplica*/
periodo VARCHAR(100), /*CADA CUANTO se aplica la vacuna*/
descripcion VARCHAR(255),
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Sinovac','123', '2', '0.5', '4 a 6 meses', 'Vacuna covid, aplicarse dos 
dosis entre 4 a 6 meses, es efectiva para mayores de 18 años y personas 
de tercera edad');


DELETE FROM nueva_vacuna WHERE id = ?;
