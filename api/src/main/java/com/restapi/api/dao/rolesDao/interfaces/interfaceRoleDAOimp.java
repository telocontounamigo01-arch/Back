package com.restapi.api.dao.rolesDao.interfaces;

import com.restapi.api.entities.Roles;
import com.restapi.api.entities.User;

public interface interfaceRoleDAOimp {

    public Roles  roleFindByID(Long id);
    public String createRole(Roles role);
    public String deleteRole(Long id);
    public String updateRole(Roles role, Long id);
    public String asociateRoleByUser(Roles role, User user);

}
