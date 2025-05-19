package Controller.Action.Action;

import model.DetalleCarrito;
import model.DetalleCarritoDao;

import javax.servlet.http.*;
import java.util.ArrayList;

    public class DetalleCarritoAction {
        public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
            switch (accion) {
                case "listar":
                    return listar();
                default:
                    return "Acción no válida";
            }
        }

        private String listar() {
            DetalleCarritoDao dao = new DetalleCarritoDao();
            ArrayList<DetalleCarrito> lista = dao.FindAll(null);
            if (lista.isEmpty()) return "[]";
            return lista.get(0).toArrayJson(lista);
        }
    }

