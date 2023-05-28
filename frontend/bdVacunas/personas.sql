CREATE TABLE personas (
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    curp               VARCHAR(255) NOT NULL,
    nombre             VARCHAR(255) NULL,
    apellido_paterno   VARCHAR(255) NULL,
    apellido_materno   VARCHAR(255) NULL,
    fecha_nacimiento   DATE NULL, --AAAA/MM/DD Ejemplo: 2001/12/28
    edad               INT NULL,
    calle              VARCHAR(255) NULL,
    numero_casa        VARCHAR(255) NULL,
    colonia_localidad  VARCHAR(255) NULL,
    municipio_alcaldia VARCHAR(255) NULL,
    codigo_postal      INT NULL,
    entidad_federativa VARCHAR(255) NULL,
    lugar_nacimiento   VARCHAR(255) NULL,
    CONSTRAINT curp UNIQUE (curp)
);
------Se crea un trigger que se ejecutará antes de insertar o actualizar un registro en la tabla:
DELIMITER //
CREATE TRIGGER calcular_edad BEFORE INSERT ON personas
FOR EACH ROW
BEGIN
    SET NEW.edad = YEAR(CURDATE()) - YEAR(NEW.fecha_nacimiento) -
        (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(NEW.fecha_nacimiento, '%m%d'));
END //
DELIMITER ;
