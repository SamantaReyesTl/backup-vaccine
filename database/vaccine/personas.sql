create table personas
(
    id                       int auto_increment
        primary key,
    curp                     varchar(255) null,
    datos_clinicos_id        int          null,
    datos_clinicos_matricula varchar(255) null,
    registro_vacuna_id       int          null,
    nombre                   varchar(255) null,
    apellido_paterno         varchar(255) null,
    apellido_materno         varchar(255) null,
    fecha_nacimiento         varchar(255) null,
    calle                    varchar(255) null,
    numero_casa              varchar(255) null,
    colonia_localidad        varchar(255) null,
    municipio_alcaldia       varchar(255) null,
    codigo_postal            int          null,
    entidad_federativa       varchar(255) null,
    lugar_nacimiento         varchar(255) null,
    constraint curp
        unique (curp),
    constraint datos_clinicos_id
        foreign key (datos_clinicos_id) references datos_clinicos (id),
    constraint datos_clinicos_matricula
        foreign key (datos_clinicos_matricula) references datos_clinicos (matricula),
    constraint registro_vacuna_id
        foreign key (registro_vacuna_id) references registro_vacuna (id)
);

