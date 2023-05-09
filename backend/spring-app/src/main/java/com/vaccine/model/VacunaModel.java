package com.vaccine.model;

public class VacunaModel {
    private Integer id;
    private String folio;
    private String edadVacunacion;
    private String proposito;
    private String nombreVacuna;
    private String periodo;

    public VacunaModel(Integer id, String folio, String edadVacunacion,
                       String proposito, String nombreVacuna, String periodo) {
        this.id = id;
        this.folio = folio;
        this.edadVacunacion = edadVacunacion;
        this.proposito = proposito;
        this.nombreVacuna = nombreVacuna;
        this.periodo = periodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getEdadVacunacion() {
        return edadVacunacion;
    }

    public void setEdadVacunacion(String edadVacunacion) {
        this.edadVacunacion = edadVacunacion;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
