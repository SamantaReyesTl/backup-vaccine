create table registro_vacuna
(
    id           int auto_increment
        primary key,
    personas_id  int          null,
    vacunas_id   int          null,
    region       varchar(255) null,
    fecha_vacuna varchar(255) null,
    laboratiorio varchar(255) null,
    lote         varchar(255) null,
    dosis        varchar(255) null,
    constraint personas_id
        foreign key (personas_id) references personas (id),
    constraint vacunas_id
        foreign key (vacunas_id) references vacunas (id)
);

