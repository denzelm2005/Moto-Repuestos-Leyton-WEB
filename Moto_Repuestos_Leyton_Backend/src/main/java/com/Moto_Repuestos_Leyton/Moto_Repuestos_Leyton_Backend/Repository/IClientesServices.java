package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository;

import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Cliente;
import java.util.HashMap;
import java.util.List;

public interface IClientesServices {

    public Cliente createclientes(Cliente clientes);
    
    public HashMap<String, String> deleteclientes(int Id);

    public List<Cliente> getAllClientes(); // Método para listar

    public Cliente updateCliente(Cliente cliente);
}