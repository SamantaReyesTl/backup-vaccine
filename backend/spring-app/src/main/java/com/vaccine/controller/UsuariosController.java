package com.vaccine.controller;

import com.vaccine.model.UsuariosModel;
import com.vaccine.service.UsuariosSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {
    @GetMapping("/obtenerUsuarios")
    public ResponseEntity<Object> getUsuarios(@RequestParam String nombre) {
        UsuariosSerivce usuariosSerivce = new UsuariosSerivce();
        return usuariosSerivce.getUsuarios(nombre);
    }

    @PostMapping("/altaUsuario")
    public ResponseEntity<Object> altaUsuario(@RequestBody UsuariosModel usuariosModel) {
        UsuariosSerivce usuariosSerivce = new UsuariosSerivce();
        return usuariosSerivce.altaUsuario(usuariosModel);
    }

    @PutMapping("/actualizarUsuario")
    public ResponseEntity<Object> actualizarUsuario(@RequestParam String nombre, @RequestBody UsuariosModel usuariosModel) {
        UsuariosSerivce usuariosSerivce = new UsuariosSerivce();
        return usuariosSerivce.actualizarUsuario(nombre, usuariosModel);
    }

    @DeleteMapping("/eliminarUsuario")
    public ResponseEntity<Object> eliminarUsuario(@RequestParam String nombre) {
        UsuariosSerivce usuariosSerivce = new UsuariosSerivce();
        return usuariosSerivce.eliminarUsuario(nombre);
    }
}
