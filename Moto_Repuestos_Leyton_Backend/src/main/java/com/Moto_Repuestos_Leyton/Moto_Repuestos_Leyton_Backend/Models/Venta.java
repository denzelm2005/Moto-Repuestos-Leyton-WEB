package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"id_venta", "fecha_venta", "id_cliente"})
@Entity
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_venta")
    private int ID_Venta;

    @JsonProperty("fecha_venta")
    private LocalDateTime Fecha_venta;

    @JsonProperty("id_cliente")
    private int ID_Cliente;  // Aquí solo el ID del cliente, no el objeto entero

    // Constructor vacío
    public Venta() {
    }

    // Constructor sin ID_Venta (para creación de ventas)
    public Venta(LocalDateTime fecha_venta, int id_cliente) {
        this.Fecha_venta = fecha_venta;
        this.ID_Cliente = id_cliente;
    }

    // Constructor con ID_Venta (para operaciones específicas)
    public Venta(int id_venta, LocalDateTime fecha_venta, int id_cliente) {
        this.ID_Venta = id_venta;
        this.Fecha_venta = fecha_venta;
        this.ID_Cliente = id_cliente;
    }
}
