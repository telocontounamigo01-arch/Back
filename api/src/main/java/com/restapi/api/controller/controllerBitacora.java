package com.restapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Bitacora;
import com.restapi.api.services.serviceBitacora;


@RestController
@RequestMapping("/bitacora")
public class controllerBitacora {

    @Autowired
    private serviceBitacora serviceBitacora;

    @PostMapping("/createBitacora")
    public String createRoles(@RequestBody Bitacora bitacora) {
        //TODO: process POST request
        
        return serviceBitacora.createBitacora(bitacora);
    }


    @PostMapping("/bitacoraByID")
    public Bitacora bitacoraByID(@PathVariable Long ID) {
        //TODO: process POST request
        
        return serviceBitacora.getBitacorabyID(ID);
    }


}
