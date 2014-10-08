package pelagaggemodel.dao.model;

import conservatorioutilities.dao.GenericDAO;
import java.util.List;
import pelagaggemodel.pojo.Recibo;

/**
 *
 * @author arturo
 */
public interface ReciboDAO extends GenericDAO {
    
    public List<Recibo> retrieve(int mes, int anio);
    
    
    public String existsReciboInq(int mes, int anio, int id_alquiler);
    public String existsReciboProp(int mes, int anio, int id_alquiler);

}
