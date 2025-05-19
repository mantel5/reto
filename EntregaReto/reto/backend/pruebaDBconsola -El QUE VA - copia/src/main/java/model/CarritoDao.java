package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

    public class CarritoDao implements iDao {
        private final String SQL_FIND = "SELECT * FROM carritos WHERE 1=1 ";
        private IMotorSql motorSql;

        public CarritoDao() {
            motorSql = new MotorSql();
        }

        @Override
        public int add(Object bean) {
            Carrito carrito = (Carrito) bean;
            String sql = "INSERT INTO carritos (id_cliente, fecha_creacion) " +
                    "VALUES (" + carrito.getId_cliente() + ", NOW())";
            motorSql.connect();
            int result = motorSql.executeUpdate(sql);
            if (result > 0) {
                // Insertar productos en el carrito, dependiendo de la estructura de la base de datos.
                for (Producto producto : carrito.getProductos()) {
                    String sqlProducto = "INSERT INTO carrito_productos (id_carrito, id_producto) " +
                            "VALUES (" + carrito.getId_carrito() + ", " + producto.getId_producto() + ")";
                    motorSql.executeUpdate(sqlProducto);
                }
            }
            return result;
        }

        @Override
        public int delete(Object e) {
            Carrito carrito = (Carrito) e;
            String sql = "DELETE FROM carritos WHERE id_carrito = " + carrito.getId_carrito();
            motorSql.connect();
            // Eliminar los productos del carrito antes de eliminar el carrito
            String sqlDeleteProductos = "DELETE FROM carrito_productos WHERE id_carrito = " + carrito.getId_carrito();
            motorSql.executeUpdate(sqlDeleteProductos);

            return motorSql.executeUpdate(sql);
        }

        @Override
        public int update(Object bean) {
            // Aquí podrías implementar la actualización de carritos si fuera necesario
            return 0;
        }

        @Override
        public ArrayList<Carrito> FindAll(Object bean) {
            ArrayList<Carrito> carritos = new ArrayList<>();
            String sql = SQL_FIND;

            try {
                motorSql.connect();

                if (bean != null) {
                    Carrito carrito = (Carrito) bean;
                    if (carrito.getId_carrito() >= 0) {
                        sql += " AND id_carrito = '" + carrito.getId_carrito() + "'";
                    }
                    if (carrito.getId_cliente() >= 0) {
                        sql += " AND id_cliente = '" + carrito.getId_cliente() + "'";
                    }
                }

                ResultSet rs = motorSql.executeQuery(sql);

                while (rs.next()) {
                    Carrito carritoBd = new Carrito();
                    carritoBd.setId_carrito(rs.getInt("id_carrito"));
                    carritoBd.setId_cliente(rs.getInt("id_cliente"));
                    carritoBd.setFecha_creacion(rs.getDate("fecha_creacion"));

                    // Obtener los productos del carrito
                    String sqlProductos = "SELECT * FROM carrito_productos WHERE id_carrito = " + carritoBd.getId_carrito();
                    ResultSet rsProductos = motorSql.executeQuery(sqlProductos);
                    while (rsProductos.next()) {
                        ProductoDao productoDao = new ProductoDao();
                        Producto producto = new Producto();
                        producto.setId_producto(rsProductos.getInt("id_producto"));
                        ArrayList<Producto> productos = productoDao.FindAll(producto);
                        carritoBd.addProducto(productos.get(0)); // Asumiendo que solo hay un producto por cada entrada
                    }

                    carritos.add(carritoBd);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            return carritos;
        }
    }

