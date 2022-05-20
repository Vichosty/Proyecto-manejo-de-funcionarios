/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gobierno;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author chkp
 */
public abstract class Trabajador {

    private int id;
    private String nombre;
    private String apellido;
    private String fechaDeNacimientoAsString;
    private Date fechaDeNacimiento;
    private Genero genero;
    
    public Trabajador() {
        setId(-1);
        setNombre("Nombre");
        setApellido("Apellido");
        setFechaDeNacimiento(new Date(System.currentTimeMillis()));
        setGenero(Genero.Desconocido);
    }

    public Trabajador(int id, String nombre, String apellido, Genero genero, Date fechaDeNacimiento) {
        setId(id);
        setNombre(nombre);
        setApellido(apellido);
        setFechaDeNacimiento(fechaDeNacimiento);
        setGenero(genero);
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
    
    public String getGeneroAsString() {
        return genero.toString();
    }
    
    public Genero getGenero(){
        if (genero == null){
            setGenero(Genero.Desconocido);
        }
        return genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public String getTipo() {
        return "Trabajador";
    }
    
    public static String getIconPath() {
        return "icons/employee.png";
    }
}
