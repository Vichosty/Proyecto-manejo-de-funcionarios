
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
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
        /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(new Trabajador(0, "Jorge", "Botarro", dateFormat.parse("09/10/1997")));
        trabajadores.add(new Trabajador(1, "Juan", "Perez", dateFormat.parse("15/04/1995")));
        trabajadores.add(new Trabajador(2, "Pablo", "Morales", dateFormat.parse("19/11/1993")));
        
        Reparticion[] reparticiones = new Reparticion[2];
        reparticiones[0] = new Reparticion(0, "Reparticion A");
        // TODO: Replace this with an addTrabajador() function that automatically
        // looks up the id, etc.
        reparticiones[0].getTrabajadores().add(trabajadores.get(0).getId());
        
        reparticiones[1] = new Reparticion(1, "Reparticion B");
        reparticiones[1].getTrabajadores().add(trabajadores.get(1).getId());
        reparticiones[1].getTrabajadores().add(trabajadores.get(2).getId());
        
        // TODO: add trabajadores to it' sown class so we can then search by id or by name
        // or something like that.
        
        // TODO: use reparticiones[i] for something...
        */
        
        // Create a database connection
        
        try {
            String conURL = "jdbc:mysql://localhost:3306/chk_test";
            String conUser = "chkP";
            String conPass = "8heeArhoqm3G";
            Connection connection = DriverManager.getConnection(conURL, conUser, conPass);
            
            // Get some users
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from trabajadores");
            ArrayList<Trabajador> trabajadores = new ArrayList<>();
            while(results.next())
            {
                int id = results.getInt(1);
                String nombre = results.getString(2);
                String apellido = results.getString(3);
                Date fechaDeNacimiento = results.getTimestamp(4);
                trabajadores.add(new Trabajador(id, nombre, apellido, fechaDeNacimiento));
            }
            connection.close();
            
            for(Trabajador trabajador : trabajadores)
            {
                System.out.println(trabajador.getNombre());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
