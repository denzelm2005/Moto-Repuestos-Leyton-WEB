package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Marca;
import java.util.HashMap;
import java.util.List;



public interface IMarcaServices {

    public Marca createMarca(Marca marca);
    
    public HashMap<String, String> deletemarca(int Id);

    public List<Marca> getAllMarca(); // Método para listar

    public Marca updateMarca(Marca marca);
}
