package com.restapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Pishing;
import com.restapi.api.services.sevicePishing;


@CrossOrigin(
   // origins = {"https://front-tesis-nu.vercel.app/", "http://localhost:4200"},
    origins = "https://front-tesis-nu.vercel.app/",
 
   methods = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.GET}
)
@RestController
@RequestMapping("/Pishing")
public class controllerFishing {

    @Autowired
    private sevicePishing sevicePishing;

    // POST - crear registro de phishing
    @PostMapping("/createPishing")
    public String createPishing(@RequestBody Pishing pishing) {
        return sevicePishing.createPishing(pishing);
    }

    // GET - buscar por ID
    @GetMapping("/getPishingById/{id}")
    public Pishing getPishingById(@PathVariable Long id) {
        return sevicePishing.getPishingByID(id);
    }

    // GET - obtener todos los registros de un usuario (por body)
    @GetMapping("/getAllByUser")
    public List<Pishing> getAllByUser(@RequestBody Pishing pishing) {
        return sevicePishing.getAllPishingByUserId(pishing.getUserId());
    }
}
