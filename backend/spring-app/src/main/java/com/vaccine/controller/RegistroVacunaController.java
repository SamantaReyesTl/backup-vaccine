package com.vaccine.controller;

import com.vaccine.model.RegistroVacunaModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegistroVacunaController {

    @GetMapping("/consultarRegistroVacuna")
    public String consultarRegistroVacuna(@RequestParam("id") Integer id) {
        return "Consultar registro de vacuna";
    }

    @PostMapping("/altaRegistroVacuna")
    public String altaRegistroVacuna(@RequestBody RegistroVacunaModel registroVacunaModel) {
        return "Alta de registro de vacuna";
    }

    @PutMapping("/actualizarRegistroVacuna")
    public String actualizarRegistroVacuna(@RequestParam("id") Integer id, @RequestBody RegistroVacunaModel registroVacunaModel) {
        return "Actualizar registro de vacuna";
    }

    @DeleteMapping("/bajaRegistroVacuna")
    public String bajaRegistroVacuna(@RequestParam("id") Integer id) {
        return "Baja de registro de vacuna";
    }
}
