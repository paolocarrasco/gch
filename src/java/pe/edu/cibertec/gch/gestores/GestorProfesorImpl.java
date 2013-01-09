package pe.edu.cibertec.gch.gestores;

import java.util.List;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Usuario;

/**
 * Implementacion del contrato de gestion de profesores.
 */
public class GestorProfesorImpl implements GestorProfesor {

    private ProfesorDao profesorDAO;

    public GestorProfesorImpl(ProfesorDao profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    @Override
    public List<Profesor> listar(Usuario usuario) {
        return getProfesorDAO().listarTodo();
    }

    @Override
    public List<Profesor> listarSegun(Usuario usuario, String nombres, String apellidoPaterno, String apellidoMaterno) {
        return getProfesorDAO().listarSegun(nombres, apellidoPaterno, apellidoMaterno);
    }

    @Override
    public Profesor buscarPorId(Usuario usuario, String id) {
        return (id == null || id.trim().isEmpty())
                ? null : getProfesorDAO().obtenerSegun(id);
    }

    @Override
    public void ingresar(Usuario usuario, Profesor profesor) {
        if (profesor.esValido()) {
            getProfesorDAO().registrar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void actualizar(Usuario usuario, Profesor profesor) {
        if (profesor.esValido()) {
            getProfesorDAO().actualizar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void eliminarPorId(Usuario usuario, String id) {
        if (id != null && !id.trim().isEmpty()) {
            getProfesorDAO().eliminarSegun(id);
        }
    }

    public ProfesorDao getProfesorDAO() {
        return profesorDAO;
    }

}
