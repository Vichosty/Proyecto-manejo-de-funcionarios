/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofuncionarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chkp
 */
public class ProyectoFuncionarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gobierno.Gobierno gob = new gobierno.Gobierno();

        // <editor-fold defaultstate="collapsed" desc="Cargar los datos de la BD">
        /*
         * try { String conURL = "jdbc:mysql://localhost:3306/chk_test"; String
         * conUser = "chkP"; String conPass = "8heeArhoqm3G";
         *
         * Connection connection = DriverManager.getConnection(conURL, conUser,
         * conPass);
         *
         * // bd -> trabajadores Statement statement =
         * connection.createStatement(); ResultSet results =
         * statement.executeQuery("select * from trabajadores"); while
         * (results.next()) { int id = results.getInt("id"); String nombre =
         * results.getString("nombre"); String apellido =
         * results.getString("apellido"); Date fechaDeNacimiento =
         * results.getTimestamp("fechaDeNacimiento");
         *
         * gobierno.addTrabajador(new gobierno.Trabajador(id, nombre, apellido,
         * fechaDeNacimiento)); } statement.close();
         *
         * // bd -> reparticiones statement = connection.createStatement();
         * results = statement.executeQuery("select * from reparticiones");
         * while (results.next()) { int id = results.getInt("id"); String nombre
         * = results.getString("nombre"); String estado =
         * results.getString("estado");
         *
         * gobierno.addReparticion(new gobierno.Reparticion(id, nombre,
         * estado)); } statement.close();
         *
         * // TODO: falta una tabla que contenga todas las relaciones //
         * trabajador -> reparticion, para poder deducir a que //
         * reparticion(es) pertenece cada trabajador. (util para cuando un //
         * trabajador pertenezca a multiples reparticiones) connection.close();
         * } catch (Exception ex) {
         * Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
         * }
         */
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Agregar algunas reparticiones de prueba">
        // Agregar algunas reparticiones de prueba
        String[] reparticionNames = {
            "Deportes", "Economia", "Construccion", "Politica"
        };

        for (int index = 0; index < reparticionNames.length; ++index) {
            gob.addReparticion(
                    new gobierno.Reparticion(
                            index + 1, reparticionNames[index], gobierno.EstadoReparticion.Normal
                    )
            );
        }
        //</editor-fold>

        // Crear varios trabajadores random
        debugCrearDatosRandom(gob);

        // <editor-fold defaultstate="collapsed" desc="Look and Feel">
        try {
            // Test de GUI
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProyectoFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        // </editor-fold>

        gob.printAll(gob, false);

        chk.forms.MainWindow mainWindow = new chk.forms.MainWindow(gob);
        mainWindow.setVisible(true);
    }

    public static void debugCrearDatosRandom(gobierno.Gobierno gob) {
        String[] commonNames = {
            "James", "Robert", "John", "Michael", "William",
            "David", "Richard", "Joseph", "Thomas", "Charles",
            "Kenneth", "Kevin", "Brian", "George", "Edward",
            "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan",
            "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth",
            "Barbara", "Susan", "Jessica", "Sarah", "Karen",
            "Michelle", "Dorothy", "Carol", "Amanda", "Melissa",
            "Deborah", "Stephanie", "Rebecca", "Sharon", "Laura"
        };
        String[] commonSurnames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin",
            "Lee", "Perez", "Thompson", "White", "Harris",
            "Sanchez", "Clark", "Hall", "Allen", "Young"
        };

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = df.parse("1990-01-01");
            Date endDate = df.parse("2010-01-01");
            long startMilis = startDate.getTime();
            long endMilis = endDate.getTime();
            for (int i = 1; i <= 50; ++i) {
                String randomName = commonNames[ThreadLocalRandom.current().nextInt(commonNames.length)];
                String randomSurname = commonSurnames[ThreadLocalRandom.current().nextInt(commonSurnames.length)];

                long randomMilis = ThreadLocalRandom.current().nextLong(startMilis, endMilis);
                Date randomDate = new Date(randomMilis);
                gobierno.Trabajador t = new gobierno.Trabajador(i, randomName, randomSurname, randomDate);
                gob.addTrabajador(t);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Crea contratos aleatorios entre los trabajadores y una reparticion al azar
        Object[] items = gob.getReparticiones().toArray();
        int indexContrato = 0;
        if (items.length > 0) {
            for (gobierno.Trabajador t : gob.getTrabajadores()) {

                Object randomItem = items[ThreadLocalRandom.current().nextInt(items.length)];

                gobierno.Reparticion r = (gobierno.Reparticion) randomItem;
                gobierno.Contrato c = new gobierno.Contrato(indexContrato++, t.getId(), r.getId());
                gob.addContrato(c);
            }
            if (indexContrato == 0) {
                System.out.println("No hay trabajadores!");
            }
        } else {
            System.out.println("No hay reparticiones!");
        }
    }
}
