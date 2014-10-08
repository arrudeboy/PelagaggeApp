package pelagaggemodel.dao.factory;

import pelagaggemodel.dao.model.*;

/**
 *
 * @author arturo
 */
public abstract class FactoryDAO {

    public static final int HIBERNATE= 1;

    public abstract DepartamentoDAO getDepartamentoDAO();
    public abstract InteresesDAO getInteresesDAO();
    public abstract PersonaDAO getPersonaDAO();
    public abstract AlquilerDAO getAlquilerDAO();
    public abstract AlertaDAO getAlertaDAO();
    public abstract ReciboDAO getReciboDAO();
    
    public abstract boolean blockSystem();
    
    public abstract boolean existsBackUp(int mes, int anio);
    public abstract void saveBackUp(int mes, int anio);
    
    public abstract void updateDataBackupConfig(String email, String passwd, int dia_backup);
    public abstract Object getDataBackupConfig();
    
    public abstract String getCurrentNroRecibo(String descripcion);
    public abstract void updateNroRecibo(String descripcion, String valor);

    public static FactoryDAO getHibernateDAOFactory(int typeOfDAOFactory){
        switch(typeOfDAOFactory){
            case HIBERNATE:
            default:
                return new HibernateFactoryDAO();
        }
    }

}
