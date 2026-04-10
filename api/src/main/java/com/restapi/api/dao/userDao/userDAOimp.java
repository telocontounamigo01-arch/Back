package com.restapi.api.dao.userDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.restapi.api.dao.userDao.interfaces.interfaceUserDAO;
import com.restapi.api.entities.User;
import com.restapi.api.generics.collectionGeneric;
import com.restapi.api.generics.printElements;

import jakarta.el.ELException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class userDAOimp implements interfaceUserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    /// read
    @Override
    @Transactional
    public List<User> getAllUsers() {
       String QueryJPQL = "SELECT u FROM User u";
       // String QueryJPQL = "SELECT u FROM User u LEFT JOIN FETCH u.tarjeta";

        return entityManager.createQuery(QueryJPQL, User.class).getResultList();
    }

    /// read
    @Override
    @Transactional
    public User userFindByID(Long ID) {
        User user = entityManager.find(User.class, ID);

      
        // usamos la clase generica para guardar el elemento
        // luego usamos la funcion generica para imprimir el elemento
        collectionGeneric <String> userGeneric = new collectionGeneric<>("usamos el generico v2");

        printElements.viewElement( userGeneric.getElement());

    // Validar que el usuario no sea nulo
    if (user != null) {
        return user;
    } else {
        // // Manejo de error si el usuario no existe
        return null;
    }

    }

    /// create
    @Override
    @Transactional
    public String createUser(User user) {
        entityManager.persist(user);
        return "Usuario Creado";
    }

    /// update
    @Override
    @Transactional
    public String updateUser(Long ID, User user) {

        // Buscar el usuario por ID antes de actualizar
        User existingUser = userFindByID(ID);

        if (existingUser == null)
            return "Usuario no encontrado";

        entityManager.merge(user); // Modificar usuario
        return "Usuario Modificado";

    }

    /// delete
    @Override
    @Transactional
    public String deleteUser(Long ID) {
        User usuario = userFindByID(ID);
        if (usuario != null) {
            entityManager.remove(usuario);
            return "Usuario Eliminado";
        } else {
            return "Error al eliminar el usuario";
        }

    }

    @Override
    @Transactional
    public User findByEmailAndPassword(String email, String password) {
        try {

            System.out.println("Buscando usuario con email: " + email);
            System.out.println("Buscando usuario con email: " + password);

            String jpql = "SELECT u FROM User u WHERE u.Email = :email AND u.PassWord = :passWord";

            List<User> result = entityManager
                    .createQuery(jpql, User.class)
                    .setParameter("email", email)
                    .setParameter("passWord", password)
                    .getResultList();

            // Si no hay usuario → login incorrecto
            if (result.isEmpty()) {
                throw new ELException("Email o contraseña incorrectos");
            }

            // Devuelve el primero
            return result.get(0);

        } catch (Exception e) {
            // No se encontró usuario o error
            throw new ELException("Email o contraseña incorrectos");
        }
    }

}
