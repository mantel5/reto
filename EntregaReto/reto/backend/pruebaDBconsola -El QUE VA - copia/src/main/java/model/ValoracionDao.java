package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValoracionDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM valoraciones WHERE 1=1 ";
    private IMotorSql motorSql;

    public ValoracionDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Valoracion valoracion = (Valoracion) bean;
        String sql = "INSERT INTO valoraciones (id_cliente, id_producto, puntuacion, comentario) VALUES (" +
                valoracion.getId_cliente() + ", " +
                valoracion.getId_producto() + ", " +
                valoracion.getPuntuacion() + ", '" +
                valoracion.getComentario() + "')";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Valoracion valoracion = (Valoracion) bean;
        String sql = "DELETE FROM valoraciones WHERE id_valoracion = " + valoracion.getId_valoracion();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Valoracion valoracion = (Valoracion) bean;
        String sql = "UPDATE valoraciones SET " +
                "id_cliente = " + valoracion.getId_cliente() + ", " +
                "id_producto = " + valoracion.getId_producto() + ", " +
                "puntuacion = " + valoracion.getPuntuacion() + ", " +
                "comentario = '" + valoracion.getComentario() + "' " +
                "WHERE id_valoracion = " + valoracion.getId_valoracion();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Valoracion> FindAll(Object bean) {
        ArrayList<Valoracion> valoraciones = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Valoracion v = (Valoracion) bean;
                if (v.getId_valoracion() > 0) {
                    sql += " AND id_valoracion = " + v.getId_valoracion();
                }
                if (v.getId_cliente() > 0) {
                    sql += " AND id_cliente = " + v.getId_cliente();
                }
                if (v.getId_producto() > 0) {
                    sql += " AND id_producto = " + v.getId_producto();
                }
                if (v.getPuntuacion() > 0) {
                    sql += " AND puntuacion = " + v.getPuntuacion();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Valoracion v = new Valoracion();
                v.setId_valoracion(rs.getInt("id_valoracion"));
                v.setId_cliente(rs.getInt("id_cliente"));
                v.setId_producto(rs.getInt("id_producto"));
                v.setPuntuacion(rs.getInt("puntuacion"));
                v.setComentario(rs.getString("comentario"));
                v.setFecha_valoracion(rs.getTimestamp("fecha_valoracion"));

                valoraciones.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return valoraciones;
    }
}

