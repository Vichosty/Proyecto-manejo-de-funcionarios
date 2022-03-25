
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chkp
 */
public class Gobierno {
    final private Map<Integer, Reparticion> reparticiones;
    final private Map<Integer, Trabajador> trabajadores;

    public Gobierno() {
        reparticiones = new HashMap<>();
        trabajadores = new HashMap<>();
    }

    // Reparticion
    // <editor-fold defaultstate="collapsed" desc="Reparticion">
    public Reparticion getReparticion(int id) {
        if (reparticiones.containsKey(id)) {
            return reparticiones.get(id);
        }
        return null;
    }
    
    public Collection<Reparticion> getReparticiones() {
        return reparticiones.values();
    }
    
    public boolean addReparticion(Reparticion reparticion)
    {
        // Intentar agregar la reparticion al mapa, pero solo si la id no esta en uso.
        Reparticion anterior = reparticiones.putIfAbsent(reparticion.getId(), reparticion);
        // Si anterior tiene un valor, entonces trabajador.id ya existe en trabajadores
        if (anterior != null) { return false; }
        // Sino, entonces estaba vacio antes.
        return true;
    }
    
    public Reparticion removeReparticion(int id)
    {
        if (reparticiones.containsKey(id))
        {
            return reparticiones.remove(id);
        }
        return null;
    }
    // </editor-fold>

    // Trabajador
    // <editor-fold defaultstate="collapsed" desc="Trabajador">
    public Trabajador getTrabajador(int id) {
        if (trabajadores.containsKey(id)) {
            return trabajadores.get(id);
        }
        return null;
    }
    
    public Collection<Trabajador> getTrabajadores() {
        return trabajadores.values();
    }
     
    public boolean addTrabajador(Trabajador trabajador)
    {
        // Intentar agregar el trabajador al mapa, pero solo si la id no esta en uso.
        Trabajador anterior = trabajadores.putIfAbsent(trabajador.getId(), trabajador);
        // Si anterior tiene un valor, entonces trabajador.id ya existe en trabajadores
        if (anterior != null) { return false; }
        // Sino, entonces estaba vacio antes.
        return(true);
    }
    
    public Trabajador removeTrabajador(int id)
    {
        if (trabajadores.containsKey(id))
        {
            return trabajadores.remove(id);
        }
        return null;
    }
    // </editor-fold>
}
