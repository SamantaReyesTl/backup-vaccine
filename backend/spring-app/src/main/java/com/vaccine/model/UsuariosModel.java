package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    private Integer id;
    private String nombre;
    private String contrasena;
    private String comunidad;
    private Boolean es_administrador;
}
