create table vacunas
(
    id              int auto_increment
        primary key,
    folio_vacuna    varchar(255) null,
    nombre_vacuna   varchar(255) null,
    edad_vacunacion varchar(255) null,
    registro_vacuna varchar(255) null,
    proposito       varchar(255) null,
    periodo         varchar(255) null
);

