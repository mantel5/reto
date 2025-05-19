package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleCarritoDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM detalle_carrito WHERE 1=1 ";
    private IMotorSql motorSql;

    public DetalleCarritoDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        DetalleCarrito d = (DetalleCarrito) bean;
        String sql = "INSERT INTO detalle_carrito (id_carrito, id_producto, cantidad, precio_unitario) VALUES (" +
                d.getId_carrito() + ", " +
                d.getId_producto() + ", " +
                d.getCantidad() + ", " +
                d.getPrecio_unitario() + ")";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        DetalleCarrito d = (DetalleCarrito) bean;
        String sql = "DELETE FROM detalle_carrito WHERE id_detalle = " + d.getId_detalle();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        DetalleCarrito d = (DetalleCarrito) bean;
        String sql = "UPDATE detalle_carrito SET " +
                "id_carrito = " + d.getId_carrito() + ", " +
                "id_producto = " + d.getId_producto() + ", " +
                "cantidad = " + d.getCantidad() + ", " +
                "precio_unitario = " + d.getPrecio_unitario() +
                " WHERE id_detalle = " + d.getId_detalle();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<DetalleCarrito> FindAll(Object bean) {
        ArrayList<DetalleCarrito> lista = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();
            if (bean != null) {
                DetalleCarrito d = (DetalleCarrito) bean;
                if (d.getId_detalle() > 0) {
                    sql += " AND id_detalle = " + d.getId_detalle();
                }
                if (d.getId_carrito() > 0) {
                    sql += " AND id_carrito = " + d.getId_carrito();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                DetalleCarrito d = new DetalleCarrito();
                d.setId_detalle(rs.getInt("id_detalle"));
                d.setId_carrito(rs.getInt("id_carrito"));
                d.setId_producto(rs.getInt("id_producto"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecio_unitario(rs.getDouble("precio_unitario"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
}


