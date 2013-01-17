package pe.edu.cibertec.gch.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.gch.modelo.Profesor;

@Repository
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
        return em.createQuery("SELECT p FROM Profesor p").getResultList();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        return em.createQuery("SELECT p FROM Profesor p "
                + "WHERE p.nombres LIKE :nombres "
                + "AND p.apellidoPaterno LIKE :apellidoPaterno "
                + "AND p.apellidoPaterno LIKE :apellidoMaterno")
                .setParameter("nombres", "%" + ((nombres == null) ? "" : nombres) + "%")
                .setParameter("apellidoPaterno", "%" + ((apellidoPaterno == null) ? "" : apellidoPaterno) + "%")
                .setParameter("apellidoMaterno", "%" + ((apellidoMaterno == null) ? "" : apellidoMaterno) + "%")
                .getResultList();
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno,
            String apellidoMaterno, int paginaInicia, int profesoresPorPagina) {
        return em.createQuery("SELECT p FROM Profesor p WHERE p.nombres")
                .setParameter("nombres", nombres)
                .setParameter("apellidoPaterno", apellidoPaterno)
                .setParameter("apellidoMaterno", apellidoMaterno)
                .setFirstResult((paginaInicia - 1) * profesoresPorPagina)
                .setMaxResults(profesoresPorPagina)
                .getResultList();
    }

    @Override
    public Profesor obtenerSegun(String codigo) {
        return em.find(Profesor.class, codigo);
    }
}
