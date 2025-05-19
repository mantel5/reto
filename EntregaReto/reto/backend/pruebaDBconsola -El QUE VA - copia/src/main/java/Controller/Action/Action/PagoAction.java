package Controller.Action.Action;


import model.Pago;
import model.PagoDao;

import javax.servlet.http.*;
import java.util.ArrayList;

public class PagoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar();
            default:
                return "Acción no válida";
        }
    }

    private String listar() {
        PagoDao dao = new PagoDao();
        ArrayList<Pago> lista = dao.FindAll(null);
        if (lista.isEmpty()) return "[]";
        return lista.get(0).toArrayJson(lista);
    }
}



