package pe.edu.cibertec.gch.servlets.utiles;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * Utilitario que ayuda en cuestiones relacionadas a la sesion de usuario.
 */
public final class SessionUtil {

    private SessionUtil() {
    }

    public static boolean esUsuarioAutenticado(PageContext context) {
        HttpSession session = context.getSession();
        if (session == null) {
            return false;
        } else {
            String id = (String) session.getAttribute("ID");
            // evalua si la sesion tiene el ID asignado al autenticarse
            return (id != null && id.equals(session.getId()));
        }
    }
}