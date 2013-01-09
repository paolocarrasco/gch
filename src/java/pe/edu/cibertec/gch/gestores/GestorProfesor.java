package pe.edu.cibertec.gch.gestores;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Usuario;

/**
 * Contrato con las acciones que pueden realizarse respecto a un profesor.
 */
public interface GestorProfesor {

    /**
     * Lista todos los profesores registrados.
     */
    List<Profesor> listar(Usuario usuario);

    /**
     *
     * Lista los profesores segun nombres y apellidos.
     */
    List<Profesor> listarSegun(Usuario usuario, String nombres, String apellidoPaterno, String apellidoMaterno);

    /**
     * Busca el profesor que corresponda con el ID.
     */
    Profesor buscarPorId(Usuario usuario, String id);

    /**
     * Ingresa por primera vez los datos del profesor.
     */
    void ingresar(Usuario usuario, Profesor profesor);

    /**
     * Actualiza los datos del profesor.
     */
    void actualizar(Usuario usuario, Profesor profesor);

    /**
     * Elimina el profesor del ID especificado.
     */
    void eliminarPorId(Usuario usuario, String id);

}
