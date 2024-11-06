package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Puntuacion;
import java.util.HashMap;
import java.util.List;

public interface IPuntuacionServices {

    public Puntuacion createPuntuacion(Puntuacion puntuacion);
    
    public HashMap<String, String> deletePuntuacion(int id);

    public List<Puntuacion> getAllPuntuacion(); // Método para listar

    public Puntuacion updatePuntuacion(Puntuacion puntuacion);
}
