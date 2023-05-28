create table vacunas
(
    id                  int auto_increment
        primary key,
    nombre_vacuna       varchar(100) null,
    enfermedad_previene varchar(100) null,
    tomas               varchar(100) null comment 'Aqui va el numero de tomas iniciales',
    refuerzo			varchar(100) null comment 'aquí se registra si se debe poner más dosis de manera anual o mensual u otro',
    edad_vacunacion     int          null,
    periodicidad        varchar(100) null comment 'Aqui va el plazo que se tiene que dejar para la siguiente toma en meses'
);





