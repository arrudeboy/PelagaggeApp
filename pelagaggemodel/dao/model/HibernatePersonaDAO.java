package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.HibernateGenericDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public class HibernatePersonaDAO extends HibernateGenericDAO implements PersonaDAO {
    
    public HibernatePersonaDAO(Session s)
    {
        super(s);
    }

    @Override
    public Persona retrieve(int id) {
        return (Persona)session.load(pelagaggemodel.pojo.Persona.class, id);
    }

    @Override
    public List retrieveAll() {
         Query hqlQuery=session.createQuery("from Persona p order by p.apellido");
         return (List<Persona>)hqlQuery.list();
    }

    @Override
    public void deleteAll(){
        beginTx();
        Query hqlQuery=session.createQuery("delete from Persona");
        hqlQuery.executeUpdate();
        commitTx();
        closeSession();
    }

    @Override
    public List<Persona> retrieveInquilinos() {
        
        Query hqlQuery=session.createQuery(
                "select distinct p from Persona p "
                + "where p in (select distinct inq from Alquiler a join a.responsable_pago as inq) order by p.apellido");
        return (List<Persona>)hqlQuery.list();
     
    }
    
    @Override
    public List<Persona> retrievePropietarios() {
        
        Query hqlQuery=session.createQuery(
                "select distinct p from Persona p join fetch Departamento d "
                + "join fetch d.propietario as propietario where p = propietario order by p.apellido");
        return (List<Persona>)hqlQuery.list();
        
    }

    @Override
    public List<Persona> retrievePropietariosConInmsAlq() {
        
        Query hqlQuery=session.createQuery(
                "select distinct new Persona("
                                +"a.departamento.propietario.id_persona,"
                                +"a.departamento.propietario.apellido,"
                                +"a.departamento.propietario.nombre,"
                                +"a.departamento.propietario.telefono,"
                                +"a.departamento.propietario.dni) from Alquiler a "
                + "order by a.departamento.propietario.apellido");

        return (List<Persona>)hqlQuery.list();
        
    }
    
    
    
}
