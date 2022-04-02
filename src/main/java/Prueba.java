
import chk.chkui.EnumerateUsers;
import gobierno.Contrato;
import gobierno.EstadoReparticion;
import gobierno.Gobierno;
import gobierno.Reparticion;
import gobierno.Trabajador;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 * lol
 *
 * @author Vichosty
 */
public class Prueba {
    public static void main(String[] args) throws SQLException {
        Gobierno gobierno = new Gobierno();

        /*
        // Create a database connection
        try {
            String conURL = "jdbc:mysql://localhost:3306/chk_test";
            String conUser = "chkP";
            String conPass = "8heeArhoqm3G";

            Connection connection = DriverManager.getConnection(conURL, conUser, conPass);

            // bd -> trabajadores
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from trabajadores");
            while (results.next()) {
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
            while (results.next()) {
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
        */

        // Agregar algunas reparticiones de prueba.
        String[] reparticionNames = {
            "Deportes", "Economia", "Construccion"
        };
        
        int index = 1;
        for(String name : reparticionNames) {
            gobierno.addReparticion(new Reparticion(index++, name, EstadoReparticion.Normal));
        }
        
        // Crear 20 trabajadores random
        debugCrearDatosRandom(gobierno);
        
        debugPrintGobierno(gobierno);
        
        try {
            // Test de GUI
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EnumerateUsers enumerateUsers = new EnumerateUsers(gobierno);
        enumerateUsers.setVisible(true);
        
        debugPrintGobierno(gobierno);
    }
    
    public static void debugPrintGobierno(Gobierno gobierno) {
        // Mostrar valores en consola para probar.
        System.out.println("Reparticiones:");
        for (Reparticion reparticion : gobierno.getReparticiones()) {
            System.out.println("\t" + reparticion.getNombre());
        }

        System.out.println("Trabajadores:");
        for (Trabajador trabajador : gobierno.getTrabajadores()) {
            System.out.println("\t" + trabajador.getNombre());
        }

        System.out.println("Contratos:");
        for (List<Contrato> listasDeContratos : gobierno.getContratos()) {
            for (Contrato c : listasDeContratos) {
                Trabajador t = gobierno.getTrabajador(c.getIdTrabajador());
                Reparticion r = gobierno.getReparticion(c.getIdReparticion());
                System.out.println("\t" + t.getNombre() + " -> " + r.getNombre());
            }
        }
    }
    
    public static void debugCrearDatosRandom(Gobierno gobierno) {
        Random random = new Random();

        String[] commonNames = {
            "James", "Robert", "John", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles",
            "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen"
        };
        String[] commonSurnames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin"
        };
        
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = df.parse("1990-01-01");
            Date endDate = df.parse("2010-01-01");
            long startMilis = startDate.getTime();
            long endMilis = endDate.getTime();
            for(int i = 1; i <= 20; ++i) {
                String randomName = commonNames[random.nextInt(commonNames.length)];
                String randomSurname = commonSurnames[random.nextInt(commonSurnames.length)];

                long randomMilis = ThreadLocalRandom.current().nextLong(startMilis, endMilis);
                Date randomDate = new Date(randomMilis);
                Trabajador t = new Trabajador(i, randomName, randomSurname, randomDate);
                gobierno.addTrabajador(t);
            }
        }catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Crea contratos aleatorios entre los trabajadores y una reparticion al azar
        Object[] items = gobierno.getReparticiones().toArray();
        if (items.length > 0) {
            for(Trabajador t : gobierno.getTrabajadores()) {    
                Object randomItem = items[random.nextInt(items.length)];

                Reparticion r = (Reparticion)randomItem;
                Contrato c = new Contrato(t.getId(), r.getId());
                gobierno.addContrato(c);
            }
        } else {
            System.out.println("No hay reparticiones!");
        }
    }
}
