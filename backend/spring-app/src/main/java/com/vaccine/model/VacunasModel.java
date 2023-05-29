package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class VacunasModel {
    private Integer id;
    //private String folio;
    private String nombre_Vacuna;
    private String enfermedad_Previene;
    private Integer numero_Dosis;
    private Integer edad_Vacunacion;
    //private String proposito;
    private Integer esquema_1;
    private Integer esquema_2;
    private Integer siguiente_Esquema;
    //private String periodo;
}
