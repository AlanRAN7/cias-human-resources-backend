package com.pruebaTecnica.app.cqciasrecursoshumanos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pruebaTecnica.app.cqciasrecursoshumanos.modelo.Persona;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {

    @Query("SELECT p FROM Persona p WHERE p.estatus = '1'")
    List<Persona> findByEstatus();
}
