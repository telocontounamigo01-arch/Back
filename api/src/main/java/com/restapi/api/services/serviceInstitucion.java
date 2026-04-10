package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.institucionDao.institucionDAOimp;
import com.restapi.api.entities.Institucion;

@Service
public class serviceInstitucion {

     @Autowired
     private institucionDAOimp institucionDAOimp;
    
     public String createInstitucion(Institucion institucion){
        try {
            return institucionDAOimp.createInstitucion(institucion);        
        } catch (Exception e) {
            return "FAIL";
        }
     }

    public Institucion institucionFindByID(Long ID){
        try {
            return institucionDAOimp.institucionFindByID(ID);        
        } catch (Exception e) {
            return null;
        }
     }


}
