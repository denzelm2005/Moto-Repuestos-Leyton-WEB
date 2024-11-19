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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Objects;
import java.util.Optional;


@Service
public class ProductoServices implements IProductoServices {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoServices.class);

    @Autowired
    ProductoRepository productoRepository;
    @SuppressWarnings("null")
    // Servicio para crear un Producto
    @Override
    public Producto createProducto(Producto producto, MultipartFile fotografia) {
        try {
            int index = fotografia.getOriginalFilename().lastIndexOf('.');
            String extension = "";
            if (index > 0 && index < fotografia.getOriginalFilename().length() - 1) {
                extension = fotografia.getOriginalFilename().substring(index);
            }
            byte[] FotoBytes = fotografia.getBytes();
            Path ruta = Paths.get("C:\\Users\\admin\\Desktop\\Moto_Repuestos_Leyton_Backend\\Moto_Repuestos_Leyton_Backend\\src\\main\\resources\\Fotografia\\" + 
                                  producto.getNombre() + 
                                  producto.getModelo() + extension);
            Files.write(ruta, FotoBytes);

            producto.setFotografia(producto.getNombre() + extension);
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
public Producto updateProducto(int id_producto, Producto producto, MultipartFile fotografia) {
    try {
        Producto productoExistente = productoRepository.findById(id_producto)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id_producto));

        if (producto.getNombre() != null && !producto.getNombre().isEmpty()) {
            productoExistente.setNombre(producto.getNombre());
        }
        if (producto.getModelo() != null && !producto.getModelo().isEmpty()) {
            productoExistente.setModelo(producto.getModelo());
        }
        if (producto.getPrecio_Venta() > 0) {
            productoExistente.setPrecio_Venta(producto.getPrecio_Venta());
        }
        if (producto.getPrecio_Compra() > 0) {
            productoExistente.setPrecio_Compra(producto.getPrecio_Compra());
        }
        if (producto.getStock() >= 0) {
            productoExistente.setStock(producto.getStock());
        }
        if (producto.getID_Marca() != null) {
            productoExistente.setID_Marca(producto.getID_Marca());
        }

        // Manejo de fotografía
        if (fotografia != null && !fotografia.isEmpty()) {
            @SuppressWarnings("null")
            String extension = Objects.requireNonNull(fotografia.getOriginalFilename())
                                       .substring(fotografia.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            if (!extension.matches("\\.(jpg|jpeg|png)$")) {
                throw new RuntimeException("Formato no permitido");
            }

            String nombreArchivo = "producto_" + id_producto + extension;
            Path ruta = Paths.get("src/main/resources/Fotografia/" + nombreArchivo);
            Files.write(ruta, fotografia.getBytes());

            productoExistente.setFotografia(nombreArchivo);
        }
        return productoRepository.save(productoExistente);
    } catch (IOException e) {
        throw new RuntimeException("Error procesando fotografía: " + e.getMessage());
    } catch (Exception e) {
        throw new RuntimeException("Error actualizando producto: " + e.getMessage());
    }
}

    // Servicio para obtener un Producto por ID
    @Override
    public Optional<Producto> obtenerProductoPorId(int Id) {
        try {
            return productoRepository.findById(Id);
        } catch (Exception e) {
            LOGGER.error("Error while fetching Producto by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching Producto by ID");
        }
    }

// Servicio para descargar la foto del Producto
@Override
    public File descargarFoto(String archivo) throws Exception {
        Path path = Paths.get("C:\\Users\\admin\\Desktop\\Moto_Repuestos_Leyton_Backend\\" +
        "\\Moto_Repuestos_Leyton_Backend\\src\\main\\resources\\Fotografia");
        if (archivo == null) {
            throw new NullPointerException("file name is null");
        }
        var foto = new File(path + File.separator + archivo);
        if (!Objects.equals(foto.getParent(), path.toString())) {
            throw new SecurityException("unsupported file");
        }
        if (!foto.exists()) {
            throw new FileNotFoundException("No file name:" + archivo);
        }
        return foto;
    }
}