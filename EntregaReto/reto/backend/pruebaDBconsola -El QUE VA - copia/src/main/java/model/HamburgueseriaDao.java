package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

     public class HamburgueseriaDao implements iDao {
        private final String SQL_FIND = "SELECT * FROM hamburgueserias WHERE 1=1 ";
        private IMotorSql motorSql;

        public HamburgueseriaDao() {
            motorSql = new MotorSql();
        }

        @Override
        public int add(Object bean) {
            // Implementar el código para agregar una hamburguesería en la base de datos
            return 0;
        }

        @Override
        public int delete(Object e) {
            // Implementar el código para eliminar una hamburguesería en la base de datos
            return 0;
        }

        @Override
        public int update(Object bean) {
            // Implementar el código para actualizar una hamburguesería en la base de datos
            return 0;
        }

        @Override
        public ArrayList<hamburgueserias> FindAll(Object bean) {
            ArrayList<hamburgueserias> hamburgueserias = new ArrayList<>();
            String sql = SQL_FIND;

            try {
                motorSql.connect();

                if (bean != null) {
                    hamburgueserias hamburgueseria = (hamburgueserias) bean;
                    if (hamburgueseria.getId_hamburgueseria() >= 0) {
                        sql += " AND id_hamburgueseria = '" + hamburgueseria.getId_hamburgueseria() + "'";
                    }
                    if (!hamburgueseria.getNombre().isEmpty()) {
                        sql += " AND nombre = '" + hamburgueseria.getNombre() + "'";
                    }
                    if (!hamburgueseria.getDireccion().isEmpty()) {
                        sql += " AND direccion = '" + hamburgueseria.getDireccion() + "'";
                    }
                    if (!hamburgueseria.getTelefono().isEmpty()) {
                        sql += " AND telefono = '" + hamburgueseria.getTelefono() + "'";
                    }
                    if (!hamburgueseria.getHorario().isEmpty()) {
                        sql += " AND horario = '" + hamburgueseria.getHorario() + "'";
                    }
                    if (!hamburgueseria.getEmail().isEmpty()) {
                        sql += " AND email = '" + hamburgueseria.getEmail() + "'";
                    }
                    if (!hamburgueseria.getPais().isEmpty()) {
                        sql += " AND pais = '" + hamburgueseria.getPais() + "'";
                    }

                    hamburgueseria.toSqlWhereString(); // Método aún no implementado
                }

                ResultSet rs = motorSql.executeQuery(sql);

                while (rs.next()) {
                    hamburgueserias hamburgueseriaBd = new hamburgueserias();
                    hamburgueseriaBd.setId_hamburgueseria(rs.getInt("id_hamburgueseria"));
                    hamburgueseriaBd.setNombre(rs.getString("nombre"));
                    hamburgueseriaBd.setDireccion(rs.getString("direccion"));
                    hamburgueseriaBd.setTelefono(rs.getString("telefono"));
                    hamburgueseriaBd.setHorario(rs.getString("horario"));
                    hamburgueseriaBd.setEmail(rs.getString("email"));
                    hamburgueseriaBd.setPais(rs.getString("pais"));

                    hamburgueserias.add(hamburgueseriaBd);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            return hamburgueserias;
        }

         public boolean insertar(hamburgueserias nueva) {
             return false;
         }
     }


