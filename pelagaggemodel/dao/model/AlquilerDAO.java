package pelagaggemodel.dao.model;

import pelagaggemodel.dao.generic.GenericDAO;
import java.util.Date;
import pelagaggemodel.pojo.Alquiler;
import pelagaggemodel.pojo.Departamento;
import pelagaggemodel.pojo.Persona;

/**
 *
 * @author arturo
 */
public interface AlquilerDAO extends GenericDAO {
    
    public Alquiler retrieve(Departamento d, Date startDate, Date endDate);
    
    //Retorna una lista de alquileres a los cuales el inquilino esta asignado
    public java.util.List<Alquiler> retrieve (Persona inquilino);
    //Retorna los alquileres en los cuales esta involucrado el propietario del deptartamento del alq
    public java.util.List<Alquiler> retrieve1 (Persona propietario);
    
    //Retorna una lista de alquileres, los cuales aun no fueron abonados por el inquilino en el mes y anio especificado
    public java.util.List<Alquiler> retrieveAdeudados(int mes, int anio);
   
}
