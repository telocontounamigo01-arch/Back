package com.restapi.api.dao.encuestaDao.interfaces;

import java.util.List;

import com.restapi.api.entities.Encuesta;


public interface  interfaceEncuestaDAOimp {

    public String createEncuesta(Encuesta encuesta);
    public String deleteEncuesta(Long id);
    List<Encuesta> allRegistrosByInstitucionAndTipo(String institucion, String tipo);

}
