package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Marca;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.MarcaRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IMarcaServices;
import java.util.HashMap;
import java.util.List;

@Service
public class MarcaServices implements IMarcaServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarcaServices.class);


 @Autowired
    MarcaRepository marcaRepository;

    //Servicio para crear una Marca
    @Override
    public Marca createMarca(Marca marca){
        try {
            return marcaRepository.save(marca);
        }catch (Exception e){
            LOGGER.error("Error while creating Marca: {}", e.getMessage());
            throw new RuntimeException("Error creating Marca");
        
        }
    }

     //Servicio para eliminar una Marca
    @Override
    public HashMap<String, String> deletemarca(int Id){
       try {
        HashMap<String,String> response = new HashMap<>();
        response.put("Message", "Marca delete succesfully!");
        marcaRepository.deleteById(Id);
        return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting Marca");
        }
    }

    //Servicio para listar una Marca
      @Override
public List<Marca> getAllMarca() {
    try {
        return marcaRepository.findAll();
    } catch (Exception e) {
        LOGGER.error("Error while fetching Marca: {}", e.getMessage());
        throw new RuntimeException("Error fetching Marca");
    }
}

    //Servicio para modificar una Marca
@Override
public Marca updateMarca(Marca marca) {
    if (marcaRepository.existsById(marca.getID_Marca())) {
        return marcaRepository.save(marca);
    } else {
        LOGGER.error("Marca no encontrada con ID: {}", marca.getID_Marca());
        throw new RuntimeException("Marca no encontrado");
    }
}
}
