CREATE TABLE usuarios (
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    nombre             VARCHAR(255) NULL,
    apellido_paterno   VARCHAR(255) NULL,
    apellido_materno   VARCHAR(255) NULL,
    usuario              VARCHAR(255) NULL,
    contrasena       VARCHAR(255) NULL,
    CONSTRAINT usuario UNIQUE (usuario)
);
