package servlets;
        import model.Producto;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import java.io.IOException;

public class ClienteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Crear cliente simulado (en la práctica lo obtienes desde una base de datos)
        Producto producto = new Producto(1, "Hamburguesa Clásica", "Carne de res, queso, lechuga, tomate", 5.99,"Hamburguesa");

        // Convertir manualmente a JSON (si no usas librerías como Gson o Jackson)
        String json = "{"
                + "\"id\":" + producto.getId_producto() + ","
                + "\"nombre\":\"" + producto.getNombre() + "\","
                + "\"email\":\"" + producto.getPrecio() + "\""
                + "}";

        // Configurar la respuesta como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}


