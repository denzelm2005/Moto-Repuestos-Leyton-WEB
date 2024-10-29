package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Compra;
import java.util.HashMap;
import java.util.List;

public interface ICompraServices {

    // Método para crear una compra
    public Compra createCompra(Compra compra);

    // Método para eliminar una compra por ID
    public HashMap<String, String> deleteCompra(int id);

    // Método para listar todas las compras
    public List<Compra> getAllCompras();

    // Método para actualizar una compra
    public Compra updateCompra(Compra compra);
}
