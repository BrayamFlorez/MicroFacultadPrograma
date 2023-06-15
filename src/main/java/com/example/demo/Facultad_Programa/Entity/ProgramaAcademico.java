package com.example.demo.Facultad_Programa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programa_academico", schema = "uvEMEGXn6u")
public class ProgramaAcademico {

    @Id
    @Column(name = "id") 
    private long id;

    @Column(name = "nombre")
    private String nombre;

    
    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    private Facultad idFacultad;

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

    
}
