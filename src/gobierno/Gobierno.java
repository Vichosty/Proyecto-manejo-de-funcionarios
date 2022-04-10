package gobierno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 * @author chkp
 */
public class Gobierno {

    final private HashMap<Integer, Reparticion> reparticiones;
    final private HashMap<Integer, Trabajador> trabajadores;
    final private HashMap<Integer, ArrayList<Contrato>> contratos;
    private int mayorIdTrabajador;
    private int mayorIdReparticion;
    private int mayorIdContrato;

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

    public boolean addReparticion(Reparticion reparticion) {
        // Intentar agregar la reparticion al mapa, pero solo si la id no esta en uso.
        Reparticion anterior = reparticiones.putIfAbsent(reparticion.getId(), reparticion);
        // Si anterior tiene un valor, entonces trabajador.id ya existe en trabajadores
        if (anterior != null) {
            return false;
        } else {
            // Chequeamos si la id ingresada es la mayor hasta ahora.
            if (reparticion.getId() > this.mayorIdReparticion) {
                this.mayorIdReparticion = reparticion.getId();
            }
        }
        // Sino, entonces estaba vacio antes.
        return true;
    }

    public Reparticion removeReparticion(int id) {
        if (reparticiones.containsKey(id)) {
            // Remover todos los contratos que continenen a esta reparticion
            for (List<Contrato> lc : getContratos()) {
                ListIterator iter = lc.listIterator();
                while (iter.hasNext()) {
                    Contrato c = (Contrato) iter.next();
                    if (c.getIdReparticion() == id) {
                        iter.remove();
                    }
                }
            }

            return reparticiones.remove(id);
        }
        return null;
    }

    public boolean renameReparticion(int id, String newName) {
        Reparticion r = getReparticion(id);
        if (r != null) {
            r.setNombre(newName);
            return true;
        }
        return false;
    }

    public boolean replaceReparticion(int id, Reparticion reparticion) {
        if (!this.reparticiones.containsKey(id)) {
            return false;
        }

        if (reparticion != null) {
            this.trabajadores.get(id).setNombre(reparticion.getNombre());
            return true;
        }
        return false;
    }

