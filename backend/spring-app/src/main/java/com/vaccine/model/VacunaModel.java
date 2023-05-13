package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * En Java los modelos son clases que representan exactamente a las tablas de la base de datos.
 * Por lo tanto VacunaModel representa a la tabla vacuna.
 *
 * Ocupamos la anotacion @Data de Lombok para no tener que escribir los getters y setters.
 * y @AllArgsConstructor para no tener que escribir el constructor.
 *
 * Lomnok es una libreria que realiza el codigo por nosotros.
 */

@Data
@AllArgsConstructor
public class VacunaModel {
    private Integer id;
    private String folio;
    private String edadVacunacion;
    private String proposito;
    private String nombreVacuna;
    private String periodo;
}
