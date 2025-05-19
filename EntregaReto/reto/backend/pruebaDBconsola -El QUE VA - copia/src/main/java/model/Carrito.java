package model;

import java.util.ArrayList;
import java.util.Date;

    public class Carrito {
        private int id_carrito;
        private int id_cliente;
        private Date fecha_creacion;
        private String direccion_envio;
        private ArrayList<Producto> productos;

        // Constructor
        public Carrito() {
            this.productos = new ArrayList<>();
        }

        // Getters y setters

        public int getId_carrito() {
            return id_carrito;
        }

        public void setId_carrito(int id_carrito) {
            this.id_carrito = id_carrito;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public Date getFecha_creacion() {
            return fecha_creacion;
        }

        public void setFecha_creacion(Date fecha_creacion) {
            this.fecha_creacion = fecha_creacion;
        }

        public String getDireccion_envio() {
            return direccion_envio;
        }

        public void setDireccion_envio(String direccion_envio) {
            this.direccion_envio = direccion_envio;
        }

        public ArrayList<Producto> getProductos() {
            return productos;
        }

        public void setProductos(ArrayList<Producto> productos) {
            this.productos = productos;
        }

        @Override
        public String toString() {
            return "Carrito{" +
                    "id_carrito=" + id_carrito +
                    ", id_cliente=" + id_cliente +
                    ", fecha_creacion=" + fecha_creacion +
                    ", direccion_envio='" + direccion_envio + '\'' +
                    ", productos=" + productos +
                    '}';
        }

        public void addProducto(Producto producto) {
        }

        public String toArrayJson(ArrayList<Carrito> lista) {
            return "";
        }
    }



