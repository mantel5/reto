package Controller.Action.Action;

import javax.servlet.http.*;

import model.Pedido;
import model.PedidoDao;

import javax.servlet.http.*;
import java.util.ArrayList;

public class PedidoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar();
            default:
                return "Acción no válida";
        }
    }

    private String listar() {
        PedidoDao dao = new PedidoDao();
        ArrayList<Pedido> lista = dao.FindAll(null);
        if (lista.isEmpty()) return "[]";
        return lista.get(0).toArrayJson(lista);
    }
}




