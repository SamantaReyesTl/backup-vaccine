create table vacunas
(
    id                  int auto_increment
        primary key,
    nombre_vacuna       varchar(100) null,
    enfermedad_previene varchar(100) null,
    numero_dosis        int          null comment 'Si el numero de dosis es 0 se aplica n veces',
    edad_vacunacion     int          null comment 'Numero de meses de la toma inicial',
    esquema_1           int          null comment 'Primer refuerzo',
    esquema_2           int          null comment 'Refuerzos subsecuentes',
    siguiente_esquema   int          null comment 'Si es igual o mayor al numero de dosis se toma el siguiente esquema (2)'
);

