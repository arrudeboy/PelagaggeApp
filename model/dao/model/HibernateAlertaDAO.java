package pelagaggemodel.dao.model;

import conservatorioutilities.dao.HibernateGenericDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Alerta;
import pelagaggemodel.pojo.Alquiler;

/**
 *
 * @author arturo
 */
public class HibernateAlertaDAO extends HibernateGenericDAO implements AlertaDAO{
    
    public HibernateAlertaDAO(Session s)
    {
        super(s);
    }
    
    @Override
    public Alerta retrieve(int id) {
        return (Alerta)session.load(pelagaggemodel.pojo.Alerta.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Alerta");
         return (List<Alerta>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Alerta");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }

    @Override
    public List<Alerta> retrieve(Alquiler alquiler) {
               
        Query hqlQuery=session.createQuery("select a from Alerta a join fetch "
                + "a.alquiler as alquiler where alquiler = :var0");
        hqlQuery.setEntity("var0", alquiler);
        
        return (java.util.List<Alerta>)hqlQuery.list();

    }
    
    @Override   
    public List<Alerta> getAlertasPendientes() {
               
        Query hqlQuery=session.createQuery("select a from Alerta a where a.fecha <= CURDATE()");
        
        return (java.util.List<Alerta>)hqlQuery.list();   
    }
       
    @Override
    public Alerta retrieveFinDeContrato(Alquiler alquiler) {
                
        Query hqlQuery=session.createQuery("select a from Alerta a join fetch "
                + "a.alquiler as alquiler where alquiler = :var0 "
                + "and a.fecha = :var1 and a.descripcion = :var2");
        
        hqlQuery.setEntity("var0", alquiler);
        hqlQuery.setDate("var1", alquiler.getFechaFin());
        hqlQuery.setString("var2", "fin de contrato");
        
        return (Alerta)hqlQuery.uniqueResult();
    }
}
