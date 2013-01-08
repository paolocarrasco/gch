package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroProfesorServlet", urlPatterns = {"/registrarProfesor"})
public class RegistroProfesorServlet extends HttpServlet {

    private GestorProfesor gestorProfesor;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        gestorProfesor = context.getBean(GestorProfesor.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String codigo = req.getParameter("codigo"),
                nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno"),
                direccion = req.getParameter("direccion"),
                referencia = req.getParameter("referencia"),
                fechaNacimiento = req.getParameter("fechaNacimiento"),
                sexo = req.getParameter("sexo"),
                estadoCivil = req.getParameter("estadoCivil");

        // se validan los parametros recibidos
        if (sonDatosValidos(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, referencia, fechaNacimiento, sexo, estadoCivil)) {
            // si es conforme, se registra en la fuente de datos
            Date nacimiento = null;
            try {
                nacimiento = SimpleDateFormat.getDateInstance().parse(fechaNacimiento);
            } catch (ParseException ex) {
                Logger.getLogger(RegistroProfesorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            gestorProfesor.ingresar(new Profesor(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, referencia, nacimiento, sexo, estadoCivil));
            resp.sendRedirect("listarProfesores");
        } else {
            // si hay algunos campos invalidos, se retorna
            req.setAttribute("mensaje", "Hay errores en los datos enviados");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/profesor/registro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private boolean sonDatosValidos(String codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String referencia, String fechaNacimiento, String sexo, String estadoCivil) {
        boolean esValido = true;
        // TODO solo se valida que no sean vacios, sin embargo la logica de 
        // validacion deberia incluir otros aspectos
        if (codigo == null || codigo.isEmpty()) {
            esValido = false;
        } else if (nombres == null || nombres.isEmpty()) {
            esValido = false;
        } else if (apellidoPaterno == null || apellidoPaterno.isEmpty()) {
            esValido = false;
        } else if (direccion == null || direccion.isEmpty()) {
            esValido = false;
        } else if (fechaNacimiento != null && !fechaNacimiento.matches("\\d{1,4}[/-]\\d{1,2}[/-]\\d{1,4}")) {
            esValido = false;
        }
        return esValido;
    }
}
