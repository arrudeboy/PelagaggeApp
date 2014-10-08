package pelagaggemodel.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author arturo
 */
public class Alquiler implements Serializable, Cloneable {
    
    private int id_alquiler;
    private Persona responsable_pago;
    private Departamento departamento;
    private int valorAlquiler;
    private Date fechaInicio;
    private Date fechaFin;
    private int eliminado;

    public Alquiler(){}
    
    public Alquiler(int id_alquiler, Persona responsable_pago
            ,Departamento departamento, int valorAlquiler, Date fechaInicio
            ,Date fechaFin){
        
        this.id_alquiler = id_alquiler;
        this.responsable_pago=responsable_pago;
        this.departamento=departamento;
        this.valorAlquiler=valorAlquiler;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
                
    }

    /**
     * @return the id_alquiler
     */
    public int getId_alquiler() {
        return id_alquiler;
    }

    /**
     * @param id_alquiler t
    
    
    he id_alquiler to set
     */
    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    /**
     * @return the responsable_pago
     */
    public Persona getResponsable_pago() {
        return responsable_pago;
    }

    /**
     * @param responsable_pago the responsable_pago to set
     */
    public void setResponsable_pago(Persona responsable_pago) {
        this.responsable_pago = responsable_pago;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the valorAlquiler
     */
    public int getValorAlquiler() {
        return valorAlquiler;
    }

    /**
     * @param valorAlquiler the valorAlquiler to set
     */
    public void setValorAlquiler(int valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the eliminado
     */
    public int getEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }
    
    
    
    
    
    
}
