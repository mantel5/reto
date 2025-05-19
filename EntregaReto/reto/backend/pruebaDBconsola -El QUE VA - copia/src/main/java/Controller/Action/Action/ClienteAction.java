package Controller.Action.Action;

import model.Clientes;
import model.ClientesDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ClienteAction implements IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, String action) {
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        switch (action){
            case "listar": {
                Clientes cliente = new Clientes(1, "Manuel");
            /*cliente.setContrasena("aaa");
            cliente.setEmail("lolo@lolo.com");
            cliente.setTelefono("978696969");
            clientes.add(cliente);
            Clientes client = new Clientes(2,"Pepe");
            cliente.setContrasena("bbb");
            cliente.setEmail("lala@lolo.com");
            cliente.setTelefono("978707070");
            clientes.add(client);*/
                ClientesDao clientesDao = new ClientesDao();
                clientes = clientesDao.FindAll(null);
                return cliente.fromArrayToJson(clientes);
            }
        }
        return "";
    }
}

/*public class ClientesAction {
    public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
        switch (accion) {
            case "listar":
                return listar(request, response);
            case "crear":
                return crear(request, response);
            default:
                return "Acción no válida";
        }
    }

    private String listar(HttpServletRequest request, HttpServletResponse response) {
        ClientesDao dao = new ClientesDao();
        ArrayList<Clientes> clientes = dao.getAll();

        // Usamos el método personalizado de la clase Clientes para generar JSON
        if (clientes.isEmpty()) return "[]";
        return clientes.get(0).fromArrayToJson(clientes);
    }

    private String crear(HttpServletRequest request, HttpServletResponse response) {
        // Aquí podrías implementar lógica para insertar un nuevo cliente si lo necesitas
        return "Operación 'crear' no implementada todavía";
    }
}
*/