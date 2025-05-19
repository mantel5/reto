package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrabajadorDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM trabajadores WHERE 1=1 ";
    private IMotorSql motorSql;

    public TrabajadorDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Trabajador t = (Trabajador) bean;
        String sql = "INSERT INTO trabajadores (nombre, email, telefono, puesto, fecha_contratacion) VALUES (" +
                "'" + t.getNombre() + "', " +
                "'" + t.getEmail() + "', " +
                "'" + t.getTelefono() + "', " +
                "'" + t.getPuesto() + "', " +
                "'" + t.getFecha_contratacion() + "')";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Trabajador t = (Trabajador) bean;
        String sql = "DELETE FROM trabajadores WHERE id_trabajador = " + t.getId_trabajador();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Trabajador t = (Trabajador) bean;
        String sql = "UPDATE trabajadores SET " +
                "nombre = '" + t.getNombre() + "', " +
                "email = '" + t.getEmail() + "', " +
                "telefono = '" + t.getTelefono() + "', " +
                "puesto = '" + t.getPuesto() + "', " +
                "fecha_contratacion = '" + t.getFecha_contratacion() + "' " +
                "WHERE id_trabajador = " + t.getId_trabajador();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Trabajador> FindAll(Object bean) {
        ArrayList<Trabajador> lista = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();
            if (bean != null) {
                Trabajador t = (Trabajador) bean;
                if (t.getId_trabajador() > 0) {
                    sql += " AND id_trabajador = " + t.getId_trabajador();
                }
                if (t.getNombre() != null && !t.getNombre().isEmpty()) {
                    sql += " AND nombre = '" + t.getNombre() + "'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Trabajador t = new Trabajador();
                t.setId_trabajador(rs.getInt("id_trabajador"));
                t.setNombre(rs.getString("nombre"));
                t.setEmail(rs.getString("email"));
                t.setTelefono(rs.getString("telefono"));
                t.setPuesto(rs.getString("puesto"));
                t.setFecha_contratacion(rs.getDate("fecha_contratacion"));

                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }

    public boolean insertar(Trabajador nuevoTrabajador) {
        return false;
    }

    public Object listar() {
        return null;
    }
}


