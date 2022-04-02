package gobierno;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    final private Map<Integer, List<Contrato>> contratos;

    public Gobierno() {
        reparticiones = new HashMap<>();
        trabajadores = new HashMap<>();
        contratos = new HashMap<>();
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
    
    public Set<Integer> getReparticionesIds() {
        return reparticiones.keySet();
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
    
    public List<Trabajador> getTrabajadoresEnReparticion(int idReparticion) {
        List<Trabajador> resultado = new ArrayList<>();
        for(List<Contrato> listaContratos : contratos.values()) {
            for (Contrato c : listaContratos) {
                if (c.getIdReparticion() == idReparticion) {
                    resultado.add(getTrabajador(c.getIdTrabajador()));
                }
            }
        }
        return resultado;
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
    
    // Contratos
    // <editor-fold defaultstate="collapsed" desc="Contratos">
    public Contrato getContrato(int idTrabajador, int idReparticion) {
        if (contratos.containsKey(idTrabajador)) {
            for(Contrato c : contratos.get(idTrabajador)) {
                if (c.getIdReparticion() == idReparticion) {
                    return c;
                }
            }
        }
        return null;
    }
    
    public Collection<List<Contrato>> getContratos() {
        return contratos.values();
    }
    
    public boolean addContrato(Contrato contrato)
    {
        if (contratos.containsKey(contrato.getIdTrabajador())) {
            // La lista ya existe, agrega al final, pero solo si la reparticion no esta previamente
            List<Contrato> listaContratos = contratos.get(contrato.getIdTrabajador());
            for(Contrato c : listaContratos) {
                if (c.getIdReparticion() == contrato.getIdReparticion()) {
                    return false;
                }
            }
            listaContratos.add(contrato);
            return true;
        } else {
            // La lista no existe, crea una nueva, agrega el contrato y retorna
            List<Contrato> listaContratos = new ArrayList<>();
            listaContratos.add(contrato);
            contratos.put(contrato.getIdTrabajador(), listaContratos);
            return true;
        }
    }
    
    public Contrato removeContrato(int idTrabajador, int idReparticion)
    {
        if (contratos.containsKey(idTrabajador))
        {
            List<Contrato> listaContratos = contratos.get(idTrabajador);
            Contrato found = null;
            for(Contrato c : listaContratos) {
                if (c.getIdReparticion() == idReparticion) {
                    found = c;
                    break;
                }
            }
            if (found != null) {
                listaContratos.remove(found);
                return found;
            }
        }
        return null;
    }
    // </editor-fold>
}
