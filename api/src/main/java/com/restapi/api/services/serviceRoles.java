package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.rolesDao.rolesDAOimp;
import com.restapi.api.dao.userDao.userDAOimp;
import com.restapi.api.entities.Roles;
import com.restapi.api.entities.User;


@Service
public class serviceRoles {

    @Autowired
    private rolesDAOimp rolesDAOimp;

    @Autowired 
    private userDAOimp userDAOimp;

    public String CreateRole(Roles role){

        try {
            return rolesDAOimp.createRole(role);
        } catch (Exception e) {
            // TODO: handle exception
            return "FAIL";
        }
    }


    public String asociateRoleByUser(Long idROL, long idUSER){

        try {
            
            Roles RoleById = rolesDAOimp.roleFindByID(idROL);             
            User userById = userDAOimp.userFindByID(idUSER);

            System.out.println("RoleById  --> " + RoleById);
            return rolesDAOimp.asociateRoleByUser(RoleById,userById);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("error" + e);
            return "FAIL";
        }
    }



}
