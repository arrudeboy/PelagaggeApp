package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.HibernateGenericDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public class HibernateDepartamentoDAO extends HibernateGenericDAO implements DepartamentoDAO {
    
    public HibernateDepartamentoDAO(Session s)
    {
        super(s);
    }

    @Override
    public Departamento retrieve(int id) {
        return (Departamento)session.load(pelagaggemodel.pojo.Departamento.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Departamento d order by d.direccion");
         return (List<Departamento>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Departamento");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }
    
    @Override
    public List retrieve(Persona propietario) {

        Query hqlQuery=session.createQuery("select d from Departamento d "
                + "join fetch d.propietario as propietario where propietario = :var0");
        
        hqlQuery.setEntity("var0", propietario);
        
        return (java.util.List<Departamento>)hqlQuery.list();
    }

    @Override
    public Departamento retrieve(String direccion) {
        
        Query hqlQuery=session.createQuery(
                "select d from Departamento d where d.direccion = :var0");
        hqlQuery.setString("var0", direccion);
        return (Departamento)hqlQuery.uniqueResult();
    }

    @Override
    public List retrieveOnlyNoAlquilados(Persona propietario) {

        Query hqlQuery=session.createQuery("select d from Departamento d "
                + "join fetch d.propietario as propietario where propietario = :var0 "
                + "and d not in ("
                + "select adepto from Alquiler a join a.departamento as adepto)");
        
        hqlQuery.setEntity("var0", propietario);
        
        return (java.util.List<Departamento>)hqlQuery.list();
    
    }

    @Override
    public List retrieveOnlyAlquilados(Persona propietario) {
                       
        Query hqlQuery=session.createQuery("select d from Departamento d "
                + "join fetch d.propietario as propietario where propietario = :var0 "
                + "and d in ("
                + "select adepto from Alquiler a join a.departamento as adepto)");
        
        hqlQuery.setEntity("var0", propietario);
        
        return (java.util.List<Departamento>)hqlQuery.list();
        
    }
 
}
