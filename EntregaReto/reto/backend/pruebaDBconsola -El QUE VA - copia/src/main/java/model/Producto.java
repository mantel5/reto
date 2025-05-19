package model;

    public class Producto {
        private int id_producto;
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;

        public Producto(int i, String hamburguesaClásica, String s, double v, String hamburguesa) {
        }

        public Producto() {

        }

        // Getters y setters
        public int getId_producto() {
            return id_producto;
        }

        public void setId_producto(int id_producto) {
            this.id_producto = id_producto;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return "Producto{" +
                    "id_producto=" + id_producto +
                    ", nombre='" + nombre + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", precio=" + precio +
                    ", categoria='" + categoria + '\'' +
                    '}';
        }
    }


