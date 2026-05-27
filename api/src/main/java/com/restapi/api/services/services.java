package com.restapi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.userDao.userDAOimp;
import com.restapi.api.entities.User;


///en esta clase implementamos toda la logica de negocio(FALTA)
@Service
public class services  {

     @Autowired
     private userDAOimp userDAO;

     public List<User> getUsers(){
      try {
        return userDAO.getAllUsers();        
      } catch (Exception e) {
        return null;
      }
     }


     public User getUserbyID(long ID){
      try {
        return userDAO.userFindByID(ID);        
      } catch (Exception e) {
        return null;
      }
    }


     public String createUser(User user){
      if (user == null || user.getEmail() == null || user.getEmail().trim().isEmpty()) {
        throw new IllegalArgumentException("El usuario y email no pueden estar vacíos");
      }

      String email = user.getEmail().trim().toLowerCase();
      User existingUser = userDAO.findByEmail(email);

      if (existingUser != null) {
        throw new IllegalArgumentException("El email ya está registrado");
      }

      user.setEmail(email);
      return userDAO.createUser(user);
     }


     public String deleteUserByID(Long ID){
      try {
        return userDAO.deleteUser(ID);        
      } catch (Exception e) {
        return "FAIL";
      }
     }


     public String updateUser(Long ID, User user){
      try {
        return userDAO.updateUser(ID,user);
      } catch (Exception e) {
        // TODO: handle exception
        return "FAIL";
      }
     }

      public User getUserByEmailAndPassword(String email, String password) {
          return userDAO.findByEmailAndPassword(email, password);
      }


}
