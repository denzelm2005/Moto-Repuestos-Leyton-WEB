package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

@JsonPropertyOrder({"id_compra", "fecha_compra", "id_prov"}) // Incluye el ID del proveedor
@Entity
@Getter
@Setter
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_compra")
    private int ID_Compra;

    @JsonProperty("fecha_compra")
    private LocalDateTime Fecha_Compra;

    // ID del proveedor
    @JsonProperty("id_prov")
    private int ID_Prov;

    // Constructor vacío
    public Compra() {
    }

    // Constructor con parámetros (sin el ID de la compra, ya que se autogenera)
    public Compra(LocalDateTime fecha_compra, int id_prov) {
        this.Fecha_Compra = fecha_compra;
        this.ID_Prov = id_prov;
    }

    // Constructor con ID de compra
    public Compra(int id_compra, LocalDateTime fecha_compra, int id_prov) {
        this.ID_Compra = id_compra;
        this.Fecha_Compra = fecha_compra;
        this.ID_Prov = id_prov;
    }
}