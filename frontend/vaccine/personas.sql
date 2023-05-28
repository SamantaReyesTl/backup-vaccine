create table personas
(
    id                 int auto_increment
        primary key,
    curp               varchar(18)  not null,
    nombre             varchar(100) null,
    apellido_paterno   varchar(100) null,
    apellido_materno   varchar(100) null,
    fecha_nacimiento   date         null,
    edad               int          null,
    calle              varchar(100) null,
    numero_casa        int          null,
    colonia_localidad  varchar(100) null,
    comunidad          varchar(100) null,
    codigo_postal      int          null,
    entidad_federativa varchar(100) null,
    lugar_nacimiento   varchar(200) null,
    constraint curp
        unique (curp)
);

