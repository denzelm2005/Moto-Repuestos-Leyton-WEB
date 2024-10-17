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


import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Marca;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IMarcaServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/MarcaController")
public class MarcaController {
private static final Logger LOGGER = LoggerFactory.getLogger(MarcaController.class);
@Autowired 
IMarcaServices marcaServices;

@PostMapping("/insertarmarca")
public ResponseEntity<Marca> createMarca(@RequestBody Marca marcas) {
try {
    Marca createMarca = marcaServices.createMarca(marcas);
    return new ResponseEntity<>(createMarca,HttpStatus.CREATED);
}catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@DeleteMapping("/eliminarmarca/{id}")
public ResponseEntity<HashMap<String, String>> deletemarca(@PathVariable int id) {
    try {
    HashMap<String, String> response = marcaServices.deletemarca(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping("/listarMarca")
    public ResponseEntity<List<Marca>> getAllMarca() {
        try {
            List<Marca> marca = marcaServices.getAllMarca();
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarMarca")
    public ResponseEntity<Marca> updateMarca(@RequestBody Marca marca) {
        try {
            Marca updatedMarca = marcaServices.updateMarca(marca);
            return new ResponseEntity<>(updatedMarca, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el proveedor: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el proveedor: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

 