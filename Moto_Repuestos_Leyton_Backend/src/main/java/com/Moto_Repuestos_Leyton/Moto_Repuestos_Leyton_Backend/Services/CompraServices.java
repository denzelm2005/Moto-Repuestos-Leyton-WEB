package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Compra;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.CompraRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.ICompraServices;
import java.util.HashMap;
import java.util.List;

@Service
public class CompraServices implements ICompraServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompraServices.class);
    
    @Autowired
    CompraRepository comprasRepository;

    // Servicio para crear una Compra
    @Override
    public Compra createCompra(Compra compra) {
        try {
            return comprasRepository.save(compra);
        } catch (Exception e) {
            LOGGER.error("Error while creating Compra: {}", e.getMessage());
            throw new RuntimeException("Error creating Compra");
        }
    }
 
    // Servicio para eliminar una Compra
    @Override
    public HashMap<String, String> deleteCompra(int id) {
       try {
        HashMap<String,String> response = new HashMap<>();
        response.put("Message", "Compra deleted successfully!");
        comprasRepository.deleteById(id);
        return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting Compra: {}", e.getMessage());
            throw new RuntimeException("Error deleting Compra");
        }
    }

    // Servicio para listar las Compras
    @Override
    public List<Compra> getAllCompras() {
        try {
            return comprasRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching Compras: {}", e.getMessage());
            throw new RuntimeException("Error fetching Compras");
        }
    }

    // Servicio para modificar una Compra
    @Override
    public Compra updateCompra(Compra compra) {
        if (comprasRepository.existsById(compra.getID_Compra())) {
            return comprasRepository.save(compra);
        } else {
            LOGGER.error("Compra no encontrada con ID: {}", compra.getID_Compra());
            throw new RuntimeException("Compra no encontrada");
        }
    }
}
