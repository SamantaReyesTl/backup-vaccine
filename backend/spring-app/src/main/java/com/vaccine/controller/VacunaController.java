package com.vaccine.controller;

import com.vaccine.model.VacunasModel;
import com.vaccine.service.VacunaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Los controladores son aquellos metodos que reciben las peticiones del cliente y mandan a otra clase
 * a que procese todo.
 *
 * En este caso tendremos distintos endpoints como por ejemplo: /api/v1/consultarVacuna el cual entrara
 * en el metodo consultarVacuna y gracias al @ResquestParam agarrara el parametro que nos pase
 * el usuario por la url por ejemplo "/api/v1/consultarPersona?id=ABC123131" donde el parametro es id
 * y el valor es ABC123131. Pero tambien si necesitamos mandar un objeto en especifico, podemos usar
 * el @RequestBody para que Spring se encargue de convertir el JSON que nos mande el usuario a un objeto.
 */

@RestController
@RequestMapping("/api/v1")
public class VacunaController {

    /**
     * Para estas funciones, se hace uso de la clase VacunaService, la cual se encarga de procesar
     * la informacion que se le pasa y hacer las consultas a la base de datos. Nosotros por comodidad
     * solo llamamos a los metodos de la clase VacunaService y nos resuelve todo.
     *
     * Aqui no hay mucha logica de programacion, tan solo se relega la responsabilidad a otra clase, pero
     * es buena practica debido a que no tenemos todo de golpe en un solo archivo.
     */

    @GetMapping("/obtenerVacuna")
    public ResponseEntity<Object> consultarVacuna(@RequestParam("id") Integer id) {
        VacunaService vacunaService = new VacunaService();
        return vacunaService.consultarVacuna(id);
    }

    @PostMapping("/altaVacuna")
    public ResponseEntity<Object> altaVacuna(@RequestBody VacunasModel vacunaModel) {
        VacunaService vacunaService = new VacunaService();
        return vacunaService.altaVacuna(vacunaModel);
    }

    @PutMapping("/actualizarVacuna")
    public ResponseEntity<Object> actualizarVacuna(@RequestParam("id") Integer id, @RequestBody VacunasModel vacunaModel) {
        VacunaService vacunaService = new VacunaService();
        return vacunaService.actualizarVacuna(id, vacunaModel);
    }

    @DeleteMapping("/bajaVacuna")
    public ResponseEntity<Object> bajaVacuna(@RequestParam("id") Integer id) {
        VacunaService vacunaService = new VacunaService();
        return vacunaService.bajaVacuna(id);
    }
}
