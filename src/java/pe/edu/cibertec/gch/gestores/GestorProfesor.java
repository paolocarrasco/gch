package pe.edu.cibertec.gch.gestores;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Contrato con las acciones que pueden realizarse respecto a un profesor.
 */
public interface GestorProfesor {

    /**
     * Lista todos los profesores registrados.
     */
    List<Profesor> listar();

    /**
     *
     * Lista los profesores segun nombres y apellidos.
     */
    List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno);

    /**
     * Busca el profesor que corresponda con el ID.
     */
    Profesor buscarPorId(String id);

    /**
     * Ingresa por primera vez los datos del profesor.
     */
    void ingresar(Profesor profesor);

    /**
     * Actualiza los datos del profesor.
     */
    void actualizar(Profesor profesor);

    /**
     * Elimina el profesor del ID especificado.
     */
    void eliminarPorId(String id);

}
