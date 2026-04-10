package com.restapi.api.dao.institucionDao;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.institucionDao.interfaces.interfaceInstitucionDAO;
import com.restapi.api.entities.Institucion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class institucionDAOimp implements interfaceInstitucionDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
    /// create
    @Override
    @Transactional
    public String createInstitucion(Institucion institucion) {
        entityManager.persist(institucion);
        return "institucion Creado";
    }


    /// find by ID
    @Override
    @Transactional
    public Institucion institucionFindByID(Long ID) {
      Institucion institucion = entityManager.find(Institucion.class, ID);

        // Validar la bitacora no sea nula
        if (institucion != null) {
            return institucion;
        } else {
            // // Manejo de error si la bitacora no existe
            return null;
        }

    }


}
