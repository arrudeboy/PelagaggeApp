package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.GenericDAO;
import java.util.List;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Intereses;

/**
 *
 * @author arturo
 */
public interface InteresesDAO extends GenericDAO {
    
    public List<Intereses> retrieve(Departamento departamento);
}
