package pe.edu.cibertec.gch.gestores;

import java.util.List;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.dao.ProfesorDaoImpl;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Implementacion del contrato de gestion de profesores.
 */
public class GestorProfesorImpl implements GestorProfesor {

    private ProfesorDao profesorDAO = new ProfesorDaoImpl();

    @Override
    public List<Profesor> listar() {
        return getProfesorDAO().listarTodo();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        return getProfesorDAO().listarSegun(nombres, apellidoPaterno, apellidoMaterno);
    }

    @Override
    public Profesor buscarPorId(String id) {
        return (id == null || id.trim().isEmpty())
                ? null : getProfesorDAO().obtenerSegun(id);
    }

    @Override
    public void ingresar(Profesor profesor) {
        if (profesor.esValido()) {
            getProfesorDAO().registrar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void actualizar(Profesor profesor) {
        if (profesor.esValido()) {
            getProfesorDAO().actualizar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void eliminarPorId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            getProfesorDAO().eliminarSegun(id);
        }
    }

    public ProfesorDao getProfesorDAO() {
        return profesorDAO;
    }

    public void setProfesorDAO(ProfesorDao profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

}
