package com.restapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Roles;
import com.restapi.api.services.serviceRoles;

@CrossOrigin(
   // origins = {"https://front-tesis-nu.vercel.app/", "http://localhost:4200"},
    origins = "https://front-tesis-nu.vercel.app/",
 
   methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET}
)

@RestController
@RequestMapping("/roles")
public class controllerRoles {

    @Autowired
    private serviceRoles serviceRoles;

    @PostMapping("/createRoles")
    public String createRoles(@RequestBody Roles roles) {
        //TODO: process POST request
        
        return serviceRoles.CreateRole(roles);
    }


    @PostMapping("/associateRolesByUsers")
    public String postMethodName(@RequestBody java.util.Map<String, Long> requestBody ) {
        //TODO: process POST request
        Long idRol = requestBody.get("idRol");
        Long idUser = requestBody.get("idUser");

        System.out.println("idRol --> " + idRol);
        return serviceRoles.asociateRoleByUser(idRol, idUser);
    }
    

}
