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

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Compra;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.ICompraServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ComprasController")
public class ComprasController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComprasController.class);

    @Autowired 
    ICompraServices comprasServices;

    // EndPoint para insertar una Compra
    @PostMapping("/insertarcompra")
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
        try {
            Compra nuevaCompra = comprasServices.createCompra(compra);
            return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error al insertar la compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar una Compra
    @DeleteMapping("/eliminarcompra/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCompra(@PathVariable int id) {
        try {
            HashMap<String, String> response = comprasServices.deleteCompra(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar la compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar las Compras
    @GetMapping("/listarcompras")
    public ResponseEntity<List<Compra>> getAllCompras() {
        try {
            List<Compra> compras = comprasServices.getAllCompras();
            return new ResponseEntity<>(compras, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al listar las compras: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para actualizar una Compra
    @PutMapping("/actualizarcompra")
    public ResponseEntity<Compra> updateCompra(@RequestBody Compra compra) {
        try {
            Compra updatedCompra = comprasServices.updateCompra(compra);
            return new ResponseEntity<>(updatedCompra, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Compra no encontrada: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar la compra: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
