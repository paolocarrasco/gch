package pe.edu.cibertec.gch.registro;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import pe.edu.cibertec.gch.gestores.GestorProfesor;
import pe.edu.cibertec.gch.gestores.GestorProfesorImpl;

/**
 * Contiene las implementaciones de la clases solicitadas
 */
public final class ServiceLocator {

    private final static ServiceLocator INSTANCIA = new ServiceLocator();
    private Map<Class<?>, Object> clases = Collections.synchronizedMap(new HashMap<Class<?>, Object>());
    private boolean pendienteInicializar = true;
    
    private ServiceLocator() {
    }
    
    private void init() {
        // deben estar desde el mas independiente hasta 
        // el mas dependiente (en ese orden)
        clases.put(GestorProfesor.class, new GestorProfesorImpl());
    }
    
    public static ServiceLocator instancia() {
        return INSTANCIA;
    }
    
    public <T> T obtener(Class<T> clase) {
        synchronized (this) {
            if(pendienteInicializar) {
                pendienteInicializar = false;
                init();
            }
        }
        return (T) clases.get(clase);
    }
}
