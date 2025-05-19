package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Pago {
    private int id_pago;
    private int id_pedido;
    private String metodo_pago;
    private String estado_pago;
    private Timestamp fecha_pago;

    public Pago() {}

    public Pago(int id_pago, int id_pedido) {
        this.id_pago = id_pago;
        this.id_pedido = id_pedido;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public Timestamp getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Timestamp fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id_pago=" + id_pago +
                ", id_pedido=" + id_pedido +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", estado_pago='" + estado_pago + '\'' +
                ", fecha_pago=" + fecha_pago +
                '}';
    }

    public String toArrayJson(ArrayList<Pago> lista) {
        return "";
    }
}


