package com.example.demo.Facultad_Programa.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Facultad_Programa.Converter.ProgramaAcademicoConverter;
import com.example.demo.Facultad_Programa.Entity.Facultad;
import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;
import com.example.demo.Facultad_Programa.Model.FacultadModel;
import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;
import com.example.demo.Facultad_Programa.Repository.FacultadRepository;
import com.example.demo.Facultad_Programa.Repository.ProgramaAcademicoRepository;
import com.example.demo.Facultad_Programa.Service.ProgramaAcademicoService;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service("programaAcademicoServiceImpl")
public class ProgramaAcademicoServiceImpl implements ProgramaAcademicoService{

    @Autowired
    @Qualifier("programaAcademicoRepository")
    private ProgramaAcademicoRepository programaAcademicoRepository;

    @Autowired
    @Qualifier("programaAcademicoConverter")
    private ProgramaAcademicoConverter programaAcademicoConverter;

    @Autowired
    @Qualifier("facultadRepository")
    private FacultadRepository facultadRepository;

    

    @Override
    public List<ProgramaAcademicoModel> getAllProgramasAcademicos() {
        List<ProgramaAcademico> listadoProg = programaAcademicoRepository.findAll();
        List<ProgramaAcademicoModel> lista = new ArrayList<>();

        for (ProgramaAcademico p : listadoProg) {
            lista.add(programaAcademicoConverter.entityToModel(p));

        }
        return lista;
    }


    @Override
    public ProgramaAcademicoModel crearPrograma(ProgramaAcademicoModel programaModel) {
        ProgramaAcademicoModel prog = null;
        try {


            programaModel.setIdFacultad(facultadRepository.getById(programaModel.getFacultad()));


            System.out.println(programaModel.getIdFacultad().getNombre());
            ProgramaAcademico residuo = programaAcademicoRepository.save(programaAcademicoConverter.modelToEntity(programaModel));
           
            prog = programaAcademicoConverter.entityToModel(residuo);
        }  catch (NullPointerException e) {
        } catch (SQLGrammarException e) {
            System.out.println(e);
        } 
        return prog;
    }

    @Override
    public boolean deletePrograma(Long id) {
        boolean resultado =false;
        try {
            programaAcademicoRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
    }

    @Override
    public ProgramaAcademicoModel getPrograma(Long id) {

        ProgramaAcademicoModel programa = programaAcademicoConverter.entityToModel(programaAcademicoRepository.getById(id));
     
        return  programa ;
    }



	@Override
	public List<String> crearProgramaMasivo(List<ProgramaAcademicoModel> programa) {
		List<String> rta = new ArrayList<>();
	        try {
	        	
	        	for(ProgramaAcademicoModel pro: programa) {
	        		
	                pro.setIdFacultad(facultadRepository.getById(pro.getFacultad()));
	                
	                

	                ProgramaAcademico residuo = programaAcademicoRepository.save(programaAcademicoConverter.modelToEntity(pro));
		            if(residuo==null) {
		            	rta.add("Fallo al agregar a "+pro.getNombre());
		            }else {
		            	rta.add("Registro Exitoso");
		            }

	        	}

	           
	        } catch (SQLGrammarException e) {
	            System.out.println(e);
	        } catch (InvalidDataAccessApiUsageException e) {
	            System.out.println(e);
	        } catch (IllegalArgumentException e) {
	            System.out.println(e);
	        }
		return rta;
	}
	public Boolean editarPrograma(ProgramaAcademicoModel programaModel, Long nuevaId) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + programaModel.toString());

					if (programaAcademicoRepository.updateProgramaSetStatusForNameNative(programaModel.getId(),
							programaModel.getNombre(), programaModel.getFacultad() ,nuevaId) != 0) {
						resultado = true;
					}
				

			

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public List<ProgramaAcademicoModel> crearListadoPrograma(List<ProgramaAcademicoModel> programa) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
