package com.restapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Institucion;
import com.restapi.api.services.serviceInstitucion;


@CrossOrigin(
   // origins = {"https://front-tesis-nu.vercel.app/", "http://localhost:4200"},
    origins = "https://front-tesis-nu.vercel.app/",
 
   methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET}
)

@RestController
@RequestMapping("/Institucion")
public class controllerInstitucion {

    @Autowired
    private serviceInstitucion serviceInstitucion;

    @PostMapping("/createInstitucion")
    public String createInstitucion(@RequestBody Institucion institucion) {
        //TODO: process POST request
        
        return serviceInstitucion.createInstitucion(institucion);
    }


    @PostMapping("/InstitucionByID/{ID}")
    public Institucion InstitucionByID(@PathVariable Long ID) {
        //TODO: process POST request
        
        return serviceInstitucion.institucionFindByID(ID);
    }
}
