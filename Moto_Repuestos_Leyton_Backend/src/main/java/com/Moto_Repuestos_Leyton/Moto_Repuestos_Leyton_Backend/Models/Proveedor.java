package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_pro",  "nombre", "telefono", "empresa"}) // Incluye el ID primero

@Entity
@Getter
@Setter
public class Proveedor{

    @Id
    @JsonProperty("id_pro")
    private int ID_Prov;
    
    @JsonProperty("nombre")
    private String Nombre;
    
    @JsonProperty("telefono")
    private String Teléfono;
    
    @JsonProperty("empresa")
    private String Empresa;
    
    

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor sin ID
    public Proveedor(String nombre, String telefono, String empresa) {
        this.Nombre = nombre;
        this.Teléfono = telefono;
        this.Empresa = empresa;
    }

    // Constructor con ID
    public Proveedor(Integer id_pro, String nombre, String telefono, String empresa) {
        this.ID_Prov = id_pro;
        this.Nombre = nombre;
        this.Teléfono = telefono;
        this.Empresa = empresa;
        
    }
}
