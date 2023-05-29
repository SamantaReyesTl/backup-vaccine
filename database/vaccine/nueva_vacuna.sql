
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

INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'B C G','123', '123', '98', 'al nacer', 'Vacuna que previene la Tuberculosis
refuerzo cada 10 años');

INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Hepaptitis B','123', '3', '0', 'al nacer, 2 mese. 6 meses', 'Vacuna que previene la 
Hepatitis B, aplicarla al nacer, 2 mese despues y 6 meses despues');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Rotavirus','123', '2', '0', '2 mese, 4 meses', 'Vacuna que previene la diarrea
por Rotavirus se aplica 2 y 6 mese despues de nacer');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Rotavirus','123', '2', '0', '2 mese, 4 meses', 'Vacuna que previene la diarrea
por Rotavirus se aplica 2 y 6 mese despues de nacer');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Influenza','123', '3', '0', '6, 7 meses y anual', 'Vacuna que previene la influenza,
se apica al tener 6 y 7 mese despues de nacer, despues de manera anual');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'S R P','1', '2', '0', '1 año, 6 mese', 'Vacuna que previene el Sarampion
Rubeola y Parotiditis se aplica la primera dosis al cumplir un año 
despues de pasar 6 meses de la primera dosis');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Varicela','3', '2', '0', '12 mese, 4 años', 'Vacuna que previene la varicela
se aplica al cumplir 12 mese de nacer y despues 4 años');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'VPH','3', '3', '0', '9 años, 9 años y 2 meses, 9 años y 6 meses', 
'Vacuna que previene el virus del papiloma humano, se aplica a los 9 años, 
se aplica al tener 2 y 6 mese despues de la anterior dosis');
INSERT INTO nueva_vacuna (
nombre_vacuna, folio, cantidad_dosis, dosis, 
periodo, descripcion) VALUES(
'Hepatitis A','3', '2', '0', '12 y 18 meses', 
'Vacuna que previene la Hepatitis A, se aplican dos dos, al cumplir 12 meses y 
la segunda al tener 12 mese');


DELETE FROM nueva_vacuna WHERE id = ?;

