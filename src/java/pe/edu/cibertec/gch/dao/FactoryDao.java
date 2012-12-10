package pe.edu.cibertec.gch.dao;

/**
 * Crea instancias de las interfaces DAO solicitadas.
 */
public class FactoryDao {
    
    public static ProfesorDao getDaoProfesor() {
        return new ProfesorDaoImpl();
    }
}

