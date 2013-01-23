package pe.edu.cibertec.gch.gestores;

import java.util.List;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Implementacion del contrato de gestion de profesores.
 */
// Para ubicar la transaccionalidad aqui con anotaciones, usar @Transactional
public class GestorProfesorImpl implements GestorProfesor {

    // Se puede inyectar este DAO por anotaciones: probar @Autowired
    // (quitando el constructor y su inyeccion por configuracion XML)
    private ProfesorDao profesorDAO;

    public GestorProfesorImpl(ProfesorDao profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    @Override
    public List<Profesor> listar() {
        return profesorDAO.listarTodo();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        return profesorDAO.listarSegun(nombres, apellidoPaterno, apellidoMaterno);
    }

    @Override
    public Profesor buscarPorId(String id) {
        return (id == null || id.trim().isEmpty())
                ? null : profesorDAO.obtenerSegun(id);
    }

    @Override
    public void ingresar(Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.registrar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void actualizar(Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.actualizar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    @Override
    public void eliminarPorId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            profesorDAO.eliminarSegun(id);
        }
    }

}
