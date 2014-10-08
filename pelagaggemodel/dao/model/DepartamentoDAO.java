package pelagaggemodel.dao.model;

import conservatorioutilities.dao.GenericDAO;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Persona;
/**
 *
 * @author arturo
 */
public interface DepartamentoDAO extends GenericDAO {
    
    public java.util.List retrieve (Persona propietario);
    public Departamento retrieve(String direccion);
    public java.util.List retrieveOnlyNoAlquilados(Persona propietario);
    public java.util.List retrieveOnlyAlquilados (Persona propietario);
}
