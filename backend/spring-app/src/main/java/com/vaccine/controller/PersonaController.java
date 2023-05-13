package com.vaccine.controller;

import com.vaccine.model.PersonasModel;
import com.vaccine.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/consultarPersona")
    public ResponseEntity<PersonasModel> consultarPersona(@RequestParam("curp") String CURP) {
        PersonaService personaService = new PersonaService();
        PersonasModel personaModel = personaService.consultarPersona(CURP);
        return ResponseEntity.ok().body(personaModel);
    }

    @PostMapping("/altaPersona")
    public ResponseEntity<String> altaPersona(@RequestBody PersonasModel personaModel) {
        PersonaService personaService = new PersonaService();
        personaService.altaPersona(personaModel);
        return ResponseEntity.ok().body("Paciente dado de alta con éxito");
    }

    @PutMapping("/actualizarPersona")
    public ResponseEntity<String> actualizarPersona(@RequestParam("curp") String CURP, @RequestBody PersonasModel personaModel) {
        PersonaService personaService = new PersonaService();
        personaService.actualizarPersona(CURP, personaModel);
        return ResponseEntity.ok().body("Paciente actualizado con éxito");
    }

    @DeleteMapping("/bajaPersona")
    public ResponseEntity<String> bajaPersona(@RequestParam("curp") String CURP) {
        PersonaService personaService = new PersonaService();
        personaService.bajaPersona(CURP);
        return ResponseEntity.ok().body("Paciente dado de baja");
    }
}
