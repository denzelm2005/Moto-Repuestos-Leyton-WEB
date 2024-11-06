package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_puntuacion", "puntuacion", "id_producto"}) // Incluye el ID primero

@Entity
@Getter
@Setter
public class Puntuacion {

    @Id
  @JsonProperty("id_puntuacion")
    private int ID_Puntuacion;

    @JsonProperty("puntuacion")
    private int Puntuacion;

    @JsonProperty("id_producto")
    private int ID_Producto;

    // Constructor vacío
    public Puntuacion() {
    }

    // Constructor sin ID
    public Puntuacion(int puntuacion, int id_producto) {
        this.Puntuacion = puntuacion;
        this.ID_Producto = id_producto;
    }

    // Constructor con ID
    public Puntuacion(Integer id_puntuacion, int puntuacion, int id_producto) {
        this.ID_Puntuacion = id_puntuacion;
        this.Puntuacion = puntuacion;
        this.ID_Producto = id_producto;
    }
}
