package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/reto";
        String usuario = "root";
        String contraseña = "Cambiame2024";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("✅ Conexión exitosa a la base de datos");

            String sql = "SELECT * FROM clientes";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_cliente");
                String nombre = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                String contrasena = resultSet.getString("contrasena");
                String fecha = resultSet.getString("fecha_registro");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Email: " + email +
                        ", Teléfono: " + telefono + ", Contraseña: " + contrasena + ", Fecha: " + fecha);
            }


            // ✅ Ahora sí: cerrar al final
            conexion.close();

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}

