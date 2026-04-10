package com.restapi.api.dao.preguntasDao.preguntas;

import com.restapi.api.entities.Preguntas;


public interface interfacePreguntasDao {

    String createPreguntas(Preguntas preguntas);
    Preguntas preguntasFindByID(Long ID);

}
