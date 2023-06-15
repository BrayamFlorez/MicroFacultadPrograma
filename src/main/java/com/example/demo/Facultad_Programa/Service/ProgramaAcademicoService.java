package com.example.demo.Facultad_Programa.Service;

import java.util.List;

import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;

import org.springframework.stereotype.Service;

@Service
public interface ProgramaAcademicoService {
    
    public abstract List<ProgramaAcademicoModel> getAllProgramasAcademicos();

    public abstract List<ProgramaAcademicoModel> crearListadoPrograma(List<ProgramaAcademicoModel> programa);

    public abstract ProgramaAcademicoModel getPrograma(Long id);

    public abstract ProgramaAcademicoModel crearPrograma(ProgramaAcademicoModel programa);

    public abstract boolean deletePrograma(Long id);

	public abstract List<String> crearProgramaMasivo(List<ProgramaAcademicoModel> programa);
	
}
