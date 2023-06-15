package com.example.demo.Controller;
import java.util.HashMap;
import java.util.List;

import com.example.demo.Facultad_Programa.Model.FacultadModel;
import com.example.demo.Facultad_Programa.ServiceImpl.FacultadServiceImpl;
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
public class FacultadController {
    public static Log LOG = LogFactory.getLog(FacultadController.class);
	public static Gson gson = new Gson();
	
	FacultadModel u = new FacultadModel();
	@Autowired
	@Qualifier("facultadServiceImpl")
	private FacultadServiceImpl facultadService;

    @RequestMapping(value = "/facultad", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<FacultadModel>> getFacultades() {
		List<FacultadModel> listaFacultadModelReturn = null;
		try {
			listaFacultadModelReturn = facultadService.getAllFacultades();
			return new ResponseEntity<>(listaFacultadModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/facultad/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<FacultadModel> addFacultad(@RequestBody FacultadModel facultad) {
		
		FacultadModel facultadModel = null;
		try {
			
			facultadModel = facultadService.crearFacultad(facultad);
			
			return new ResponseEntity<>(facultadModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/facultad/editar/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> editarFacultad(@RequestBody FacultadModel facultad,@PathVariable Long id) {
		
		Boolean resultado = null;
		try {
			
			resultado =facultadService.editarFacultad(facultad,id);
			
			return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/facultad/masivo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<String>> addMasivo(@RequestBody List<FacultadModel> facultad) {
		HashMap<String, String> msg = new HashMap<>();
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			
			return new ResponseEntity<>(facultadService.crearFacultadMasivo(facultad), HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/facultad/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleterFacultad(@PathVariable long id) {
		boolean resultado =false;
        try {
			resultado=facultadService.deleteFacultad(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}

	@RequestMapping(value = "/facultad/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FacultadModel> getFacultad(@PathVariable long id) {
		FacultadModel FacultadModelReturn = null;
		try {
			FacultadModelReturn = facultadService.getFacultadWithId(id);
			return new ResponseEntity<>(FacultadModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@RequestMapping(value = "/facultad/nombre/{nombre}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FacultadModel> findFacultadXNombre(@PathVariable String nombre) {
		FacultadModel FacultadModelReturn = null;
		try {
			FacultadModelReturn = facultadService.buscarPorNombre(nombre);
			return new ResponseEntity<>(FacultadModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/facultad/addMas", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> addfacultadMasivo(@RequestBody List<FacultadModel> facultad) {
		
		Boolean facultadModel = null;
		try {
			
			facultadModel = facultadService.agregaMasiva(facultad);
			
			return new ResponseEntity<>(facultadModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
