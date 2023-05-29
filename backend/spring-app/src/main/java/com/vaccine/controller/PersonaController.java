package com.vaccine.controller;

import com.vaccine.model.PersonasModel;
import com.vaccine.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Los controladores son aquellos metodos que reciben las peticiones del cliente y mandan a otra clase
 * a que procese todo.
 *
 * En este caso tendremos distintos endpoints como por ejemplo: /api/v1/consultarPersona el cual entrara
 * en el metodo consultarPersona y gracias al @ResquestParam agarrara el parametro que nos pase
 * el usuario por la url por ejemplo "/api/v1/consultarPersona?curp=ABC123131" donde el parametro es curp
 * y el valor es ABC123131.
 */

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

    /**
     * Para estas funciones, se hace uso de la clase PersonaService, la cual se encarga de procesar
     * la informacion que se le pasa y hacer las consultas a la base de datos. Nosotros por comodidad
     * solo llamamos a los metodos de la clase PersonaService y nos resuelve todo.
     *
     * Aqui no hay mucha logica de programacion, tan solo se relega la responsabilidad a otra clase, pero
     * es buena practica debido a que no tenemos todo de golpe en un solo archivo.
     */

    @GetMapping("/obtenerPersonas")
    public ResponseEntity<Object> consultarPersonas() {
        PersonaService personaService = new PersonaService();
        return personaService.consultarPersonas();
    }

    @GetMapping("/obtenerPersona")
    public ResponseEntity<Object> consultarPersona(@RequestParam("curp") String CURP) {
        PersonaService personaService = new PersonaService();
        return personaService.consultarPersona(CURP);
    }

    @PostMapping("/altaPersona")
    public ResponseEntity<Object> altaPersona(@RequestBody PersonasModel personaModel) {
        PersonaService personaService = new PersonaService();
        return personaService.altaPersona(personaModel);
    }

    @PutMapping("/actualizarPersona")
    public ResponseEntity<Object> actualizarPersona(@RequestParam("curp") String curp, @RequestBody PersonasModel personaModel) {
        PersonaService personaService = new PersonaService(); // el constructor vacio permite que cual sea el valor
        return personaService.actualizarPersona(curp, personaModel); // que se le pase va a llenar los que pueda
        // tener cuidado en post y put pues pueden colarse campos null
    }

    @DeleteMapping("/bajaPersona")
    public ResponseEntity<Object> bajaPersona(@RequestParam("curp") String CURP) {
        PersonaService personaService = new PersonaService();
        return personaService.bajaPersona(CURP);
    }
}
