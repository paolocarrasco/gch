package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de cerrar la sesion.
 */
@WebServlet(name = "CierreSesionServlet", urlPatterns = {"/cerrarSesion"})
public class CierreSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath());
    }

}
