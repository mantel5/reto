package model;

import java.util.ArrayList;

public class DetalleCarrito {
    private int id_detalle;
    private int id_carrito;
    private int id_producto;
    private int cantidad;
    private double precio_unitario;

    public DetalleCarrito() {}

    public DetalleCarrito(int id_detalle, int id_carrito) {
        this.id_detalle = id_detalle;
        this.id_carrito = id_carrito;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "DetalleCarrito{" +
                "id_detalle=" + id_detalle +
                ", id_carrito=" + id_carrito +
                ", id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                '}';
    }

    public String toArrayJson(ArrayList<DetalleCarrito> lista) {
        return "";
    }
}


