package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.gestores.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Servlet para listar profesores
 */
@WebServlet(name = "ListadoProfesorServlet", urlPatterns = {"/listarProfesores"})
public class ListadoProfesorServlet extends HttpServlet {

    @EJB
    private GestorProfesor gestorProfesor;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno");

        // trae los profesores en la fuente de datos
        List<Profesor> profesores = gestorProfesor.listarSegun(nombres, apellidoPaterno, apellidoMaterno);
        // almacena resultado en el request
        req.setAttribute("profesores", profesores);
        // pinta los datos en el listado
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/profesor/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
