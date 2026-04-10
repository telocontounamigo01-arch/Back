package com.restapi.api.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;




@Entity
public class User {

    //properties
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String Name;
    private String LastName;
    private String Email;
    private String PassWord; 
    private String Two_factors;
    private String InstitucionOid;
    // private String Rol;


    @ManyToMany(mappedBy = "userRoles")
    // @JsonBackReference  
   // @JsonManagedReference
    private List<Roles> roles;

    @OneToMany(mappedBy = "usuario_Regi", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Bitacora> Bitacoras;


    ///getter and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassWord() {
        return PassWord;
    }
    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
    public String get2FA_Pass() {
        return Two_factors;
    }
    public void set2FA_Pass(String two_factors_input) {
        Two_factors = two_factors_input;
    }
    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    public List<Bitacora> getBitacoras() {
        return Bitacoras;
    }
    public void setBitacoras(List<Bitacora> bitacoras) {
        Bitacoras = bitacoras;
    }

    public String getInstitucionOid() {
        return InstitucionOid;
    }

    public void setInstitucionOid(String institucionOid) {
         this.InstitucionOid = institucionOid;
    }

}
