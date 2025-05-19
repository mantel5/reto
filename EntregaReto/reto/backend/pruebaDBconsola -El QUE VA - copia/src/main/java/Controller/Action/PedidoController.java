package Controller.Action;




import Controller.Action.Action.PedidoAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

    @WebServlet(name = "PedidoController", urlPatterns = {"/PedidoController"})
    public class PedidoController extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String accion = request.getParameter("accion");
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = response.getWriter();

            switch (accion) {
                case "listar":
                case "crear":
                    out.print(new PedidoAction().execute(request, response, accion));
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
    }


