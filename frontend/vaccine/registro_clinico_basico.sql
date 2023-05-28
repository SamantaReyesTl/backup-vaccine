create table registro_clinico_basico
(
    id_personas int          not null
        primary key,
    tipo_sangre varchar(100) null,
    sexo        varchar(10)  null,
    peso        double       null,
    altura      double       null,
    alergias    varchar(255) null,
    constraint personas_id1
        foreign key (id_personas) references personas (id)
            on delete cascade
);

