package model;

import java.sql.Timestamp;

    public class Valoracion {
        private int id_valoracion;
        private int id_cliente;
        private int id_producto;
        private int puntuacion;
        private String comentario;
        private Timestamp fecha_valoracion;

        public Valoracion() {}

        public Valoracion(int id_valoracion, int id_cliente, int id_producto, int puntuacion, String comentario) {
            this.id_valoracion = id_valoracion;
            this.id_cliente = id_cliente;
            this.id_producto = id_producto;
            this.puntuacion = puntuacion;
            this.comentario = comentario;
        }

        public int getId_valoracion() {
            return id_valoracion;
        }

        public void setId_valoracion(int id_valoracion) {
            this.id_valoracion = id_valoracion;
        }

        public int getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
        }

        public int getId_producto() {
            return id_producto;
        }

        public void setId_producto(int id_producto) {
            this.id_producto = id_producto;
        }

        public int getPuntuacion() {
            return puntuacion;
        }

        public void setPuntuacion(int puntuacion) {
            this.puntuacion = puntuacion;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public Timestamp getFecha_valoracion() {
            return fecha_valoracion;
        }

        public void setFecha_valoracion(Timestamp fecha_valoracion) {
            this.fecha_valoracion = fecha_valoracion;
        }

        @Override
        public String toString() {
            return "Valoracion{" +
                    "id_valoracion=" + id_valoracion +
                    ", id_cliente=" + id_cliente +
                    ", id_producto=" + id_producto +
                    ", puntuacion=" + puntuacion +
                    ", comentario='" + comentario + '\'' +
                    ", fecha_valoracion=" + fecha_valoracion +
                    '}';
        }
    }


