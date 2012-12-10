package pe.edu.cibertec.gch.utiles;

/**
 * Clase para contar la cantidad de usuarios que se autentican.
 */
public final class ConteoAutenticacion {
    private static final ConteoAutenticacion INSTANCIA = 
        new ConteoAutenticacion();
    private int contador = 0;

    private ConteoAutenticacion() {
    }
    public static ConteoAutenticacion Instancia() {
        return INSTANCIA;
    }
    public void sumar() {
        contador++;
    }
    public int mostrarAutenticaciones() {
        return contador;
    }
}
