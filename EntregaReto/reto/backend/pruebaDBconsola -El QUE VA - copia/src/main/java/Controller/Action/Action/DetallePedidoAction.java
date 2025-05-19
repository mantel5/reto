package Controller.Action.Action;


import model.Detalle_Pedido;
import model.Detalle_PedidoDao;

import javax.servlet.http.*;
import java.util.ArrayList;

public class DetallePedidoAction {
    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar();
            default:
                return "Acción no válida";
        }
    }

    private String listar() {
        Detalle_PedidoDao dao = new Detalle_PedidoDao();
        ArrayList<Detalle_Pedido> lista = dao.FindAll(null);
        if (lista.isEmpty()) return "[]";
        return lista.get(0).toArrayJson(lista);
    }
}

