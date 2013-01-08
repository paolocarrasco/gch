package pe.edu.cibertec.gch.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Utilitario para JPA
 */
public final class JpaUtil {

    private static final EntityManagerFactory emf;
    private static final Logger LOGGER = Logger.getLogger(JpaUtil.class.getName());

    static {
        emf = Persistence.createEntityManagerFactory("GCH_PU");
    }

    private JpaUtil() {
    }

    public static void usarPersistencia(ContextoPersistente contextoPersistente) {
        EntityManager em = emf.createEntityManager();
        try {
            contextoPersistente.ejecutar(em);
        } finally {
            em.close();
        }
    }

    public static void usarTransaccionalidad(ContextoTransaccional contextoTransaccional) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            contextoTransaccional.ejecutar(em);
            transaction.commit();
        } catch (Exception e) {
            contextoTransaccional.enError(e);
            transaction.rollback();
        } finally {
            em.close();
        }
    }

    public static <T> void persistir(final T item) {
        usarTransaccionalidad(new ContextoTransaccional() {
            @Override
            public void ejecutar(EntityManager em) {
                em.persist(item);
            }
        });
    }

    public static <T> void actualizar(final T item) {
        usarTransaccionalidad(new ContextoTransaccional() {
            @Override
            public void ejecutar(EntityManager em) {
                em.merge(item);
            }
        });
    }

    public static void actualizarSegun(final String jpql, final Map<String, ?> parametros) {
        usarTransaccionalidad(new ContextoTransaccional() {
            @Override
            public void ejecutar(EntityManager em) {
                Query query = crearQuery(em, jpql, parametros);
                query.executeUpdate();
            }
        });
    }

    public static <T> List<T> listarSegun(final String jpql, final Map<String, ?> parametros) {
        ContextoPersistenteRecuperable<List<T>> contextoPersistente = new ContextoPersistenteRecuperable<List<T>>() {
            List<T> items = new LinkedList<T>();

            @Override
            public void ejecutar(EntityManager em) {
                Query query = crearQuery(em, jpql, parametros);
                items = query.getResultList();
            }

            @Override
            public List<T> recuperar() {
                return items;
            }
        };

        usarPersistencia(contextoPersistente);
        List<T> recuperar = contextoPersistente.recuperar();
        return recuperar;
    }

    public interface ContextoPersistente {

        void ejecutar(EntityManager em);
    }

    public interface ContextoPersistenteRecuperable<T> extends ContextoPersistente {

        T recuperar();
    }

    public static abstract class ContextoTransaccional implements ContextoPersistente {

        public void enError(Exception e) {
            LOGGER.log(Level.WARNING, "Error en contexto transaccional", e);
        }
    }

    private static Query crearQuery(EntityManager em, String jpql, Map<String, ?> parametros) {
        Query query = em.createQuery(jpql);
        for (Map.Entry<String, ? extends Object> entry : parametros.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }
}
