package com.example.demo.Facultad_Programa.Repository;

import java.util.Optional;

import com.example.demo.Facultad_Programa.Entity.ProgramaAcademico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("programaAcademicoRepository")
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    
    
    @Transactional(readOnly = true)
    Optional<ProgramaAcademico> findProgramById(Long id);
    
    @Transactional
    @Modifying
	  @Query(value = "UPDATE programa_academico SET programa_academico.id = :idNueva , programa_academico.nombre = :nombre, programa_academico.id_facultad = :facultad WHERE programa_academico.id = :id",
//			  update Users u set u.status = ? where u.name = )
	    nativeQuery = true)
	  int updateProgramaSetStatusForNameNative(Long id, String nombre, Long facultad, Long idNueva);

    
}
