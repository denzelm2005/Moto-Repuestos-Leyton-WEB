package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleVenta;
import java.util.HashMap;
import java.util.List;

public interface IDetalleVentaServices {

    // Método para crear un detalle de venta
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta);

    // Método para eliminar un detalle de venta por ID
    public HashMap<String, String> deleteDetalleVenta(int Id);

    // Método para listar todos los detalles de venta
    public List<DetalleVenta> getAllDetalleVenta();

    // Método para actualizar un detalle de venta
    public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta);
}

