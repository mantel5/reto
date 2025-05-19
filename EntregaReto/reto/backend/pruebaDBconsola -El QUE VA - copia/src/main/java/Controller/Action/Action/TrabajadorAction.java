package Controller.Action.Action;

import model.Trabajador;
import model.TrabajadorDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class TrabajadorAction {
        public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
            TrabajadorDao dao = new TrabajadorDao();

            switch (accion) {
                case "listar":
                    return new Trabajador().fromArrayToJson(dao.listar());

                case "crear":
                    Trabajador nuevoTrabajador = new Trabajador();
                    // Ejemplo de asignación de parámetros:
                    // nuevoTrabajador.setNombre(request.getParameter("nombre"));
                    // nuevoTrabajador.setEmail(request.getParameter("email"));
                    // nuevoTrabajador.setContrasena(request.getParameter("contrasena"));
                    return dao.insertar(nuevoTrabajador) ? "1" : "0";

                default:
                    return "Acción no válida para Trabajador";
            }
        }
    }


