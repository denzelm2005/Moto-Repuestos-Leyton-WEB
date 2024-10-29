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

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Venta;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IVentasServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/VentasController")
public class VentasController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VentasController.class);

    @Autowired
    IVentasServices ventasServices;

    // EndPoint para insertar una Venta
    @PostMapping("/insertarventa")
    public ResponseEntity<Venta> createVentas(@RequestBody Venta ventas) {
        try {
            Venta createdVenta = ventasServices.createventas(ventas);
            return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error while creating Venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar una Venta
    @DeleteMapping("/eliminarventa/{id}")
    public ResponseEntity<HashMap<String, String>> deleteVentas(@PathVariable int id) {
        try {
            HashMap<String, String> response = ventasServices.deleteventas(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error while deleting Venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar todas las Ventas
    @GetMapping("/listarventas")
    public ResponseEntity<List<Venta>> getAllVentas() {
        try {
            List<Venta> ventas = ventasServices.getAllVentas();
            return new ResponseEntity<>(ventas, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error while fetching Ventas: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para actualizar una Venta
    @PutMapping("/actualizarventa")
    public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
        try {
            Venta updatedVenta = ventasServices.updateVenta(venta);
            return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Venta no encontrada: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar la Venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
