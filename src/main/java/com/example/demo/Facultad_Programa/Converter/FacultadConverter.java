package com.example.demo.Facultad_Programa.Converter;
import com.example.demo.Facultad_Programa.Entity.Facultad;
import com.example.demo.Facultad_Programa.Model.FacultadModel;

import org.springframework.stereotype.Component;

@Component("facultadConverter")
public class FacultadConverter {

    public FacultadModel entityToModel(Facultad facultad) { 
        FacultadModel fac = new FacultadModel();
            if(facultad!=null){
                fac.setId(facultad.getId());
                fac.setNombre(facultad.getNombre());

            }
        return fac;
    }

    public Facultad modelToEntity(FacultadModel facultad) {
        Facultad fac = new Facultad();
            if(facultad!=null){
                fac.setId(facultad.getId());
                fac.setNombre(facultad.getNombre());
            }
        return fac;
    }
}
