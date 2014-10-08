package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.HibernateGenericDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Intereses;

/**
 *
 * @author arturo
 */
public class HibernateInteresesDAO extends HibernateGenericDAO implements InteresesDAO{
    
    public HibernateInteresesDAO(Session s)
    {
        super(s);
    }

    @Override
    public Intereses retrieve(int id) {
        return (Intereses)session.load(pelagaggemodel.pojo.Intereses.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Intereses");
         return (List<Intereses>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Intereses");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }

    @Override
    public List<Intereses> retrieve(Departamento departamento) {
                 
        Query hqlQuery=session.createQuery("select i from Intereses i join fetch "
                + "i.departamento as departamento where departamento =:var0");
        hqlQuery.setEntity("var0", departamento);
        
        return (List<Intereses>)hqlQuery.list();

    }
    
}
