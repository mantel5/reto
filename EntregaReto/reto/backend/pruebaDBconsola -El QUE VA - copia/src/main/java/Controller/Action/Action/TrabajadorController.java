package Controller.Action.Action;
import Controller.Action.Action.TrabajadorAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

    @WebServlet(name = "TrabajadorController", urlPatterns = {"/TrabajadorController"})
    public class TrabajadorController extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String accion = request.getParameter("accion");
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = response.getWriter();

            switch (accion) {
                case "listar":
                case "crear":
                    out.print(new TrabajadorAction().execute(request, response, accion));
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida para Trabajador");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
    }


