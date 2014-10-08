package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.GenericDAO;
import java.util.List;
import pelagaggemodel.pojo.Alerta;
import pelagaggemodel.pojo.Alquiler;

/**
 *
 * @author arturo
 */
public interface AlertaDAO extends GenericDAO {
    
    public List<Alerta> retrieve(Alquiler alquiler);
    public Alerta retrieveFinDeContrato(Alquiler alquiler);
    public List<Alerta> getAlertasPendientes() ;
}
