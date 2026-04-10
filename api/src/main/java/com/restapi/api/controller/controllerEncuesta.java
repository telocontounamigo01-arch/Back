package com.restapi.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.Dto.EncuestaFiltroDTO;
import com.restapi.api.entities.Encuesta;
import com.restapi.api.services.serviceEncuesta;



@CrossOrigin(
    origins = "http://localhost:4200",
    methods = {RequestMethod.POST, RequestMethod.OPTIONS}
)

@RestController
@RequestMapping("/Encuesta")
public class controllerEncuesta {

    @Autowired
    private serviceEncuesta serviceEncuesta; 



    //post
     @PostMapping("/createEncuesta")
     public ResponseEntity<?> createEncuesta(@RequestBody Encuesta encuesta) {
         //TODO: process POST request
            String resultado = serviceEncuesta.CreateEncuesta(encuesta);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", resultado);

            return ResponseEntity.ok(response);
     }


    //delete
     @DeleteMapping("/deleteEncuesta/{ID}")
     public String deleteEncuesta(@PathVariable Long ID){
       return serviceEncuesta.deleteEncuesta(ID);
     }


    @GetMapping("/allRegistrosByInstitucionAndTipo")
    public List<Encuesta> allRegistros(@RequestBody EncuestaFiltroDTO filtro) {
            return serviceEncuesta.allRegistrosByInstitucionAndTipo(
              filtro.getInstitucion(),
              filtro.getTipo()
        );
    }

    @PostMapping("/findAllEncuestas")
    public List<Encuesta> findAllEncuestas(@RequestBody EncuestaFiltroDTO filtro) {
            return serviceEncuesta.allRegistrosByInstitucionAndTipo(
              filtro.getInstitucion(),
              filtro.getTipo()
        );
    }
     
     
}
