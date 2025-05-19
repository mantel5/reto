package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagoDao implements iDao {
    private final String SQL_FIND = "SELECT * FROM pagos WHERE 1=1 ";
    private IMotorSql motorSql;

    public PagoDao() {
        motorSql = new MotorSql();
    }

    @Override
    public int add(Object bean) {
        Pago pago = (Pago) bean;
        String sql = "INSERT INTO pagos (id_pedido, metodo_pago, estado_pago, fecha_pago) VALUES (" +
                pago.getId_pedido() + ", " +
                "'" + pago.getMetodo_pago() + "', " +
                "'" + pago.getEstado_pago() + "', " +
                "CURRENT_TIMESTAMP)";
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int delete(Object bean) {
        Pago pago = (Pago) bean;
        String sql = "DELETE FROM pagos WHERE id_pago = " + pago.getId_pago();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public int update(Object bean) {
        Pago pago = (Pago) bean;
        String sql = "UPDATE pagos SET " +
                "id_pedido = " + pago.getId_pedido() + ", " +
                "metodo_pago = '" + pago.getMetodo_pago() + "', " +
                "estado_pago = '" + pago.getEstado_pago() + "' " +
                "WHERE id_pago = " + pago.getId_pago();
        motorSql.connect();
        return motorSql.executeUpdate(sql);
    }

    @Override
    public ArrayList<Pago> FindAll(Object bean) {
        ArrayList<Pago> pagos = new ArrayList<>();
        String sql = SQL_FIND;

        try {
            motorSql.connect();

            if (bean != null) {
                Pago pago = (Pago) bean;
                if (pago.getId_pago() > 0) {
                    sql += " AND id_pago = " + pago.getId_pago();
                }
                if (pago.getId_pedido() > 0) {
                    sql += " AND id_pedido = " + pago.getId_pedido();
                }
            }

            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Pago p = new Pago();
                p.setId_pago(rs.getInt("id_pago"));
                p.setId_pedido(rs.getInt("id_pedido"));
                p.setMetodo_pago(rs.getString("metodo_pago"));
                p.setEstado_pago(rs.getString("estado_pago"));
                p.setFecha_pago(rs.getTimestamp("fecha_pago"));

                pagos.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pagos;
    }
}


