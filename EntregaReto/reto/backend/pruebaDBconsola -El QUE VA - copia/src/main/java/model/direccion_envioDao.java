package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class direccion_envioDao implements iDao {
        private final String SQL_FIND = "SELECT * FROM direccion_envio WHERE 1=1 ";
        private IMotorSql motorSql;

        public direccion_envioDao() {
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
            ArrayList<direccion_envio> direccionesEnvio = new ArrayList<>();
            String sql = SQL_FIND;

            try {
                motorSql.connect();

                if (bean != null) {
                    direccion_envio direccionEnvio = (direccion_envio) bean;
                    if (direccionEnvio.getId_direccion() >= 0) {
                        sql += " AND id_direccion = '" + direccionEnvio.getId_direccion() + "'";
                    }
                    if (!direccionEnvio.getCalle().isEmpty()) {
                        sql += " AND calle = '" + direccionEnvio.getCalle() + "'";
                    }
                    if (!direccionEnvio.getCiudad().isEmpty()) {
                        sql += " AND ciudad = '" + direccionEnvio.getCiudad() + "'";
                    }
                    if (!direccionEnvio.getCodigo_postal().isEmpty()) {
                        sql += " AND codigo_postal = '" + direccionEnvio.getCodigo_postal() + "'";
                    }
                    if (!direccionEnvio.getPais().isEmpty()) {
                        sql += " AND pais = '" + direccionEnvio.getPais() + "'";
                    }

                    direccionEnvio.toSqlWhereString(); // Método aún no implementado
                }

                ResultSet rs = motorSql.executeQuery(sql);

                while (rs.next()) {
                    direccion_envio direccionEnvioBd = new direccion_envio();
                    direccionEnvioBd.setId_direccion(rs.getInt("id_direccion"));
                    direccionEnvioBd.setCalle(rs.getString("calle"));
                    direccionEnvioBd.setCiudad(rs.getString("ciudad"));
                    direccionEnvioBd.setCodigo_postal(rs.getString("codigo_postal"));
                    direccionEnvioBd.setPais(rs.getString("pais"));
                    direccionEnvioBd.setFecha_creacion(rs.getTimestamp("fecha_creacion"));

                    direccionesEnvio.add(direccionEnvioBd);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            return direccionesEnvio;
        }

    public boolean insertar(direccion_envio nuevaDireccion) {
        return false;
    }
}


