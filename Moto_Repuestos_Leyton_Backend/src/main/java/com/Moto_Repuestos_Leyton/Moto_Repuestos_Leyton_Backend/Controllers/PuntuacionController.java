package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Puntuacion;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IPuntuacionServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/PuntuacionesController")
public class PuntuacionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PuntuacionController.class);

    @Autowired 
    IPuntuacionServices puntuacionServices;

    // EndPoint para insertar una Puntuacion
    @PostMapping("/insertarpuntuacion")
    public ResponseEntity<Puntuacion> createPuntuacion(@RequestBody Puntuacion puntuacion) {
        try {
            Puntuacion createdPuntuacion = puntuacionServices.createPuntuacion(puntuacion);
            return new ResponseEntity<>(createdPuntuacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar una Puntuacion
    @DeleteMapping("/eliminarpuntuacion/{id}")
    public ResponseEntity<HashMap<String, String>> deletePuntuacion(@PathVariable int id) {
        try {
            HashMap<String, String> response = puntuacionServices.deletePuntuacion(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar todas las Puntuaciones
    @GetMapping("/listarpuntuaciones")
    public ResponseEntity<List<Puntuacion>> getAllPuntuaciones() {
        try {
            List<Puntuacion> puntuaciones = puntuacionServices.getAllPuntuacion();
            return new ResponseEntity<>(puntuaciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar una Puntuacion
    @PutMapping("/actualizarpuntuacion")
    public ResponseEntity<Puntuacion> updatePuntuacion(@RequestBody Puntuacion puntuacion) {
        try {
            Puntuacion updatedPuntuacion = puntuacionServices.updatePuntuacion(puntuacion);
            return new ResponseEntity<>(updatedPuntuacion, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar la puntuacion: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar la puntuacion: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
