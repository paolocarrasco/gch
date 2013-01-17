package pe.edu.cibertec.gch.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Utilitario para JPA
 */
public final class JpaUtil {
    
    private final EntityManager em;
    
    public static JpaUtil con(EntityManager entityManager) {
        return new JpaUtil(entityManager);
    }
    
    private JpaUtil(EntityManager entityManager) {
        this.em = entityManager;
    }

    public <T> void persistir(final T item) {
        em.persist(item);
    }
    
    public <T> void actualizar(final T item) {
        em.merge(item);
    }
    
    public void actualizarSegun(final String jpql, final Map<String, ?> parametros) {
        Query query = crearQuery(jpql, parametros);
        query.executeUpdate();
    }
    
    public <T> List<T> listarSegun(final String jpql, final Map<String, ?> parametros) {
        return crearQuery(jpql, parametros).getResultList();
    }
    
    public <K, V> V buscarSegunId(final K id, Class<V> clase) {
        return em.find(clase, id);
    }
    
    private Query crearQuery(String jpql, Map<String, ?> parametros) {
        Query query = em.createQuery(jpql);
        for (Map.Entry<String, ? extends Object> entry : parametros.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }
}
