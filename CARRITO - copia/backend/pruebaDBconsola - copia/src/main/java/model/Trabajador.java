package model;

import java.sql.Date;

public class Trabajador {
    private int id_trabajador;
    private String nombre;
    private String email;
    private String telefono;
    private String puesto;
    private Date fecha_contratacion;

    public Trabajador() {}

    public Trabajador(int id_trabajador, String nombre) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id_trabajador=" + id_trabajador +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puesto='" + puesto + '\'' +
                ", fecha_contratacion=" + fecha_contratacion +
                '}';
    }
}

