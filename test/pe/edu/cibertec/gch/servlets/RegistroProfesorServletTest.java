package pe.edu.cibertec.gch.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RegistroProfesorServletTest {

    private RegistroProfesorServlet registroProfesorServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Before
    public void setUp() {
        registroProfesorServlet = new RegistroProfesorServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcherMock);
    }

    @Test
    public void testDoPost() throws Exception {
        when(req.getParameter(anyString())).thenReturn("algo");
        registroProfesorServlet.doPost(req, resp);
        // si todo ha sido correcto debio enviarlo a la pagina 
        // de listado de profesores
        verify(resp).sendRedirect("listarProfesores");
    }
}
