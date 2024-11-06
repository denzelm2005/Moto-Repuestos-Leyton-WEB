package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Puntuacion;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.PuntuacionRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IPuntuacionServices;
import java.util.HashMap;
import java.util.List;

@Service
public class PuntuacionServices implements IPuntuacionServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(PuntuacionServices.class);
    
    @Autowired
    PuntuacionRepository puntuacionRepository;

    // Servicio para crear una Puntuacion
    @Override
    public Puntuacion createPuntuacion(Puntuacion puntuacion) {
        try {
            return puntuacionRepository.save(puntuacion);
        } catch (Exception e) {
            LOGGER.error("Error while creating Puntuacion: {}", e.getMessage());
            throw new RuntimeException("Error creating Puntuacion");
        }
    }
 
    // Servicio para eliminar una Puntuacion
    @Override
    public HashMap<String, String> deletePuntuacion(int id) {
       try {
           HashMap<String, String> response = new HashMap<>();
           response.put("Message", "Puntuacion deleted successfully!");
           puntuacionRepository.deleteById(id);
           return response;
       } catch (Exception e) {
           LOGGER.error("Error while deleting Puntuacion: {}", e.getMessage());
           throw new RuntimeException("Error deleting Puntuacion");
       }
    }

    // Servicio para listar todas las Puntuaciones
    @Override
    public List<Puntuacion> getAllPuntuacion() {
        try {
            return puntuacionRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching Puntuaciones: {}", e.getMessage());
            throw new RuntimeException("Error fetching Puntuaciones");
        }
    }

    // Servicio para modificar una Puntuacion
    @Override
    public Puntuacion updatePuntuacion(Puntuacion puntuacion) {
        if (puntuacionRepository.existsById(puntuacion.getID_Puntuacion())) {
            return puntuacionRepository.save(puntuacion);
        } else {
            LOGGER.error("Puntuacion no encontrada con ID: {}", puntuacion.getID_Puntuacion());
            throw new RuntimeException("Puntuacion no encontrada");
        }
    }
}
