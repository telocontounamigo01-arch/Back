package com.restapi.api.dao.encuestaDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.encuestaDao.interfaces.interfaceEncuestaDAOimp;
import com.restapi.api.entities.Encuesta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class encuestaDAOimp implements interfaceEncuestaDAOimp {


    @PersistenceContext
    private EntityManager entityManager;


    
    @Override
    @Transactional
    public String createEncuesta(Encuesta encuesta) {

        entityManager.persist(encuesta);

        return "Encuesta create";
    }


    @Override
    @Transactional
    public String deleteEncuesta(Long id) {
        Encuesta encuesta = entityManager.find(Encuesta.class, id);

        if (encuesta != null) {
            entityManager.remove(encuesta);
             return "Encuesta delete";
        } else {
            return "Error al eliminar la encuesta: no existe";
        }

    }

    @Override
    public List<Encuesta> allRegistrosByInstitucionAndTipo(String institucion, String tipo) {
        return entityManager.createQuery(
                "SELECT e FROM Encuesta e WHERE e.idInstitucion = :institucion AND e.tipo = :tipo",
                Encuesta.class
        )
        .setParameter("institucion", institucion)
        .setParameter("tipo", tipo)
        .getResultList();
    }


}
