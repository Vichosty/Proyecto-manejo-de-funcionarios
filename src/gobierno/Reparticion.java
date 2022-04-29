/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobierno;

import java.util.ArrayList;

/**
 *
 * @author chkp
 */
public class Reparticion {

    private int id;
    private String nombre;
    private EstadoReparticion estado;
    private ArrayList<Integer> idsTrabajadores;

    @Override
    public String toString() {
        return nombre;
    }

    public Reparticion() {
        this.id = -1;
        this.nombre = "Nombre";
        this.estado = EstadoReparticion.Normal;
        this.idsTrabajadores = new ArrayList<>();
    }

    public Reparticion(int id, String nombre, EstadoReparticion estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.idsTrabajadores = new ArrayList<>();
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

    public ArrayList<Integer> getIdsTrabajadores() {
        ArrayList<Integer> result = new ArrayList<>();
        for(int idTrabajador : idsTrabajadores) { result.add(idTrabajador); }
        return(result);
    }
    
    // Agrega una referencia a un trabajador en la lista de ids
    // Sin crear un nuevo contrato (usado por Contratos para agregar una referencia)
    public boolean addTrabajadorRef(int id) {
        // Chequear si ya esta en la lista
        for(int idTrabajador : idsTrabajadores) {
            if (idTrabajador == id) { return(false); }
        }
        
        return(idsTrabajadores.add(id));
    }
    
    public int findTrabajadorId(String nombre) {
        Trabajadores ts = Trabajadores.get();
        for (int trabajadorId : idsTrabajadores) {
            Trabajador t = ts.get(trabajadorId);
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                return(t.getId());
            }
        }
        
        return(-1);
    }
    
    public boolean removeTrabajadorById(int id) {
        Contratos cs = Contratos.get();
        
        ArrayList<Integer> found = new ArrayList<>();
        if (cs.remove(id, getId())) {
            // Removido con exito de los contratos, remover de aca tambien
            for(int idTrabajador : idsTrabajadores) {
                if (idTrabajador == id) { found.add(idTrabajador); }
            }
        }
        
        return(idsTrabajadores.removeAll(found));
    }
    
    public boolean removeAll() {
        if (idsTrabajadores.isEmpty()) { return(false); }
        
        idsTrabajadores.clear();
        return(true);
    }
    
    public EstadoReparticion getEstado() {
        // Check if we're in an anormal state, then return that.

        /*
         * if (are_we_in_deficit()) { this.estado = EstadoReparticion.Deficit; }
         * else if (are_we_in_superavit()) { this.estado =
         * EstadoReparticion.Superavit; } else { this.estado =
         * EstadoReparticion.Normal; }
         */
        return estado;
    }

    // TODO: findTrabajador, etc. (para no tener que usar directamente al gobierno.)
    
    public static String getIconPath() {
        return "icons/reparticion.png";
    }
}
