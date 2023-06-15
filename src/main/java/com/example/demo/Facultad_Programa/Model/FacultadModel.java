package com.example.demo.Facultad_Programa.Model;

public class FacultadModel {
    
    private Long id;
    private String nombre;

    public FacultadModel(){}

    public FacultadModel(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	@Override
	public String toString() {
		return "FacultadModel [id=" + id + ", nombre=" + nombre + "]";
	}
    
    
}
