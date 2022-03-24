
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

    public List<Integer> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Integer> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
