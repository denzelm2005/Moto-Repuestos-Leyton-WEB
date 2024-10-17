package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Proveedor;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.ProveedorRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IProveedorServices;
import java.util.HashMap;
import java.util.List;

@Service
public class ProveedorServices implements IProveedorServices {
 private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorServices.class);
    
    @Autowired
    ProveedorRepository proveedorRepository;

    //Servicio para crear un proveedor
    @Override
    public Proveedor createproveedor(Proveedor proveedor){
        try {
            return proveedorRepository.save(proveedor);
        }catch (Exception e){
            LOGGER.error("Error while creating Proveedor: {}", e.getMessage());
            throw new RuntimeException("Error creating Proveedor");
        
        }
    }

       //Servicio para eliminar un proveedor
    @Override
    public HashMap<String, String> deleteproveedores(int Id){
       try {
        HashMap<String,String> response = new HashMap<>();
        response.put("Message", "User delete succesfully!");
        proveedorRepository.deleteById(Id);
        return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
    }

       //Servicio para listar los proveedores
      @Override
public List<Proveedor> getAllProveedor() {
    try {
        return proveedorRepository.findAll();
    } catch (Exception e) {
        LOGGER.error("Error while fetching proveedor: {}", e.getMessage());
        throw new RuntimeException("Error fetching Proveedor");
    }
}

    //Servicio para actualizar un proveedor
@Override
public Proveedor updateProveedor(Proveedor proveedor) {
    if (proveedorRepository.existsById(proveedor.getID_Prov())) {
        return proveedorRepository.save(proveedor);
    } else {
        LOGGER.error("Proveedor no encontrado con ID: {}", proveedor.getID_Prov());
        throw new RuntimeException("Proveedor no encontrado");
    }
}

}
