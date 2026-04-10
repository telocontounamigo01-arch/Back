package com.restapi.api.dao.bitacoraDao;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.bitacoraDao.interfaces.interfaceBitacoraDAO;
import com.restapi.api.entities.Bitacora;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class bitacoraDAOimp implements interfaceBitacoraDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
    /// create
    @Override
    @Transactional
    public String createBitacora(Bitacora bitacora) {
        entityManager.persist(bitacora);
        return "bitacora Creado";
    }


    /// find by ID
    @Override
    @Transactional
    public Bitacora bitacoraFindByID(Long ID) {
      Bitacora bitacora = entityManager.find(Bitacora.class, ID);

        // Validar la bitacora no sea nula
        if (bitacora != null) {
            return bitacora;
        } else {
            // // Manejo de error si la bitacora no existe
            return null;
        }

    }


}
