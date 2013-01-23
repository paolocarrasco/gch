package pe.edu.cibertec.gch.servlets.utiles;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Utilitario que ayuda en cuestiones relacionadas a la sesion de usuario.
 */
public final class SessionUtil {

    private SessionUtil() {
    }

    public static boolean esUsuarioAutenticado() {
        return !SecurityContextHolder.getContext().getAuthentication().getName().startsWith("anonymous");
    }
}