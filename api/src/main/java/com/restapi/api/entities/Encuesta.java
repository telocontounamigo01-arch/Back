package com.restapi.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String idPreguntas;
    private String idUser;
    private String idInstitucion;
    private String fecha;

    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuesta4;
    private String respuesta5;
    private String respuesta6;
    private String respuesta7;
    private String respuesta8;
    private String respuesta9;
    private String respuesta10;
    private String respuesta11;
    private String respuesta12;
    private String respuesta13;
    private String respuesta14;
    private String respuesta15;


    // Si querés guardar quién respondió o quién creó la encuesta:
    // @ManyToOne
    // private User usuario;

    // ======= Getters y Setters =======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String Respuesta1) {
        this.respuesta1 = Respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String Respuesta2) {
        this.respuesta2 = Respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String Respuesta3) {
        this.respuesta3 = Respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(String Respuesta4) {
        this.respuesta4 = Respuesta4;
    }

    public String getRespuesta5() {
        return respuesta5;
    }

    public void setRespuesta5(String Respuesta5) {
        this.respuesta5 = Respuesta5;
    }

    public String getRespuesta6() {
        return respuesta6;
    }

    public void setRespuesta6(String Respuesta6) {
        this.respuesta6 = Respuesta6;
    }

    public String getRespuesta7() {
        return respuesta7;
    }

    public void setRespuesta7(String Respuesta7) {
        this.respuesta7 = Respuesta7;
    }

    public String getRespuesta8() {
        return respuesta8;
    }

    public void setRespuesta8(String Respuesta8) {
        this.respuesta8 = Respuesta8;
    }

    public String getRespuesta9() {
        return respuesta9;
    }

    public void setRespuesta9(String Respuesta9) {
        this.respuesta9 = Respuesta9;
    }

    public String getRespuesta10() {
        return respuesta10;
    }

    public void setRespuesta10(String Respuesta10) {
        this.respuesta10 = Respuesta10;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String IdUser) {
        idUser = IdUser;
    }

    public String getidInstitucion() {
        return idInstitucion;
    }

    public void setidInstitucion(String IdInstitucion) {
        idInstitucion = IdInstitucion;
    }

    public String getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(String idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getRespuesta11() {
        return respuesta11;
    }

    public void setRespuesta11(String respuesta11) {
        this.respuesta11 = respuesta11;
    }

    public String getRespuesta12() {
        return respuesta12;
    }

    public void setRespuesta12(String respuesta12) {
        this.respuesta12 = respuesta12;
    }

    public String getRespuesta13() {
        return respuesta13;
    }

    public void setRespuesta13(String respuesta13) {
        this.respuesta13 = respuesta13;
    }

    public String getRespuesta14() {
        return respuesta14;
    }

    public void setRespuesta14(String respuesta14) {
        this.respuesta14 = respuesta14;
    }

    public String getRespuesta15() {
        return respuesta15;
    }

    public void setRespuesta15(String respuesta15) {
        this.respuesta15 = respuesta15;
    }
    
}
