package Controller.Action;

import Controller.Action.Action.ClienteAction;
import Controller.Action.ClienteController;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        switch (accion) {
            case "listar":
                out.print(new ClienteAction().execute(request,response,accion));

                break;
            case "crear":
                out.print(new ClienteAction().execute(request,response,accion));
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Opcionalmente puedes usar doPost si se requiere
    }
}
