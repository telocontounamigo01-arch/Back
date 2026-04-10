package com.restapi.api.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@JsonIgnoreProperties({"users"})
public class Roles {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeRol;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "user_roles3",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id")
    )
    List<User> userRoles;

    public String getTypeRol() {
        return typeRol;
    }

    public void setTypeRol(String typeRol) {
        this.typeRol = typeRol;
    }

    // Método para añadir un usuario a la lista de roles
    public List<User> getUsers() {
        return this.userRoles;
    }
    public void setUsers(List<User> userRoles) {
        this.userRoles = userRoles;
    }
}
