package com.vaccine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de inicio de la aplicacion. No te preocupes por esto dado a que con Spring Boot
 * no es necesario escribir algo en el main para iniciar la aplicacion.
 *
 * Dato importante: Las librerias y dependencias se encuentran en el archivo pom.xml, esto es
 * que gracias a Maven no es necesario descargar las librerias manualmente. Sino que Maven se encarga
 * de descargarlas y gestionarlas por nosotros.
 */

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
