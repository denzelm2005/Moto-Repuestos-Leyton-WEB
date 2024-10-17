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


import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Proveedor;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IProveedorServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ProveedorController")
public class ProveedorController {
 private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);
@Autowired 
IProveedorServices proveedorServices;

@PostMapping("/insertarproveedor")
public ResponseEntity<Proveedor> createproveedor(@RequestBody Proveedor proveedor) {
try {
    Proveedor createProveedor = proveedorServices.createproveedor(proveedor);
    return new ResponseEntity<>(createProveedor,HttpStatus.CREATED);


}catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@DeleteMapping("/eliminarproveedor/{id}")
public ResponseEntity<HashMap<String, String>> deleteproveedores(@PathVariable int id) {
    try {
    HashMap<String, String> response = proveedorServices.deleteproveedores(id);
    return new ResponseEntity<>(response, HttpStatus.OK);

    }catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping("/listarproveedor")
    public ResponseEntity<List<Proveedor>> getAllProveedor() {
        try {
            List<Proveedor> proveedor = proveedorServices.getAllProveedor();
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un estudiante
    @PutMapping("/actualizarproveedor")
public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
    try {
        Proveedor updatedProveedor = proveedorServices.updateProveedor(proveedor);
        return new ResponseEntity<>(updatedProveedor, HttpStatus.OK);
    } catch (RuntimeException e) {
        LOGGER.error("Error al actualizar el proveedor: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        LOGGER.error("Error al actualizar el proveedor: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
