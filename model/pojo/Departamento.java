package pelagaggemodel.pojo;

import java.io.Serializable;

/**
 *
 * @author arturo
 */
public class Departamento implements Serializable, Cloneable{
    
    private int id_departamento;
    private String direccion;
    private String descripcion;
    private Persona propietario;

    public Departamento(){}
    
    public Departamento(String direccion,String descripcion,Persona propietario){
        this.descripcion=descripcion;
        this.direccion=direccion;
        this.propietario=propietario;
    }
    
    /**
     * @return the id_departamento
     */
    public int getId_departamento() {
        return id_departamento;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     * @param id_departamento the id_departamento to set
     */
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    /**
     * @return the propietario
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        Departamento d = (Departamento)obj;
        if (this.descripcion.equals(d.getDescripcion())
            &&
            this.direccion.equals(d.direccion)
            &&
            this.propietario.equals(d.getPropietario())) {
            
            return true;
        }
        else {
            return false;
        }
            
                  
    }
    
}
