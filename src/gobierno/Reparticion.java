package gobierno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chkp
 */
public class Reparticion {
    private int id;
    private String nombre;
    private EstadoReparticion estado;

    @Override
    public String toString() {
        return nombre;
    }
    
    public Reparticion() {
        this.id = -1;
        this.nombre = "Nombre";
        this.estado = EstadoReparticion.Normal;
    }
    
    public Reparticion(int id, String nombre, EstadoReparticion estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    public Reparticion(int id, String nombre, String estadoString) {
        this();
        
        this.estado = EstadoReparticion.Normal;
        if (estadoString.compareToIgnoreCase("deficit") == 0) {
            this.estado = EstadoReparticion.Deficit;
        } else if (estadoString.compareToIgnoreCase("superavit") == 0) {
            this.estado = EstadoReparticion.Superavit;
        }
        
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public EstadoReparticion getEstado() {
        // Check if we're in an anormal state, then return that.
        
        /*
        if (are_we_in_deficit()) { this.estado = EstadoReparticion.Deficit; }
        else if (are_we_in_superavit()) { this.estado = EstadoReparticion.Superavit; }
        else { this.estado = EstadoReparticion.Normal; }
        */
        
        return estado;
    }
    
    public static String getIconPath() {
        return "icons/reparticion.png";
    }
}
