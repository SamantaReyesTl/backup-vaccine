create table registro_vacuna
(
    folio          int auto_increment
        primary key,
    id_vacunas     int          null,
    curp_personas  varchar(18)  null,
    dosis          int          null,
    fecha_vacuna   date         null,
    proxima_vacuna date         null,
    laboratiorio   varchar(100) null,
    lote           varchar(100) null,
    constraint curp_personas
        foreign key (curp_personas) references personas (curp),
    constraint vacunas_id
        foreign key (id_vacunas) references vacunas (id)
);

create index curp_personas_idx
    on registro_vacuna (curp_personas);

