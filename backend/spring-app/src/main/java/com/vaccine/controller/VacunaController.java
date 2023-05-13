package com.vaccine.controller;

import com.vaccine.model.VacunaModel;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: Realiza lo mismo que en PersonaController y RegistroVacunaController
 */

@RestController
@RequestMapping("/api/v1")
public class VacunaController {

    @GetMapping("/consultarVacuna")
    public String consultarVacuna(@RequestParam("nombre_vacuna") String nombreVacuna) {
        nombreVacuna = nombreVacuna.replace("_", " ");
        return "Consultar vacuna";
    }

    @PostMapping("/altaVacuna")
    public String altaVacuna(@RequestBody VacunaModel vacunaModel) {
        return "Alta de vacuna";
    }

    @PutMapping("/actualizarVacuna")
    public String actualizarVacuna(@RequestParam("nombre_vacuna") String nombreVacuna, @RequestBody VacunaModel vacunaModel) {
        return "Actualizar vacuna";
    }

    @DeleteMapping("/bajaVacuna")
    public String bajaVacuna(@RequestParam("nombre_vacuna") String nombreVacuna) {
        return "Baja de vacuna";
    }
}
