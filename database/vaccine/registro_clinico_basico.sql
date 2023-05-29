create table registro_clinico_basico
(
    curp_personas varchar(100) not null
        primary key,
    tipo_sangre   varchar(100) null,
    sexo          varchar(10)  null,
    peso          double       null,
    altura        double       null,
    alergias      varchar(255) null,
    constraint curp_fk
        foreign key (curp_personas) references personas (curp)
            on delete cascade
);

create index curp_fk_idx
    on registro_clinico_basico (curp_personas);

