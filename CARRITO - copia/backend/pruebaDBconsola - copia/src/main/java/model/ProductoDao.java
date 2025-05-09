package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    public class ProductoDao implements iDao {
        private final String SQL_FIND = "SELECT * FROM productos WHERE 1=1 ";
        private IMotorSql motorSql;

        public ProductoDao() {
            motorSql = new MotorSql();
        }

        @Override
        public int add(Object bean) {
            // Implementar el código para agregar un producto en la base de datos
            Producto producto = (Producto) bean;
            String sql = "INSERT INTO productos (nombre, descripcion, precio, categoria) " +
                    "VALUES ('" + producto.getNombre() + "', '" + producto.getDescripcion() + "', " +
                    producto.getPrecio() + ", '" + producto.getCategoria() + "')";
            motorSql.connect();
            return motorSql.executeUpdate(sql);
        }

        @Override
        public int delete(Object e) {
            Producto producto = (Producto) e;
            String sql = "DELETE FROM productos WHERE id_producto = " + producto.getId_producto();
            motorSql.connect();
            return motorSql.executeUpdate(sql);
        }

        @Override
        public int update(Object bean) {
            Producto producto = (Producto) bean;
            String sql = "UPDATE productos SET nombre = '" + producto.getNombre() + "', " +
                    "descripcion = '" + producto.getDescripcion() + "', " +
                    "precio = " + producto.getPrecio() + ", " +
                    "categoria = '" + producto.getCategoria() + "' " +
                    "WHERE id_producto = " + producto.getId_producto();
            motorSql.connect();
            return motorSql.executeUpdate(sql);
        }

        @Override
        public ArrayList<Producto> FindAll(Object bean) {
            ArrayList<Producto> productos = new ArrayList<>();
            String sql = SQL_FIND;

            try {
                motorSql.connect();

                if (bean != null) {
                    Producto producto = (Producto) bean;
                    if (producto.getId_producto() >= 0) {
                        sql += " AND id_producto = '" + producto.getId_producto() + "'";
                    }
                    if (!producto.getNombre().isEmpty()) {
                        sql += " AND nombre = '" + producto.getNombre() + "'";
                    }
                    if (!producto.getDescripcion().isEmpty()) {
                        sql += " AND descripcion = '" + producto.getDescripcion() + "'";
                    }
                    if (producto.getPrecio() >= 0) {
                        sql += " AND precio = " + producto.getPrecio();
                    }
                    if (!producto.getCategoria().isEmpty()) {
                        sql += " AND categoria = '" + producto.getCategoria() + "'";
                    }
                }

                ResultSet rs = motorSql.executeQuery(sql);

                while (rs.next()) {
                    Producto productoBd = new Producto();
                    productoBd.setId_producto(rs.getInt("id_producto"));
                    productoBd.setNombre(rs.getString("nombre"));
                    productoBd.setDescripcion(rs.getString("descripcion"));
                    productoBd.setPrecio(rs.getDouble("precio"));
                    productoBd.setCategoria(rs.getString("categoria"));

                    productos.add(productoBd);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            return productos;
        }
    }


