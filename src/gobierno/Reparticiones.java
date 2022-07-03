/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobierno;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chkp
 */
public class Reparticiones implements Imprimible {
    private static Reparticiones instance;
    private final HashMap<Integer, Reparticion> reparticiones;
    private int mayorId;
    
    private Reparticiones() {
        reparticiones = new HashMap<>();
    }
    
    public static Reparticiones get() {
        if (instance == null) {
            instance = new Reparticiones();
        }
        return instance;
    }
    
    public Reparticion get(int id) {
        if (reparticiones.containsKey(id)) {
            return reparticiones.get(id);
        }
        return null;
    }
    
    /**
    * Retorna una lista con las IDs de todas las Reparticiones.
    */
    public ArrayList<Integer> getIDs() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : reparticiones.keySet()) {
            list.add(key);
        }
        return list;
    }
    
    /**
    * Retorna una lista con las IDs de todas las Reparticiones sin Trabajadores.
    */
    public ArrayList<Integer> getIDsSinTrabajadores() {
        ArrayList<Integer> list = new ArrayList<>();
        Contratos cs = Contratos.get();
        for(Reparticion r : reparticiones.values()) {
            if (!cs.getIDsByIdReparticion(r.getId()).isEmpty()) { continue; }
            list.add(r.getId());
        }
        return list;
    }
    
    /**
    * Agrega una nueva reparticion. En caso que este tenga ID negativa, se le
    * asigna automaticamente una nueva que no se encuentre en uso.
    */
    public boolean add(Reparticion r) {
        // Si agregamos uno con id < 0, auto asignar la mayor posible
        if (r.getId() < 0) { r.setId(mayorId + 1); }
        
        // Intentar agregar si ya no esta
        Reparticion prev = reparticiones.putIfAbsent(r.getId(), r);
        if (prev == null) {
            if (r.getId() > mayorId) {
                mayorId = r.getId();
            }
            return true;
        }
        return false;
    }
    
    /**
    * Elimina la primera reparticion que tenga la ID entregada.
    */
    public Reparticion remove(int id) {
        if (reparticiones.containsKey(id)) {
            // Remover todos los contratos que continenen a esta reparticion
            Contratos cs = Contratos.get();
            cs.removeByIdReparticion(id);
            return reparticiones.remove(id);
        }
        return null;
    }
    
    /**
    * Si existe una reparticion con la ID entregada, a esta se le cambia el 
    * nombre por el entregado.
    */
    public boolean modify(int id, String nombre) {
        if (this.reparticiones.containsKey(id)) {
            Reparticion orig = reparticiones.get(id);
            orig.setNombre(nombre);
            return true;
        }
        return false;
    }
    
    /**
    * Si existe una reparticion con la ID entregada, a esta se le cambia el
    * nombre por el de la reparticion entregada por parametro.
    */
    public boolean modify(int id, Reparticion r) {
        if (r != null) {
            return modify(id, r.getNombre());
        }
        return false;
    }
    
    /**
    * Retorna una lista de IDs de reparticion, conteniendo todas las que 
    * tengan el mismo nombre, ignorando mayusculas.
    */
    public ArrayList<Integer> findByName(String nombre) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Reparticion r : reparticiones.values()) {
            if (r.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                list.add(r.getId());
            }
        }
        return list;
    }
    
    public int getMayorId() {
        return this.mayorId;
    }

    @Override
    public void imprimir(StringBuilder sb) {
        sb.append("[Reparticiones]:\n");
        for(int reparticionId : this.getIDs()) {
            Reparticion r = this.get(reparticionId);
            sb.append("\t").append(r.getNombre()).append(":\n");
            for(int tIndex = 0; tIndex < r.getNumTrabajadores(); ++tIndex) {
                Trabajador t = r.getTrabajador(tIndex);
                sb.append("\t\t");
                t.imprimir(sb);
            }
        }
        sb.append('\n');
    }
}
