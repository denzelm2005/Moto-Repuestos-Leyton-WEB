package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.DetalleCompra;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.DetalleCompraRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IDetalleCompraServices;

import java.util.HashMap;
import java.util.List;

@Service
public class DetalleCompraServices implements IDetalleCompraServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleCompraServices.class);

    @Autowired
    DetalleCompraRepository detalleCompraRepository;

    // Servicio para crear un DetalleCompra
    @Override
    public DetalleCompra createDetalleCompra(DetalleCompra detalleCompra) {
        try {
            return detalleCompraRepository.save(detalleCompra);
        } catch (Exception e) {
            LOGGER.error("Error al crear DetalleCompra: {}", e.getMessage());
            throw new RuntimeException("Error al crear DetalleCompra");
        }
    }

    // Servicio para eliminar un DetalleCompra
    @Override
    public HashMap<String, String> deleteDetalleCompra(int idDetalleCompra) {
        try {
            HashMap<String, String> response = new HashMap<>();
            detalleCompraRepository.deleteById(idDetalleCompra);
            response.put("Message", "DetalleCompra eliminado exitosamente.");
            return response;
        } catch (Exception e) {
            LOGGER.error("Error al eliminar DetalleCompra: {}", e.getMessage());
            throw new RuntimeException("Error al eliminar DetalleCompra");
        }
    }

    // Servicio para listar todos los DetalleCompra
    @Override
    public List<DetalleCompra> getAllDetalleCompra() {
        try {
            return detalleCompraRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error al obtener DetalleCompra: {}", e.getMessage());
            throw new RuntimeException("Error al obtener DetalleCompra");
        }
    }

    // Servicio para modificar un DetalleCompra
    @Override
    public DetalleCompra updateDetalleCompra(DetalleCompra detalleCompra) {
        if (detalleCompraRepository.existsById(detalleCompra.getID_Detalle_compra())) {
            try {
                return detalleCompraRepository.save(detalleCompra);
            } catch (Exception e) {
                LOGGER.error("Error al actualizar DetalleCompra: {}", e.getMessage());
                throw new RuntimeException("Error al actualizar DetalleCompra");
            }
        } else {
            LOGGER.error("DetalleCompra no encontrado con ID: {}", detalleCompra.getID_Detalle_compra());
            throw new RuntimeException("DetalleCompra no encontrado");
        }
    }
}
