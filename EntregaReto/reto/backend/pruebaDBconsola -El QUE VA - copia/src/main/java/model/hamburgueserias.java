package model;

public class hamburgueserias {
        private int id_hamburgueseria;
        private String nombre;
        private String direccion;
        private String telefono;
        private String horario;
        private String email;
        private String pais;

        // Getters y setters
        public int getId_hamburgueseria() {
            return id_hamburgueseria;
        }

        public void setId_hamburgueseria(int id_hamburgueseria) {
            this.id_hamburgueseria = id_hamburgueseria;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        @Override
        public String toString() {
            return "Hamburgueseria{" +
                    "id_hamburgueseria=" + id_hamburgueseria +
                    ", nombre='" + nombre + '\'' +
                    ", direccion='" + direccion + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", horario='" + horario + '\'' +
                    ", email='" + email + '\'' +
                    ", pais='" + pais + '\'' +
                    '}';
        }

    public void toSqlWhereString() {
    }
}



