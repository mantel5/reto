package model;

import java.util.ArrayList;

public class Detalle_Pedido {
    private int id_detalle;
    private int id_pedido;
    private int id_producto;
    private int cantidad;
    private double precio_unitario;

    public Detalle_Pedido() {}

    public Detalle_Pedido(int id_detalle, int id_pedido) {
        this.id_detalle = id_detalle;
        this.id_pedido = id_pedido;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
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
        return "DetallePedido{" +
                "id_detalle=" + id_detalle +
                ", id_pedido=" + id_pedido +
                ", id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                '}';
    }

    public String toArrayJson(ArrayList<Detalle_Pedido> lista) {
        return "";
    }
}


