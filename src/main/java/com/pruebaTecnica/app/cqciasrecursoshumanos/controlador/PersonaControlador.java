package com.pruebaTecnica.app.cqciasrecursoshumanos.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pruebaTecnica.app.cqciasrecursoshumanos.excepciones.ResourceNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaTecnica.app.cqciasrecursoshumanos.modelo.Persona;
import com.pruebaTecnica.app.cqciasrecursoshumanos.repositorio.PersonaRepositorio;
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaControlador {
    @Autowired
    private PersonaRepositorio repositorio;

    //Conseguir todos los elementos de la base de datos
    @GetMapping("/persona")
    public List<Persona> listarTodasLasPersonas(){
        return repositorio.findByEstatus();
    }

    // Método para guardar datos
    @PostMapping("/persona")
    public Persona guardarPersona(@RequestBody Persona persona){
        return repositorio.save(persona);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id){
        Persona persona = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No fue encontrado la persona con el ID: " + id)));
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<Persona> actualizarPersonaPorId(@PathVariable Long id, @RequestBody Persona detallesPersona){
        Persona persona = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No fue encontrado la persona con el ID: " + id)));
        persona.setNombre(detallesPersona.getNombre());
        persona.setPrimer_apellido(detallesPersona.getPrimer_apellido());
        persona.setSegundo_apellido(detallesPersona.getSegundo_apellido());
        persona.setTelefono(detallesPersona.getTelefono());
        persona.setEstatus(detallesPersona.getEstatus());
        persona.setFechaUpd(detallesPersona.getFechaUpd());

        Persona personaActualizada = repositorio.save(persona);
        return ResponseEntity.ok(personaActualizada);
    }

    // Eliminar persona de la tabla

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
        Persona persona  = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));

        repositorio.delete(persona);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
