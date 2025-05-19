package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private Timestamp fecha_pedido;
    private String estado;
    private double total;

    public Pedido() {}

    public Pedido(int id_pedido, int id_cliente) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Timestamp getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Timestamp fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", id_cliente=" + id_cliente +
                ", fecha_pedido=" + fecha_pedido +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                '}';
    }

    public String toArrayJson(ArrayList<Pedido> lista) {
        return "";
    }
}


