package pelagaggemodel.dao.factory;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pelagaggemodel.dao.model.*;

/**
 *
 * @author arturo
 */
public class HibernateFactoryDAO extends FactoryDAO{

  Session session;


  public HibernateFactoryDAO(){
      
        SessionFactory sessionFactory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
    } 

    @Override
    public DepartamentoDAO getDepartamentoDAO(){
        return new HibernateDepartamentoDAO(session);
    }

    @Override
    public InteresesDAO getInteresesDAO(){
        return new HibernateInteresesDAO(session);
    }

    @Override
    public PersonaDAO getPersonaDAO(){
        return new HibernatePersonaDAO(session);
    }

    @Override
    public AlquilerDAO getAlquilerDAO(){
        return new HibernateAlquilerDAO(session);
    }
    
    @Override
    public AlertaDAO getAlertaDAO(){
        return new HibernateAlertaDAO(session);
    }

    @Override
    public ReciboDAO getReciboDAO() {
        return new HibernateReciboDAO(session);
    }
    
    @Override
    public boolean blockSystem(){
        
        Query sqlQuery=session.createSQLQuery("select * from Blocks where fecha = CURDATE()");
        
        if (sqlQuery.list().isEmpty()){
            return false;
        }
        else {return true;}
        
    }

    @Override
    public String getCurrentNroRecibo(String descripcion) {
        
        Query sqlQuery=session.createSQLQuery("select valor from NroRecibos where descripcion =:desc");
        sqlQuery.setString("desc", descripcion);
        
        return (String)sqlQuery.uniqueResult();
    }

    @Override
    public void updateNroRecibo(String descripcion, String valor) {

        Transaction tx = session.beginTransaction();
        
        String sqlquery = "update NroRecibos set valor = :valor where descripcion = :descripcion";
        session.createSQLQuery(sqlquery)
                        .setParameter("valor", valor)
                        .setParameter("descripcion", descripcion)
                        .executeUpdate();
        
        
        tx.commit();
 
    }

    @Override
    public boolean existsBackUp(int mes, int anio) {
        
        Query sqlQuery=session.createSQLQuery("select * from Backups "
                + "where mes="+mes+" and anio="+anio);
        
        if (sqlQuery.list().isEmpty()){
            return false;
        }
        else {return true;}
    }

    @Override
    public void saveBackUp(int mes, int anio) {
                
        Transaction tx = session.beginTransaction();
        
        String sqlquery = "insert into Backups(mes,anio) values(:mes,:anio)";
        session.createSQLQuery(sqlquery)
                        .setParameter("mes", mes)
                        .setParameter("anio", anio)
                        .executeUpdate();
        
        tx.commit();

    }

    @Override
    public void updateDataBackupConfig(String email, String passwd, int dia_backup) {
        
        Transaction tx = session.beginTransaction();
        String sqlquery;
        
        if (getDataBackupConfig() == null){
            sqlquery = "insert into Backups_config(email,password,dia_backup) values(:email,:passwd,:dia_backup)";
        }
        else{
        sqlquery = "update Backups_config set email = :email, password = :passwd,"
                + "dia_backup = :dia_backup";}
        
        session.createSQLQuery(sqlquery)
                        .setParameter("email", email)
                        .setParameter("passwd", passwd)
                        .setParameter("dia_backup", dia_backup)
                        .executeUpdate();
        
        
        tx.commit();
        
    }

    @Override
    public Object getDataBackupConfig() {
        
        Query sqlQuery=session.createSQLQuery("select * from Backups_config");
        
        return sqlQuery.uniqueResult();
        
    }
}
