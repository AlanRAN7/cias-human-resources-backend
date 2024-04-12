package com.pruebaTecnica.app.cqciasrecursoshumanos.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "primer_apellido", length = 100, nullable = false)
    private String primer_apellido;
    @Column(name="segundo_apellido", length = 100, nullable = false)
    private String segundo_apellido;
    @Column(name="telefono", length = 10, nullable = false)
    private String telefono;
    @Column(name="estatus", length = 1, nullable = false)
    private String estatus;
    @Column(name="fechaIns")
    private LocalDateTime fechaIns;
    @Column(name="fechaUpd")
    private LocalDateTime fechaUpd;

    public Persona(){

    }

    public Persona(Integer id, String nombre, String primer_apellido, String segundo_apellido, String telefono, String estatus, LocalDateTime fechaIns, LocalDateTime fechaUpd) {
        // Id = id;
        super();
        this.id = id;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
        this.estatus = estatus;
        this.fechaIns = fechaIns;
        this.fechaUpd = fechaUpd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public LocalDateTime getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(LocalDateTime fechaIns) {
        this.fechaIns = fechaIns;
    }

    public LocalDateTime getFechaUpd() {
        return fechaUpd;
    }

    public void setFechaUpd(LocalDateTime fechaUpd) {
        this.fechaUpd = fechaUpd;
    }
}
