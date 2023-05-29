package com.vaccine.controller;

import com.vaccine.model.RegistroClinicoBasicoModel;
import com.vaccine.service.RegistroClinicoBasicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegistroClinicoBasicoController {

    @GetMapping("/obtenerRegistroClinicoBasico")
    public ResponseEntity<Object> obtenerRegistroClinicoBasico(@RequestParam String curp){
        RegistroClinicoBasicoService registroclinicobasicoservice = new RegistroClinicoBasicoService();
        return registroclinicobasicoservice.obtener(curp);
    }

    @PostMapping("/altaRegistroClinicoBasico")
    public ResponseEntity<Object> altaRegistroClinicoBasico(@RequestBody RegistroClinicoBasicoModel RCB ){
        RegistroClinicoBasicoService registroclinicobasicoservice = new RegistroClinicoBasicoService();
        return registroclinicobasicoservice.alta(RCB);
    }

    @PutMapping("/actualizarRegistroClinicoBasico")
    public ResponseEntity<Object> actualizarRegistroClinicoBasico (@RequestParam String curp,@RequestBody RegistroClinicoBasicoModel RCB){
        RegistroClinicoBasicoService registroclinicobasicoservice = new RegistroClinicoBasicoService();
        return registroclinicobasicoservice.actualizar(curp, RCB);
    }

    @DeleteMapping("/eliminarRegistroClinicoBasico")
    public ResponseEntity<Object> eliminarRegistroClinicoBasico(@RequestParam String curp){
        RegistroClinicoBasicoService registroclinicobasicoservice = new RegistroClinicoBasicoService();
        return registroclinicobasicoservice.eliminar(curp);
    }
}
