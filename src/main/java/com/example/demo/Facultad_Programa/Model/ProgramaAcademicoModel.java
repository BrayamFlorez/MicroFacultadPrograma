package com.example.demo.Facultad_Programa.Model;

import com.example.demo.Facultad_Programa.Entity.Facultad;

public class ProgramaAcademicoModel {

    private long id;
    private String nombre;
    private Facultad idFacultad;
    private Long facultad;

    public ProgramaAcademicoModel(){}
    
    public ProgramaAcademicoModel(long id, String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Long getFacultad() {
        return facultad;
    }

    public void setFacultad(Long facultad) {
        this.facultad = facultad;
    }

	@Override
	public String toString() {
		return "ProgramaAcademicoModel [id=" + id + ", nombre=" + nombre + ", idFacultad=" + idFacultad + ", facultad="
				+ facultad + "]";
	}
    
    

    
}
