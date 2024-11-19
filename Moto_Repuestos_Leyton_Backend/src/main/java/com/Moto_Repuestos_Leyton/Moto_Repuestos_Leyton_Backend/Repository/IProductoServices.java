package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Producto;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface IProductoServices {

    public Producto createProducto(Producto producto, MultipartFile fotografia);  // Crear un producto

    public HashMap<String, String> deleteProducto(int Id);  // Eliminar un producto por ID

    public List<Producto> getAllProductos();  // Listar todos los productos

    public Optional<Producto> obtenerProductoPorId(int Id);  // Obtener un producto por ID

    public File descargarFoto(String archivo) throws Exception;  // Descargar una foto del producto

    public Producto updateProducto(int id_producto, Producto producto, MultipartFile fotografia);
}
