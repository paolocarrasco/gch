package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pe.edu.cibertec.gch.gestores.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Usuario;

/**
 * Servlet para listar profesores
 */
@WebServlet(name = "ListadoProfesorServlet", urlPatterns = {"/listarProfesores"})
public class ListadoProfesorServlet extends HttpServlet {

    private GestorProfesor gestorProfesor;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        gestorProfesor = context.getBean(GestorProfesor.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno");

        Usuario usuario = (Usuario) req.getSession(false).getAttribute("usuario");
        // trae los profesores en la fuente de datos
        List<Profesor> profesores = gestorProfesor.listarSegun(usuario, nombres, apellidoPaterno, apellidoMaterno);
        // almacena resultado en el request
        req.setAttribute("profesores", profesores);
        // pinta los datos en el listado
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/profesor/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
