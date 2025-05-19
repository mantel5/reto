package Controller.Action;

import Controller.Action.Action.ProductoAction;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/api/*")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener acción de la URL (por ejemplo: /api/hamburguesas -> "hamburguesas")
        String pathInfo = request.getPathInfo(); // puede ser null
        String accion = (pathInfo != null && pathInfo.length() > 1) ? pathInfo.substring(1) : "listar";

        ProductoAction action = new ProductoAction();
        String resultado = action.execute(request, response, accion);

        // Evita problemas de CORS si tu frontend está en otro origen
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(resultado);
    }
}
