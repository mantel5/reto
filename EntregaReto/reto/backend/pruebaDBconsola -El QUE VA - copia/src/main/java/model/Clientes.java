package model;

import java.util.ArrayList;
import java.sql.Timestamp;

public class Clientes implements iModel {
    private int m_iIDCliente;
    private String m_strNombre;
    private String m_strEmail;
    private String m_strTelefono;
    private String m_strContrasena;
    private Timestamp m_tsFechaRegistro;

    public int getIDCliente() {
        return m_iIDCliente;
    }

    public void setIDCliente(int m_iIDCliente) {
        this.m_iIDCliente = m_iIDCliente;
    }

    public String getNombre() {
        return m_strNombre;
    }

    public void setNombre(String m_strNombre) {
        this.m_strNombre = m_strNombre;
    }

    public String getEmail() {
        return m_strEmail;
    }

    public void setEmail(String m_strEmail) {
        this.m_strEmail = m_strEmail;
    }

    public String getTelefono() {
        return m_strTelefono;
    }

    public void setTelefono(String m_strTelefono) {
        this.m_strTelefono = m_strTelefono;
    }

    public String getContrasena() {
        return m_strContrasena;
    }

    public void setContrasena(String m_strContrasena) {
        this.m_strContrasena = m_strContrasena;
    }

    public Timestamp getFechaRegistro() {
        return m_tsFechaRegistro;
    }

    public void setFechaRegistro(Timestamp m_tsFechaRegistro) {
        this.m_tsFechaRegistro = m_tsFechaRegistro;
    }

    public Clientes(int m_iIDCliente, String m_strNombre) {
        this.m_iIDCliente = m_iIDCliente;
        this.m_strNombre = m_strNombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "m_iIDCliente=" + m_iIDCliente +
                ", m_strNombre='" + m_strNombre + '\'' +
                ", m_strEmail='" + m_strEmail + '\'' +
                ", m_strTelefono='" + m_strTelefono + '\'' +
                ", m_strContrasena='" + m_strContrasena + '\'' +
                ", m_tsFechaRegistro=" + m_tsFechaRegistro +
                '}';
    }

    public String fromArrayToJson(ArrayList clientes){
        String resp = "[";
        for (Object cliente : clientes) {
            resp+= "{" +
                    "'id':'" + ((Clientes)cliente).getIDCliente() + "', "
                    + "'nombre':'" + ((Clientes)cliente).getNombre() + "',"
                    + " 'email':'" + ((Clientes)cliente).getEmail() + "', "
                    + "'telefono':" + ((Clientes)cliente).getTelefono() + "', "
                    + "'contrasena':" + ((Clientes)cliente).getContrasena() + "', "
                    + "'fecharegistro':'" + ((Clientes)cliente).getFechaRegistro()+ "'}";
            resp+=",";
        }
        resp = resp.substring(0, resp.length()-1);
        resp+="]";
        return resp;
    }

    @Override
    public String toArrayJson(ArrayList bean) {
        return null;
    }


    /*public static String toArrayJSon(ArrayList<Clientes> clientes) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);

        return resp;
    }*/

    @Override
    public String toSqlWhereString() {
        return null;
    }
}
