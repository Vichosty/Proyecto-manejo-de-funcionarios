
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * lol
 * @author Vichosty
 */
public class Prueba {
    public static void main (String[] args) throws SQLException {
        Gobierno gobierno = new Gobierno();
        
        // Create a database connection
        try {
            String conURL = "jdbc:mysql://localhost:3306/chk_test";
            String conUser = "chkP";
            String conPass = "8heeArhoqm3G";
            
            Connection connection = DriverManager.getConnection(conURL, conUser, conPass);
            
            // bd -> trabajadores
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from trabajadores");
            while(results.next())
            {
                int id = results.getInt("id");
                String nombre = results.getString("nombre");
                String apellido = results.getString("apellido");
                Date fechaDeNacimiento = results.getTimestamp("fechaDeNacimiento");
                
                gobierno.addTrabajador(new Trabajador(id, nombre, apellido, fechaDeNacimiento));
            }
            statement.close();
            
            // bd -> reparticiones
            statement = connection.createStatement();
            results = statement.executeQuery("select * from reparticiones");
            while(results.next())
            {
                int id = results.getInt("id");
                String nombre = results.getString("nombre");
                String estado = results.getString("estado");
                
                gobierno.addReparticion(new Reparticion(id, nombre, estado));
            }
            statement.close();
            
            // TODO: falta una tabla que contenga todas las relaciones
            // trabajador -> reparticion, para poder deducir a que
            // reparticion(es) pertenece cada trabajador. (util para cuando un
            // trabajador pertenezca a multiples reparticiones)
            
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Reparticiones:");
        for(Reparticion reparticion : gobierno.getReparticiones())
        {
            System.out.println("\t" + reparticion.getNombre());
        }
        
        System.out.println("Trabajadores:");
        for(Trabajador trabajador : gobierno.getTrabajadores())
        {
            System.out.println("\t" + trabajador.getNombre());
        }
    }
}
