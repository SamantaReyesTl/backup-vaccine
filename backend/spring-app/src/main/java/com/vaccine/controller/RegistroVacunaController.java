package com.vaccine.controller;

import com.vaccine.model.RegistroVacunaModel;
import com.vaccine.service.RegistroVacunaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Los controladores son aquellos metodos que reciben las peticiones del cliente y mandan a otra clase
 * a que procese todo.
 *
 * En este caso tendremos distintos endpoints como por ejemplo: /api/v1/consultarRegistroVacuna el cual entrara
 * en el metodo consultarRegistroVacuna y gracias al @ResquestParam agarrara el parametro que nos pase
 * el usuario por la url por ejemplo "/api/v1/consultarPersona?id=ABC123131" donde el parametro es id
 * y el valor es ABC123131.
 */


@RestController
@RequestMapping("/api/v1")
public class RegistroVacunaController { // TODO: CREA ESTOS OBJETOS

    /**
     * Para estas funciones, se hace uso de la clase VacunaService, la cual se encarga de procesar
     * la informacion que se le pasa y hacer las consultas a la base de datos. Nosotros por comodidad
     * solo llamamos a los metodos de la clase VacunaService y nos resuelve todo.
     *
     * Aqui no hay mucha logica de programacion, tan solo se relega la responsabilidad a otra clase, pero
     * es buena practica debido a que no tenemos todo de golpe en un solo archivo.
     */

    @GetMapping("/consultarRegistroVacuna")
    public ResponseEntity<RegistroVacunaModel> consultarRegistroVacuna(@RequestParam("id") Integer id) {
        RegistroVacunaService vacunaService = new RegistroVacunaService();
        RegistroVacunaModel registroVacunaModel = vacunaService.consultarRegistroVacuna(id);
        return ResponseEntity.ok().body(registroVacunaModel);
    }

    @PostMapping("/altaRegistroVacuna")
    public ResponseEntity<String> altaRegistroVacuna(@RequestBody RegistroVacunaModel registroVacunaModel) {
        RegistroVacunaService vacunaService = new RegistroVacunaService();
        vacunaService.altaRegistroVacuna(registroVacunaModel);
        return ResponseEntity.ok().body("Alta de registro de vacuna");
    }

    @PutMapping("/actualizarRegistroVacuna")
    public ResponseEntity<String> actualizarRegistroVacuna(@RequestParam("id") Integer id, @RequestBody RegistroVacunaModel registroVacunaModel) {
        RegistroVacunaService vacunaService = new RegistroVacunaService();
        vacunaService.actualizarRegistroVacuna(id, registroVacunaModel);
        return ResponseEntity.ok().body("Actualizar registro de vacuna");
    }

    @DeleteMapping("/bajaRegistroVacuna")
    public ResponseEntity<String> bajaRegistroVacuna(@RequestParam("id") Integer id) {
        RegistroVacunaService vacunaService = new RegistroVacunaService();
        vacunaService.bajaRegistroVacuna(id);
        return ResponseEntity.ok().body("Baja de registro de vacuna");
    }
}
