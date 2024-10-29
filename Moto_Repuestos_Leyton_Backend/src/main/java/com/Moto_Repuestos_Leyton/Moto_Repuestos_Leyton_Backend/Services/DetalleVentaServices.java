package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleVenta;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.DetalleVentaRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IDetalleVentaServices;

import java.util.HashMap;
import java.util.List;

@Service
public class DetalleVentaServices implements IDetalleVentaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleVentaServices.class);

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    // Servicio para crear un DetalleVenta
    @Override
    public DetalleVenta createDetalleVenta(DetalleVenta detalleVenta) {
        try {
            return detalleVentaRepository.save(detalleVenta);
        } catch (Exception e) {
            LOGGER.error("Error al crear DetalleVenta: {}", e.getMessage());
            throw new RuntimeException("Error al crear DetalleVenta");
        }
    }

    // Servicio para eliminar un DetalleVenta
    @Override
    public HashMap<String, String> deleteDetalleVenta(int idDetalleVenta) {
        try {
            HashMap<String, String> response = new HashMap<>();
            detalleVentaRepository.deleteById(idDetalleVenta);
            response.put("Message", "DetalleVenta eliminado exitosamente.");
            return response;
        } catch (Exception e) {
            LOGGER.error("Error al eliminar DetalleVenta: {}", e.getMessage());
            throw new RuntimeException("Error al eliminar DetalleVenta");
        }
    }

    // Servicio para listar todos los DetalleVenta
    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        try {
            return detalleVentaRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error al obtener DetalleVenta: {}", e.getMessage());
            throw new RuntimeException("Error al obtener DetalleVenta");
        }
    }

    // Servicio para modificar un DetalleVenta
    @Override
    public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta) {
        if (detalleVentaRepository.existsById(detalleVenta.getID_Detalle_venta())) {
            try {
                return detalleVentaRepository.save(detalleVenta);
            } catch (Exception e) {
                LOGGER.error("Error al actualizar DetalleVenta: {}", e.getMessage());
                throw new RuntimeException("Error al actualizar DetalleVenta");
            }
        } else {
            LOGGER.error("DetalleVenta no encontrado con ID: {}", detalleVenta.getID_Detalle_venta());
            throw new RuntimeException("DetalleVenta no encontrado");
        }
    }
}
