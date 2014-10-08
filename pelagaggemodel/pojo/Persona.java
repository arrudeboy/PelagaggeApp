package pelagaggemodel.pojo;

import java.io.Serializable;

/**
 *
 * @author arturo
 */
public class Persona implements Serializable,Cloneable{
    
    private int id_persona;
    private String apellido;
    private String nombre;
    private String telefono;
    private String dni;

    /**
     * @return the id_persona
     */
    
    public Persona (){}
    
       
    public Persona (String apellido, String nombre, String telefono, String dni){
        this.apellido=apellido;
        this.nombre=nombre;
        this.telefono=telefono;
        this.dni=dni;
    }
    
    public Persona (int id_persona,String apellido, String nombre, String telefono, String dni){
        this.id_persona=id_persona;
        this.apellido=apellido;
        this.nombre=nombre;
        this.telefono=telefono;
        this.dni=dni;
    }
    
    public int getId_persona() {
        return id_persona;
    }

    /**
     * @param id_persona the id_persona to set
     */
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object obj) {
        
        Persona p = (Persona)obj;
        if (this.apellido.equals(p.getApellido())
            &&
            this.nombre.equals(p.getNombre())
            &&
            this.telefono.equals(p.getTelefono())
            &&
            this.dni.equals(p.getDni())){
            
            return true;
        }
        else return false;
            
                  
    }
    
}
