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
public class Contratos implements Imprimible {

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

    /**
     * Retorna una lista con las IDs de todos los Contratos.
     */
    public ArrayList<Integer> getIDs() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : contratos.keySet()) {
            list.add(key);
        }
        return list;
    }

    /**
     * Retorna una lista con las IDs de todos los Contratos pertenecientes al
     * Trabajador cuya ID corresponda al parametro idTrabajador.
     */
    public ArrayList<Integer> getIDsByIdTrabajador(int idTrabajador) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Contrato c : contratos.values()) {
            if (c.getIdTrabajador() == idTrabajador) {
                list.add(c.getId());
            }
        }
        return list;
    }

    /**
     * Retorna una lista con las IDs de todos los contratos pertenecientes a la
     * Reparticion con ID idReparticion.
     */
    public ArrayList<Integer> getIDsByIdReparticion(int idReparticion) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Contrato c : contratos.values()) {
            if (c.getIdReparticion() == idReparticion) {
                list.add(c.getId());
            }
        }
        return list;
    }

    /**
     * Agrega un nuevo contrato. En caso que este tenga ID negativa, se le
     * asigna automaticamente una nueva que no se encuentre en uso.
     */
    public boolean add(Contrato c) {
        // Si agregamos uno con id < 0, auto asignar la mayor posible
        if (c.getId() < 0) {
            c.setId(mayorId + 1);
        }

        // Intentar agregar si ya no esta
        Contrato prev = contratos.putIfAbsent(c.getId(), c);
        if (prev == null) {
            if (c.getId() > mayorId) {
                mayorId = c.getId();
            }

            // Al agregar, tambien agregar en la respectiva Reparticion
            Reparticion r = Reparticiones.get().get(c.getIdReparticion());
            r.addTrabajadorRef(c.getIdTrabajador());

            return true;
        }
        return false;
    }

    /**
     * Elimina el primer contrato que tenga la ID entregada.
     */
    public Contrato remove(int id) {
        if (contratos.containsKey(id)) {
            Contrato c = get(id);

            // Remover el trabajador de la reparticion
            Reparticion r = Reparticiones.get().get(c.getIdReparticion());
            r.removeTrabajadorById(c.getIdTrabajador(), true);

            return contratos.remove(id);
        }
        return null;
    }

    /**
     * Elimina el primer contrato cuyo par Trabajador/Reparticion sea igual a
     * los provistos.
     */
    public boolean remove(int idTrabajador, int idReparticion) {
        boolean found = false;
        for (int idContrato : getIDsByIdTrabajador(idTrabajador)) {
            Contrato c = get(idContrato);
            if (c.getIdReparticion() == idReparticion) {
                // Remover el trabajador de la reparticion
                Reparticion r = Reparticiones.get().get(c.getIdReparticion());
                r.removeTrabajadorById(c.getIdTrabajador(), false);

                contratos.remove(c.getId());
                found = true;
            }
        }
        return found;
    }

    /**
     * Remueve todos los contratos cuyo Trabajador corresponde a la ID
     * entregada.
     */
    public boolean removeByIdTrabajador(int id) {
        boolean found = false;
        for (int idContrato : getIDs()) {
            Contrato c = get(idContrato);
            if (c.getIdTrabajador() == id) {
                found = true;

                // Remover el trabajador de la reparticion
                Reparticion r = Reparticiones.get().get(c.getIdReparticion());
                r.removeTrabajadorById(c.getIdTrabajador(), true);

                contratos.remove(idContrato);
            }
        }
        return found;
    }

    /**
     * Remueve todos los contratos cuya Reparticion corresponda a la ID
     * entregada.
     */
    public boolean removeByIdReparticion(int id) {
        boolean found = false;
        for (int idContrato : getIDs()) {
            Contrato c = get(idContrato);
            if (c.getIdReparticion() == id) {
                found = true;
                contratos.remove(idContrato);
            }
        }

        Reparticion r = Reparticiones.get().get(id);
        if (r != null) {
            r.removeAll();
        }

        return found;
    }

    public int getMayorId() {
        return this.mayorId;
    }

    @Override
    public void imprimir(StringBuilder sb) {
        Trabajadores ts = Trabajadores.get();
        Reparticiones rs = Reparticiones.get();

        sb.append("[Contratos]:\n");
        for (int contratoId : this.getIDs()) {
            Contrato c = this.get(contratoId);
            Trabajador t = ts.get(c.getIdTrabajador());
            Reparticion r = rs.get(c.getIdReparticion());
            sb.append("\t- [").append(c.getIdTrabajador()).append("]")
                    .append(t.getNombreCompleto())
                    .append(" => [").append(c.getIdReparticion()).append("]")
                    .append(r.getNombre())
                    .append("\n");
        }
        sb.append('\n');
    }
}
