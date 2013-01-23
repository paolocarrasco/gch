package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para enviar al login
 */
@WebServlet(name = "ReenvioLogin", urlPatterns = {"/iniciarSesion"})
public class ReenvioLoginServlet extends HttpServlet {

    @Override    
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/login.jsp");
        requestDispatcher.forward(req, resp);
    }
    
}
