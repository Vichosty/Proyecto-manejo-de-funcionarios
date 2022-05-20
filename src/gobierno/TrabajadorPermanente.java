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
public final class TrabajadorPermanente extends Trabajador {
    
    public TrabajadorPermanente(int id, String nombre, String apellido, Genero genero, Date fechaDeNacimiento) {
        super(id, nombre, apellido, genero, fechaDeNacimiento);
    }
    
    @Override public String getTipo() {
        return "Permanente";
    }
}
