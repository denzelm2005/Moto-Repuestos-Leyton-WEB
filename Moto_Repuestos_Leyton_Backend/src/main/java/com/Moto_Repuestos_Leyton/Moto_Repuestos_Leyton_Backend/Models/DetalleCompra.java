package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_detalle_compra", "cantidad", "precio_unitario", "id_compra", "id_producto"})
@Entity
@Getter
@Setter
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_detalle_compra")
    private int ID_Detalle_compra;

    @JsonProperty("cantidad")
    private int Cantidad;

    @JsonProperty("precio_unitario")
    private float Precio_unitario;

    @JsonProperty("id_compra")
    private Integer ID_Compra;

    @JsonProperty("id_producto")
    private Integer ID_Producto;

    // Constructor vacío
    public DetalleCompra() {
    }

    // Constructor sin ID
    public DetalleCompra(int cantidad, float precio_unitario, Integer idCompra, Integer idProducto) {
        this.Cantidad = cantidad;
        this.Precio_unitario = precio_unitario;
        this.ID_Compra = idCompra;
        this.ID_Producto = idProducto;
    }

    // Constructor con ID
    public DetalleCompra(int idDetalleCompra, int cantidad, float precio_unitario, Integer idCompra, Integer idProducto) {
        this.ID_Detalle_compra = idDetalleCompra;
        this.Cantidad = cantidad;
        this.Precio_unitario = precio_unitario;
        this.ID_Compra = idCompra;
        this.ID_Producto = idProducto;
    }
}
