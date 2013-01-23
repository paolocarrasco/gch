package pe.edu.cibertec.gch.aspectos;

import java.util.logging.Logger;

/**
 * Aspecto de registro en bitacora.
 */
public class AspectoLogging {

    private static final Logger LOG =
          Logger.getLogger(AspectoLogging.class.getName());

    public void registrarOperacion() {
        LOG.info("* * * La operacion se ha registrado * * *");
    }
}

