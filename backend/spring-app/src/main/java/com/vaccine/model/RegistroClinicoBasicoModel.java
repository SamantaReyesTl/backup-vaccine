package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * En Java los modelos son clases que representan exactamente a las tablas de la base de datos.
 * Por lo tanto DatosClinicosModel representa a la tabla datos_clinicos.
 *
 * Ocupamos la anotacion @Data de Lombok para no tener que escribir los getters y setters.
 * y @AllArgsConstructor para no tener que escribir el constructor.
 *
 * Lomnok es una libreria que realiza el codigo por nosotros.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroClinicoBasicoModel {
    private String curp_personas;
    private String tipoSangre;
    private Boolean sexo;   //0 es mujer, 1 es hombre
    private Double peso;
    private Double altura;
    private String alergias;
}