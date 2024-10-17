package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_cliente", "cedula", "nombre", "apellidos", "telefono"}) // Incluye el ID primero

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @JsonProperty("id_cliente")
    private int ID_Cliente;
    
    @JsonProperty("cedula")
    private String Cédula;
    
    @JsonProperty("nombre")
    private String Nombre;
    
    @JsonProperty("apellidos")
    private String Apellidos;
    
    @JsonProperty("telefono")
    private String Teléfono;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor sin ID
    public Cliente(String cedula, String nombre, String apellidos, String telefono) {
        this.Cédula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Teléfono = telefono;
    }

    // Constructor con ID
    public Cliente(Integer id_cliente, String cedula, String nombre, String apellidos, String telefono) {
        this.ID_Cliente = id_cliente;
        this.Cédula = cedula;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Teléfono = telefono;
    }
}
