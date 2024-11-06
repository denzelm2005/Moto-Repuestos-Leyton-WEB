package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Controllers;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleCompra;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IDetalleCompraServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/DetalleCompraController")
public class DetalleCompraController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleCompraController.class);

    @Autowired
    IDetalleCompraServices detalleCompraServices;

    // EndPoint para insertar un Detalle de Compra
    @PostMapping("/insertardetallecompra")
    public ResponseEntity<DetalleCompra> createDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        try {
            DetalleCompra createdDetalleCompra = detalleCompraServices.createDetalleCompra(detalleCompra);
            return new ResponseEntity<>(createdDetalleCompra, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error al crear el detalle de compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar un Detalle de Compra
    @DeleteMapping("/eliminardetallecompra/{id}")
    public ResponseEntity<HashMap<String, String>> deleteDetalleCompra(@PathVariable int id) {
        try {
            HashMap<String, String> response = detalleCompraServices.deleteDetalleCompra(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el detalle de compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar todos los Detalles de Compra
    @GetMapping("/listardetallecompra")
    public ResponseEntity<List<DetalleCompra>> getAllDetalleCompras() {
        try {
            List<DetalleCompra> detalleCompras = detalleCompraServices.getAllDetalleCompra();
            return new ResponseEntity<>(detalleCompras, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al listar los detalles de compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para actualizar un Detalle de Compra
    @PutMapping("/actualizardetallecompra")
    public ResponseEntity<DetalleCompra> updateDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
        try {
            DetalleCompra updatedDetalleCompra = detalleCompraServices.updateDetalleCompra(detalleCompra);
            return new ResponseEntity<>(updatedDetalleCompra, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Detalle de compra no encontrado: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el detalle de compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
