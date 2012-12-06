/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paolo
 */
public class RegistroProfesorServletTest {
    
    private RegistroProfesorServlet registroProfesorServlet;
    
    @Before
    public void setUp() {
        registroProfesorServlet = new RegistroProfesorServlet();
    }

    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest req;
        HttpServletResponse res;
//        registroProfesorServlet.doPost(req, res);
    }
}
