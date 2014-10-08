package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.GenericDAO;
import java.util.List;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public interface PersonaDAO extends GenericDAO {
    
    public List<Persona> retrieveInquilinos();
    public List<Persona> retrievePropietarios();
    public List<Persona> retrievePropietariosConInmsAlq();
            
}
