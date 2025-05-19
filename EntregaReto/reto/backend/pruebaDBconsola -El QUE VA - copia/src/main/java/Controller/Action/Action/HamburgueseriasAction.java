package Controller.Action.Action;


import model.hamburgueserias;
import model.HamburgueseriaDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class HamburgueseriasAction {
        public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
            HamburgueseriaDao dao = new HamburgueseriaDao();

            switch (accion) {
                case "listar":
                    // Sustituye con Gson como en el ejemplo anterior si lo deseas
                    return "LISTA_JSON"; // ← aquí debes usar Gson o tu método de conversión

                case "crear":
                    hamburgueserias nueva = new hamburgueserias();
                    // Ejemplo: nueva.setNombre(request.getParameter("nombre"));
                    return dao.insertar(nueva) ? "1" : "0";

                default:
                    return "Acción no válida para Hamburgueserías";
            }
        }
    }


