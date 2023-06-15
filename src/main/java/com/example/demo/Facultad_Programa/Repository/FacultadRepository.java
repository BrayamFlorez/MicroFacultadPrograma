package com.example.demo.Facultad_Programa.Repository;

import java.util.Optional;

import com.example.demo.Facultad_Programa.Entity.Facultad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("facultadRepository")
public interface FacultadRepository extends JpaRepository<Facultad, Long> {
    
    @Transactional(readOnly = true)
    Optional<Facultad> findById(Long id);
    
    @Transactional
    @Modifying
	  @Query(value = "UPDATE facultad SET facultad.id = :idNueva , facultad.nombre = :nombre WHERE facultad.id = :id",
//			  update Users u set u.status = ? where u.name = )
	    nativeQuery = true)
	  int updateFacultadSetStatusForNameNative(Long id, String nombre, Long idNueva);

    
}
