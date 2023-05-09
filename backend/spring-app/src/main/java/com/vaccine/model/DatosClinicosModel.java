package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

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