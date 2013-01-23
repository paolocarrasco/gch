package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Contrato de operaciones referentes a la entidad de Profesor en la fuente de
 * datos.
 *
 */
public interface ProfesorDao {
    
    void registrar(Profesor profesor);
    void actualizar(Profesor profesor);
    void eliminarSegun(String codigo);
    List<Profesor> listarTodo();
    /**
     * @deprecated se deberia usar la sobre carga de esta operacion con paginado
     */
    @Deprecated
    List<Profesor> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno);
    List<Profesor> listarSegun(String nombre, String apellidoPaterno, String apellidoMaterno, int paginaInicial, int profesoresPorPagina);
    Profesor obtenerSegun(String codigo);

}
