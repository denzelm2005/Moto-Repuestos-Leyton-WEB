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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Producto;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IProductoServices;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ProductoController")
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IProductoServices productoServices;

    // EndPoint para insertar un Producto
    @PostMapping(value = "/insertarproducto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Producto> createProducto(@RequestParam ("producto")  String producto,
   @RequestParam("fotografia") MultipartFile fotografia  ) {
    ObjectMapper objectMapper = new ObjectMapper();
        try {
            Producto Oproducto = objectMapper.readValue(producto, Producto.class);
            Producto createdProducto = productoServices.createProducto(Oproducto, fotografia);
            return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error al crear el producto: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para eliminar un Producto
    @DeleteMapping("/eliminarproducto/{id}")
    public ResponseEntity<HashMap<String, String>> deleteProducto(@PathVariable int id) {
        try {
            HashMap<String, String> response = productoServices.deleteProducto(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el producto: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para listar los Productos
    @GetMapping("/listarproductos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        try {
            List<Producto> productos = productoServices.getAllProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error al listar los productos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // EndPoint para actualizar un Producto
    @PutMapping("/actualizarproducto")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        try {
            Producto updatedProducto = productoServices.updateProducto(producto);
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } catch (RuntimeException e) {
            LOGGER.error("Producto no encontrado: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar el producto: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
