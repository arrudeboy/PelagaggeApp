package pelagaggemodel.model.dao.generic;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author arturo
 */
public class HibernateGenericDAO implements GenericDAO{

    protected Session session;

    public HibernateGenericDAO (Session session){
        this.session=session;
    }

    @Override
    public Object retrieve(int id) {
        // this method must be implemented by subclass
        return null;
    }

    @Override
    public List retrieveAll() {
        // this method must be implemented by subclass
        return null;
    }

    @Override
    public void deleteAll() {
        // this method must be implemented by subclass
        return;
    }

    @Override
    public void delete(Object o) {

        beginTx();
        session.delete(o);
        commitTx();
        closeSession();

    }

    @Override
    public void update(Object o) {

        beginTx();

        session.merge(o);
        session.flush();

        commitTx();
        closeSession();

    }

    @Override
    public void save(Object o) {

        beginTx();
        session.save(o);
        commitTx();
        //closeSession();

    }

    protected void beginTx(){
        this.session.beginTransaction();
    }

    protected void commitTx(){
        this.session.getTransaction().commit();
    }

    public void closeSession(){
        this.session.close();
    }

    @Override
    public Session getSession() {
        return this.session;
    }

}
