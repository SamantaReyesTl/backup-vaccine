create table datos_clinicos
(
    id            int          not null
        primary key,
    matricula     varchar(255) null,
    tipo_sangre   varchar(255) null,
    unidad_medica varchar(255) null,
    sexo          varchar(1)   null,
    peso          varchar(255) null,
    altura        varchar(255) null,
    constraint matricula
        unique (matricula)
);

