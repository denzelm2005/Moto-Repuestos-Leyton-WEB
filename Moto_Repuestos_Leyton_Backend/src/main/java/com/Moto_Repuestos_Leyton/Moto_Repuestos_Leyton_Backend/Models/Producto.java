package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_producto", "nombre", "modelo", "precio_venta", "precio_compra", "stock", "id_marca", "fotografia"}) // Incluye el ID primero

@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_producto")
    private int ID_Producto;

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("modelo")
    private String Modelo;

    @JsonProperty("precio_venta")
    private float Precio_Venta;

    @JsonProperty("precio_compra")
    private float Precio_Compra;

    @JsonProperty("stock")
    private int Stock;

    @JsonProperty("id_marca")
    private Integer ID_Marca;

    @JsonProperty("fotografia")
    private String Fotografia;

    // Constructor vacío
    public Producto() {
    }

    // Constructor sin ID
    public Producto(String nombre, String modelo, float precio_Venta, float precio_Compra, int stock, Integer idMarca, String fotografia) {
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.Precio_Venta =  precio_Venta;
        this.Precio_Compra = precio_Compra;
        this.Stock = stock;
        this.ID_Marca = idMarca;
        this.Fotografia = fotografia;
    }

    // Constructor con ID
    public Producto(Integer idProducto, String nombre, String modelo, float precio_Venta, float precio_Compra, int stock, Integer idMarca, String fotografia) {
        this.ID_Producto = idProducto;
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.Precio_Venta = precio_Venta;
        this.Precio_Compra = precio_Compra;
        this.Stock = stock;
        this.ID_Marca = idMarca;
        this.Fotografia = fotografia;
    }
}
