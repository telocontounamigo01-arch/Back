package com.restapi.api.dao.pishingDao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.pishingDao.interfaces.interfacePishingDAO;
import com.restapi.api.entities.Pishing;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class pishingDaoimp implements interfacePishingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /// create
    @Override
    @Transactional
    public String createPishing(Pishing pishing) {
        entityManager.persist(pishing);
        return "Pishing creado";
    }

    /// find by ID
    @Override
    @Transactional
    public Pishing pishingFindByID(Long id) {
        Pishing pishing = entityManager.find(Pishing.class, id);

        if (pishing != null) {
            return pishing;
        } else {
            return null;
        }
    }

    /// find all by userId
    @Override
    @Transactional
    public List<Pishing> pishingFindAllByUserId(Long userId) {
        return entityManager.createQuery(
                "SELECT p FROM Pishing p WHERE p.userId = :userId",
                Pishing.class
        )
        .setParameter("userId", userId)
        .getResultList();
    }

}
