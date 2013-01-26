package pe.edu.cibertec.gch.dao;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.cibertec.gch.modelo.Profesor;

// Ponemos la transaccionabilidad a nivel de la clase
// A nivel de DAO se espera que ya se haya creado una transaccion
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ProfesorDaoImpl implements ProfesorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void registrar(Profesor profesor) {
        em.persist(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        em.merge(profesor);
    }

    @Override
    public void eliminarSegun(String codigo) {
        Profesor profesor = obtenerSegun(codigo);
        em.remove(profesor);
    }

    @Override
    public List<Profesor> listarTodo() {
        return em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        return em.createQuery("SELECT p FROM Profesor p "
                + "WHERE p.nombres LIKE :nombres "
                + "AND p.apellidoPaterno LIKE :apellidoPaterno "
                + "AND p.apellidoPaterno LIKE :apellidoMaterno", Profesor.class)
                .setParameter("nombres", "%" + ((nombres == null) ? "" : nombres) + "%")
                .setParameter("apellidoPaterno", "%" + ((apellidoPaterno == null) ? "" : apellidoPaterno) + "%")
                .setParameter("apellidoMaterno", "%" + ((apellidoMaterno == null) ? "" : apellidoMaterno) + "%")
                .getResultList();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno,
            String apellidoMaterno, int paginaInicial, int profesoresPorPagina) {
        return em.createQuery("SELECT p FROM Profesor p "
                + "WHERE p.nombres LIKE :nombres "
                + "AND p.apellidoPaterno LIKE :apellidoPaterno "
                + "AND p.apellidoPaterno LIKE :apellidoMaterno", Profesor.class)
                .setParameter("nombres", "%" + ((nombres == null) ? "" : nombres) + "%")
                .setParameter("apellidoPaterno", "%" + ((apellidoPaterno == null) ? "" : apellidoPaterno) + "%")
                .setParameter("apellidoMaterno", "%" + ((apellidoMaterno == null) ? "" : apellidoMaterno) + "%")
                .setFirstResult((paginaInicial - 1) * profesoresPorPagina)
                .setMaxResults(profesoresPorPagina)
                .getResultList();
    }

    @Override
    public Profesor obtenerSegun(String codigo) {
        return em.find(Profesor.class, codigo);
    }
}
