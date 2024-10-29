package com.Moto_Repuestos_Leyton.Moto_Repuestos_Leyton_Backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_detalle_venta", "cantidad", "id_producto", "id_venta"})
@Entity
@Getter
@Setter
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_detalle_venta")
    private int ID_Detalle_venta;

    @JsonProperty("cantidad")
    private int Cantidad;

    @JsonProperty("id_producto")
    private Integer ID_Producto;

    @JsonProperty("id_venta")
    private Integer ID_Venta;

    // Constructor vacío
    public DetalleVenta() {}

    // Constructor sin ID (para creación de DetalleVenta)
    public DetalleVenta(int cantidad, Integer idProducto, Integer idVenta) {
        this.Cantidad = cantidad;
        this.ID_Producto = idProducto;
        this.ID_Venta = idVenta;
    }

    // Constructor con ID (para operaciones específicas)
    public DetalleVenta(int id_detalle_venta, int cantidad, Integer idProducto, Integer idVenta) {
        this.ID_Detalle_venta = id_detalle_venta;
        this.Cantidad = cantidad;
        this.ID_Producto = idProducto;
        this.ID_Venta = idVenta;
    }
}