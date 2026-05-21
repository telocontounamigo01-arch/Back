package com.restapi.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Preguntas;
import com.restapi.api.services.servicePreguntas;

@CrossOrigin(
   // origins = {"https://front-tesis-nu.vercel.app/", "http://localhost:4200"},
    origins = "https://front-tesis-nu.vercel.app/",
 
   methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET}
)
@RestController
@RequestMapping("/Peguntas")
public class controllerPreguntas {


    @Autowired
    private servicePreguntas servicePreguntas; 

    //post
     @PostMapping("/createPreguntas")
     public String createPreguntas(@RequestBody com.restapi.api.entities.Preguntas preguntas) {
        return servicePreguntas.createPreguntas(preguntas);
      }

    //findbyid
     @DeleteMapping("/preguntasFindByID/{ID}")  
        public Preguntas preguntasFindByID(@PathVariable Long ID){
        return servicePreguntas.preguntasFindByID(ID);
        }
}
