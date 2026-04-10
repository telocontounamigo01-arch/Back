package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.bitacoraDao.bitacoraDAOimp;
import com.restapi.api.entities.Bitacora;


@Service
public class serviceBitacora {

     @Autowired
     private bitacoraDAOimp bitacoraDAO;

     public Bitacora getBitacorabyID(long ID){
        try {
            return bitacoraDAO.bitacoraFindByID(ID);        
        } catch (Exception e) {
            return null;
        }
     }

     
     public String createBitacora(Bitacora bitacora){
      try {
        return bitacoraDAO.createBitacora(bitacora);        
      } catch (Exception e) {
        return "FAIL";
      }
     }


}
