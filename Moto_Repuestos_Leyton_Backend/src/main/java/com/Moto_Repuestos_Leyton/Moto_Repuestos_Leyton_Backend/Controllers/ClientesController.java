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

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Cliente;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IClientesServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ClientesController")

public class ClientesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientesController.class);
@Autowired 
IClientesServices clientesServices;

//EndPoint para isertar un Cliente
@PostMapping("/insertarcliente")
public ResponseEntity<Cliente> createclientes(@RequestBody Cliente clientes) {
try {
    Cliente createeClientes = clientesServices.createclientes(clientes);
    return new ResponseEntity<>(createeClientes,HttpStatus.CREATED);


}catch (Exception e) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}

//EndPoint para eliminar un Cliente
@DeleteMapping("/eliminarclientes/{id}")
public ResponseEntity<HashMap<String, String>> deleteclientes(@PathVariable int id) {
    try {
    HashMap<String, String> response = clientesServices.deleteclientes(id);
    return new ResponseEntity<>(response, HttpStatus.OK);

    }catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

//EndPoint para listar los Cliente
@GetMapping("/listarclientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        try {
            List<Cliente> cliente = clientesServices.getAllClientes();
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para actualizar un Cliente
    @PutMapping("/actualizarcliente")
public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
    try {
        Cliente updatedCliente = clientesServices.updateCliente(cliente);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    } catch (RuntimeException e) {
        LOGGER.error("Error al actualizar el estudiante: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        LOGGER.error("Error al actualizar el estudiante: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}