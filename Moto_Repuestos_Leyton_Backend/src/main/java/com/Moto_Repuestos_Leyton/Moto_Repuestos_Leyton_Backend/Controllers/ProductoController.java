package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.var;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Producto;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IProductoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ProductoController")
public class ProductoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IProductoServices productoServices;

    @PostMapping(value = "/insertarproducto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Producto> createProducto(@RequestParam("producto") String producto,
                                                   @RequestParam("fotografia") MultipartFile fotografia) {
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

    @GetMapping("/obtenerproducto/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        try {
            Optional<Producto> producto = productoServices.obtenerProductoPorId(id);
            return producto.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            LOGGER.error("Error al obtener el producto por ID: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

    @PutMapping(value = "/actualizarproducto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<Producto> updateProducto(
        @RequestParam("producto") String producto,
        @RequestParam(value = "fotografia", required = false) MultipartFile fotografia) {
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        Producto productoObj = objectMapper.readValue(producto, Producto.class);
        Producto updatedProducto = productoServices.updateProducto(productoObj.getID_Producto(), productoObj, fotografia);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    } catch (RuntimeException e) {
        LOGGER.error("Producto no encontrado: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        LOGGER.error("Error al actualizar el producto: {}", e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping ("/descargarfoto/{archivo}")
public ResponseEntity<Resource> downloadFile(@PathVariable String archivo){
    // System.out.println(archivo);
    try{
        var fileToDownload = productoServices.descargarFoto(archivo);
        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo + "\"")
        .contentLength(fileToDownload.length())
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(new InputStreamResource(Files.newInputStream(fileToDownload.toPath())));

    }catch (Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
}