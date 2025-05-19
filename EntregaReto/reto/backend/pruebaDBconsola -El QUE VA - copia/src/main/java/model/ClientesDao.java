package model;
import model.Clientes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM clientes WHERE 1=1 ";
    private IMotorSql motorSql;

    public ClientesDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        return 0;
    }

    @Override
    public int delete(Object e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList FindAll(Object bean) {
        ArrayList<Clientes> clientes = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Clientes cliente = (Clientes) bean;
                if (cliente.getIDCliente() >= 0) {
                    sql += " AND id_cliente = '" + cliente.getIDCliente() + "'";
                }
                if (!cliente.getNombre().isEmpty()) {
                    sql += " AND nombre = '" + cliente.getNombre() + "'";
                }
                if (!cliente.getEmail().isEmpty()) {
                    sql += " AND email = '" + cliente.getEmail() + "'";
                }
                if (!cliente.getTelefono().isEmpty()) {
                    sql += " AND telefono = '" + cliente.getTelefono() + "'";
                }
                if (!cliente.getContrasena().isEmpty()) {
                    sql += " AND contrasena = '" + cliente.getContrasena() + "'";
                }

                cliente.toSqlWhereString(); // Método aún no implementado
            }


            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Clientes clienteBd = new Clientes(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre")
                );
                clienteBd.setEmail(rs.getString("email"));
                clienteBd.setTelefono(rs.getString("telefono"));
                clienteBd.setContrasena(rs.getString("contrasena"));
                clienteBd.setFechaRegistro(rs.getTimestamp("fecha_registro"));

                clientes.add(clienteBd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return clientes;
    }
}

/*if (cliente.getIDCliente() >= 0) {
sql += " AND id_cliente = '" + cliente.getIDCliente() + "'";
        }
        if (cliente.getNombre() != null && !cliente.getNombre().isEmpty()) {
sql += " AND nombre = '" + cliente.getNombre() + "'";
        }
        if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
sql += " AND email = '" + cliente.getEmail() + "'";
        }
        if (cliente.getTelefono() != null && !cliente.getTelefono().isEmpty()) {
sql += " AND telefono = '" + cliente.getTelefono() + "'";
        }
        if (cliente.getContrasena() != null && !cliente.getContrasena().isEmpty()) {
sql += " AND contrasena = '" + cliente.getContrasena() + "'";
        }
*/