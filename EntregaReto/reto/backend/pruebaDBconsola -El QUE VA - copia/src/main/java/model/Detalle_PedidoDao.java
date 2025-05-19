package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Detalle_PedidoDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM detalle_pedido WHERE 1=1 ";
    private IMotorSql motorSql;

    public Detalle_PedidoDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Detalle_Pedido dp = (Detalle_Pedido) bean;
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES (" +
                dp.getId_pedido() + ", " +
                dp.getId_producto() + ", " +
                dp.getCantidad() + ", " +
                dp.getPrecio_unitario() + ")";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Detalle_Pedido dp = (Detalle_Pedido) bean;
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle = " + dp.getId_detalle();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Detalle_Pedido dp = (Detalle_Pedido) bean;
        String sql = "UPDATE detalle_pedido SET " +
                "id_pedido = " + dp.getId_pedido() + ", " +
                "id_producto = " + dp.getId_producto() + ", " +
                "cantidad = " + dp.getCantidad() + ", " +
                "precio_unitario = " + dp.getPrecio_unitario() +
                " WHERE id_detalle = " + dp.getId_detalle();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Detalle_Pedido> FindAll(Object bean) {
        ArrayList<Detalle_Pedido> lista = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Detalle_Pedido dp = (Detalle_Pedido) bean;
                if (dp.getId_detalle() > 0) {
                    sql += " AND id_detalle = " + dp.getId_detalle();
                }
                if (dp.getId_pedido() > 0) {
                    sql += " AND id_pedido = " + dp.getId_pedido();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Detalle_Pedido dp = new Detalle_Pedido();
                dp.setId_detalle(rs.getInt("id_detalle"));
                dp.setId_pedido(rs.getInt("id_pedido"));
                dp.setId_producto(rs.getInt("id_producto"));
                dp.setCantidad(rs.getInt("cantidad"));
                dp.setPrecio_unitario(rs.getDouble("precio_unitario"));

                lista.add(dp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
}


