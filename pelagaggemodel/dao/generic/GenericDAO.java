package pelagaggemodel.model.dao.generic;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author arturo
 */
public interface GenericDAO {
    public Object retrieve(int id);
    public List retrieveAll();
    public void delete (Object o);
    public void deleteAll();
    public void update(Object o);
    public void save(Object o);
    public Session getSession();
}
