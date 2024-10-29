package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Controllers;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleVenta;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IDetalleVentaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/DetalleVentaController")
public class DetalleVentaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleVentaController.class);

    @Autowired
    IDetalleVentaServices detalleVentaServices;

    // EndPoint para insertar un Detalle de Venta
    @PostMapping("/insertardetalleventa")
    public ResponseEntity<DetalleVenta> createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta createdDetalleVenta = detalleVentaServices.createDetalleVenta(detalleVenta);
            return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error al crear el detalle de venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar un Detalle de Venta
    @DeleteMapping("/eliminardetalleventa/{id}")
    public ResponseEntity<HashMap<String, String>> deleteDetalleVenta(@PathVariable int id) {
        try {
            HashMap<String, String> response = detalleVentaServices.deleteDetalleVenta(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el detalle de venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar todos los Detalles de Venta
    @GetMapping("/listardetalleventa")
    public ResponseEntity<List<DetalleVenta>> getAllDetalleVentas() {
        try {
            List<DetalleVenta> detalleVentas = detalleVentaServices.getAllDetalleVenta();
            return new ResponseEntity<>(detalleVentas, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al listar los detalles de venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para actualizar un Detalle de Venta
    @PutMapping("/actualizardetalleventa")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta updatedDetalleVenta = detalleVentaServices.updateDetalleVenta(detalleVenta);
            return new ResponseEntity<>(updatedDetalleVenta, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Detalle de venta no encontrado: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el detalle de venta: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

