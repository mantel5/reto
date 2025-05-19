package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM pedidos WHERE 1=1 ";
    private IMotorSql motorSql;

    public PedidoDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Pedido pedido = (Pedido) bean;
        String sql = "INSERT INTO pedidos (id_cliente, estado, total, fecha_pedido) VALUES (" +
                pedido.getId_cliente() + ", " +
                "'" + pedido.getEstado() + "', " +
                pedido.getTotal() + ", " +
                "CURRENT_TIMESTAMP)";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Pedido pedido = (Pedido) bean;
        String sql = "DELETE FROM pedidos WHERE id_pedido = " + pedido.getId_pedido();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Pedido pedido = (Pedido) bean;
        String sql = "UPDATE pedidos SET " +
                "id_cliente = " + pedido.getId_cliente() + ", " +
                "estado = '" + pedido.getEstado() + "', " +
                "total = " + pedido.getTotal() + " " +
                "WHERE id_pedido = " + pedido.getId_pedido();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Pedido> FindAll(Object bean) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Pedido p = (Pedido) bean;
                if (p.getId_pedido() > 0) {
                    sql += " AND id_pedido = " + p.getId_pedido();
                }
                if (p.getId_cliente() > 0) {
                    sql += " AND id_cliente = " + p.getId_cliente();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setId_cliente(rs.getInt("id_cliente"));
                p.setFecha_pedido(rs.getTimestamp("fecha_pedido"));
                p.setEstado(rs.getString("estado"));
                p.setTotal(rs.getDouble("total"));

                pedidos.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pedidos;
    }
}


