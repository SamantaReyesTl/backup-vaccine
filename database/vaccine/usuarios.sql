create table usuarios
(
    id               int auto_increment
        primary key,
    nombre           varchar(100) null,
    contraseña       varchar(100) null,
    comunidad        varchar(100) null,
    es_administrador tinyint(1)   null
);

