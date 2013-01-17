package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.cibertec.gch.modelo.Usuario;
import pe.edu.cibertec.gch.utiles.ConteoAutenticacion;

/**
 * Autentica al usuario en la aplicacion.
 */
@WebServlet(name = "AutenticacionServlet", urlPatterns = {"/autenticar"})
public class AutenticacionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("usuario"),
                clave = req.getParameter("clave");
        boolean nombreNoIngresado = nombre == null || nombre.isEmpty();
        boolean claveNoIngresada = clave == null || clave.isEmpty();
        // validando si usuario ingreso campos obligatorios en el form de login
        if (nombreNoIngresado) {
            req.setAttribute("mensaje", "No se ingreso el nombre de usuario");
        } else if (claveNoIngresada) {
            req.setAttribute("mensaje", "No se ingreso la clave de usuario");
        }
        boolean tieneCamposObligatorios = !nombreNoIngresado && !claveNoIngresada;
        String pagina = "view/login.jsp";
        // si campos obligatorios estan con data
        if (tieneCamposObligatorios) {
            // evaluamos que data coincida con data de usuario
            if (nombre.equalsIgnoreCase("cibertec") && clave.equals("123")) {
                HttpSession session = req.getSession(true);
                session.setAttribute("ID", session.getId());
                session.setAttribute("usuario", new Usuario(nombre, clave));
                ConteoAutenticacion.Instancia().sumar();
                resp.sendRedirect("landing");
                return;
            } else {
                req.setAttribute("mensaje", "El usuario y la clave no coinciden");
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
        requestDispatcher.forward(req, resp);
    }
}
