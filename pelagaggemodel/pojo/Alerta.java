package pelagaggemodel.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author arturo
 */
public class Alerta implements Serializable, Cloneable{
    
    private int id_alerta;
    private String descripcion;
    private Date fecha;
    private Alquiler alquiler;

    /**
     * @return the id_alerta
     */
    public int getId_alerta() {
        return id_alerta;
    }

    /**
     * @param id_alerta the id_alerta to set
     */
    public void setId_alerta(int id_alerta) {
        this.id_alerta = id_alerta;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the alquiler
     */
    public Alquiler getAlquiler() {
        return alquiler;
    }

    /**
     * @param alquiler the alquiler to set
     */
    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    
}
