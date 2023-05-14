create table datos_clinicos
(
    id            int auto_increment
        primary key,
    matricula     varchar(255) null,
    personas_id   int          not null,
    tipo_sangre   varchar(255) null,
    unidad_medica varchar(255) null,
    sexo          varchar(1)   null,
    peso          varchar(255) null,
    altura        varchar(255) null,
    constraint matricula
        unique (matricula),
    constraint personas_id1
        foreign key (personas_id) references personas (id)
);

