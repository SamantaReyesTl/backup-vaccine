create table registro_vacuna
(
    folio          int auto_increment
        primary key,
    id_personas    int          null,
    id_vacunas     int          null,
    dosis          int          null,
    fecha_vacuna   date         null,
    proxima_vacuna date         null,
    laboratiorio   varchar(100) null,
    lote           varchar(100) null,	/*Dato no necesario pues no siempre tenemos esta informacion*/
    constraint personas_id
        foreign key (id_personas) references personas (id),
    constraint vacunas_id
        foreign key (id_vacunas) references vacunas (id)
);

