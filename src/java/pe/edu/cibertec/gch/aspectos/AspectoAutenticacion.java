package pe.edu.cibertec.gch.aspectos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import pe.edu.cibertec.gch.modelo.Usuario;

/**
 * Aspecto que revisa la autenticacion del usuario.
 */
public class AspectoAutenticacion {
    
    private static final Logger LOG = Logger.getLogger(AspectoAutenticacion.class.getName());
    
    public Object revisar(ProceedingJoinPoint call) throws Throwable {
        LOG.info("* * Vericando la autorizacion del usuario... * *");
        // deberiamos pasar el usuario como primer parametro
        Object parametroUsuario = (call.getArgs().length > 0)
                ? call.getArgs()[0] : "No hay usuario";
        LOG.log(Level.INFO, "El usuario que se va a autorizar es {0}", parametroUsuario);
        
        if (parametroUsuario instanceof Usuario) {
            Usuario usuario = (Usuario) parametroUsuario;
            // aqui se puede verificar mas sobre la autorizacion
            // por el momento solo verificaremos que el primer
            // parametro sea un usuario
            return call.proceed();
        }
        return null;
    }

}
