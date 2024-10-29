package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleCompra;
import java.util.HashMap;
import java.util.List;

public interface IDetalleCompraServices {

    public DetalleCompra createDetalleCompra(DetalleCompra detalleCompra);  // Método para crear un detalle de compra

    public HashMap<String, String> deleteDetalleCompra(int Id);  // Método para eliminar un detalle de compra por ID

    public List<DetalleCompra> getAllDetalleCompra();  // Método para listar todos los detalles de compra

    public DetalleCompra updateDetalleCompra(DetalleCompra detalleCompra);  // Método para actualizar un detalle de compra
}

