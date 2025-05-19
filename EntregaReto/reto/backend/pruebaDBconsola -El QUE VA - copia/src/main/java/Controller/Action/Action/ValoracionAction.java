package Controller.Action.Action;

import model.Valoracion;
import model.ValoracionDao;

import javax.servlet.http.*;
import java.util.ArrayList;

    public class ValoracionAction {
        public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
            switch (accion) {
                case "listar":
                    return listar();
                default:
                    return "Acción no válida";
            }
        }

        private String listar() {
            ValoracionDao dao = new ValoracionDao();
            ArrayList<Valoracion> lista = dao.FindAll(null);
            if (lista.isEmpty()) return "[]";
            return lista.get(0).toArrayJson(lista);
        }
    }


