USE vacunas;
SELECT * FROM vacunas;

create table registro_vacuna
(
    folio          int auto_increment	/*identificador de la vacuna*/
        primary key,
    id_personas    int          null,
    id_vacunas     int          null,
    dosis          int          null,
    fecha_vacuna   date         null,
    proxima_vacuna date         null,
    laboratiorio   varchar(100) null,
    constraint personas_id
        foreign key (id_personas) references personas (id),
    constraint vacunas_id
        foreign key (id_vacunas) references vacunas (id)
);
use vacunas;
create table vacunas
(
    id                  int auto_increment
        primary key,
    nombre_vacuna       varchar(100) null,
    enfermedad_previene varchar(100) null,
    tomas               varchar(100) null comment 'Aqui va el numero de tomas iniciales',
    edad_vacunacion     int          null,
    refuerzo			varchar(100) null comment 'aquí se registra si se debe poner más dosis de manera anual o mensual u otro',
    periodicidad        varchar(100) null comment 'Aqui va el plazo que se tiene que dejar para la siguiente toma en meses'
);


ALTER TABLE vacunas  add periodicidad varchar(100) not null; 
Alter TABLE vacunas drop column refuerzo;


ALTER TABLE registro_vacuna drop column lote;

ALTER TABLE registro_vacuna  add lote varchar(100) null; 
