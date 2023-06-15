package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import com.example.demo.Facultad_Programa.Model.FacultadModel;
import com.example.demo.Facultad_Programa.Model.ProgramaAcademicoModel;
import com.example.demo.Facultad_Programa.Service.ProgramaAcademicoService;
import com.example.demo.Facultad_Programa.ServiceImpl.ProgramaAcademicoServiceImpl;
import com.google.gson.Gson;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProgramaAcademicoController {
    
    public static Log LOG = LogFactory.getLog(ProgramaAcademicoController.class);
	public static Gson gson = new Gson();
	
	ProgramaAcademicoModel u = new ProgramaAcademicoModel();
	@Autowired
	@Qualifier("programaAcademicoServiceImpl")
	private ProgramaAcademicoServiceImpl programaAcademicoService;

    @RequestMapping(value = "/programas-acad", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProgramaAcademicoModel>> getAllProgramasAcad() {
		List<ProgramaAcademicoModel> listaProgramaAcademicoModelReturn = null;
		try {
			listaProgramaAcademicoModelReturn = programaAcademicoService.getAllProgramasAcademicos();
			return new ResponseEntity<>(listaProgramaAcademicoModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/programas-acad/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ProgramaAcademicoModel> addPrograma(@RequestBody ProgramaAcademicoModel programa) {
		System.out.println("----------------------------------------llega");

		HashMap<String, String> msg = new HashMap<>();
		ProgramaAcademicoModel usuarioModel = null;
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			usuarioModel = programaAcademicoService.crearPrograma(programa);
			
			return new ResponseEntity<>(usuarioModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/programas-acad/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleterPrograma(@PathVariable long id) {
		boolean resultado =false;
        try {
			resultado=programaAcademicoService.deletePrograma(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/programas-acad/buscarBy/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProgramaAcademicoModel buscarByID(@PathVariable long id) {
		ProgramaAcademicoModel resultado =new ProgramaAcademicoModel();
        try {
			resultado=programaAcademicoService.getPrograma(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/programas-acad/nombre/{nombre}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ProgramaAcademicoModel> findProgramaXNombre(@PathVariable String nombre) {
		ProgramaAcademicoModel ProgramaAcademicoModelReturn = null;
		try {
			ProgramaAcademicoModelReturn =null;
			return new ResponseEntity<>(ProgramaAcademicoModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@RequestMapping(value = "/programas-acad/masivo", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<List<String>> addProgramaMasivo(@RequestBody List<ProgramaAcademicoModel> programa) {
//		
//		Boolean programaModel = null;
//		try {
//			 
//			
//			return new ResponseEntity<>(programaAcademicoService.crearProgramaMasivo(programa), HttpStatus.OK);
//		} catch (HibernateException e) {
//			LOG.error("Error: " + e.getMessage());
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}



	@RequestMapping(value = "/programas-acad/masivo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> addMasivo(@RequestBody List<ProgramaAcademicoModel> programa) {
		HashMap<String, String> msg = new HashMap<>();

		try {
			
			
			return new ResponseEntity<>(programaAcademicoService.crearProgramaMasivo(programa), HttpStatus.OK);
			} catch (HibernateException e) {
				LOG.error("Error: " + e.getMessage());
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
	@RequestMapping(value = "/programas-acad/editar/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> editarFacultad(@RequestBody ProgramaAcademicoModel programa,@PathVariable Long id) {
		
		Boolean resultado = null;
		try {
			
			resultado =programaAcademicoService.editarPrograma(programa,id);
			
			return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@RequestMapping(value = "/facultad/masivo", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<List<String>> addMasivo(@RequestBody List<FacultadModel> facultad) {
//		HashMap<String, String> msg = new HashMap<>();
//		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
//		try {
//			
//			
//			return new ResponseEntity<>(facultadService.crearFacultadMasivo(facultad), HttpStatus.OK);
//		} catch (HibernateException e) {
//			LOG.error("Error: " + e.getMessage());
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}


}
