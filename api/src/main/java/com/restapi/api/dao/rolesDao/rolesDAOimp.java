package com.restapi.api.dao.rolesDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.rolesDao.interfaces.interfaceRoleDAOimp;
import com.restapi.api.entities.Roles;
import com.restapi.api.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class rolesDAOimp implements interfaceRoleDAOimp {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Roles roleFindByID(Long ID) {
        Roles role = entityManager.find(Roles.class, ID);
        System.out.println("RoleById 2 --> " + role.getTypeRol());

        // Validar que el usuario no sea nulo
        if (role != null) {
            return role;
        } else {
            // // Manejo de error si el usuario no existe
            return null;
        }

    }

    @Override
    @Transactional
    public String createRole(Roles role) {

        entityManager.persist(role);

        return "Role create";
    }

    @Override
    @Transactional
    public String asociateRoleByUser(Roles role, User user) {

        if (role == null) {
        return "The role does not exist";
        }

        if (user == null) {
        return "The user does not exist.";
        }

        List<Roles> TotalRoles = user.getRoles();
        List<User> TotalUsers = role.getUsers();

        TotalRoles.add(role);
        TotalUsers.add(user);

        user.setRoles(TotalRoles);
        role.setUsers(TotalUsers);

        System.out.println("TotalRoles 3 --> " + TotalUsers.get(0));

        System.out.println("TotalUsers 3 --> " + user);

        entityManager.merge(user);
        entityManager.merge(role);

        return "Usuario y roles asociados con exito";
    }

    @Override
    @Transactional
    public String deleteRole(Long id) {
        return " ";
    }

    @Override
    @Transactional
    public String updateRole(Roles role, Long id) {
        return " ";
    }

}
