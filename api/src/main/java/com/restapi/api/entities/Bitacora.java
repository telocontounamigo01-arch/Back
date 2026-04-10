package com.restapi.api.entities;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tipo de acción realizada (Inicio Sesión, Envío Encuesta, etc.)
    private String accion;

    // Descripción detallada opcional
    private String descripcion;

    // Fecha y hora de la acción
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "User_Associate")
    @JsonBackReference
    private User usuario_Regi;

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public User getUsuario_Regi() {
        return usuario_Regi;
    }

    public void setUsuario_Regi(User User_Associate) {
        this.usuario_Regi = User_Associate;
    }
    
}
