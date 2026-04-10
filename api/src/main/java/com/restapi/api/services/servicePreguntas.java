package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.preguntasDao.preguntasDaoimp;
import com.restapi.api.entities.Preguntas;

@Service
public class servicePreguntas {


     @Autowired
     private preguntasDaoimp preguntasDaoimp;

        public String createPreguntas(com.restapi.api.entities.Preguntas preguntas){
            try {
                return preguntasDaoimp.createPreguntas(preguntas);        
            } catch (Exception e) {
                return "FAIL";
            }
        }

        public Preguntas preguntasFindByID(Long ID){
            try {   
                return preguntasDaoimp.preguntasFindByID(ID);        
            } catch (Exception e) {
                return null;
            }
        }
}
