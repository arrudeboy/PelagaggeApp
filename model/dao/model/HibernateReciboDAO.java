package pelagaggemodel.dao.model;

import conservatorioutilities.dao.HibernateGenericDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Recibo;

/**
 *
 * @author arturo
 */
public class HibernateReciboDAO extends HibernateGenericDAO implements ReciboDAO {
    
    public HibernateReciboDAO(Session s)
    {
        super(s);
    }

    @Override
    public Recibo retrieve(int id) {
        return (Recibo)session.load(pelagaggemodel.pojo.Recibo.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Recibo");
         return (List<Recibo>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Recibo");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }

    @Override
    public List<Recibo> retrieve(int mes, int anio) {
                  
        /*retorna solo los recibos de inquilino*/
        Query hqlQuery=session.createQuery(
                "select r from Recibo r where r.mes = :var0 "
                + "and r.anio = :var1 and r.alquiler.valorAlquiler <= r.entrega order by r.alquiler.responsable_pago.apellido");
        
        hqlQuery.setInteger("var0", mes);
        hqlQuery.setInteger("var1", anio);
        
        return (List<Recibo>)hqlQuery.list();
    }

    @Override
    public String existsReciboInq(int mes, int anio, int id_alquiler) {
         
        /*Si existe retorna el numero de recibo (como String), si no existe retorna null */
        Query hqlQuery=session.createQuery(
                "select r from Recibo r where r.mes = :var0 "
                + "and r.anio = :var1 and r.alquiler.valorAlquiler <= r.entrega "
                + "and r.alquiler.id_alquiler = :var2");
        
        hqlQuery.setInteger("var0", mes);
        hqlQuery.setInteger("var1", anio);
        hqlQuery.setInteger("var2", id_alquiler);
        
        if (hqlQuery.list().isEmpty()){
            return null;
        }
        else {
            List<Recibo> l =  hqlQuery.list();
            return l.get(0).getNro_recibo();
        }

    }

    @Override
    public String existsReciboProp(int mes, int anio, int id_alquiler) {
        
        /*Si existe retorna el numero de recibo (como String), si no existe retorna null */
        Query hqlQuery=session.createQuery(
                "select r from Recibo r where r.mes = :var0 "
                + "and r.anio = :var1 and r.alquiler.valorAlquiler > r.entrega "
                + "and r.alquiler.id_alquiler = :var2");
        
        hqlQuery.setInteger("var0", mes);
        hqlQuery.setInteger("var1", anio);
        hqlQuery.setInteger("var2", id_alquiler);
        
        if (hqlQuery.list().isEmpty()){
            return null;
        }
        else {
            List<Recibo> l =  hqlQuery.list();
            return l.get(0).getNro_recibo();
        }
        
    }
    
}
