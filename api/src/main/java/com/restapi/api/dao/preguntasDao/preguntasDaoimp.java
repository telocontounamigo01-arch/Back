package com.restapi.api.dao.preguntasDao;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.preguntasDao.preguntas.interfacePreguntasDao;
import com.restapi.api.entities.Preguntas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class preguntasDaoimp implements interfacePreguntasDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String createPreguntas(Preguntas preguntas) {
        entityManager.persist(preguntas);
        return "Pregunta creada exitosamente";
    }

    @Override
    public Preguntas preguntasFindByID(Long ID) {
        return entityManager.find(Preguntas.class, ID);
    }
}