    public int getMayorIdReparticion() {
        return this.mayorIdReparticion;
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

    public ArrayList<Trabajador> getTrabajadoresEnReparticion(int idReparticion) {
        ArrayList<Trabajador> resultado = new ArrayList<>();
        for (List<Contrato> listaContratos : contratos.values()) {
            for (Contrato c : listaContratos) {
                if (c.getIdReparticion() == idReparticion) {
                    resultado.add(getTrabajador(c.getIdTrabajador()));
                }
            }
        }
        return resultado;
    }

    public ArrayList<Trabajador> getTrabajadoresSinReparticion() {
        ArrayList<Trabajador> resultado = new ArrayList<>();
        for (Trabajador t : getTrabajadores()) {
            List<Contrato> lc = getContratosDeTrabajador(t.getId());
            if (lc.isEmpty()) {
                resultado.add(t);
            }
        }
        return resultado;
    }

    public boolean addTrabajador(Trabajador trabajador) {
        // Intentar agregar el trabajador al mapa, pero solo si la id no esta en uso.
        Trabajador anterior = trabajadores.putIfAbsent(trabajador.getId(), trabajador);
        // Si anterior tiene un valor, entonces trabajador.id ya existe en trabajadores
        if (anterior != null) {
            return false;
        } else {
            // Chequeamos si la id ingresada es la mayor hasta ahora.
            if (trabajador.getId() > this.mayorIdTrabajador) {
                this.mayorIdTrabajador = trabajador.getId();
            }
        }
        // Sino, entonces estaba vacio antes.
        return (true);
    }

    public Trabajador removeTrabajador(int id) {
        if (trabajadores.containsKey(id)) {
            // Remover todos los contratos que continenen a este trabajador
            for (ArrayList<Contrato> lc : getContratos()) {
                ListIterator iter = lc.listIterator();
                while (iter.hasNext()) {
                    Contrato c = (Contrato) iter.next();
                    if (c.getIdTrabajador() == id) {
                        iter.remove();
                    }
                }
            }

            return trabajadores.remove(id);
        }
        return null;
    }

    public boolean replaceTrabajador(int id, Trabajador trabajador) {
        if (!this.trabajadores.containsKey(id)) {
            return false;
        }

        if (trabajador != null) {
            this.trabajadores.get(id).setNombre(trabajador.getNombre());
            this.trabajadores.get(id).setApellido(trabajador.getApellido());
            this.trabajadores.get(id).setFechaDeNacimiento(trabajador.getFechaDeNacimiento());
            return true;
        }
        return false;
    }

    public int getMayorIdTrabajador() {
        return this.mayorIdTrabajador;
    }
    // </editor-fold>

    // Contratos
    // <editor-fold defaultstate="collapsed" desc="Contratos">
    public Contrato getContrato(int idTrabajador, int idReparticion) {
        if (contratos.containsKey(idTrabajador)) {
            for (Contrato c : contratos.get(idTrabajador)) {
                if (c.getIdReparticion() == idReparticion) {
                    return c;
                }
            }
        }
        return null;
    }

    public ArrayList<Contrato> getContratosDeTrabajador(int idTrabajador) {
        ArrayList<Contrato> resultado = new ArrayList<>();

        for (ArrayList<Contrato> lc : contratos.values()) {
            for (Contrato c : lc) {
                if (c.getIdTrabajador() == idTrabajador) {
                    resultado.add(c);
                }
            }
        }

        return resultado;
    }

    public Collection<ArrayList<Contrato>> getContratos() {
        return contratos.values();
    }

    public boolean addContrato(Contrato contrato) {
        if (contratos.containsKey(contrato.getIdTrabajador())) {
            // La lista ya existe, agrega al final, pero solo si la reparticion no esta previamente
            List<Contrato> listaContratos = contratos.get(contrato.getIdTrabajador());
            for (Contrato c : listaContratos) {
                if (c.getIdReparticion() == contrato.getIdReparticion()) {
                    return false;
                }
            }
            listaContratos.add(contrato);
        } else {
            // La lista no existe, crea una nueva, agrega el contrato y retorna
            ArrayList<Contrato> listaContratos = new ArrayList<>();
            listaContratos.add(contrato);
            contratos.put(contrato.getIdTrabajador(), listaContratos);
        }

        if (contrato.getId() > this.mayorIdContrato) {
            this.mayorIdContrato = contrato.getId();
        }
        return true;
    }

    public Contrato removeContrato(int idTrabajador, int idReparticion) {
        if (contratos.containsKey(idTrabajador)) {
            ArrayList<Contrato> listaContratos = contratos.get(idTrabajador);
            Contrato found = null;
            for (Contrato c : listaContratos) {
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

    public int getMayorIdContrato() {
        return this.mayorIdContrato;
    }
    // </editor-fold>

    
    public static void print(gobierno.Trabajador t) {
        System.out.println("\t" + t.getNombre() + " " + t.getApellido());
    }

    public static void print(gobierno.Reparticion r) {
        System.out.println("\t" + r.getNombre());
    }

    public static void print(gobierno.Gobierno gob, gobierno.Contrato c) {
        gobierno.Trabajador t = gob.getTrabajador(c.getIdTrabajador());
        gobierno.Reparticion r = gob.getReparticion(c.getIdReparticion());
        System.out.println("\t" + t.getNombre() + " -> " + r.getNombre());
    }

    public static void printAll(gobierno.Gobierno gob, boolean printContratos) {
        // Mostrar valores en consola para probar.
        System.out.println("================================================");
        System.out.println("Reparticiones:");
        for (gobierno.Reparticion r : gob.getReparticiones()) {
            print(r);
        }

        System.out.println("Trabajadores:");
        for (gobierno.Trabajador t : gob.getTrabajadores()) {
            print(t);
        }

        if (printContratos) {
            System.out.println("Contratos:");
            for (List<gobierno.Contrato> listasDeContratos : gob.getContratos()) {
                for (gobierno.Contrato c : listasDeContratos) {
                    print(gob, c);
                }
            }
        }
        System.out.println("================================================");
    }
    
    public static String getIconPath() {
        return "icons/gobierno.png";
    }
}
