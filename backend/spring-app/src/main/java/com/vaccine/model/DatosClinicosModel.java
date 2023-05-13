package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

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
public class DatosClinicosModel {
    private Integer id;
    private String tipoSangre;
    private String matricula;
    private String unidadMedica;
    private String sexo;
    private String peso;
    private String altura;
}