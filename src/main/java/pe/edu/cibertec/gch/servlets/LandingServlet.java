package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.utiles.ConteoAutenticacion;

/**
 * Envia a la pagina de landing page.
 */
@WebServlet(name = "LandingServlet", urlPatterns = {"/landing"})
public class LandingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("numeroAutenticados", ConteoAutenticacion.Instancia().mostrarAutenticaciones());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
