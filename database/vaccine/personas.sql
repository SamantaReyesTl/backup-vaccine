create table personas
(
    id                 int auto_increment
        primary key,
    curp               varchar(255) not null,
    nombre             varchar(255) null,
    apellido_paterno   varchar(255) null,
    apellido_materno   varchar(255) null,
    fecha_nacimiento   varchar(255) null,
    calle              varchar(255) null,
    numero_casa        varchar(255) null,
    colonia_localidad  varchar(255) null,
    municipio_alcaldia varchar(255) null,
    codigo_postal      int          null,
    entidad_federativa varchar(255) null,
    lugar_nacimiento   varchar(255) null,
    constraint curp
        unique (curp)
);

