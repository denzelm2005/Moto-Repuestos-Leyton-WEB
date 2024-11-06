package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Producto;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.ProductoRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IProductoServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ProductoServices implements IProductoServices {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoServices.class);

    @Autowired
    ProductoRepository productoRepository;

    // Servicio para crear un Producto
    @Override
    public Producto createProducto(Producto producto, MultipartFile fotografia) {
        try {
            byte[] FotoBytes = fotografia.getBytes();
           Path ruta = Paths.get("C:\\Users\\admin\\Downloads\\Moto_Repuestos_Leyton_Backend\\" + 
            "Moto_Repuestos_Leyton_Backend\\src\\main\\resources\\" + 
            "Fotografia\\" + fotografia.getOriginalFilename());
            Files.write(ruta, FotoBytes);
            producto.setUbicacionFotografia(ruta.toString());
            return productoRepository.save(producto);
        } catch (Exception e) {
            LOGGER.error("Error while creating Producto: {}", e.getMessage());
            throw new RuntimeException("Error creating Producto");
        }
    }

    // Servicio para eliminar un Producto
    @Override
    public HashMap<String, String> deleteProducto(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("Message", "Producto delete successfully!");
            productoRepository.deleteById(Id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting Producto: {}", e.getMessage());
            throw new RuntimeException("Error deleting Producto");
        }
    }

    // Servicio para listar todos los Productos
    @Override
    public List<Producto> getAllProductos() {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching Productos: {}", e.getMessage());
            throw new RuntimeException("Error fetching Productos");
        }
    }

    // Servicio para modificar un Producto
    @Override
    public Producto updateProducto(Producto producto) {
        if (productoRepository.existsById(producto.getID_Producto())) {
            return productoRepository.save(producto);
        } else {
            LOGGER.error("Producto no encontrado con ID: {}", producto.getID_Producto());
            throw new RuntimeException("Producto no encontrado");
        }
    }
}
