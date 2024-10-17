package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;


import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Proveedor;
import java.util.HashMap;
import java.util.List;

public interface IProveedorServices {

    public Proveedor createproveedor(Proveedor proveedor);
    
    public HashMap<String, String> deleteproveedores(int Id);

    public List<Proveedor> getAllProveedor(); // Método para listar

    public Proveedor updateProveedor(Proveedor proveedor);
}
