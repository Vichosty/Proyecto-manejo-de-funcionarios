/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gobierno;

import java.util.Date;

/**
 *
 * @author chk
 */
public final class TrabajadorTemporero extends Trabajador {

    private Date fechaTerminoDeContrato;

    public TrabajadorTemporero() {
        super();
    }

    public TrabajadorTemporero(int id, String nombre, String apellido, Genero genero, Date fechaDeNacimiento, Date fechaTerminoContrato) {
        super(id, nombre, apellido, genero, fechaDeNacimiento);
        fechaTerminoContrato = fechaTerminoContrato;
    }

    @Override
    public String getTipo() {
        return "Temporero";
    }

    public static String getIconPath() {
        return "icons/employee.png";
    }
}
