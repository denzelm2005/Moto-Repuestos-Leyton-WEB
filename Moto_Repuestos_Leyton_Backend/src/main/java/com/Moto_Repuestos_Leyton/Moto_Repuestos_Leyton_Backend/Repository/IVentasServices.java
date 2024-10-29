package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Venta;
import java.util.HashMap;
import java.util.List;


public interface IVentasServices {

    public Venta createventas(Venta ventas);
    
    public HashMap<String, String> deleteventas(int Id);

    public List<Venta> getAllVentas(); // Método para listar

    public Venta updateVenta(Venta venta);
}
