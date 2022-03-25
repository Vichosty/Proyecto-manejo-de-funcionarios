
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
    private List<Integer> trabajadores;
    private EstadoReparticion estado;
    
    public Reparticion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.trabajadores = new ArrayList<>();
    }

    public Reparticion(int id, String nombre, List<Integer> trabajadores) {
        this(id, nombre);
        
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
