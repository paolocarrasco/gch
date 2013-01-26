package pe.edu.cibertec.gch.gestores;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Implementacion del contrato de gestion de profesores.
 */
@Stateless
public class GestorProfesorImpl implements GestorProfesor {

    @Inject
    private ProfesorDao profesorDAO;

    // Para los metodos que solo consultan no es necesario crear una transaccion
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Profesor> listar() {
        return profesorDAO.listarTodo();
    }

    // Para los metodos que solo consultan no es necesario crear una transaccion
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        return profesorDAO.listarSegun(nombres, apellidoPaterno, apellidoMaterno, 1, Integer.MAX_VALUE);
    }

    // Para los metodos que solo consultan no es necesario crear una transaccion
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Profesor buscarPorId(String id) {
        return (id == null || id.trim().isEmpty())
                ? null : profesorDAO.obtenerSegun(id);
    }

    // Para los metodos que modifican la data siempre se debe crear una transaccion
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void ingresar(Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.registrar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    // Para los metodos que modifican la data siempre se debe crear una transaccion
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void actualizar(Profesor profesor) {
        if (profesor.esValido()) {
            profesorDAO.actualizar(profesor);
        } else {
            // TODO deberia arrojarse una excepcion unchecked
        }
    }

    // Para los metodos que modifican la data siempre se debe crear una transaccion
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void eliminarPorId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            profesorDAO.eliminarSegun(id);
        }
    }

}
