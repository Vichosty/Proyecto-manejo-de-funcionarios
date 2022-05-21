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
public class Trabajadores implements Imprimible {
    private static Trabajadores instance;
    private final HashMap<Integer, Trabajador> trabajadores;
    private int mayorId;
    
    private Trabajadores() {
        trabajadores = new HashMap<>();
    }
    
    public static Trabajadores get() {
        if (instance == null) {
            instance = new Trabajadores();
        }
        return instance;
    }
    
    public Trabajador get(int id) {
        if (trabajadores.containsKey(id)) {
            return trabajadores.get(id);
        }
        return null;
    }
    
    public ArrayList<Integer> getIDs() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : trabajadores.keySet()) {
            list.add(key);
        }
        return list;
    }
    
    public ArrayList<Integer> getIDsSinReparticion() {
        ArrayList<Integer> list = new ArrayList<>();
        Contratos cs = Contratos.get();
        for(Trabajador t : trabajadores.values()) {
            if (!cs.getIDsByIdTrabajador(t.getId()).isEmpty()) { continue; }
            list.add(t.getId());
        }
        return list;
    }
    
    public boolean add(Trabajador t) {
        // Si agregamos uno con id < 0, auto asignar la mayor posible
        if (t.getId() < 0) { t.setId(mayorId + 1); }
        
        // Intentar agregar si ya no esta
        Trabajador prev = trabajadores.putIfAbsent(t.getId(), t);
        if (prev == null) {
            if (t.getId() > mayorId) {
                mayorId = t.getId();
            }
            return true;
        }
        return false;
    }
    
    public Trabajador remove(int id) {
        if (trabajadores.containsKey(id)) {
            // Remover todos los contratos que continenen a este trabajador
            Contratos cs = Contratos.get();
            cs.removeByIdTrabajador(id);
            return trabajadores.remove(id);
        }
        return null;
    }
    
    public boolean modify(int id, String nombre, String apellido, java.util.Date fechaDeNacimiento, Genero genero) {
        if (this.trabajadores.containsKey(id)) {
            Trabajador orig = trabajadores.get(id);
            orig.setNombre(nombre);
            orig.setApellido(apellido);
            orig.setFechaDeNacimiento(fechaDeNacimiento);
            orig.setGenero(genero);
            return true;
        }
        return false;
    }
    
    public boolean modify(int id, Trabajador t) {
        if (t != null) {
            return modify(id, t.getNombre(), t.getApellido(), t.getFechaDeNacimiento(),t.getGenero());
        }
        return false;
    }
    
    public ArrayList<Integer> findByName(String nombre) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Trabajador t : trabajadores.values()) {
            if (t.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                list.add(t.getId());
            }
        }
        return list;
    }
    
    public int getMayorId() {
        return this.mayorId;
    }

    @Override
    public void imprimir(StringBuilder sb) {
        sb.append("[Sin Reparticion]:\n");
        for(int trabajadorId: this.getIDsSinReparticion()) {
            Trabajador t = this.get(trabajadorId);
            sb.append('\t');
            t.imprimir(sb);
        }
        sb.append('\n');
    }
}
