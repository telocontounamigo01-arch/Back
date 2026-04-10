package com.restapi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.pishingDao.pishingDaoimp;
import com.restapi.api.entities.Pishing;

@Service
public class sevicePishing {

    @Autowired
    private pishingDaoimp pishingDAO;

    // Buscar por ID
    public Pishing getPishingByID(long id) {
        try {
            return pishingDAO.pishingFindByID(id);
        } catch (Exception e) {
            return null;
        }
    }

    // Crear registro
    public String createPishing(Pishing pishing) {
        try {
            return pishingDAO.createPishing(pishing);
        } catch (Exception e) {
            return "FAIL";
        }
    }

    // Obtener todos los registros de un usuario
    public List<Pishing> getAllPishingByUserId(Long userId) {
        try {
            return pishingDAO.pishingFindAllByUserId(userId);
        } catch (Exception e) {
            return List.of();
        }
    }
}
