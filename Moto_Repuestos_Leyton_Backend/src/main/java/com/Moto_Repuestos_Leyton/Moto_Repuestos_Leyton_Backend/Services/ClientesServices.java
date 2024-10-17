package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models.Cliente;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.ClientesRepository;
import com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Repository.IClientesServices;
import java.util.HashMap;
import java.util.List;

@Service
public class ClientesServices implements IClientesServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientesServices.class);
    
    @Autowired
    ClientesRepository clienteRepository;

    //Servicio para crear un Cliente
    @Override
    public Cliente createclientes(Cliente clientes){
        try {
            return clienteRepository.save(clientes);
        }catch (Exception e){
            LOGGER.error("Error while creating Cliente: {}", e.getMessage());
            throw new RuntimeException("Error creating Cliente");
        
        }
    }
 
    //Servicio para eliminar un Cliente
    @Override
    public HashMap<String, String> deleteclientes(int Id){
       try {
        HashMap<String,String> response = new HashMap<>();
        response.put("Message", "User delete succesfully!");
        clienteRepository.deleteById(Id);
        return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting Cliente");
        }
    }

    //Servicio para listar los Clientes
    @Override
public List<Cliente> getAllClientes() {
    try {
        return clienteRepository.findAll();
    } catch (Exception e) {
        LOGGER.error("Error while fetching cliente: {}", e.getMessage());
        throw new RuntimeException("Error fetching Cliente");
    }
}

//Servicio para modificar un Cliente
@Override
public Cliente updateCliente(Cliente cliente) {
    if (clienteRepository.existsById(cliente.getID_Cliente())) {
        return clienteRepository.save(cliente);
    } else {
        LOGGER.error("Cliente no encontrado con ID: {}", cliente.getID_Cliente());
        throw new RuntimeException("Cliente no encontrado");
    }
}
}
