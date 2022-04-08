package gobierno;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 * @author chkp
 */
public final class Trabajador {

    private int id;
    private String nombre;
    private String apellido;
    private String fechaDeNacimientoAsString;
    private Date fechaDeNacimiento;

    public Trabajador() {
        this.id = -1;
        this.nombre = "Nombre";
        this.apellido = "Apellido";
        setFechaDeNacimiento(new Date(System.currentTimeMillis()));
    }

    public Trabajador(int id, String nombre, String apellido, Date fechaDeNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        setFechaDeNacimiento(fechaDeNacimiento);
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

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaDeNacimientoAsString() {
        return fechaDeNacimientoAsString;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        if (fechaDeNacimiento != null) {
            this.fechaDeNacimiento = fechaDeNacimiento;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaDeNacimientoAsString = df.format(this.fechaDeNacimiento);
        }
    }
    
    public static String getIconPath() {
        return "icons/trabajador.png";
    }
}
