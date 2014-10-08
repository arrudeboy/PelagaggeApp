package pelagaggemodel.pojo;

import java.io.Serializable;

/**
 *
 * @author arturo
 */
public class Recibo implements Serializable, Cloneable{
    
    private int id_recibo;
    private Alquiler alquiler;
    private String nro_recibo;
    private int mes;
    private int anio;
    private double entrega;
    private String observacionAlquiler;

    /**
     * @return the id_recibo
     */
    public int getId_recibo() {
        return id_recibo;
    }

    /**
     * @param id_recibo the id_recibo to set
     */
    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
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

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the observacionAlquiler
     */
    public String getObservacionAlquiler() {
        return observacionAlquiler;
    }

    /**
     * @param observacionAlquiler the observacionAlquiler to set
     */
    public void setObservacionAlquiler(String observacionAlquiler) {
        this.observacionAlquiler = observacionAlquiler;
    }

    /**
     * @return the entrega
     */
    public double getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(double entrega) {
        this.entrega = entrega;
    }

    /**
     * @return the nro_recibo
     */
    public String getNro_recibo() {
        return nro_recibo;
    }

    /**
     * @param nro_recibo the nro_recibo to set
     */
    public void setNro_recibo(String nro_recibo) {
        this.nro_recibo = nro_recibo;
    }
    
}
