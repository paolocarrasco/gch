package pe.edu.cibertec.gch.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import pe.edu.cibertec.gch.dao.JpaUtil.ContextoPersistenteRecuperable;
import pe.edu.cibertec.gch.modelo.Profesor;

public class ProfesorDaoImpl implements ProfesorDao {

    @Override
    public void registrar(Profesor profesor) {
        JpaUtil.persistir(profesor);
    }

    @Override
    public void actualizar(Profesor profesor) {
        JpaUtil.actualizar(profesor);
    }

    @Override
    public void eliminarSegun(String codigo) {
        HashMap<String, String> parametros = new HashMap<String, String>();
        parametros.put("codigo", codigo);
        JpaUtil.actualizarSegun(codigo, parametros);
    }

    @Override
    public List<Profesor> listarTodo() {
        return JpaUtil.listarSegun("SELECT p FROM Profesor p", Collections.EMPTY_MAP);
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        Map<String, String> parametros = new HashMap<String, String>();
        parametros.put("nombres", "%" + (nombres == null ? "" : nombres) + "%");
        parametros.put("paterno", "%" + (apellidoPaterno == null ? "" : apellidoPaterno) + "%");
        parametros.put("materno", "%" + (apellidoMaterno == null ? "" : apellidoMaterno) + "%");

        return JpaUtil.listarSegun("SELECT p FROM Profesor p WHERE p.nombres LIKE :nombres AND p.apellidoPaterno LIKE :paterno AND p.apellidoMaterno LIKE :materno", parametros);
    }

    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno, int paginaInicia, int profesoresPorPagina) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Profesor obtenerSegun(String codigo) {
        ContextoPersistenteRecuperable<Profesor> contexto = new JpaUtil.ContextoPersistenteRecuperable() {
            private Profesor profesor;

            @Override
            public Profesor recuperar() {
                return profesor;
            }

            @Override
            public void ejecutar(EntityManager em) {
                profesor = em.find(Profesor.class, em);
            }
        };

        JpaUtil.usarPersistencia(contexto);
        return contexto.recuperar();
    }
}
