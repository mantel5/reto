package Controller.Action.Action;


import model.direccion_envio;
import model.direccion_envioDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    public class Direccion_envioAction {
        public String execute(HttpServletRequest request, HttpServletResponse response, String accion) {
            direccion_envioDao dao = new direccion_envioDao();

            switch (accion) {
                case "listar":
                    // Implementación pendiente
                    return "[]";

                case "crear":
                    direccion_envio nuevaDireccion = new direccion_envio();
                    // Ejemplo de asignación comentado
                    // nuevaDireccion.setCalle(request.getParameter("calle"));
                    // nuevaDireccion.setCiudad(request.getParameter("ciudad"));
                    return dao.insertar(nuevaDireccion) ? "1" : "0";

                default:
                    return "Acción no válida para Direccion_envio";
            }
        }
    }


