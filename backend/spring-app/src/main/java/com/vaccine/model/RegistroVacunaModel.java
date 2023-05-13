package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * En Java los modelos son clases que representan exactamente a las tablas de la base de datos.
 * Por lo tanto RegistroVacunaModel representa a la tabla registro_vacuna.
 *
 * Ocupamos la anotacion @Data de Lombok para no tener que escribir los getters y setters.
 * y @AllArgsConstructor para no tener que escribir el constructor.
 *
 * Lomnok es una libreria que realiza el codigo por nosotros.
 */

@Data
@AllArgsConstructor
public class RegistroVacunaModel {

    /**
     * Esta clase tiene persona_model_id y vacuna_model_id, por lo cual se representa como si
     * esta tabla contiene una persona y una vacuna.
     */

    private Integer id;
    private String region;
    private String fechaVacunacion; // fecha de vacunacion
    private String laboratorio;
    private String lote;
    private String dosis;
    private PersonaModel personaModel;
    private VacunaModel vacunaModel;
}
