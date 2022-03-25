
import java.util.ArrayList;
import java.util.List;

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
    private List<Integer> trabajadores;
    
    public Reparticion(int id, String nombre, EstadoReparticion estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.trabajadores = new ArrayList<>();
    }
    
    public Reparticion(int id, String nombre, String estadoString) {
        EstadoReparticion estado = EstadoReparticion.Normal;
        if (estadoString.compareToIgnoreCase("deficit") == 0) {
            estado = EstadoReparticion.Deficit;
        } else if (estadoString.compareToIgnoreCase("superavit") == 0) {
            estado = EstadoReparticion.Superavit;
        }
        
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.trabajadores = new ArrayList<>();
    }
    
    public Reparticion(int id, String nombre, EstadoReparticion estado, List<Integer> trabajadores) {
        this(id, nombre, estado);
        
        for(int i = 0; i < trabajadores.size(); ++i)
        {
            this.trabajadores.add(trabajadores.get(i));
        }
    }
    
    public Reparticion(int id, String nombre, String estadoString, List<Integer> trabajadores) {
        this(id, nombre, estadoString);
        
        for(int i = 0; i < trabajadores.size(); ++i)
        {
            this.trabajadores.add(trabajadores.get(i));
        }
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
    
    public List<Integer> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Integer> trabajadores) {
        this.trabajadores = trabajadores;
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
}
