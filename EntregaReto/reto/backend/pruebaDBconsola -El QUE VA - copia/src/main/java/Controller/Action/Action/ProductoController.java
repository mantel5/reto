package Controller.Action.Action;

import Controller.Action.Action.ProductoAction;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        switch (accion) {
            case "listar":
            case "crear":
            case "hamburguesas":
            case "entrantes":
            case "bebidas":
                out.print(new ProductoAction().execute(request, response, accion));
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Aquí también pasamos al GET
    }
}
