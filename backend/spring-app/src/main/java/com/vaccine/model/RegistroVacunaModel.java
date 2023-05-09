package com.vaccine.model;

/**
 * Permite unir tanto Personas con Vacunas
 */
public class RegistroVacunaModel {
    private Integer id;
    private String region;
    private String fechaVacunacion; // fecha de vacunacion
    private String laboratorio;
    private String lote;
    private String dosis;
    private PersonaModel personaModel;
    private VacunaModel vacunaModel;

    public RegistroVacunaModel(Integer id, String region, String fechaVacunacion,
                               String laboratorio, String lote, String dosis,
                               PersonaModel personaModel, VacunaModel vacunaModel) {
        this.id = id;
        this.region = region;
        this.fechaVacunacion = fechaVacunacion;
        this.laboratorio = laboratorio;
        this.lote = lote;
        this.dosis = dosis;
        this.personaModel = personaModel;
        this.vacunaModel = vacunaModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(String fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public PersonaModel getPersonaModel() {
        return personaModel;
    }

    public void setPersonaModel(PersonaModel personaModel) {
        this.personaModel = personaModel;
    }

    public VacunaModel getVacunaModel() {
        return vacunaModel;
    }

    public void setVacunaModel(VacunaModel vacunaModel) {
        this.vacunaModel = vacunaModel;
    }
}
