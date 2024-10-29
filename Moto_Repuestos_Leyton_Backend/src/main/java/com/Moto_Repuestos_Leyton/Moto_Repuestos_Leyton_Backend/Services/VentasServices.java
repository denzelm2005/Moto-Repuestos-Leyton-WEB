package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Venta;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.VentasRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IVentasServices;
import java.util.HashMap;
import java.util.List;

@Service
public class VentasServices implements IVentasServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(VentasServices.class);

    @Autowired
    VentasRepository ventasRepository;

    // Servicio para crear una Venta
    @Override
    public Venta createventas(Venta ventas) {
        try {
            return ventasRepository.save(ventas);
        } catch (Exception e) {
            LOGGER.error("Error while creating Venta: {}", e.getMessage());
            throw new RuntimeException("Error creating Venta");
        }
    }

    // Servicio para eliminar una Venta
    @Override
    public HashMap<String, String> deleteventas(int Id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("Message", "Venta deleted successfully!");
            ventasRepository.deleteById(Id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting Venta: {}", e.getMessage());
            throw new RuntimeException("Error deleting Venta");
        }
    }

    // Servicio para listar todas las Ventas
    @Override
    public List<Venta> getAllVentas() {
        try {
            return ventasRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching Ventas: {}", e.getMessage());
            throw new RuntimeException("Error fetching Ventas");
        }
    }

    // Servicio para modificar una Venta
    @Override
    public Venta updateVenta(Venta venta) {
        if (ventasRepository.existsById(venta.getID_Venta())) {
            return ventasRepository.save(venta);
        } else {
            LOGGER.error("Venta no encontrada con ID: {}", venta.getID_Venta());
            throw new RuntimeException("Venta no encontrada");
        }
    }
}
