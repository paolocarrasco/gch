package pe.edu.cibertec.gch.gestores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.Usuario;

/**
 * Implementacion del contrato de gestion de profesores.
 */
@Transactional
public class GestorProfesorImpl implements GestorProfesor {

    @Autowired
    private ProfesorDao profesorDAO;

    @Override
    public List<Profesor> listar(Usuario usuario) {
        return profesorDAO.listarTodo();
    }

    @Override
    public List<Profesor> listarSegun(Usuario usuario, String nombres, String apellidoPaterno, String apellidoMaterno) {
        return profesorDAO.listarSegun(nombres, apellidoPaterno, apellidoMaterno);
    }

    @Override
    public Profesor buscarPorId(Usuario usuario, String id) {
        return (id == null || id.trim().isEmpty())
                ? null : profesorDAO.obtenerSegun(id);
    }

    @Override
    public void ingresar(Usuario usuario, Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.registrar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void actualizar(Usuario usuario, Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.actualizar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void eliminarPorId(Usuario usuario, String id) {
        if (id != null && !id.trim().isEmpty()) {
            profesorDAO.eliminarSegun(id);
        }
    }

}
