package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Producto;
import java.util.HashMap;
import java.util.List;

public interface IProductoServices {

    public Producto createProducto(Producto producto);  // Método para crear un producto

    public HashMap<String, String> deleteProducto(int Id);  // Método para eliminar un producto por ID

    public List<Producto> getAllProductos();  // Método para listar todos los productos

    public Producto updateProducto(Producto producto);  // Método para actualizar un producto
}
