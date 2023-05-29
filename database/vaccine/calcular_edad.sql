use vaccine;
SELECT * FROM personas, registro_clinico_basico;
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


/*eliminar lo de arriba*/