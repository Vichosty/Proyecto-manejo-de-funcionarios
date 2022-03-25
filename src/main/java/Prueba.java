
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
    public static void main (String[] args) throws ParseException, SQLException {
        Gobierno gobierno = new Gobierno();
        
        // Create a database connection
        try {
            String conURL = "jdbc:mysql://localhost:3306/chk_test";
            String conUser = "chkP";
            String conPass = "8heeArhoqm3G";
            Connection connection = DriverManager.getConnection(conURL, conUser, conPass);
            
            // Get some users
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from trabajadores");
            while(results.next())
            {
                int id = results.getInt(1);
                String nombre = results.getString(2);
                String apellido = results.getString(3);
                Date fechaDeNacimiento = results.getTimestamp(4);
                gobierno.addTrabajador(new Trabajador(id, nombre, apellido, fechaDeNacimiento));
            }
            connection.close();
            
            for(Trabajador trabajador : gobierno.getTrabajadores())
            {
                System.out.println(trabajador.getNombre());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
