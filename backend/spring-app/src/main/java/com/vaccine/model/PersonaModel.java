package com.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaModel {
    private Integer id;
    private String CURP;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String calle;
    private String numeroCasa;
    private String coloniaLocalidad;
    private String municipioAlcaldia;
    private String codigoPostal;
    private String entidadFederativa;
    private String lugarNacimiento;
    private Integer datosClinicosId;
    private String datosClinicosMatricula;
    private DatosClinicosModel datosClinicosModel;
}