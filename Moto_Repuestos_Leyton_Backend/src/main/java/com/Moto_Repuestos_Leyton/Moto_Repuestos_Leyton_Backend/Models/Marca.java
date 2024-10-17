package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_marca", "marca"}) // Incluye el ID primero

@Entity
@Getter
@Setter
public class Marca {

    @Id
    @JsonProperty("id_marca")
    private int ID_Marca;

    @JsonProperty("marca")
    private String Marca;

    public Marca() {
    }
    
    public Marca(String marca) {
        this.Marca = marca;
       
    }

    public Marca(Integer id_marca, String marca) {
        this.ID_Marca = id_marca;
        this.Marca = marca; 
    }

}
