package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.HibernateGenericDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Alquiler;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public class HibernateAlquilerDAO extends HibernateGenericDAO implements AlquilerDAO {
    
    public HibernateAlquilerDAO(Session s)
    {
        super(s);
    }

    @Override
    public Alquiler retrieve(int id) {
        return (Alquiler)session.load(pelagaggemodel.pojo.Alquiler.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Alquiler a order by a.responsable_pago.apellido");
         return (List<Alquiler>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Alquiler");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }

    @Override
    public Alquiler retrieve(Departamento d, Date startDate, Date endDate) {
                 
        Query hqlQuery=session.createQuery(
                "select a from Alquiler a join fetch "
                + "a.departamento as departamento where departamento =:var0 "
                + "and a.fechaInicio = :var1 and a.fechaFin = :var2");
                
        hqlQuery.setEntity("var0", d);
        hqlQuery.setDate("var1", startDate);
        hqlQuery.setDate("var2", endDate);


        return (Alquiler)hqlQuery.uniqueResult();
        
    }

    @Override
    public List<Alquiler> retrieve(Persona inquilino) {
        
        Query hqlQuery=session.createQuery(
                "select distinct a from Alquiler a "
                + "left join a.responsable_pago as inquilino "
                + "where inquilino = :var0");
        
        hqlQuery.setEntity("var0", inquilino);
        
        return (List<Alquiler>)hqlQuery.list();
        
    }

    @Override
    public List<Alquiler> retrieve1(Persona propietario) {
        
        Query hqlQuery=session.createQuery(
                "select distinct new Alquiler("
                                +"a.id_alquiler,"
                                +"a.responsable_pago,"
                                +"a.departamento,"
                                +"a.valorAlquiler,"
                                +"a.fechaInicio,"
                                +"a.fechaFin) from Alquiler a "
                + "where a.departamento.propietario = :var0");
        
        hqlQuery.setEntity("var0", propietario);
        
        return (List<Alquiler>)hqlQuery.list();
        
    }

    @Override
    public List<Alquiler> retrieveAdeudados(int mes, int anio) {
        
        Query hqlQuery=session.createQuery(
                "select a from Alquiler a "
                + "where a not in (select alquiler from Recibo r "
                + "join r.alquiler as alquiler where r.mes = :var0 "
                + "and r.anio = :var1) order by a.responsable_pago.apellido " 
        );
        
        hqlQuery.setInteger("var0", mes);
        hqlQuery.setInteger("var1", anio);
        
        return (List<Alquiler>)hqlQuery.list();
            
    }
       
}
