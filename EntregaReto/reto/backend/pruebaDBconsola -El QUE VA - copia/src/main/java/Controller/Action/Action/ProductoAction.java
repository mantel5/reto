package Controller.Action.Action;

import model.ProductoDao;
import model.Producto;

import javax.servlet.http.*;
import com.google.gson.Gson;
import java.util.List;

public class ProductoAction {
    private final ProductoDao productoDao = new ProductoDao();
    private final Gson gson = new Gson();

    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar();
            case "crear":
                return crear(request);
            case "hamburguesas":
                return filtrarPorCategoria("hamburguesa");
            case "entrantes":
                return filtrarPorCategoria("entrante");
            case "bebidas":
                return filtrarPorCategoria("bebida");
            default:
                return "{\"error\":\"Acción no válida\"}";
        }
    }

    private String listar() {
        List<Producto> productos = productoDao.listarTodos();
        return gson.toJson(productos);
    }

    private String crear(HttpServletRequest request) {


        return "{\"mensaje\":\"Funcionalidad crear no implementada\"}";
    }

    private String filtrarPorCategoria(String categoria) {
        List<Producto> productos = productoDao.listarPorCategoria(categoria);
        return gson.toJson(productos);
    }
}
