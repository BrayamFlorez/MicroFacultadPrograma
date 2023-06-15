package com.example.demo.Facultad_Programa.Converter;
import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;
import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;

import org.springframework.stereotype.Component;

@Component("programaAcademicoConverter")
public class ProgramaAcademicoConverter {

    public ProgramaAcademicoModel entityToModel(ProgramaAcademico programa) {
        ProgramaAcademicoModel prog = new ProgramaAcademicoModel();
            if(programa!=null){
                prog.setId(programa.getId());
                prog.setNombre(programa.getNombre());
                prog.setIdFacultad(programa.getIdFacultad());

            }
        return prog;
    }

    public ProgramaAcademico modelToEntity(ProgramaAcademicoModel programa) {
        ProgramaAcademico prog = new ProgramaAcademico();
            if(programa!=null){
                prog.setId(programa.getId());
                prog.setNombre(programa.getNombre());
                prog.setIdFacultad(programa.getIdFacultad());
            }
        return prog;
    }
}
