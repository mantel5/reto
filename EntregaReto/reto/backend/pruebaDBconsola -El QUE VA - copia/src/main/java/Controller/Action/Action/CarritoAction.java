package Controller.Action.Action;

import javax.servlet.http.*;


import model.Carrito;
import model.CarritoDao;
import javax.servlet.http.*;
import java.util.ArrayList;

public class CarritoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar();
            default:
                return "Acción no válida";
        }
    }

    private String listar() {
        CarritoDao dao = new CarritoDao();
        ArrayList<Carrito> lista = dao.FindAll(null);
        if (lista.isEmpty()) return "[]";
        return lista.get(0).toArrayJson(lista);
    }
}



