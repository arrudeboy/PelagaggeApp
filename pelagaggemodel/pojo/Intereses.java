package pelagaggemodel.pojo;

import java.io.Serializable;

/**
 *
 * @author arturo
 */
public class Intereses implements Serializable, Cloneable {
    
    private int id_intereses;
    private String descripcion;
    private double valor;
    private Departamento departamento;

    /**
     * @return the id_intereses
     */
    public int getId_intereses() {
        return id_intereses;
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
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
     * @param id_intereses the id_intereses to set
     */
    public void setId_intereses(int id_intereses) {
        this.id_intereses = id_intereses;
    }
    
    
    
}
