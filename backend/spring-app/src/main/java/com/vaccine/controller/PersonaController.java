package com.vaccine.controller;

import com.vaccine.model.PersonaModel;
import com.vaccine.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

    @GetMapping("/consultarPersona")
    public ResponseEntity<PersonaModel> consultarPersona(@RequestParam("curp") String CURP) {
        PersonaService personaService = new PersonaService();
        PersonaModel personaModel = personaService.consultarPersona(CURP);
        return ResponseEntity.ok().body(personaModel);
    }

    @PostMapping("/altaPersona")
    public ResponseEntity<String> altaPersona(@RequestBody PersonaModel personaModel) {
        PersonaService personaService = new PersonaService();
        personaService.altaPersona(personaModel);
        return ResponseEntity.ok().body("Paciente dado de alta con éxito");
    }

    @PutMapping("/actualizarPersona")
    public ResponseEntity<String> actualizarPersona(@RequestParam("curp") String CURP, @RequestBody PersonaModel personaModel) {
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
