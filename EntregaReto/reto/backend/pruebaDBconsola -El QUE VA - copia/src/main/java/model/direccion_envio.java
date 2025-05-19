package model;
import java.sql.Timestamp;
public class direccion_envio {
        private int id_direccion;
        private String calle;
        private String ciudad;
        private String codigo_postal;
        private String pais;
        private Timestamp fecha_creacion;

        // Getters y setters
        public int getId_direccion() {
            return id_direccion;
        }

        public void setId_direccion(int id_direccion) {
            this.id_direccion = id_direccion;
        }

        public String getCalle() {
            return calle;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public String getCodigo_postal() {
            return codigo_postal;
        }

        public void setCodigo_postal(String codigo_postal) {
            this.codigo_postal = codigo_postal;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public Timestamp getFecha_creacion() {
            return fecha_creacion;
        }

        public void setFecha_creacion(Timestamp fecha_creacion) {
            this.fecha_creacion = fecha_creacion;
        }

        @Override
        public String toString() {
            return "DireccionEnvio{" +
                    "id_direccion=" + id_direccion +
                    ", calle='" + calle + '\'' +
                    ", ciudad='" + ciudad + '\'' +
                    ", codigo_postal='" + codigo_postal + '\'' +
                    ", pais='" + pais + '\'' +
                    ", fecha_creacion=" + fecha_creacion +
                    '}';
        }

    public void toSqlWhereString() {
    }
}


