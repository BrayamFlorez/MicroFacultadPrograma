package com.example.demo.Facultad_Programa.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "facultad", schema = "uvEMEGXn6u")
public class Facultad {

    @Id
    @Column(name = "id") 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    @Column(name = "nombre")
    private String nombre;

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
}
