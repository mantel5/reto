package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfertaDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM ofertas WHERE 1=1 ";
    private IMotorSql motorSql;

    public OfertaDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Oferta oferta = (Oferta) bean;
        String sql = "INSERT INTO ofertas (titulo, descripcion, descuento, fecha_inicio, fecha_fin) VALUES (" +
                "'" + oferta.getTitulo() + "', " +
                "'" + oferta.getDescripcion() + "', " +
                oferta.getDescuento() + ", " +
                "'" + oferta.getFecha_inicio() + "', " +
                "'" + oferta.getFecha_fin() + "')";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Oferta oferta = (Oferta) bean;
        String sql = "DELETE FROM ofertas WHERE id_oferta = " + oferta.getId_oferta();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Oferta oferta = (Oferta) bean;
        String sql = "UPDATE ofertas SET " +
                "titulo = '" + oferta.getTitulo() + "', " +
                "descripcion = '" + oferta.getDescripcion() + "', " +
                "descuento = " + oferta.getDescuento() + ", " +
                "fecha_inicio = '" + oferta.getFecha_inicio() + "', " +
                "fecha_fin = '" + oferta.getFecha_fin() + "' " +
                "WHERE id_oferta = " + oferta.getId_oferta();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Oferta> FindAll(Object bean) {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Oferta o = (Oferta) bean;
                if (o.getId_oferta() > 0) {
                    sql += " AND id_oferta = " + o.getId_oferta();
                }
                if (o.getTitulo() != null && !o.getTitulo().isEmpty()) {
                    sql += " AND titulo LIKE '%" + o.getTitulo() + "%'";
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Oferta o = new Oferta();
                o.setId_oferta(rs.getInt("id_oferta"));
                o.setTitulo(rs.getString("titulo"));
                o.setDescripcion(rs.getString("descripcion"));
                o.setDescuento(rs.getDouble("descuento"));
                o.setFecha_inicio(rs.getDate("fecha_inicio"));
                o.setFecha_fin(rs.getDate("fecha_fin"));

                ofertas.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ofertas;
    }
}


