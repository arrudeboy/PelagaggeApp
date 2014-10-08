package pelagaggemodel.dao.testing;

import java.util.Date;
import java.util.List;
import pelagaggemodel.dao.factory.FactoryDAO;
import pelagaggemodel.dao.factory.HibernateFactoryDAO;
import pelagaggemodel.pojo.Alquiler;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Intereses;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public class DAOTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        Departamento d = new Departamento();
        d.setDescripcion("dpto de zinani");
        d.setDireccion("siria 285");
        
        Intereses i = new Intereses();
        i.setDescripcion("deudas");
        i.setValor(8900.10);
        i.setDepartamento(d);
        
        HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getDepartamentoDAO().save(d);
        
        HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getInteresesDAO().save(i);
        
        */
       
         
        Departamento d = (Departamento)HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getDepartamentoDAO().retrieve(1);
        
        System.out.println("Departamento: "+d.getDescripcion());
        
        
        /*
        List<Departamento> l = HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getDepartamentoDAO().retrieveAll();
        
        for (Departamento d: l){
            System.out.println("Departamento: "+ d.getDescripcion());
        }
        */
        
        /*
        Intereses i = (Intereses)HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getInteresesDAO().retrieve(2);
        
        System.out.println("Interes: (id:"+i.getId_intereses()+") - (descripcion:"+i.getDescripcion()+") - (valor:"+i.getValor()+")");
       */
        
       /*
       List<Intereses> l = HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getInteresesDAO().retrieveAll();

       for (Intereses i: l){
           System.out.println("Interes: (id:"+i.getId_intereses()+") - (descripcion:"+i.getDescripcion()+") - (valor:"+i.getValor()+")");
       }
       */
       /*
       Persona p = new Persona();
       p.setApellido("Zinani");
       p.setNombre("Martin Roberto Exequiel");
       p.setDni("32.817.551");
       p.setTelefono("2346 15 660918");
       
       HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getPersonaDAO().save(p);
       */
       
       /*
       Persona p = (Persona)HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getPersonaDAO().retrieve(1);
        
       Alquiler a = new Alquiler();
       a.setDepartamento(d);
       a.setPropietario(p);
       a.setResponsable_pago(p);
       a.setFechaInicio(new Date());
       a.setValorAlquiler(14000);
       
       HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getAlquilerDAO().save(a);
       */
       
        
       
       Alquiler a = (Alquiler)HibernateFactoryDAO.getHibernateDAOFactory(FactoryDAO.HIBERNATE).getAlquilerDAO().retrieve(1);
       /*
       ObservacionAlquiler oa = new ObservacionAlquiler();
       oa.setAnio(2012);
       oa.setMes(10);
       oa.setDescripcion("no pago las deudas al dia de la fecha");
       oa.setAlquiler(a);
           
        */
        
    }
        

        
    }

