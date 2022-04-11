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
public class Contratos {
    private static Contratos instance;
    private HashMap<Integer, Contrato> contratos;
    private int mayorId;
    
    private Contratos() {
        contratos = new HashMap<>();
    }
    
    public static Contratos get() {
        if (instance == null) {
            instance = new Contratos();
        }
        return instance;
    }
    
    public Contrato get(int id) {
        if (contratos.containsKey(id)) {
            return contratos.get(id);
        }
        return null;
    }
    
    public ArrayList<Integer> getIDs() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : contratos.keySet()) {
            list.add(key);
        }
        return list;
    }
    
    public ArrayList<Integer> getIDsByIdTrabajador(int idTrabajador) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Contrato c : contratos.values()) {
            if (c.getIdTrabajador() == idTrabajador) {
                list.add(c.getId());
            }
        }
        return list;
    }
    
    public ArrayList<Integer> getIDsByIdReparticion(int idReparticion) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Contrato c : contratos.values()) {
            if (c.getIdReparticion() == idReparticion) {
                list.add(c.getId());
            }
        }
        return list;
    }
    
    public boolean add(Contrato c) {
        // Si agregamos uno con id < 0, auto asignar la mayor posible
        if (c.getId() < 0) { c.setId(mayorId + 1); }
        
        // Intentar agregar si ya no esta
        Contrato prev = contratos.putIfAbsent(c.getId(), c);
        if (prev == null) {
            if (c.getId() > mayorId) {
                mayorId = c.getId();
            }
            return true;
        }
        return false;
    }
    
    public Contrato remove(int id) {
        if (contratos.containsKey(id)) {
            return contratos.remove(id);
        }
        return null;
    }
    
    public boolean remove(int idTrabajador, int idReparticion) {
        boolean found = false;
        for(int idContrato : getIDsByIdTrabajador(idTrabajador)) {
            Contrato c = get(idContrato);
            if (c.getIdReparticion() == idReparticion) {
                contratos.remove(c.getId());
                found = true;
            }
        }
        return found;
    }
    
    public boolean removeByIdTrabajador(int id) {
        boolean found = false;
        for(int idContrato : getIDs()) {
            Contrato c = get(idContrato);
            if (c.getIdTrabajador() == id) {
                found = true;
                contratos.remove(idContrato);
            }
        }
        return found;
    }
    
    public boolean removeByIdReparticion(int id) {
        boolean found = false;
        for(int idContrato : getIDs()) {
            Contrato c = get(idContrato);
            if (c.getIdReparticion() == id) {
                found = true;
                contratos.remove(idContrato);
            }
        }
        return found;
    }
    
    public int getMayorId() {
        return this.mayorId;
    }
}
