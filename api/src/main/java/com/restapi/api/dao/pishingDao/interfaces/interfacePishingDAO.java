package com.restapi.api.dao.pishingDao.interfaces;

import java.util.List;

import com.restapi.api.entities.Pishing;

public interface interfacePishingDAO {
        // Crear registro de phishing
    String createPishing(Pishing pishing);

    // Recuperar por ID
    Pishing pishingFindByID(Long id);

    // Recuperar todos los registros de un usuario
    List<Pishing> pishingFindAllByUserId(Long userId);

}
