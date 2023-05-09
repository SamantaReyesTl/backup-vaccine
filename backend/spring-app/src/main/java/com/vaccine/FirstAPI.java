package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstAPI {
    @GetMapping("/")
    public Productos getHome() {
        Productos productos = new Productos("Agua", "Hoy");
        return productos;
    }

    @GetMapping("/productos")
    public ResponseEntity<Productos> getProductos() {
        Productos productos = new Productos("Agua", "Hoy");
        return ResponseEntity.ok().body(productos);
    }
}

