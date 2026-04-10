package com.restapi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.encuestaDao.encuestaDAOimp;
import com.restapi.api.entities.Encuesta;


@Service
public class serviceEncuesta {

    @Autowired
    private encuestaDAOimp encuestDAOimp;


 
    public String CreateEncuesta(Encuesta encuesta){

        try {
            return encuestDAOimp.createEncuesta(encuesta);
        } catch (Exception e) {
            // TODO: handle exception
            return "FAIL";
            
        }
    }
   

    public String deleteEncuesta(Long id){

        try {
            return encuestDAOimp.deleteEncuesta(id);
        } catch (Exception e) {
            // TODO: handle exception
            return "FAIL";
        }
    }

    public List<Encuesta> allRegistrosByInstitucionAndTipo(String institucion, String tipo) {
        try {
            return encuestDAOimp.allRegistrosByInstitucionAndTipo(institucion, tipo);
        } catch (Exception e) {
            // loggear el error sería lo ideal
            return null; // lista vacía en caso de error
        }
    }

}
