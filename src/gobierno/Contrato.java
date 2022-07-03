/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobierno;

/**
 *
 * @author chkp
 */
public class Contrato {

    private int id;
    private int idTrabajador;
    private int idReparticion;

    public Contrato() {
        this.id = -1;
        this.idTrabajador = -1;
        this.idReparticion = -1;
    }

    public Contrato(int id, int idTrabajador, int idReparticion) {
        this.id = id;
        this.idTrabajador = idTrabajador;
        this.idReparticion = idReparticion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public int getIdReparticion() {
        return idReparticion;
    }

    @Override
    public String toString() {
        // TODO: busca los nombres de los elementos involucrados en el contrato.
        return "Contrato{" + "id=" + id + ", idTrabajador=" + idTrabajador + ", idReparticion=" + idReparticion + '}';
    }

    public static String getIconPath() {
        return "icons/contract.png";
    }
}
