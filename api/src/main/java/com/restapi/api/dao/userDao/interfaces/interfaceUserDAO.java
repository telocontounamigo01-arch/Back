package com.restapi.api.dao.userDao.interfaces;

import java.util.List;

import com.restapi.api.entities.User;

public interface interfaceUserDAO {
    
    String createUser(User user);
    String deleteUser(Long ID);
    String updateUser(Long ID ,User user);
    User userFindByID(Long ID);
    List<User> getAllUsers();    
    User findByEmailAndPassword(String email, String password);
}
