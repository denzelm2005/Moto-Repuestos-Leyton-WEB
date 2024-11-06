package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_producto", "nombre", "modelo", "precio_venta", "precio_compra", "stock", "id_marca", "ubicacionfotografia"}) // Incluye el ID primero

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
    private float PrecioVenta;

    @JsonProperty("precio_compra")
    private float PrecioCompra;

    @JsonProperty("stock")
    private int Stock;

    @JsonProperty("id_marca")
    private Integer ID_Marca;

    @JsonProperty("ubicacionfotografia")
    private String UbicacionFotografia;

 

    // Constructor vacío
    public Producto() {
    }

    // Constructor sin ID
    public Producto(String nombre, String modelo, float precioVenta, float precioCompra, int stock, Integer idMarca) {
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.PrecioVenta = precioVenta;
        this.PrecioCompra = precioCompra;
        this.Stock = stock;
        this.ID_Marca = idMarca;
    }

    // Constructor con ID
    public Producto(Integer idProducto, String nombre, String modelo, float precioVenta, float precioCompra, int stock, Integer idMarca) {
        this.ID_Producto = idProducto;
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.PrecioVenta = precioVenta;
        this.PrecioCompra = precioCompra;
        this.Stock = stock;
        this.ID_Marca = idMarca;
    }
}
